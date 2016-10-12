package kth.id2007.project.model;

/**
 * @author Kim Hammar on 2016-10-12.
 */
public class EventStatus {
    public static final String CREATED = "CREATED";
    public static final String OPEN = "OPEN";
    public static final String IN_PROGRESS = "IN PROGRESS";
    public static final String CLOSED_AND_ARCHIVED = "CLOSED AND ARCHIVED";

    public static String[] getAllStatuses(){
        return new String[]{
                CREATED, OPEN, IN_PROGRESS, CLOSED_AND_ARCHIVED
        };
    }
}
