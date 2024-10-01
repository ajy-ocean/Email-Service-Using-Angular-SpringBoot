package com.email.controller;


import com.email.model.EmailRequest;
import com.email.model.EmailResponse;
import com.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/welcome")
    public String greeting() {
        return "Hi, Welcome";
    }

    @RequestMapping(value="/send-mail", method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
        System.out.println(request);
        if (request.getTo() == null || request.getSubject() == null || request.getMessage() == null) {
            return ResponseEntity.badRequest().body(new EmailResponse("Invalid input data"));
        }
        // boolean result =  this.emailService.sendEmailUsingGmail(request.getSubject(), request.getMessage(), request.getTo());
        boolean result =  this.emailService.sendEmailUsingRediffPro(request.getSubject(), request.getMessage(), request.getTo());
        if(result){
            return ResponseEntity.ok(new EmailResponse("Sent..Successfully"));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Something went wrong"));
        }
    }
}
