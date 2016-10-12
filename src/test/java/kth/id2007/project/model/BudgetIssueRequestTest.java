package kth.id2007.project.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BudgetIssueRequestTest {
	@Test
	public void createBudgetIssueRequest(){
		 int requestingDepartment=1;
		 long projectRefrenceId=21342;
		 int amount=9001;
		 String reason = "Thinngs happen...";
		 BudgetIssueRequest b = new BudgetIssueRequest(requestingDepartment, projectRefrenceId, amount, reason);
		 assertEquals("req Dep",requestingDepartment,b.getRequestingDepartment());
		 assertEquals("pro ref",projectRefrenceId,b.getProjectReferenceId());
		 assertEquals("amount",amount,b.getAmount());
		 assertEquals("reason",reason,b.getReason());		 
	}
}
