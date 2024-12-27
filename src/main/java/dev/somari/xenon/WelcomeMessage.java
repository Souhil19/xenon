package dev.somari.xenon;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
    public String getMessage(){
        return "Welcome User";
    }
}
