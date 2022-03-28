package com.twilio.twiliodemo.implementations;

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

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioConfiguration.class);

    private TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

// IMPLEMENT YOUR OWN METHOD HERE
    @Override
    public void smsSender(SmsRequest smsRequest) {

//        if(isPhoneNumberValid(smsRequest.getPhoneNumber())){


        PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber from  = new PhoneNumber(twilioConfiguration.getTrialNumber());

       // String message = "......";

        String message = smsRequest.getMessage();



        MessageCreator creator = Message.creator(to, from, message);
        creator.create();

        LOGGER.info("send sms {}", smsRequest);

//    }else{
//        throw new IllegalArgumentException("Phone Number [ " + smsRequest.getPhoneNumber() +" ] is not a valid number");
//    }

    }


    private boolean isPhoneNumberValid(String phoneNumber) {
        // TODO: implement phone validation
        return false;
    }
}
