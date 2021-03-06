package cn.itcast.jk.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ContractC implements Serializable {
    private String contractId;
    private BigInteger cpnum;
    private BigInteger epnum;
    private String offeror;
    private String contractNo;
    private Date signingDate;
    private String inputBy;
    private String checkBy;
    private String inspector;
    private Double totalAmount;
    private String crequest;
    private String customName;
    private Date shipTime;
    private Integer importNum;
    private Date deliveryPeriod;
    private String remark;
    private String printStyle;
    private Integer oldState;
    private Integer state;
    private Integer outState;
    private String tradeTerms;
    private String createBy;
    private String createDept;
    private Date createTime;
    private Set<ContractProductC> contractProductCSet = new HashSet<ContractProductC>();

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public BigInteger getCpnum() {
        return cpnum;
    }

    public void setCpnum(BigInteger cpnum) {
        this.cpnum = cpnum;
    }

    public BigInteger getEpnum() {
        return epnum;
    }

    public void setEpnum(BigInteger epnum) {
        this.epnum = epnum;
    }

    public String getOfferor() {
        return offeror;
    }

    public void setOfferor(String offeror) {
        this.offeror = offeror;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }

    public String getInputBy() {
        return inputBy;
    }

    public void setInputBy(String inputBy) {
        this.inputBy = inputBy;
    }

    public String getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(String checkBy) {
        this.checkBy = checkBy;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCrequest() {
        return crequest;
    }

    public void setCrequest(String crequest) {
        this.crequest = crequest;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public Integer getImportNum() {
        return importNum;
    }

    public void setImportNum(Integer importNum) {
        this.importNum = importNum;
    }

    public Date getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setDeliveryPeriod(Date deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPrintStyle() {
        return printStyle;
    }

    public void setPrintStyle(String printStyle) {
        this.printStyle = printStyle;
    }

    public Integer getOldState() {
        return oldState;
    }

    public void setOldState(Integer oldState) {
        this.oldState = oldState;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOutState() {
        return outState;
    }

    public void setOutState(Integer outState) {
        this.outState = outState;
    }

    public String getTradeTerms() {
        return tradeTerms;
    }

    public void setTradeTerms(String tradeTerms) {
        this.tradeTerms = tradeTerms;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDept() {
        return createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Set<ContractProductC> getContractProductCSet() {
        return contractProductCSet;
    }

    public void setContractProductCSet(Set<ContractProductC> contractProductCSet) {
        this.contractProductCSet = contractProductCSet;
    }

    @Override
    public String toString() {
        return "ContractC{" +
                "contractId='" + contractId + '\'' +
                ", offeror='" + offeror + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", totalAmount=" + totalAmount +
                ", shipTime=" + shipTime +
                ", contractProductCSet=" + contractProductCSet +
                '}';
    }
}
