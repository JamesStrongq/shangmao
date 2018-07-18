package cn.itcast.jk.service.impl;

import cn.itcast.common.springdao.SQLDAO;
import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.domain.ContractC;
import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.vo.OutProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private SQLDAO sqldao;

    public List<ContractC> findContract(ContractC contract) {
        return contractDao.find(contract);
    }

    public ContractC getContract(Serializable id) {
        return contractDao.get(id);
    }

    public void insertContract(ContractC contract) {
        contractDao.insert(contract);
    }

    public void updateContract(ContractC contract) {
        contractDao.update(contract);
    }

    public void deleteBatch(String[] contractId) {
        contractDao.deleteBatch(contractId);
    }

    public BigInteger[] getNum(String contractId) {
        return contractDao.getNum(contractId);
    }

    public void updateState(Integer state, String[] contractId) {
        contractDao.changeState(state,contractId);
    }

    public List<OutProduct> findOutProduct(String inputDate) {
        return contractDao.findOutProduct(inputDate);
    }

    public void pigeonhole(String[] contractIds) {
        StringBuffer sb = new StringBuffer();
        for(String id : contractIds){
            sb.append("insert into contract_his_c select * from contract_c where contract_id='" + id + "';");
            sb.append("insert into contract_product_his_c select * from contract_product_c where contract_id='" + id + "';");
            sb.append("insert into ext_cproduct_his_c select * from ext_cproduct_c where contract_product_id in (select contract_product_id from contract_product_c where contract_id='" + id + "');");
        }

        sqldao.batchSQL(sb.toString().split(";"));
    }
}
