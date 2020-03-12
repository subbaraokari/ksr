package com.cts.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.service.RechargeService;
@SpringBootTest
public class CustomerDetailsTest {

	static CustomerDetails customerdetails=null;
	RechargeService rechargeservice = new RechargeService();
	/*
	 * @BeforeAll public static void setUp() { customerdetails= new
	 * CustomerDetails(); customerdetails.setName("ksrao");
	 * customerdetails.setMobileNo("9505962345");
	 * customerdetails.setPreviousRechargeDate("02/02/2018");
	 * customerdetails.setPreviousSelectedPackage("Airtel ABC Plan"); }
	 */
	@Test
	public void TestExpectedName() {
		String expectedName = "ksrao";
		assertEquals(expectedName, customerdetails.getName());
	}
	@Test
	public void TestMobileNo() {
		String expectedMobileNo = "9505962345";
		assertEquals(expectedMobileNo, customerdetails.getMobileNo());
	}
	@Test
	public void TestExpectedPreviousRechargeDate()
	{
		String expectedPreviousRechargeDate = "02/02/2018";
		assertEquals(expectedPreviousRechargeDate, customerdetails.getPreviousRechargeDate());
	}
	@Test
	public void TestExpectedpreviousSelectedPackage()
	{
		String expectedPreviousSelectedPackage = "Airtel ABC Plan";
		assertEquals(expectedPreviousSelectedPackage, customerdetails.getPreviousSelectedPackage());
	}
	@Test
	public void TestHashMap()
	{
		assertNotNull(customerdetails.getPackageNames());
	}
	@AfterAll
	public static void tearDown()
	{
		customerdetails=null;
	}

}
