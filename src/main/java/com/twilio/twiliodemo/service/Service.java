package com.twilio.twiliodemo.service;

import com.twilio.twiliodemo.entity.TwilioConfiguration;
import com.twilio.twiliodemo.implementations.TwilioSmsSender;
//import com.twilio.twiliodemo.implementations.db.TwilioSmsSenderDb;
import com.twilio.twiliodemo.implementations.fileReading.hashmap.TwilioSmsSenderFromFile;
import com.twilio.twiliodemo.implementations.hashmap.TwilioSmsSenderNew;
import com.twilio.twiliodemo.model.SmsRequest;
import com.twilio.twiliodemo.model.SmsSender;
import com.twilio.twiliodemo.repository.SmsRepo;
import com.twilio.type.PhoneNumber;
import org.aspectj.apache.bcel.generic.LOOKUPSWITCH;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service

public class Service {
    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioConfiguration.class);

    @Autowired
    // using the interface
    private SmsRepo repo;

    private SmsSender smsSender;

    // METHOD 1
//@Autowired
//    public Service(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
//        this.smsSender = twilioSmsSender;
//    }

    // METHOD 2
//    @Autowired
//    public Service(@Qualifier("twilioDb") TwilioSmsSenderDb twilioSmsSender) {
//        this.smsSender = twilioSmsSender;
//
//    }

    // Method 3
@Autowired
    public Service(@Qualifier("twilioFromFile") TwilioSmsSenderFromFile twilioSmsSender) {
        this.smsSender = twilioSmsSender;

    }
    // METHOD 4
//    @Autowired
//    public Service(@Qualifier("twilioSoccerPlayers") TwilioSmsSenderPlayers twilioSmsSender) {
//        this.smsSender =  twilioSmsSender;
//    }


// retreive data from db
    // this is the binding part of the two pojos
//    public void smsSend(SmsRequest smsRequest) throws SQLException, ClassNotFoundException, IOException {
    public void smsSend(SmsRequest smsRequest) throws SQLException, IOException {
//        repo.getOne(smsRequest.getPhoneNumber());

        LOGGER.info("You made it, take control your database now!");

//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con = null;
        // DriverManager.getConnection("jdbc:mysql://localhost/smsDB? "user=root&password=");
//        PreparedStatement st = con.prepareStatement("select * from sms_request");
//        ResultSet r1 =st.executeQuery();
//        while(r1.next()) {
//            String name =  r1.getString("name");
//            String num = r1.getString("phoneNumber");
//            LOGGER.info(name + " " + num);
//        }




        HashMap<String, String> phoneList = new HashMap<String, String>();
    phoneList.put(smsRequest.getName(), smsRequest.getPhoneNumber());

        /*
        Connection connection = null; // = Boolean.parseBoolean(null);
//        if (connection != null) {
            System.out.println("You made it, take control your database now!");
            Statement st = connection.createStatement();
            String sql = ("SELECT * FROM sms_request;");
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("Alex");
                System.out.println(name);
                LOGGER.info(name);
            }
//        }
*/


         LOGGER.info("Phone sent to client sms {}: ", phoneList);
         smsSender.smsSender(smsRequest);
    }

    // save to  db
    public ResponseEntity<SmsRequest> addNumber(SmsRequest smsRequest){
        SmsRequest newNumber = repo.save(smsRequest);
        return  new ResponseEntity(newNumber, HttpStatus.OK);
    }

    // get from  db
//    public ResponseEntity getPhoneNumbers(Long id){
//
////        return  new ResponseEntity(smsR, HttpStatus.OK);
////
//        return   new repo.findById(id);
//
//    }

}

