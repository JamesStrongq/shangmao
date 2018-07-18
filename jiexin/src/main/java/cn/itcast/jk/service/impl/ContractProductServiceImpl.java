package cn.itcast.jk.service.impl;

import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.dao.ContractProductDao;
import cn.itcast.jk.domain.ContractC;
import cn.itcast.jk.domain.ContractProductC;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ContractProductServiceImpl implements ContractProductService {

    @Autowired
    private ContractProductDao contractProductDao;


    public List<ContractProductC> findContractProductC(ContractProductC contractProduct) {
        return contractProductDao.find(contractProduct);
    }

    public ContractProductC getContractProductC(Serializable id) {
        return contractProductDao.get(id);
    }

    public void insertContractProductC(ContractProductC contractProduct) {
        contractProductDao.insert(contractProduct);
    }

    public void updateContractProductC(ContractProductC contractProduct) {
        contractProductDao.update(contractProduct);
    }

    public void deleteContractProductC(ContractProductC contractProductC) {
        contractProductDao.delete(contractProductC);
    }

    public List<ContractProductC> findContractProductById(String contractId) {
        return contractProductDao.findContractProductById(contractId);
    }

    public List<ContractProductC> findForExport(Serializable contractId) {
        return contractProductDao.findForExport(contractId);
    }
}
