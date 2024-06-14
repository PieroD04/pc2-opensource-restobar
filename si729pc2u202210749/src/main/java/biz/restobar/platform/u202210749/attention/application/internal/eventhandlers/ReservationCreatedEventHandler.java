package biz.restobar.platform.u202210749.attention.application.internal.eventhandlers;

import biz.restobar.platform.u202210749.attention.domain.model.events.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ReservationCreatedEventHandler {
    @EventListener(ReservationCreatedEvent.class)
    public void on(ReservationCreatedEvent event) {
        System.out.println("Reservation created for client with id: " + event.getClientId() + ".");
    }
}
