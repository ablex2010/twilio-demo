package com.twilio.twiliodemo.implementations.fileReading.hashmap;

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

import java.io.*;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.*;

@Service("twilioFromFile")
public class TwilioSmsSenderFromFile implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioConfiguration.class);
    private TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSenderFromFile(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    // IMPLEMENT YOUR OWN METHOD HERE data reading from file
    @Override
    public void smsSender(SmsRequest smsRequest) throws IOException {

//        String inPutpath1 = "C:\\Users\\ablex\\OneDrive\\Desktop\\SMS\\SampleInput.txt";
//        String inPutpath2 = "C:\\Users\\ablex\\OneDrive\\Desktop\\SMS\\TenaSoccerTeamMessage.txt";

        String outPutPath = "C:\\Users\\ablex\\OneDrive\\Desktop\\SMS\\SampleOutput.txt";


        String inPutpath1 = "C:\\Users\\ablex\\OneDrive\\Desktop\\SMS\\SampleInput.txt";
        String inPutpath2 = "C:\\Users\\ablex\\OneDrive\\Desktop\\SMS\\SampleMessage.txt";

//        String inPutpath1 = "C:\\Users\\ablex\\OneDrive\\Desktop\\SMS\\EritreanSoccerInput.txt";
//        String inPutpath2 = "C:\\Users\\ablex\\OneDrive\\Desktop\\SMS\\EritreanSoccerMessage.txt";

//        String inPutpath1 = "C:\\Users\\ablex\\OneDrive\\Desktop\\SMS\\TenaSoccerTeamInput.txt";
//        String inPutpath2 = "C:\\Users\\ablex\\OneDrive\\Desktop\\SMS\\TenaSoccerTeamMessage.txt";

//        String inPutpath2 = "C:\\Users\\ablex\\OneDrive\\Desktop\\SMS\\AbunelibanosInput.txt";
//        String inPutpath2 = "C:\\Users\\ablex\\OneDrive\\Desktop\\SMS\\AbunelibanosMessage.txt";


        BufferedReader numListSendTo = new BufferedReader(new FileReader(inPutpath1));
        BufferedReader txtMsg = new BufferedReader(new FileReader(inPutpath2));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outPutPath));


        HashMap<String, String> employees = new HashMap<String, String>();


        int count = 1;
        String line;
        while ((line = numListSendTo.readLine()) != null) {
//		            String[] pair = line.split(",");
//		            String[] pair = line.split(" ");
            String[] pair = line.split(":");

//						   System.out.println(count + ". " + line);
//		            if(line == "\n") {
//		            	line = reader.readLine();
//		            }

            System.out.println("===========================================");

            // good to go printed name list
            List<String> ls =  Arrays.asList(pair);



//		            System.out.println(ls.get(0) + ": " + ls.get(1) + "  " + ls.get(2) + " : " + ls.get(3));

            employees.put(ls.get(0), ls.get(1));

            System.out.println(count + ". " + ls.get(0) + " : " + ls.get(1));





            // Writing on file output
            writer.write("Writing to a file.");
            writer.write("\nOne line of inout on the  second line.");

            String[] names = { "Marry", "John", "Alex", "Boby", "Eric" };
            for (String name : names) {
                writer.write("\n" + name, 0, names.length);
                writer.write(line);
                writer.write("Hello");
            }

            writer.write("\n==============MESSAGES===============\n");
            writer.write(numListSendTo.toString());
            writer.write("message read from file inputMessage");
            writer.write("\n");
            writer.write(count + "." + ls.toString());
            writer.write("\n");
            writer.write(employees.toString());

            writer.write("\n==============NEXTSTEP===============\n");
            writer.close();

            count++;
        }


        for(Iterator<Map.Entry<String, String>> emp = employees.entrySet().iterator();
             emp.hasNext();) {

        Map.Entry<String, String> data = emp.next();
        PhoneNumber to = new PhoneNumber("+1" + data.getValue());
//        PhoneNumber to = new PhoneNumber("+1" + "281-690-1929");
//        PhoneNumber to = new PhoneNumber("+1" + "780-881-6066"); // Mebrahtu Canada
//        PhoneNumber to = new PhoneNumber("+011"+ "251" + "94" + "774" + "0678"); // Meles
//        PhoneNumber to = new PhoneNumber("+011"+ "251" + "93" + "877" + "5399"); // Hirut
//        PhoneNumber to = new PhoneNumber("+44" + "207" + "183" + "8750");
//        PhoneNumber to = new PhoneNumber("+11"+ "46" + "762" + "17" + "2990");

        PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());

//        String link = "\" Please check your txt for upcoming information please..\"";
              String link  = "\" Be on time for tomorrow's soccer game. Game startes at 7:30 am.\"";
//            String link = "https://www.bing.com/search?pc=CBHS&ptag=N9175D091721AAA0D337D47&form=CONBDF&conlogo=CT2174808&q=houstonweather ";
//            String link = "https://ais.usvisa-info.com/en-et/iv/users/sign_in/iv";
//            String link = "Call me on viber, when you get this message.";
//            String link = "https://www.bing.com/search?q=houston+weather&cvid=95efcd0a5e6c41fab71a8eda61daffa4&aqs=edge.0.0l9.3887j0j4&FORM=ANAB01&PC=EDGEDB\n";
//            String link = "https://status.dat.com/?utm_source=embed";
        String message = "Hi, " + data.getKey() + " " + smsRequest.getMessage() + txtMsg.readLine() + link;
//        String message = "Hi ,  " + smsRequest.getMessage() + txtMsg.readLine() + link ;
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
