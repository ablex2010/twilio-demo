package com.twilio.twiliodemo.implementations.db;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.twiliodemo.entity.TwilioConfiguration;
import com.twilio.twiliodemo.model.SmsRequest;
import com.twilio.twiliodemo.model.SmsSender;
import com.twilio.twiliodemo.repository.SmsRepo;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service("twilioDb")
public class TwilioSmsSenderDb implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioConfiguration.class);

    private SmsRepo repo;

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSenderDb(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

// IMPLEMENT YOUR OWN METHOD HERE
    @Override
    public void smsSender(SmsRequest smsRequest) {

//        if(isPhoneNumberValid(smsRequest.getPhoneNumber())){
//PhoneNumber num = new PhoneNumber(smsRequest.setPhoneNumber("+12816901929"));

        // body comes from postman or end users to the text
        PhoneNumber to = new PhoneNumber( smsRequest.getPhoneNumber());
        PhoneNumber from  = new PhoneNumber(twilioConfiguration.getTrialNumber());
        String message =   smsRequest.getMessage();



/*
// Read from hash map
        HashMap<String, String> employees = new HashMap<String, String>();
        employees.put("Ablelom", "2816901929");
//        employees.put("Helen", "7132592761");
//        employees.put("Samrawit", "3375329710");
//        employees.put("Feven", "8322675895");
//        employees.put("Solomon", "7738378063");
//        employees.put("Goitom", "8323052805");

//        employees.put("Behabolom", "2816901929");

//        to see who is the employee
       LOGGER.info("send sms {}: ", employees.keySet());

        for (Iterator<Map.Entry<String, String>> emp = employees.entrySet().iterator();
             emp.hasNext();) {

            Map.Entry<String, String> data = emp.next();
            PhoneNumber to = new PhoneNumber( "+1" + data.getValue());
            PhoneNumber from  = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = "Hello World";
*/


//            MessageCreator creator = Message.creator(to, from, message);
//            creator.create();

        LOGGER.info("send sms {}: ", smsRequest);

        }

    // save to  db
//    public ResponseEntity<SmsRequest> addNumber(SmsRequest smsRequest){
//        SmsRequest newNumber = repo.save(smsRequest);
//        return  new ResponseEntity(newNumber, HttpStatus.OK);
//    }



//    }else{
//        throw new IllegalArgumentException("Phone Number [ " + smsRequest.getPhoneNumber() +" ] is not a valid number");
//    }

//    }


//    private boolean isPhoneNumberValid(String phoneNumber) {
//        // TODO: implement phone validation
//        return false;
//    }

}
