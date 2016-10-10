package kth.id2007.project.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class HrRequestTest {
	@Test
	public void createHrRequestTest(){
		 int contractType=5;
		 int requestingDepartment=6;
		 String jobTitle="Testing";
		 String jobDescription="To do tests...";
		 HrRequest r = new HrRequest(contractType, requestingDepartment, jobTitle, jobDescription);
		 assertEquals("contract",contractType,r.getContractType()); 
		 assertEquals("reqDepartment",requestingDepartment,r.getRequestingDepartment());
		 assertEquals("jobTitle",jobTitle,r.getJobTitle()); 
		 assertEquals("jobDescription",jobDescription,r.getJobDescription()); 
	}
}
