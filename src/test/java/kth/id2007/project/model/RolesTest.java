package kth.id2007.project.model;

import org.junit.Test;

import static kth.id2007.project.model.Roles.*;
import static org.junit.Assert.assertArrayEquals;

/**
 * Test suite for Roles class
 *
 * Created by kim on 2016-10-06.
 */
public class RolesTest {

    /**
     * Test for roles method
     */
    @Test
    public void roles() {
        String[] roles = new String[]{
                EMPLOYEE, CUSTOMER_SERVICE_OFFICER, SENIOR_CUSTOMER_SERVICE_OFFICER,
                FINANCIAL_MANAGER, SENIOR_HR_MANAGER, HR_ASSISTANT, MARKETING_OFFICER, MARKETING_ASSISTANT,
                ADMINISTRATION_MANAGER, PRODUCTION_MANAGER, SERVICE_MANAGER, VICE_PRESIDENT,
                ADMINISTRATOR
        };
        assertArrayEquals("Should return all roles", roles, Roles.roles());
    }

    /**
     * Test for teams method
     */
    @Test
    public void teams() {
        String[] teams = new String[]{
                NO_TEAM, PHOTOGRAPHER_TEAM, AUDIO_TEAM, GRAPHIC_TEAM, IT_TEAM, DECORATING_TEAM,
                COOKING_TEAM, RESTAURANT_SERVICES_TEAM
        };
        assertArrayEquals("Should return all teams", teams, Roles.teams());
    }

    /**
     * Test for prodDepTeams method
     */
    @Test
    public void prodDepTeams() {
        String[] prodTeams = new String[]{
                PHOTOGRAPHER_TEAM, AUDIO_TEAM, GRAPHIC_TEAM, IT_TEAM, DECORATING_TEAM
        };
        assertArrayEquals("Should return all production department teams", prodTeams, Roles.prodDepTeams());
    }

    /**
     * Test for servDepTeams method
     */
    @Test
    public void servDepTeams() {
        String[] servTeams = new String[]{
                COOKING_TEAM, RESTAURANT_SERVICES_TEAM
        };
        assertArrayEquals("Should return all service department teams", servTeams, Roles.servDepTeams());
    }

    /**
     * Test for getDepartments method
     */
    @Test
    public void getDepartments(){
        String[] departments = new String[]{SERVICE_DEPARTMENT,PRODUCTION_DEPARTMENT};
        assertArrayEquals("Should return all departments", departments, Roles.getDeparments());
    }
}