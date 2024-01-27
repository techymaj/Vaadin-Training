package org.vaadin.example;

import com.vaadin.flow.component.notification.Notification;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class GreetService implements Serializable {

    public Notification greet(String name) {
        if (name == null || name.isEmpty()) {
            return Notification.show("Hello anonymous user");
        } else {
            return Notification.show("Hello " + name);
        }
    }

}
