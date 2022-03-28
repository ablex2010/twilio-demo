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

//    private final TwilioConfiguration twilioConfiguration;
    private  TwilioConfiguration twilioConfiguration;

    @Autowired
public TiwilioInitializer(TwilioConfiguration twilioConfiguration){
    this.twilioConfiguration = twilioConfiguration;

    Twilio.init(
            twilioConfiguration.getAccountSid(),
            twilioConfiguration.getAuthToken()
    );



    LOGGER.info("TwilioInitializer .... with twilioInitializer SID {} ", twilioConfiguration.getAccountSid());
}


}
