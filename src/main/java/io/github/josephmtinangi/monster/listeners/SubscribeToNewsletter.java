package io.github.josephmtinangi.monster.listeners;

import io.github.josephmtinangi.monster.events.UserRegistered;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SubscribeToNewsletter implements ApplicationListener<UserRegistered> {

    @Override
    public void onApplicationEvent(UserRegistered userRegistered) {
        System.out.println("Subscribe " + userRegistered.getMessage() + " to newsletter");
    }
}
