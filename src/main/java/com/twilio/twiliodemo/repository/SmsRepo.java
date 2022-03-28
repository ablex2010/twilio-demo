package com.twilio.twiliodemo.repository;

import com.twilio.twiliodemo.model.SmsRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsRepo extends JpaRepository<SmsRequest, Long> {
}
