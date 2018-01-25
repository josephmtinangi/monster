package io.github.josephmtinangi.monster.publishers;

import io.github.josephmtinangi.monster.events.UserRegistered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class UserRegisteredEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void doStuffAndPublishAnEvent(final String message) {
        System.out.println("Publishing custom event.");
        UserRegistered userRegistered = new UserRegistered(this, message);
        applicationEventPublisher.publishEvent(userRegistered);
    }
}
