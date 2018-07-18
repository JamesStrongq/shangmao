package cn.itcast.jk.vo;

import java.util.Date;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-3-17
 */
public class OutProduct {
	private String contractProductId;
	private String customName;
	private String contractNo;
	private Date deliveryPeriod;
	private Date shipTime;
	private String tradeTerms;
	private String factoryName;
	private String productNo;
	private String cnumber;

	public String getContractProductId() {
		return contractProductId;
	}

	public void setContractProductId(String contractProductId) {
		this.contractProductId = contractProductId;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Date getDeliveryPeriod() {
		return deliveryPeriod;
	}

	public void setDeliveryPeriod(Date deliveryPeriod) {
		this.deliveryPeriod = deliveryPeriod;
	}

	public Date getShipTime() {
		return shipTime;
	}

	public void setShipTime(Date shipTime) {
		this.shipTime = shipTime;
	}

	public String getTradeTerms() {
		return tradeTerms;
	}

	public void setTradeTerms(String tradeTerms) {
		this.tradeTerms = tradeTerms;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getCnumber() {
		return cnumber;
	}

	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}

	@Override
	public String toString() {
		return "OutProduct{" +
				"contractProductId='" + contractProductId + '\'' +
				", customName='" + customName + '\'' +
				", contractNo='" + contractNo + '\'' +
				", deliveryPeriod=" + deliveryPeriod +
				", shipTime=" + shipTime +
				", tradeTerms='" + tradeTerms + '\'' +
				", factoryName='" + factoryName + '\'' +
				", productNo='" + productNo + '\'' +
				", cnumber='" + cnumber + '\'' +
				'}';
	}
}
