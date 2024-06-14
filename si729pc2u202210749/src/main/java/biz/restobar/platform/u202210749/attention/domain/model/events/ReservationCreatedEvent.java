package biz.restobar.platform.u202210749.attention.domain.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * ReservationCreatedEvent
 * <p>
 *     Event that represents the creation of a reservation.
 * </p>
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
@Getter
public final class ReservationCreatedEvent extends ApplicationEvent {
    private final Long clientId;

    /**
     * Constructor for the event of a reservation created
     * @param source Source of the event
     * @param clientId Id of the client that created the reservation that triggered the event
     * @author Piero Gonzalo Delgado Corrales
     */
    public ReservationCreatedEvent(Object source, Long clientId) {
        super(source);
        this.clientId = clientId;
    }
}
