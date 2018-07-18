package cn.itcast.jk.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

//合同货物
public class ContractProductC {
    private String contractProductId;
    private String contractId;
    private String factoryId;
    private String exportListId;
    private String invoiceId;
    private String productName;
    private String productNo;
    private String productImage;
    private String productDesc;
    private String loadingRate;
    private String packingUnit;//包装单位
    private Integer cnumber;
    private Integer outNumber;
    private Boolean finished;
    private Double grossWeight;
    private Double netWeight;
    private String csize;
    private Double sizeLength;
    private Double sizeWidth;
    private Double sizeHeight;
    private String productRequest;
    private String factory;
    private Double price;
    private Double amount;
    private String cunit;
    private Integer boxNum;
    private Double exPrice;
    private Double exAmount;
    private String exUnit;
    private Double noTax;
    private Double tax;
    private Double costPrice;
    private Double costTax;
    private Boolean accessories;
    private Integer orderNo;
    private FactoryC factoryC;
    private Set<ExtCproductC> extCproductCSet = new HashSet<ExtCproductC>();

    public String getContractProductId() {
        return contractProductId;
    }

    public void setContractProductId(String contractProductId) {
        this.contractProductId = contractProductId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getExportListId() {
        return exportListId;
    }

    public void setExportListId(String exportListId) {
        this.exportListId = exportListId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getLoadingRate() {
        return loadingRate;
    }

    public void setLoadingRate(String loadingRate) {
        this.loadingRate = loadingRate;
    }

    public String getPackingUnit() {
        return packingUnit;
    }

    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit;
    }

    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    public Integer getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(Integer outNumber) {
        this.outNumber = outNumber;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public String getCsize() {
        return csize;
    }

    public void setCsize(String csize) {
        this.csize = csize;
    }

    public Double getSizeLength() {
        return sizeLength;
    }

    public void setSizeLength(Double sizeLength) {
        this.sizeLength = sizeLength;
    }

    public Double getSizeWidth() {
        return sizeWidth;
    }

    public void setSizeWidth(Double sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    public Double getSizeHeight() {
        return sizeHeight;
    }

    public void setSizeHeight(Double sizeHeight) {
        this.sizeHeight = sizeHeight;
    }

    public String getProductRequest() {
        return productRequest;
    }

    public void setProductRequest(String productRequest) {
        this.productRequest = productRequest;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCunit() {
        return cunit;
    }

    public void setCunit(String cunit) {
        this.cunit = cunit;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public Double getExPrice() {
        return exPrice;
    }

    public void setExPrice(Double exPrice) {
        this.exPrice = exPrice;
    }

    public Double getExAmount() {
        return exAmount;
    }

    public void setExAmount(Double exAmount) {
        this.exAmount = exAmount;
    }

    public String getExUnit() {
        return exUnit;
    }

    public void setExUnit(String exUnit) {
        this.exUnit = exUnit;
    }

    public Double getNoTax() {
        return noTax;
    }

    public void setNoTax(Double noTax) {
        this.noTax = noTax;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getCostTax() {
        return costTax;
    }

    public void setCostTax(Double costTax) {
        this.costTax = costTax;
    }

    public Boolean getAccessories() {
        return accessories;
    }

    public void setAccessories(Boolean accessories) {
        this.accessories = accessories;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public FactoryC getFactoryC() {
        return factoryC;
    }

    public void setFactoryC(FactoryC factoryC) {
        this.factoryC = factoryC;
    }

    public Set<ExtCproductC> getExtCproductCSet() {
        return extCproductCSet;
    }

    public void setExtCproductCSet(Set<ExtCproductC> extCproductCSet) {
        this.extCproductCSet = extCproductCSet;
    }

    @Override
    public String toString() {
        return "ContractProductC{" +
                "factoryC=" + factoryC +
                ", extCproductCSet=" + extCproductCSet +
                '}';
    }
}
