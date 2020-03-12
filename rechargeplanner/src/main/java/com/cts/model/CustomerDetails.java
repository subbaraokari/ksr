package com.cts.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.cts.service.RechargeService;

public class CustomerDetails {
	@NotNull(message="name is required")
	private String name;
	@NotNull(message="mobileNo is required")
	private String mobileNo;
	private String carrier;
	@NotNull(message="recharge Date is required")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date previousRechargeDate;
	private String previousSelectedPackage;
	private LinkedHashMap<String, String> packageNames;
	private RechargeService service=new RechargeService();
	public CustomerDetails() {
		this.packageNames=service.getPackageNames();
	}
	public CustomerDetails(String name, String mobileNo, String carrier, Date previousRechargeDate,
			String previousSelectedPackage) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.carrier = carrier;
		this.previousRechargeDate = previousRechargeDate;
		this.previousSelectedPackage = previousSelectedPackage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	
	public Date getPreviousRechargeDate() {
		return previousRechargeDate;
	}
	public void setPreviousRechargeDate(Date previousRechargeDate) {
		this.previousRechargeDate = previousRechargeDate;
	}
	public String getPreviousSelectedPackage() {
		return previousSelectedPackage;
	}
	public void setPreviousSelectedPackage(String previousSelectedPackage) {
		this.previousSelectedPackage = previousSelectedPackage;
	}
	public LinkedHashMap<String, String> getPackageNames() {
		return packageNames;
	}
	
}
