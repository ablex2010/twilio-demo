package com.twilio.twiliodemo.initializer;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiliodemo.entity.TwilioConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TiwilioInitializer {

    private  final static Logger LOGGER = LoggerFactory.getLogger(TiwilioInitializer.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
public TiwilioInitializer(TwilioConfiguration twilioConfiguration){
    this.twilioConfiguration = twilioConfiguration;

    Twilio.init(
            twilioConfiguration.getAccountSid(),
            twilioConfiguration.getAuthToken()
    );

// not compaitable for now
//    Message message = Message.creator(
//                    new com.twilio.type.PhoneNumber("+12816901929"),
//                    "ACd8ff9d3b0ec34e637e99068755253afd",
//                    "Hello Friend"
//            ).create();


    LOGGER.info("TwilioInitializer .... with twilioInitializer SID {} ", twilioConfiguration.getAccountSid());
}


}
