package com.capgemini.vault.service;

import com.capgemini.vault.entity.*;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TypedQuery;

import com.haulmont.cuba.security.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;


@Service(ReadFileService.NAME)
public class ReadFileServiceBean implements ReadFileService {

    @Inject
    public Persistence persistence;


    public List<ErrorSummary> errorList=new ArrayList<ErrorSummary>();
    public int apiErrorCount;
    public int apiSuccessCount;
    public int intErrorCount;
    public int intSuccessCount;

    public String readVault(File fileid, String name, User user) {
        System.out.println("HII");
    try {
            apiErrorCount = 0;
            apiSuccessCount = 0;
            intErrorCount = 0;
            intSuccessCount = 0;

            FileInputStream file = new FileInputStream(fileid);
            String filename = name;
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            UploadSummary uploadObj = null;

            XSSFSheet sheet2 = workbook.getSheet("Integration Inventory");
            if (sheet2 != null) {
                uploadObj = readIntDetails(sheet2, filename, user);
            }
            XSSFSheet sheet = workbook.getSheet("API Inventory");
            if (sheet != null) {
                uploadObj = readApiDetails(sheet, filename, user);
            }
            if (sheet == null && sheet2 == null) {
                System.out.println("Exception raised");
                throw new SheetNotFoundException("Neither API nor Integration Inventory found");
                /*return "Neither API nor Integration Inventory found";*/
            }

            Transaction errortx = persistence.createTransaction();
            for (ErrorSummary errorObj : errorList)          //persisting errors in error table.
            {
                errorObj.setErrUpl(uploadObj);
                persistence.getEntityManager().persist(errorObj);
            }
            errorList.clear();
            errortx.commit();

            return "File uploaded";
        }
        catch (Exception e){
            System.out.println("in catch");
        }
        return "File not uploaded";
    }
    public UploadSummary readApiDetails(XSSFSheet sheet,String filename,User user) {

        UploadSummary uploadSummary=persistUpload(sheet.getSheetName(),filename);

        try(Transaction tx = persistence.createTransaction()) {
            String apiId = null;
            String validIntValues="";
            IntDetails intasset = null;
            String name = null;
            String description = null;
            MasterDataManagement classification = null;
            MasterDataManagement supportedOperations = null;
            MasterDataManagement securityClassification = null;
            MasterDataManagement brandOrBu = null;
            MasterDataManagement region = null;
            MasterDataManagement country = null;
            MasterDataManagement project = null;
            MasterDataManagement workstream = null;
            String releaseNo = null;
            MasterDataManagement priority = null;
            MasterDataManagement status = null;
            MasterDataManagement platform = null;
            MasterDataManagement platformVersion = null;
            MasterDataManagement sourceProtocol = null;
            MasterDataManagement sourcePayloadType = null;
            MasterDataManagement processingType = null;
            MasterDataManagement payloadSecClass = null;
            MasterDataManagement destinationApp = null;
            String businessOwner =null;
            Status internalStatus;
            MasterDataManagement destinationProtocol = null;
            MasterDataManagement destinationPayloadType = null;
            MasterDataManagement designPattern = null;
            MasterDataManagement complexity = null;
            String throughput = null;
            String inputMessageSize = null;
            String dependency = null;
            String intOwner = null;
            String remarks = null;
            DataFormatter formatter = new DataFormatter();
            List<String> validApiId=new ArrayList<>();

            List<String> colnames = new ArrayList<String>();      //contains column names  from xl sheet.
            for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
                colnames.add(sheet.getRow(0).getCell(i).getStringCellValue());
            }

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> columnIterator = row.cellIterator();
                internalStatus=Status.DRAFT;
                outerloop:
                if (!checkIfRowIsEmpty(row)) {
                    Set<IntDetails> validIntObj = new HashSet<>();
                    while (columnIterator.hasNext()) {
                        Cell cell = columnIterator.next();

                        for (int i = 0; i < colnames.size(); i++) {
                            try {
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("api id")) {
                                    if (cell.getCellType() == CellType.BLANK) {
                                        //persistError("API ID should not be null", row.getRowNum() + 1, cell.getColumnIndex()+1, "API Inventory");
                                        internalStatus=Status.ERROR;
                                        apiErrorCount++;
                                        throw new APIRowValidationException("API ID should not be null");
                                        //break outerloop;
                                    }
                                    apiId = Double.toString(cell.getNumericCellValue());
                                    if (validApiId.contains(apiId)) {
                                        //persistError("API ID should not be repeated", row.getRowNum() + 1, cell.getColumnIndex()+1, "API Inventory");
                                        internalStatus=Status.ERROR;
                                        apiErrorCount++;
                                        throw new APIRowValidationException("API ID should not be repeated");
                                        //break outerloop;
                                    }
                                    else
                                        validApiId.add(apiId);
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("int id - int asset no.")) {
                                    if (cell.getCellType() == CellType.BLANK) {
                                        validIntValues = "blank";
                                        break;
                                    }
                                    validIntObj = new HashSet<>();
                                    if (cell.getCellType() == CellType.NUMERIC) {// for single int id
                                        intasset = getIntegrationEntity(formatter.formatCellValue(cell));
                                        if (intasset == null) {
                                            //persistError("The mentioned Integration Id does not exist.", row.getRowNum() + 1, cell.getColumnIndex()+1, "API Inventory");
                                            internalStatus=Status.ERROR;
                                            apiErrorCount++;
                                            validIntValues = "";
                                            //break;
                                            throw new APIRowValidationException("The mentioned Integration Id does not exist.");
                                        }
                                        validIntValues = intasset.getIntAssetId();
                                        validIntObj.add(intasset);

                                    } else {                                 //for multiple int ids.
                                        List<String> intList = Arrays.asList(formatter.formatCellValue(cell).split(","));
                                        Set<String> validList = new HashSet<>();
                                        for (String temp : intList) {
                                            intasset = getIntegrationEntity(temp);
                                            if (intasset == null) {
                                                //persistError(" Integration Id " + temp + " does not exist.", row.getRowNum() + 1, cell.getColumnIndex()+1, "API Inventory");
                                                internalStatus=Status.ERROR;//ask 3,9
                                                apiErrorCount++;
                                                throw new APIRowValidationException("Integration Id does not exist.");
                                            } else {
                                                validList.add(temp);
                                                validIntObj.add(intasset);
                                            }
                                        }
                                        validIntValues = String.join(",", validList);
                                    }
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("API name")) {
                                    if (cell.getCellType() == CellType.BLANK) {
                                        //persistError("API Name should not be null", row.getRowNum() + 1, cell.getColumnIndex()+1, "API Inventory");
                                        internalStatus=Status.ERROR;
                                        apiErrorCount++;
                                        //break outerloop;
                                        throw new APIRowValidationException("API Name should not be null");
                                    }
                                    name = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("api description")) {
                                    description = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("api classification")) {
                                    if (cell.getCellType() == CellType.BLANK) {
                                        classification = null;
                                        break;
                                    }
                                    classification = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "API Classification");
//                                        if (classification==null)
////                                              internalStatus=Status.ERROR;
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("supported operations")) {
                                    supportedOperations = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("API payload security classification")) {
                                    securityClassification = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "API payload security classification");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("api brand or bu")) {
                                    brandOrBu = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "API brand or BU");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("api region")) {
                                    region = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "API Region");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("api country")) {
                                    country = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "API Country");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("project")) {
                                    project = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "Project");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("workstream")) {
                                    workstream = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "Workstream - project classification");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("release")) {
                                    releaseNo = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("priority")) {
                                    priority = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "priority");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("api status")) {
                                    status = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "API Status");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("api platform")) {
                                    platform = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "API/Int Platform");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("api platform Version")) {
                                    platformVersion = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "API/Int Platform Version");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("API Source Protocol")) {
                                    sourceProtocol = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "API/Int Source Protocol");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("API Source Payload Type")) {
                                    sourcePayloadType = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "API/Int Source Payload Type");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("API Destination App")) {
                                    destinationApp = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "API/Int Destination App");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("API Destination protocol")) {
                                    destinationProtocol = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("API Destination payload type")) {
                                    destinationPayloadType = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("API design pattern")) {
                                    designPattern = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("API processing type")) {
                                    processingType = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("API complexity")) {
                                    complexity = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "API/Int Destination App");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("throughput in seconds")) {
                                    throughput = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("int message size (kb)")) {
                                    inputMessageSize = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("dependency (if any)")) {
                                    dependency = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration owner")) {
                                    intOwner = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("business owner")) {
                                    businessOwner = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("remarks")) {
                                    remarks = cell.getStringCellValue();
                                    break;
                                }
                            } catch (IllegalStateException e) {
                                //persistError("Value entered in given row and column is invalid.", row.getRowNum() + 1, cell.getColumnIndex() + 1, "API Inventory");
                                internalStatus=Status.ERROR;
                                apiErrorCount++;
                                //break outerloop;
                                throw new APIRowValidationException("Value entered in given row and column is invalid");
                            }
                        }
                    }//end while for cell

                    ApiDetails api = new ApiDetails();
                    //
                    //setting of data from xl to our obj.
                    api.setApiId(apiId);
                    api.setApiPayloadSecurClass(payloadSecClass);
                    api.setApiBrandOrBu(brandOrBu);
                    api.setApiProcessingType(processingType);
                    api.setApiBusinessOwner(businessOwner);
                    api.setApiDestProtocol(destinationProtocol);
                    api.setApiDesignPattern(designPattern);
                    api.setApiComplexity(complexity);
                    api.setApiThrouputInSec(throughput);
                    api.setApiDependency(dependency);
                    api.setApiIntMessageSizeInKb(inputMessageSize);
                    api.setApiIntOwner(intOwner);
                    api.setApiRemarks(remarks);
                    api.setApiCountry(country);
                    api.setApiDescription(description);
                    api.setApiName(name);
                    api.setApiClassification(classification);
                    api.setApiPlatform(platform);
                    api.setApiPlatformVersion(platformVersion);
                    api.setApiProject(project);
                    api.setApiRegion(region);
                    api.setApiPriority(priority);
                    api.setApiClassification(securityClassification);
                    api.setApiRelease(releaseNo);
                    api.setApiStatus(status);
                    api.setApiSupportedOps(supportedOperations);
                    api.setApiWorkstream(workstream);
                    api.setApiDestApp(destinationApp);
                    api.setApiSrcProtocol(sourceProtocol);
                    api.setApiDestPayloadType(destinationPayloadType);
                    api.setApiInternalStatus(internalStatus);

                    if (validIntValues.length() != 0) {
                        if (validIntValues.equals("blank"))
                            validIntValues = "";
                        api.setIntAssetId(validIntValues);
                    } else {
                        api.setIntAssetId("");
                    }
                    api.setApiSrcPayloadType(sourcePayloadType);
                    api.setApiLob(user.getGroup().getName());
                    api.setApiUpl(uploadSummary);
                    ApiDetails dbApi = getApiDetails(apiId);

                    if (dbApi == null)                       //for the case where record is totally new.
                    {
                        persistence.getEntityManager().persist(api);
                        persistence.getEntityManager().flush();
                        persistLinked(validIntObj, api);
                        if (api.getApiInternalStatus() != Status.ERROR)
                            apiSuccessCount++;
                        System.out.println("apiif");
                    } else if (equateApiObjects(dbApi, api))//for the case where the record is already present and we ignore.
                    {
                        continue;
                    } else                                    //update record
                    {

                        System.out.println("apielse");
                        api.setId(dbApi.getId());
                        persistence.getEntityManager().merge(api);
                        if (api.getApiInternalStatus() != Status.ERROR)
                            apiSuccessCount++;


                        updateLinked(validIntObj, api, dbApi);
                    }
                }

            }//end while for row.

            uploadSummary.setUplSuccessRecords(apiSuccessCount);
            uploadSummary.setUplErrorRecords(apiErrorCount);
            persistence.getEntityManager().merge(uploadSummary);
            tx.commit();
            validApiId.clear();
        }//end try wr.
        catch (Exception e){
            System.out.println("some exception.");
        }
        return uploadSummary;
    }



    public UploadSummary readIntDetails(XSSFSheet sheet2,String filename,User user)
    {
        String upname=sheet2.getSheetName();
        UploadSummary uploadSummary=persistUpload(upname,filename);

        try(Transaction tx=persistence.createTransaction()) {
            String assetid = null;
            String name = null;
            String desc = null;
            MasterDataManagement crud = null;
            MasterDataManagement payloadSecureClass = null;
            String payload = null;
            MasterDataManagement brandOrBu = null;
            MasterDataManagement region = null;
            MasterDataManagement country = null;
            MasterDataManagement project = null;
            MasterDataManagement workstream = null;
            String fspecloc = null;
            MasterDataManagement status = null;
            MasterDataManagement platform = null;
            MasterDataManagement platformVersion = null;
            MasterDataManagement sourceProtocol = null;
            MasterDataManagement sourcePayloadType = null;
            MasterDataManagement processingType = null;
            MasterDataManagement destinationApp = null;
            String businessOwner = null;
            MasterDataManagement destinationProtocol = null;
            MasterDataManagement destinationPayloadType = null;
            MasterDataManagement designPattern = null;
            MasterDataManagement complexity = null;
            String inputMessageSize = null;
            String dependency = null;
            String intOwner = null;
            String remarks = null;
            Status internalStatus;
            String implPattern = null;
            String intBA = null;
            MasterDataManagement initSystem = null;
            MasterDataManagement specialops = null;
            String techSpecLoc = null;
            String srcCodeRepo = null;
            String repoLoc = null;
            String link = null;
            DataFormatter formatter = new DataFormatter();
            List<String> validIntIds=new ArrayList<>();


            List<String> colnames = new ArrayList<String>();      //contains column names  from xl sheet.
            for (int i = 0; i < sheet2.getRow(0).getPhysicalNumberOfCells(); i++) {
                colnames.add(sheet2.getRow(0).getCell(i).getStringCellValue());
            }

            Iterator<Row> rowIterator = sheet2.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();
                Iterator<Cell> columnIterator = row.cellIterator();
                internalStatus=Status.DRAFT;
                outerloop:

                if (!checkIfRowIsEmpty(row)) {
                    while (columnIterator.hasNext()) {

                        Cell cell = columnIterator.next();

                        for (int i = 0; i < colnames.size(); i++) {
                            try {

                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("int id")) {
                                    if (cell.getCellType() == CellType.BLANK) {
                                        persistError("Integration ID should not be null", row.getRowNum()+1, cell.getColumnIndex()+1, "Integration Inventory");
                                        internalStatus=Status.ERROR;
                                        intErrorCount++;
                                        break outerloop;
                                    }
                                    assetid =  formatter.formatCellValue(cell);
                                    if (validIntIds.contains(assetid)) {
                                        persistError("Integration ID should not be repeated", row.getRowNum()+1, cell.getColumnIndex()+1, "Integration Inventory");
                                        internalStatus=Status.ERROR;
                                        break outerloop;
                                    }
                                    else
                                        validIntIds.add(assetid);
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration name")) {
                                    if (cell.getCellType() == CellType.BLANK) {
                                        persistError("Integration Name should not be null", row.getRowNum(), cell.getColumnIndex()+1, "Integration Inventory");
                                        internalStatus=Status.ERROR;
                                        intErrorCount++;
                                        break outerloop;
                                    }
                                    name = formatter.formatCellValue(cell);
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration description")) {
                                    desc = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("int payload")) {
                                    payload = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("int payload security classification")) {
                                    payloadSecureClass = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("int crud")) {
                                    crud = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("int brand or bu")) {
                                    brandOrBu = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("int region")) {
                                    region = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("int country")) {
                                    country = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("project")) {
                                    project = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("workstream")) {
                                    workstream = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("int status")) {
                                    status = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration platform")) {
                                    platform = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration platform Version")) {
                                    platformVersion = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration Source Protocol")) {
                                    sourceProtocol = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration Source Payload Type")) {
                                    sourcePayloadType = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration Destination App")) {
                                    destinationApp = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "API/Int Destination App");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration Destination protocol")) {
                                    destinationProtocol = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration Destination payload type")) {
                                    destinationPayloadType = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("design pattern")) {
                                    designPattern = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("processing type")) {
                                    processingType = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("initiating system")) {
                                    initSystem = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration complexity")) {
                                    complexity = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("special ops")) {
                                    specialops = getMasterDataEntity(cell.getColumnIndex() + 1, row.getRowNum() + 1, cell.getStringCellValue(), "");
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration implementation pattern")) {
                                    implPattern = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("int message size (kb)")) {
                                    inputMessageSize = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("dependency (if any)")) {
                                    dependency = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration owner")) {
                                    intOwner = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("business owner")) {
                                    businessOwner = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("remarks")) {
                                    remarks = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("integration BA")) {
                                    intBA = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("f-spec location")) {
                                    remarks = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("source code repository")) {
                                    srcCodeRepo = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("Technical-Spec Location")) {
                                    techSpecLoc = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("Repository location")) {
                                    repoLoc = cell.getStringCellValue();
                                    break;
                                }
                                if (colnames.get(cell.getColumnIndex()).equalsIgnoreCase("link")) {
                                    link = cell.getStringCellValue();
                                    break;
                                }
                            }catch (IllegalStateException e) {
                                persistError("Value entered in given row and column is invalid.", row.getRowNum() + 1, cell.getColumnIndex() + 1, "API Inventory");
                                internalStatus=Status.ERROR;
                                apiErrorCount++;
                                break outerloop;
                            }
                        }
                    }//end while for cell

                    //setting of data from xl to our obj.
                    IntDetails intDetails = new IntDetails();

                    intDetails.setIntAssetId(assetid);
                    intDetails.setIntName(name);
                    intDetails.setIntDescription(desc);
                    intDetails.setIntCrud(crud);
                    intDetails.setIntPayload(payload);
                    intDetails.setIntPayloadSecurClass(payloadSecureClass);
                    intDetails.setIntBrandOrBu(brandOrBu);
                    intDetails.setIntRegion(region);
                    intDetails.setIntCountry(country);
                    intDetails.setIntProject(project);
                    intDetails.setIntWorkstream(workstream);
                    intDetails.setIntStatus(status);
                    intDetails.setIntPlatform(platform);
                    intDetails.setIntPlatformVersion(platformVersion);
                    intDetails.setIntSrcProtocol(sourceProtocol);
                    intDetails.setIntSrcPayloadType(sourcePayloadType);
                    intDetails.setIntDestApp(destinationApp);
                    intDetails.setIntDestProtocol(destinationProtocol);
                    intDetails.setIntDestPayloadType(destinationPayloadType);
                    intDetails.setIntDesignPattern(designPattern);
                    intDetails.setIntProcessingType(processingType);
                    intDetails.setIntInitiatingSys(initSystem);
                    intDetails.setIntSplOps(specialops);
                    intDetails.setIntImplPattern(implPattern);
                    intDetails.setIntComplexity(complexity);
                    intDetails.setIntMsgSizeInKb(inputMessageSize);
                    intDetails.setIntDependency(dependency);
                    intDetails.setIntOwner(intOwner);
                    intDetails.setIntBusinessOwner(businessOwner);
                    intDetails.setIntRemarks(remarks);
                    intDetails.setIntFSpecLoc(fspecloc);
                    intDetails.setIntBa(intBA);
                    intDetails.setIntInternalStatus(internalStatus);
                    intDetails.setTechnicalSpecLocation(techSpecLoc);
                    intDetails.setLink(link);
                    intDetails.setRepoLocation(repoLoc);
                    intDetails.setSourceCodeRepository(srcCodeRepo);
                    intDetails.setIntUpl(uploadSummary);
                    intDetails.setIntLob(user.getGroup().getName());


                    IntDetails dbIntDetails = getIntegrationEntity(assetid);
                    if (dbIntDetails == null)                       //for the case where record is totally new.
                    {
                        persistence.getEntityManager().persist(intDetails);
                        if(intDetails.getIntInternalStatus()!=Status.ERROR)
                            intSuccessCount++;
                    }
                    else if (equateIntObjects(dbIntDetails,intDetails))//for the case where the record is already present and we ignore.
                    {
                        continue;
                    }
                    else                                            //update
                    {
                        intDetails.setId(dbIntDetails.getId());
                        persistence.getEntityManager().merge(intDetails);
                        if(intDetails.getIntInternalStatus()!=Status.ERROR)
                            intSuccessCount++;
                    }
                }
            }//end while for row.
            uploadSummary.setUplSuccessRecords(intSuccessCount);
            uploadSummary.setUplErrorRecords(intErrorCount);
            persistence.getEntityManager().merge(uploadSummary);
            tx.commit();
        }
        catch (Exception e){
            System.out.println("some exception.");
        }
        return uploadSummary;
    }
    /*************************************************************************************************************************/

    public boolean checkIfRowIsEmpty(Row row)  //to check if row read from xl is empty.
    {
        if (row == null) {
            return true;
        }
        if (row.getLastCellNum() <= 0) {
            return true;
        }
        for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null && cell.getCellType() != CellType.BLANK && StringUtils.isNotBlank(cell.toString())) {
                return false;
            }
        }
        return true;
    }

    public ApiDetails getApiDetails (String apiId)    //to check if corresponding integration record is present.
    {
        try (Transaction tx = persistence.createTransaction()){
            List<ApiDetails> list = new ArrayList<ApiDetails>();
            TypedQuery<ApiDetails> query = persistence.getEntityManager().createQuery("select e from vault_ApiDetails e where e.apiId=?1", ApiDetails.class);
            query.setViewName("apiDetails-view");
            query.setParameter(1,apiId);
            list = query.getResultList();
            if (!list.isEmpty())
                return list.get(0);
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
            System.out.println("Metaclass not found.");
        }
        return null;
    }

    public IntApiDetails getLinkedFromDb (IntDetails intObj,ApiDetails apiObj)//to check if corresponding integration record is present.
    {
        try (Transaction tx = persistence.createTransaction()){
            List<IntApiDetails> list = new ArrayList<IntApiDetails>();
            TypedQuery<IntApiDetails> query = persistence.getEntityManager().createQuery("select e from vault_IntApiDetails e where e.intDetails=?1 and e.apiDetails=?2", IntApiDetails.class);
            query.setViewName("intApiDetails-view");
            query.setParameter(1,intObj);
            query.setParameter(2,apiObj);
            list = query.getResultList();
            if (!list.isEmpty())
                return list.get(0);
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
            System.out.println("Metaclass not found.");
        }
        return null;
    }

    public IntDetails getIntegrationEntity (String intId)    //to check if corresponding integration record is present.
    {
        try (Transaction tx = persistence.createTransaction()){
            List<IntDetails> list = new ArrayList<IntDetails>();
            TypedQuery<IntDetails> query = persistence.getEntityManager().createQuery("select e from vault_IntDetails e where e.intAssetId=?1", IntDetails.class);
            query.setViewName("intDetails-view");
            query.setParameter(1,intId);
            list = query.getResultList();
            if (!list.isEmpty())
                return list.get(0);
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
            System.out.println("Metaclass not found.");
        }
        return null;
    }

    public MasterDataManagement getMasterDataEntity(int col,int row,String description,String type) //gets the Master data object.
    {
        try (Transaction tx = persistence.createTransaction()) {
            List<MasterDataManagement> list = new ArrayList<MasterDataManagement>();
            TypedQuery<MasterDataManagement> query = persistence.getEntityManager().createQuery("select e from vault_MasterDataManagement e where e.masterType=?1 and e.masterDescription=?2", MasterDataManagement.class);
            query.setViewName("masterDataManagement-view");
            query.setParameter(1, type);
            query.setParameter(2, description);
            list = query.getResultList();
            if (!list.isEmpty())
                return list.get(0);
            else {
//                persistError("Entered value in given row and column no. is not allowed.", row, col, "");
            }
        }
        return null;
    }

    public void persistError(String errorDesc, int rowNum, int colNum, String dataType)//adding errors in error list.
    {
        ErrorSummary errorObj=new ErrorSummary();
        errorObj.setErrDescription(errorDesc);
        errorObj.setErrRowNo(rowNum);
        errorObj.setErrColNo(colNum);
        errorObj.setErrDatatype(dataType);
        errorList.add(errorObj);
    }
    public boolean equateApiObjects(ApiDetails dbApi, ApiDetails xlApi)      //equals for api objects.
    {
        ApiDetails that =xlApi;
        return Objects.equals(dbApi.getIntAssetId(), that.getIntAssetId()) &&
                Objects.equals(dbApi.getApiId(), that.getApiId()) &&
                Objects.equals(dbApi.getApiName(), that.getApiName()) &&
                Objects.equals(dbApi.getApiDescription(), that.getApiDescription()) &&
                Objects.equals(dbApi.getApiClassification(), that.getApiClassification()) &&
                Objects.equals(dbApi.getApiSupportedOps(), that.getApiSupportedOps()) &&
                Objects.equals(dbApi.getApiEntityName(), that.getApiEntityName()) &&
                Objects.equals(dbApi.getApiPayloadSecurClass(), that.getApiPayloadSecurClass()) &&
                Objects.equals(dbApi.getApiBrandOrBu(), that.getApiBrandOrBu()) &&
                Objects.equals(dbApi.getApiRegion(), that.getApiRegion()) &&
                Objects.equals(dbApi.getApiCountry(), that.getApiCountry()) &&
                Objects.equals(dbApi.getApiProject(), that.getApiProject()) &&
                Objects.equals(dbApi.getApiPriority(), that.getApiPriority()) &&
                Objects.equals(dbApi.getApiStatus(), that.getApiStatus()) &&
                Objects.equals(dbApi.getApiProcessingType(), that.getApiProcessingType()) &&
                Objects.equals(dbApi.getApiBusinessOwner(), that.getApiBusinessOwner()) &&
                Objects.equals(dbApi.getApiWorkstream(), that.getApiWorkstream()) &&
                Objects.equals(dbApi.getApiRelease(), that.getApiRelease()) &&
                Objects.equals(dbApi.getApiPlatform(), that.getApiPlatform()) &&
                Objects.equals(dbApi.getApiPlatformVersion(), that.getApiPlatformVersion()) &&
                Objects.equals(dbApi.getApiSrcProtocol(), that.getApiSrcProtocol()) &&
                Objects.equals(dbApi.getApiSrcPayloadType(), that.getApiSrcPayloadType()) &&
                Objects.equals(dbApi.getApiDestApp(), that.getApiDestApp()) &&
                Objects.equals(dbApi.getApiDestProtocol(), that.getApiDestProtocol()) &&
                Objects.equals(dbApi.getApiDestPayloadType(), that.getApiDestPayloadType()) &&
                Objects.equals(dbApi.getApiDesignPattern(), that.getApiDesignPattern()) &&
                Objects.equals(dbApi.getApiComplexity(), that.getApiComplexity()) &&
                Objects.equals(dbApi.getApiThrouputInSec(), that.getApiThrouputInSec()) &&
                Objects.equals(dbApi.getApiIntMessageSizeInKb(), that.getApiIntMessageSizeInKb()) &&
                Objects.equals(dbApi.getApiDependency(), that.getApiDependency()) &&
                Objects.equals(dbApi.getApiIntOwner(), that.getApiIntOwner()) &&
                Objects.equals(dbApi.getApiRemarks(), that.getApiRemarks()) ;
    }
    public boolean equateIntObjects(IntDetails dbInt, IntDetails xlInt)             ////equals for int objects.
    {
        IntDetails that = xlInt;
        return Objects.equals(dbInt.getIntAssetId(), that.getIntAssetId())  &&
                Objects.equals(dbInt.getIntName(), that.getIntName()) &&
                Objects.equals(dbInt.getIntDescription(), that.getIntDescription()) &&
                Objects.equals(dbInt.getIntCrud(), that.getIntCrud()) &&
                Objects.equals(dbInt.getIntPayload(), that.getIntPayload()) &&
                Objects.equals(dbInt.getIntPayloadSecurClass(), that.getIntPayloadSecurClass()) &&
                Objects.equals(dbInt.getIntBrandOrBu(), that.getIntBrandOrBu()) &&
                Objects.equals(dbInt.getIntRegion(), that.getIntRegion()) &&
                Objects.equals(dbInt.getIntCountry(), that.getIntCountry()) &&
                Objects.equals(dbInt.getIntPlatform(), that.getIntPlatform()) &&
                Objects.equals(dbInt.getIntPlatformVersion(), that.getIntPlatformVersion()) &&
                Objects.equals(dbInt.getIntSrcProtocol(), that.getIntSrcProtocol()) &&
                Objects.equals(dbInt.getIntSrcPayloadType(), that.getIntSrcPayloadType()) &&
                Objects.equals(dbInt.getIntDestApp(), that.getIntDestApp()) &&
                Objects.equals(dbInt.getIntDestProtocol(), that.getIntDestProtocol()) &&
                Objects.equals(dbInt.getIntDestPayloadType(), that.getIntDestPayloadType()) &&
                Objects.equals(dbInt.getIntDesignPattern(), that.getIntDesignPattern()) &&
                Objects.equals(dbInt.getIntImplPattern(), that.getIntImplPattern()) &&
                Objects.equals(dbInt.getIntComplexity(), that.getIntComplexity()) &&
                Objects.equals(dbInt.getIntThroughputInSeconds(), that.getIntThroughputInSeconds()) &&
                Objects.equals(dbInt.getIntMsgSizeInKb(), that.getIntMsgSizeInKb()) &&
                Objects.equals(dbInt.getIntOwner(), that.getIntOwner()) &&
                Objects.equals(dbInt.getIntBa(), that.getIntBa()) &&
                Objects.equals(dbInt.getIntProject(), that.getIntProject()) &&
                Objects.equals(dbInt.getIntPriority(), that.getIntPriority()) &&
                Objects.equals(dbInt.getIntWorkstream(), that.getIntWorkstream()) &&
                Objects.equals(dbInt.getIntProcessingType(), that.getIntProcessingType()) &&
                Objects.equals(dbInt.getIntInitiatingSys(), that.getIntInitiatingSys()) &&
                Objects.equals(dbInt.getIntSplOps(), that.getIntSplOps()) &&
                Objects.equals(dbInt.getIntDependency(), that.getIntDependency()) &&
                Objects.equals(dbInt.getIntBusinessOwner(), that.getIntBusinessOwner()) &&
                Objects.equals(dbInt.getIntRemarks(), that.getIntRemarks()) &&
                Objects.equals(dbInt.getIntFSpecLoc(), that.getIntFSpecLoc()) &&
                Objects.equals(dbInt.getTechnicalSpecLocation(), that.getTechnicalSpecLocation()) &&
                Objects.equals(dbInt.getSourceCodeRepository(), that.getSourceCodeRepository()) &&
                Objects.equals(dbInt.getRepoLocation(), that.getRepoLocation()) &&
                Objects.equals(dbInt.getLink(), that.getLink()) &&
                Objects.equals(dbInt.getIntStatus(), that.getIntStatus()) ;
    }
    private UploadSummary persistUpload(String name,String filename){
        try(Transaction tx = persistence.createTransaction()) {
            UploadSummary uploadSummary= new UploadSummary();
            uploadSummary.setUplFilename(filename);
            uploadSummary.setUplDatatype(name);
            persistence.getEntityManager().persist(uploadSummary);
            persistence.getEntityManager().flush();
            tx.commit();
            return uploadSummary;
        }
    }
    public void persistLinked(Set<IntDetails> validIntObj,ApiDetails api)  //persist linked objects.
    {
        IntApiDetails linked=new IntApiDetails();
        if (validIntObj.size()!=0) {
            for (IntDetails temp : validIntObj) {
                linked=new IntApiDetails();
                linked.setIntDetails(temp);
                linked.setApiDetails(api);
                persistence.getEntityManager().persist(linked);
            }
        }
    }

    public void updateLinked(Set<IntDetails> validIntObj,ApiDetails api,ApiDetails dbApi)  //update linked objects.
    {
        IntApiDetails linked=new IntApiDetails();
        if (validIntObj.size() != 0) {

            List<IntDetails> intObjDb = new ArrayList<>();
            for (IntApiDetails temp : dbApi.getIntApiDetails()) {
                intObjDb.add(temp.getIntDetails());
            }
            Collection<IntDetails> uncommonadd = CollectionUtils.subtract(validIntObj, intObjDb);
            Collection<IntDetails> uncommonsub = CollectionUtils.subtract(intObjDb, validIntObj);

            if (uncommonadd.isEmpty() == true)           //Remove link
            {
                for (IntDetails x : uncommonsub) {
                    linked=new IntApiDetails();
                    linked.setId(getLinkedFromDb(x,api).getId());
                    linked=persistence.getEntityManager().merge(linked);
                    persistence.getEntityManager().remove(linked);
                }

            }
            else if (uncommonsub.isEmpty() == true)      //Add link
            {
                for (IntDetails x : uncommonadd) {
                    linked=new IntApiDetails();
                    linked.setIntDetails(x);
                    linked.setApiDetails(api);
                    persistence.getEntityManager().persist(linked);
                    persistence.getEntityManager().flush();
                }
            }
            else                                       //Remove and add link.
            {
                for (IntDetails x : uncommonsub) {
                    linked=new IntApiDetails();
                    linked.setId(getLinkedFromDb(x,api).getId());
                    linked=persistence.getEntityManager().merge(linked);
                    persistence.getEntityManager().remove(linked);
                }
                for (IntDetails x : uncommonadd) {
                    linked=new IntApiDetails();
                    linked.setIntDetails(x);
                    linked.setApiDetails(api);
                    persistence.getEntityManager().persist(linked);
                    persistence.getEntityManager().flush();
                }
            }
        }

    }
}
