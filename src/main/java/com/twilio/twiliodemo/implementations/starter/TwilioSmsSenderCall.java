package com.twilio.twiliodemo.implementations.starter;

import com.twilio.rest.api.v2010.account.Call;
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
import org.springframework.stereotype.Service;

import java.util.*;

@Service("NewtwilioCall")
public class TwilioSmsSenderCall implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioConfiguration.class);
    private SmsRepo repo;

    private TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSenderCall(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

// IMPLEMENT YOUR OWN METHOD HERE
    @Override
    public void smsSender(SmsRequest smsRequest) {

//        if(isPhoneNumberValid(smsRequest.getPhoneNumber())){
//PhoneNumber num = new PhoneNumber(smsRequest.setPhoneNumber("+12816901929"));

//        PhoneNumber to = new PhoneNumber( smsRequest.getPhoneNumber());
//        PhoneNumber from  = new PhoneNumber(twilioConfiguration.getTrialNumber());
//        String message =   smsRequest.getMessage();


//        Message message = Message.creator(
//                        new com.twilio.type.PhoneNumber("+7164250628"),
//                        new com.twilio.type.PhoneNumber("+12816901929"),
//                        "Hi there this is just a test")
//                .create();


//        LOGGER.info("from database" + repo.findById());
//        for (String t : phoneList ) {
//            PhoneNumber to = new PhoneNumber("+1" + t);
//            PhoneNumber from  = new PhoneNumber(twilioConfiguration.getTrialNumber());
//            String message =   "Hi Meles, this is Ablelom, text me a confirmation back on viber when you get this message . I am just checking if you can recieve message through this number";
//
//            MessageCreator creator = Message.creator(to, from, message);
//            creator.create();
//        }


        HashMap<String, String> employees = new HashMap<String, String>();
//        employees.put("Ablelom", "2816901929");
////        employees.put("Helen", "7132592761");
//        employees.put("Samrawit", "3375329710");
//        employees.put("Feven", "8322675895");
//        employees.put("Solomon", "7738378063");
//        employees.put("Goitom", "8323052805");
//        employees.put("Behabolom", "2816901929");

//        to see who is the employee
        System.out.println(employees.keySet());



        for (Iterator<Map.Entry<String, String>> emp = employees.entrySet().iterator(); emp.hasNext();) {

            Map.Entry<String, String> data = emp.next();
//            PhoneNumber to = new PhoneNumber( "+1" + employees.get("Ablelom"));
            PhoneNumber to = new PhoneNumber( "+1" + data.getValue());
            PhoneNumber from  = new PhoneNumber(twilioConfiguration.getTrialNumber());
//            String message =   "https://www.bing.com/search?q=houstonweather&cvid=1e1b04561d8f4860a41bcbc8fa36264a&aqs=edge..69i57j0l8.6676j0j1&pglt=675&FORM=ANNTA1&PC=EDGEDB";
            String message =   "This is Ablelom, just tsting Solo's flight to you. https://www.bing.com/search?q=flight%20status%20Turkish%20Airlines%20Flight%2033&qs=n&form=QBRE&=Search%20%7B0%7D%20for%20%7B1%7D&=Search%20work%20for%20%7B0%7D&=%25eManage%20Your%20Search%20History%25E&msbsrank=6_7__0&sp=-1&pq=flight%20status%20&sc=7-14&sk=&cvid=27F22B47753C412989470CE718369C81";


            LOGGER.info("send sms {} to: ", "key (Name): %s, value (Employee): %s %n", data.getKey(), data.getValue());

            MessageCreator creator = Message.creator(to, from, message);
            creator.create();

            // MAKING A PHONE CALL
            PhoneNumber too = new PhoneNumber( smsRequest.getPhoneNumber());
            PhoneNumber fromm  = new PhoneNumber(twilioConfiguration.getTrialNumber());

            String uri = "http://demo.twilio.com/docs/voice.xml";
            Call call = Call.creator(too , fromm, uri).create();

//        PhoneNumber to = new PhoneNumber("+12816901929");
//        PhoneNumber to = new PhoneNumber( "+1" + employees.get("Ablelom"));
//        PhoneNumber from  = new PhoneNumber(twilioConfiguration.getTrialNumber());
//        String message =   "https://www.bing.com/search?q=houstonweather&cvid=1e1b04561d8f4860a41bcbc8fa36264a&aqs=edge..69i57j0l8.6676j0j1&pglt=675&FORM=ANNTA1&PC=EDGEDB";
//        String message =   "visit the website for more info www.wehazit.com";

//        MessageCreator creator = Message.creator(to, from, message);
//        creator.create();


        }

//        PhoneNumber to = new PhoneNumber("+12816901929");
//        PhoneNumber to = new PhoneNumber( "+1" + employees.get("Ablelom"));
//        PhoneNumber from  = new PhoneNumber(twilioConfiguration.getTrialNumber());
//        String message =   "https://www.bing.com/search?q=houstonweather&cvid=1e1b04561d8f4860a41bcbc8fa36264a&aqs=edge..69i57j0l8.6676j0j1&pglt=675&FORM=ANNTA1&PC=EDGEDB";
//        String message =   "visit the website for more info www.wehazit.com";

//        MessageCreator creator = Message.creator(to, from, message);
//        creator.create();


        LOGGER.info("send sms {}: ", smsRequest);

//    }else{
//        throw new IllegalArgumentException("Phone Number [ " + smsRequest.getPhoneNumber() +" ] is not a valid number");
//    }

    }


//    private boolean isPhoneNumberValid(String phoneNumber) {
//        // TODO: implement phone validation
//        return false;
//    }

}
