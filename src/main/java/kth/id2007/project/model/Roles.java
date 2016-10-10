package kth.id2007.project.model;

/**
 * Class that holds roles of SEP business
 *
 * Created by kim on 2016-10-06.
 */
public final class Roles {
    /**
     * Roles
     */
    public static final String CUSTOMER_SERVICE_OFFICER = "Customer Service Officer";
    public static final String SENIOR_CUSTOMER_SERVICE_OFFICER = "Senior Cusomer Service Officer";
    public static final String FINANCIAL_MANAGER = "Financial Manager";
    public static final String SENIOR_HR_MANAGER = "Senior HR Manager";
    public static final String HR_ASSISTANT = "HR Assistant";
    public static final String MARKETING_OFFICER = "Marketing Officer";
    public static final String MARKETING_ASSISTANT = "Marketing Asistant";
    public static final String ADMINISTRATION_MANAGER = "Administration Manager";
    public static final String PRODUCTION_MANAGER = "Production Manager";
    public static final String SERVICE_MANAGER = "Service Manager";
    public static final String VICE_PRESIDENT = "Vice Presideint";
    public static final String EMPLOYEE = "Employee";
    public static final String ADMINISTRATOR = "Administrator";
    /**
     * Teams
     */
    public static final String PHOTOGRAPHER_TEAM = "Photographer team";
    public static final String AUDIO_TEAM = "Audio team";
    public static final String GRAPHIC_TEAM = "Graphic team";
    public static final String IT_TEAM = "IT team";
    public static final String DECORATING_TEAM = "Decorating team";
    public static final String COOKING_TEAM = "Cooking team";
    public static final String RESTAURANT_SERVICES_TEAM = "Restaurant services team";
    public static final String NO_TEAM = "No team";
    public static final String PRODUCTION_DEPARTMENT= "Production Department";
    public static final String SERVICE_DEPARTMENT= "Serivce Department"; 
    
    /**
     * Returns all teams
     * @return
     */
    public static  String[] getDeparments(){
    	return new String[]{SERVICE_DEPARTMENT,PRODUCTION_DEPARTMENT};
    }
    
    /**
     * Returns all roles of SEP
     * @return array of roles
     */
    public static String[] roles() {
        return new String[]{
                EMPLOYEE, CUSTOMER_SERVICE_OFFICER, SENIOR_CUSTOMER_SERVICE_OFFICER,
                FINANCIAL_MANAGER, SENIOR_HR_MANAGER, HR_ASSISTANT, MARKETING_OFFICER, MARKETING_ASSISTANT,
                ADMINISTRATION_MANAGER, PRODUCTION_MANAGER, SERVICE_MANAGER, VICE_PRESIDENT,
                ADMINISTRATOR
        };
    }

    /**
     * Returns all teams of SEP
     * @return array of teams
     */
    public static String[] teams() {
        return new String[]{
                NO_TEAM, PHOTOGRAPHER_TEAM, AUDIO_TEAM, GRAPHIC_TEAM, IT_TEAM, DECORATING_TEAM,
                COOKING_TEAM, RESTAURANT_SERVICES_TEAM
        };
    }

    /**
     * Returns all teams of the production department
     * @return array of teams
     */
    public static String[] prodDepTeams(){
        return new String[]{
                PHOTOGRAPHER_TEAM, AUDIO_TEAM, GRAPHIC_TEAM, IT_TEAM, DECORATING_TEAM
        };
    }

    /**
     * Returns all teams of the services department
     * @return array of teams
     */
    public static String[] servDepTeams(){
        return new String[]{
                COOKING_TEAM, RESTAURANT_SERVICES_TEAM
        };
    }

}
