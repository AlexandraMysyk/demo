package com.example.demo.controller;

import com.example.demo.service.EmailSenderService;
import jakarta.mail.MessagingException;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class EmailSenderController {
    @Autowired
    private EmailSenderService senderService;

    @Scheduled(cron = "0 0 12 * * ?")
    public void triggerMail(String toEmail) throws MessagingException {
        senderService.sendSimpleEmail(toEmail,
                "StudyHub",
                "Don`t be lazy! Do some work!");
    }
    @PostMapping(path="/timer",produces = "emailTimer/json")
    public void sendEmail(Date startTime, long repeatInterval, String toEmail) throws MessagingException {
       triggerMail(toEmail);
    }

}
