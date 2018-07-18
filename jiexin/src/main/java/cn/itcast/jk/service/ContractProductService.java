package cn.itcast.jk.service;

import cn.itcast.jk.domain.ContractC;
import cn.itcast.jk.domain.ContractProductC;

import java.io.Serializable;
import java.util.List;

public interface ContractProductService {

    List<ContractProductC> findContractProductC(ContractProductC contractProduct);
    ContractProductC getContractProductC(Serializable id);
    void insertContractProductC(ContractProductC contractProduct);
    void updateContractProductC(ContractProductC contractProduct);
    void deleteContractProductC(ContractProductC contractProductC);
    List<ContractProductC> findContractProductById(String contractId);
    List<ContractProductC> findForExport(Serializable contractId);
}
