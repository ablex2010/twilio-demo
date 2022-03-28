package com.twilio.twiliodemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "sms_request")
public class SmsRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
    @Column(name = "id")
    private Long id;

@Column(name = "name")
    private String name;

//    @NotBlank
    @Column(name = " phone_number")
    private String phoneNumber ;  //destination

//    @NotBlank
    @Column
    private String message ; // messsage ready to be sent

    public void setMessage(String message) {
//        this.message = "This message is coming from Tena Soccer Group texting you from my other number: " + message;
        this.message = "This message is for Tena Team: " + message;
//        this.message = "It is a test." + message;
    }


    
    
}
