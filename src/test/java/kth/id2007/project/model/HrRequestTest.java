package kth.id2007.project.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HrRequestTest {
    @Test
    public void createHrRequestTest() {
        int projectReferenceId = 1;
        int contractType = 5;
        int requestingDepartment = 6;
        String jobTitle = "Testing";
        String jobDescription = "To do tests...";
        HrRequest r = new HrRequest(projectReferenceId, contractType, requestingDepartment, jobTitle, jobDescription);
        assertEquals("project reference", projectReferenceId, r.getProjectReferenceId());
        assertEquals("contract", contractType, r.getContractType());
        assertEquals("reqDepartment", requestingDepartment, r.getRequestingDepartment());
        assertEquals("jobTitle", jobTitle, r.getJobTitle());
        assertEquals("jobDescription", jobDescription, r.getJobDescription());
    }
}
