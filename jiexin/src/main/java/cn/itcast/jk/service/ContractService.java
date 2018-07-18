package cn.itcast.jk.service;

import cn.itcast.jk.domain.ContractC;
import cn.itcast.jk.vo.OutProduct;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public interface ContractService {

    List<ContractC> findContract(ContractC contract);
    ContractC getContract(Serializable id);
    void insertContract(ContractC contract);
    void updateContract(ContractC contract);
    void deleteBatch(String[] contractId);
    BigInteger[] getNum(String contractId);
    void updateState(Integer state,String[] contractId);
    List<OutProduct> findOutProduct(String inputDate);
    void pigeonhole(String[] contractIds);
}
