package com.twilio.twiliodemo.controller;

import com.twilio.twiliodemo.entity.TwilioConfiguration;
import com.twilio.twiliodemo.model.SmsRequest;
import com.twilio.twiliodemo.repository.SmsRepo;
import com.twilio.twiliodemo.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@RestController
@RequestMapping("/api/v1/sms")
public class Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioConfiguration.class);

    @Autowired
    private Service service;

    @Autowired
    private SmsRepo repo;

//    @Autowired
//    public Controller(Service service) {
//        this.service = service;
//    }


// sending out text to people
@PostMapping(path = "/txt")
public void sendSms( @Valid @RequestBody SmsRequest smsRequest) throws SQLException, ClassNotFoundException, IOException {

//    HashMap<String, String> phoneList = new HashMap<String, String>();
//    phoneList.put(smsRequest.getName(), smsRequest.getPhoneNumber());

//    LOGGER.info("Phone sent to client sms {}: ", phoneList);

    service.smsSend(smsRequest);
}



    // send in to the DB
    @PostMapping(path = "/add")
    public ResponseEntity<SmsRequest> numberAdded(@Valid @RequestBody SmsRequest smsRequest){
        HashMap<String, String> phoneList = new HashMap<String, String>();
        phoneList.put(smsRequest.getName(), smsRequest.getPhoneNumber());

        LOGGER.info("Phone added to the Phone List sms {}: ", phoneList);
        return  service.addNumber(smsRequest);
    }

    // get from db
//    @GetMapping(path = "/getPhones")
//    public ResponseEntity getNumbers(Long id){
//        HashMap<String, String> phoneNumbers = new HashMap<String, String>();
//
//    return  service.getPhoneNumbers(id);
////        Optional<SmsRequest> smsR =   repo.findById((long) id);
////        return  new ResponseEntity(smsR, HttpStatus.OK);
//    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<SmsRequest> theEmployees = new ArrayList<>();
        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "registration";
    }
}
