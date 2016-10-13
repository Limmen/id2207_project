package kth.id2007.project.model;

import org.junit.Test;

import static kth.id2007.project.model.EventStatus.*;
import static org.junit.Assert.assertArrayEquals;

/**
 * Test-suite for EventStatus class
 *
 * Created by kim on 2016-10-13.
 */
public class EventStatusTest {

    /**
     * Test for getAllStatuses method
     */
    @Test
    public void getAllStatuses(){
        String[] statuses = new String[]{
                CREATED, OPEN, IN_PROGRESS, CLOSED_AND_ARCHIVED
        };
        assertArrayEquals("Should return all statuses", statuses, EventStatus.getAllStatuses());
    }

}