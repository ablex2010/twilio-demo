package com.twilio.twiliodemo.implementations.hashmap;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.twiliodemo.entity.TwilioConfiguration;
import com.twilio.twiliodemo.model.SmsRequest;
import com.twilio.twiliodemo.model.SmsSender;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

@Service("Newtwilio")
public class TwilioSmsSenderNew implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioConfiguration.class);
    private TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSenderNew(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

// IMPLEMENT YOUR OWN METHOD HERE
    @Override
    public void smsSender(SmsRequest smsRequest) throws SQLException {

//        if(isPhoneNumberValid(smsRequest.getPhoneNumber())){
//PhoneNumber num = new PhoneNumber(smsRequest.setPhoneNumber("+12816901929"));

//        PhoneNumber to = new PhoneNumber( smsRequest.getPhoneNumber());
//        PhoneNumber from  = new PhoneNumber(twilioConfiguration.getTrialNumber());
//        String message =   smsRequest.getMessage();



        HashMap<String, String> employees = new HashMap<String, String>();
        employees.put("Ablelom", "555-555-5555");


        HashMap<String, String> soccergroup = new HashMap<String, String>();


        HashMap<String, String> itGroup = new HashMap<String, String>();


//        to see who is the employee
//       LOGGER.info("send sms {}: ", soccergroup.keySet());
//       LOGGER.info("send sms {}: ", employees.keySet());


//        Connection connection = null;
//        if (connection != null) {
//            System.out.println("You made it, take control your database now!");
//            Statement st = connection.createStatement();
//            String sql = ("SELECT * FROM sms_request;");
//            ResultSet rs = st.executeQuery(sql);
//
//        while(rs.next()){
//            int id = rs.getInt(1);
//            String message = rs.getString("message");
//            String phone = rs.getString("phoneNumber");
//            String name = rs.getString("name");
//
//            LOGGER.info("send sms {}: ", id, message, phone, name);
//        }
//
//        }


//        for (Iterator<Map.Entry<String, String>> emp = soccergroup.entrySet().iterator();
        for (Iterator<Map.Entry<String, String>> emp = employees.entrySet().iterator();
             emp.hasNext();) {

            Map.Entry<String, String> data = emp.next();
            PhoneNumber to = new PhoneNumber( "+1" + data.getValue());
            PhoneNumber from  = new PhoneNumber(twilioConfiguration.getTrialNumber());

//              String link  = "\" Please check your txt for upcoming information please..\"";
//              String link  = "\" Be on time for tomorrow's soccer game. Game startes at 7:30 am.\"";
//            String link = "https://www.bing.com/search?pc=CBHS&ptag=N9175D091721AAA0D337D47&form=CONBDF&conlogo=CT2174808&q=houstonweather ";
//            String link = "https://ais.usvisa-info.com/en-et/iv/users/sign_in/iv";
//            String link = "https://portal.fmcsa.dot.gov/login";
            String link = "https://status.dat.com/?utm_source=embed";

             String message = "Hi, "  + data.getKey() + " " + smsRequest.getMessage() + link;
//            String message = " Please check your txt for upcoming information please..";

          MessageCreator creator = Message.creator(to, from, message);
            creator.create();


        }








//        LOGGER.info("send sms {}: ", smsRequest);

//    }else{
//        throw new IllegalArgumentException("Phone Number [ " + smsRequest.getPhoneNumber() +" ] is not a valid number");
//    }

    }


//    private boolean isPhoneNumberValid(String phoneNumber) {
//        // TODO: implement phone validation
//        return false;
//    }
}
