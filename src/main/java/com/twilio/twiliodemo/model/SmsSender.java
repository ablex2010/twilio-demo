package com.twilio.twiliodemo.model;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public interface SmsSender {

    void smsSender(SmsRequest smsRequest) throws SQLException, FileNotFoundException, IOException;

}
