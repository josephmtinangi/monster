package io.github.josephmtinangi.monster.controllers.auth;

import io.github.josephmtinangi.monster.events.UserRegistered;
import io.github.josephmtinangi.monster.utilities.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<?> register(){

        System.out.println("Publishing custom event.");
        UserRegistered userRegistered = new UserRegistered(this, "josephmtinangi@gmail.com");
        applicationEventPublisher.publishEvent(userRegistered);

        return Helper.createResponse(true, null, null, HttpStatus.CREATED);
    }
}
