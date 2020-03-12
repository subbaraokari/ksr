package com.cts.service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.exceptions.InvalidRechargeDateException;
import com.cts.model.CustomerDetails;
import com.cts.model.RechargePackage;
@Service
public class RechargeService {
	private List<RechargePackage> packages;
	public RechargeService() {
		packages=new ArrayList<RechargePackage>();
		packages.add(new RechargePackage(1, "Airtel ABC Plan", "airtel", 30,399));
		packages.add(new RechargePackage(2, "Airtel xyz Plan", "airtel", 45,500));
		packages.add(new RechargePackage(3, "Bsnl ABC Plan", "bsnl", 30,299));
		packages.add(new RechargePackage(4, "Bsnl xyz Plan", "bsnl", 60,500));
		packages.add(new RechargePackage(5, "cellone ABC Plan", "cellone", 30,350));
		packages.add(new RechargePackage(6, "Cellone xyz Plan", "cellone", 45,500));
	}
	public boolean checkStatus(CustomerDetails customerDetails) {
		int validity = 0;
		boolean active=false;
		Date previousReachargeDate=customerDetails.getPreviousRechargeDate();
		String previousSelectedPackage=customerDetails.getPreviousSelectedPackage();
		for(RechargePackage rechargePackage:packages) {
			if(rechargePackage.getPackageName().equals(previousSelectedPackage))
			{
				validity=rechargePackage.getValidity();
			}
		}
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar=Calendar.getInstance();
		
		calendar.setTime(previousReachargeDate);
		calendar.add(Calendar.DATE, validity);
		Date nextRechargeDate=calendar.getTime();
		Date currentDate=new Date();
		System.out.println(previousReachargeDate);
		System.out.println(nextRechargeDate);
		if(nextRechargeDate.compareTo(currentDate)>0) {
			active=true;
		}
		if(previousReachargeDate.compareTo(currentDate)>0)
		{
			throw new InvalidRechargeDateException("You selected invalid date Please select valid date");
		}
		return active;
	}
	public List<RechargePackage> getAllPackagesByPlanName(String packageName){
		List<RechargePackage> packs;
		String carrier=null;
		for(RechargePackage pack:packages) {
			if(pack.getPackageName().equalsIgnoreCase(packageName)) {
				carrier=pack.getCarrierType();
			}
		}
		packs=getAllPackages(carrier);
		return packs;
		
	}
	public List<RechargePackage> getAllPackages(String carrierType){
		List<RechargePackage> packs=new ArrayList<RechargePackage>();
		for(RechargePackage pack:packages)
		{
			if(pack.getCarrierType().equalsIgnoreCase(carrierType)) {
				packs.add(pack);
			}
		}
		return packs;
	}
	public LinkedHashMap<String,String> getPackageNames()
	{
		LinkedHashMap<String, String> packageNames=new LinkedHashMap<String, String>();
		for(RechargePackage pack:packages) {
			packageNames.put(pack.getPackageName(), pack.getPackageName());
		}
		return packageNames;
	}
	public RechargePackage getPackage(int pid) {
		RechargePackage selectedPackage=null;
		for(RechargePackage pack:packages) {
			if(pack.getId()==pid)
				selectedPackage=pack;
		}
		return selectedPackage;
	}
	
}
