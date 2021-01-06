package com.capgemini.vault.service;

import com.capgemini.vault.entity.ApiDetails;
import com.capgemini.vault.entity.IntDetails;

import java.util.List;

public interface LinkIntApiDetailsService {
    String NAME = "vault_LinkIntApiDetailsService";

    public void commitIntApiDetails(List<IntDetails> intDetailsList, List<ApiDetails> apiList);

    public void commitApiIntDetails(List<IntDetails> intDetailsList, List<ApiDetails> apiList);
}