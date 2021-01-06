package com.capgemini.vault.service;


import com.haulmont.cuba.security.entity.User;
import java.io.File;

public interface ReadFileService {
    String NAME = "vault_ReadFileService";

    public String readVault(File fileid, String name, User user) ;
    /*public UploadSummary readApiDetails(XSSFSheet sheet, String filename, User user);
    public UploadSummary readIntDetails(XSSFSheet sheet2,String filename,User user);
    public boolean checkIfRowIsEmpty(Row row);
    public ApiDetails getApiDetails (String apiId);
    public IntApiDetails getLinkedFromDb (IntDetails intObj, ApiDetails apiObj);
    public IntDetails getIntegrationEntity (String intId);
    public MasterDataManagement getMasterDataEntity(int col, int row, String description, String type);
    public void persistError(String errorDesc, int rowNum, int colNum, String dataType);
    public boolean equateApiObjects(ApiDetails dbApi, ApiDetails xlApi);
    public boolean equateIntObjects(IntDetails dbInt, IntDetails xlInt);
    public void persistLinked(Set<IntDetails> validIntObj, ApiDetails api);
    public void updateLinked(Set<IntDetails> validIntObj,ApiDetails api,ApiDetails dbApi);*/
}
