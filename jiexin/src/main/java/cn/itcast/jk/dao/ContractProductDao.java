package cn.itcast.jk.dao;

import cn.itcast.jk.domain.ContractProductC;

import java.io.Serializable;
import java.util.List;

public interface ContractProductDao extends BaseDao<ContractProductC> {
    List<ContractProductC> findContractProductById(String contractId);
    List<ContractProductC> findForExport(Serializable contractId);

}
