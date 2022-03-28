package com.twilio.twiliodemo.sample;

    import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

    import com.twilio.Twilio;
    import com.twilio.converter.Promoter;
    import com.twilio.rest.api.v2010.account.Message;
    import com.twilio.type.PhoneNumber;

    import java.net.URI;
    import java.math.BigDecimal;

class Exampe {
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "ACd8ff9d3b0ec34e637e99068755253afd";
    public static final String AUTH_TOKEN = "[AuthToken]";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
//                        new com.twilio.type.PhoneNumber("+12816901929", "+17132592761" ),
//                        new com.twilio.type.PhoneNumber("+12816901929"),
                        new com.twilio.type.PhoneNumber("+17132592761"),
                        "MG77e3a535752267e4ba1ed360cfb0e84d",
                        "Hello http://www.wehazit.com")
                .create();

        System.out.println(message.getSid());
    }
}








