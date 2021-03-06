package kth.id2007.project.model;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Test suite for ClientRecord class
 */
public class ClientRecordTest {

    /**
     * Test for ClientRecord initialization
     */
	@Test
    public void createClientRecordTest(){
        String name = "Alice";
        String email = "alice@alice.com";
        String phone = "123453234";
        
        Date creationDate=new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy/mm/dd/hh/mm");
        System.out.println();
        ClientRecord cli = new ClientRecord(name, email, phone, null);

        assertEquals("Client Name fail", name, cli.getClientName());
        assertEquals("Client Email fail", email, cli.getClientEmail());
        assertEquals("Client Phone Number fail", phone, cli.getClientPhoneNumber());
        assertEquals("Client history fail", null, cli.getClientHistory());
        assertEquals("Client creation date mismatch", date.format(creationDate), date.format(cli.getCreationDate()));
    }

}
