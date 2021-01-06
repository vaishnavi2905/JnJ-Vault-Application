package com.capgemini.vault.service;

import com.capgemini.vault.entity.ApiDetails;
import com.capgemini.vault.entity.IntApiDetails;
import com.capgemini.vault.entity.IntDetails;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(LinkIntApiDetailsService.NAME)


public class LinkIntApiDetailsServiceBean implements LinkIntApiDetailsService {

    @Inject
    public Persistence persistence;

    public void commitIntApiDetails(List<IntDetails> intDetailsList, List<ApiDetails> apiList){

        try(Transaction tx = persistence.createTransaction()){
            for(IntDetails intD : intDetailsList){
                for(ApiDetails apiD : apiList){
                    IntApiDetails intApiDetails = new IntApiDetails();
                    intApiDetails.setApiDetails(apiD);
                    intApiDetails.setIntDetails(intD);
                    persistence.getEntityManager().persist(intApiDetails);
                }
            }
            tx.commit();
        }
    }

    public void commitApiIntDetails(List<IntDetails> intDetailsList, List<ApiDetails> apiList){

        try(Transaction tx = persistence.createTransaction()){
            for(ApiDetails apiD : apiList){
                for(IntDetails intD : intDetailsList){
                    IntApiDetails intApiDetails = new IntApiDetails();
                    intApiDetails.setApiDetails(apiD);
                    intApiDetails.setIntDetails(intD);
                    persistence.getEntityManager().persist(intApiDetails);
                }
            }
            tx.commit();
        }
    }
}