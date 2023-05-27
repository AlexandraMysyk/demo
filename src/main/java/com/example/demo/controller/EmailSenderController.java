package com.example.demo.controller;

import com.example.demo.service.EmailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailSenderController {
    @Autowired
    private EmailSenderService senderService;

    @Scheduled(cron = "@weekly")
    public void triggerMailWeekly(String toEmail) throws MessagingException {
        senderService.sendSimpleEmail(toEmail,
                "StudyHub",
                "Don`t be lazy! Do some work!");
    }
    @Scheduled(cron = "@daily")
    public void triggerMailDaily(String toEmail) throws MessagingException {
        senderService.sendSimpleEmail(toEmail,
                "StudyHub",
                "Don`t be lazy! Do some work!");
    }
    @Scheduled(cron = "@monthly")
    public void triggerMailMonthly(String toEmail) throws MessagingException {
        senderService.sendSimpleEmail(toEmail,
                "StudyHub",
                "Don`t be lazy! Do some work!");
    }
    @RequestMapping(path="/timer/{toEmail}/{frequency}",produces = "emailTimer/json")
    public void sendEmail(@RequestBody @PathVariable String toEmail, @RequestBody @PathVariable String frequency) throws MessagingException {
        switch (frequency) {
            case "weekly": {
                triggerMailWeekly(toEmail);
                break;
            }
            case "daily":{
                triggerMailDaily(toEmail);
                break;
            }
            case "monthly":{
                triggerMailMonthly(toEmail);
                break;
            }
        }
    }

}