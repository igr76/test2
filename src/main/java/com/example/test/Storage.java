package com.example.test;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventBus;
import com.vaadin.flow.component.html.Div;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/** Формирование сообщений чата */
@Component
public class Storage {
    private static DataNumber dataNumber;
    @Getter
    private Queue<DataNumber> messages = new ConcurrentLinkedQueue<>();
    private ComponentEventBus eventBus = new ComponentEventBus(new Div());
    @Getter
    @Setter
    public static class ChatMessage {
         String name;
         String message;

        public ChatMessage(String name, String message) {
            this.name = name;
            this.message = message + dataNumber.getNumber();
        }
    }
    public static class ChatEvent extends ComponentEvent<Div> {

        public ChatEvent() {
            super(new Div(),false);
        }
    }
}
