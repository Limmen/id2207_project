package kth.id2007.project.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test-suite for SubTeamTask class
 */
public class SubTeamTaskTest {

    /**
     * Test for initialization of a SubTeamTask
     */
	@Test
	public void createSubTeamTask(){
		 long projectRefrenceId=23412324;
		 String description="Testing awfd";
		 String assignedTo="Some team";
		 int priority=9001;
		
		 SubTeamTask t=new SubTeamTask(projectRefrenceId, description, assignedTo, priority);
		 assertEquals("projectRefrenceId",projectRefrenceId,t.getProjectReferenceId());
		 assertEquals("description",description,t.getDescription());
		 assertEquals("assignedTo",assignedTo,t.getAssignedTo());
		 assertEquals("priority",priority,t.getPriority());
	}

}
