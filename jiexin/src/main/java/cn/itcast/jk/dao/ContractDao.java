package cn.itcast.jk.dao;

import cn.itcast.jk.domain.ContractC;
import cn.itcast.jk.vo.OutProduct;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface ContractDao extends BaseDao<ContractC> {
    void deleteBatch(String[] contractId);
    BigInteger[] getNum(String contractId);
    void changeState(Integer state,String[]  contractId);
    List<OutProduct> findOutProduct(String inputDate);
}
