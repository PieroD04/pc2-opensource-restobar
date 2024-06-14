package biz.restobar.platform.u202210749.attention.domain.model.aggregates;

import biz.restobar.platform.u202210749.attention.domain.model.commands.CreateReservationCommand;
import biz.restobar.platform.u202210749.attention.domain.model.entities.Client;
import biz.restobar.platform.u202210749.attention.domain.model.events.ReservationCreatedEvent;
import biz.restobar.platform.u202210749.attention.domain.model.valueobjects.PersonCount;
import biz.restobar.platform.u202210749.attention.domain.model.valueobjects.ReservationDate;
import biz.restobar.platform.u202210749.attention.domain.model.valueobjects.RestaurantName;
import biz.restobar.platform.u202210749.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

/**
 * Reservation aggregate root
 * <p>
 *     This class represents a reservation made by a client for a restaurant.
 *     It contains the data of the reservation and the client that made it.
 *     It also contains the value objects for the reservation data.
 *     It also contains the event to be published when the reservation is created.
 *     It extends from AuditableAbstractAggregateRoot to have the auditing fields.
 * </p>
 * @see Client
 * @see ReservationCreatedEvent
 * @see PersonCount
 * @see ReservationDate
 * @see RestaurantName
 * @see CreateReservationCommand
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
@Entity
@Getter
public class Reservation extends AuditableAbstractAggregateRoot<Reservation> {
    @ManyToOne
    @JoinColumn(nullable = false, name = "client_id")
    private Client client;

    @Embedded
    private RestaurantName nameRestaurant;
    @Embedded
    private ReservationDate dateReservation;
    @Embedded
    private PersonCount countPerson;

    /**
     * Default constructor
     * @author Piero Gonzalo Delgado Corrales
     */
    public Reservation() {}

    /**
     * Constructor with the create command
     * <p>
     *     This constructor creates a reservation with the data from the command and the client that made the reservation.
     *     It also registers the event to be published when the reservation is created.
     * </p>
     * @param command CreateReservationCommand with the data to create the reservation
     * @param client Client that made the reservation
     * @see CreateReservationCommand
     * @see Client
     * @see ReservationCreatedEvent
     * @author Piero Gonzalo Delgado Corrales
     */
    public Reservation(CreateReservationCommand command, Client client) {
        this.nameRestaurant = new RestaurantName(command.nameRestaurant());
        this.dateReservation = new ReservationDate(command.dateReservation());
        this.countPerson = new PersonCount(command.countPerson());
        this.client = client;
        this.registerEvent(new ReservationCreatedEvent(this, this.client.getId()));
    }

    /**
     * Getter for nameRestaurant
     * <p>
     *     This method returns the name of the restaurant in the reservation.
     * </p>
     * @return String with the name of the restaurant
     * @see RestaurantName
     * @author Piero Gonzalo Delgado Corrales
     */
    public String getNameRestaurant() {
        return nameRestaurant.nameRestaurant();
    }

    /**
     * Getter for dateReservation
     * <p>
     *     This method returns the date of the reservation.
     * </p>
     * @return Date with the date of the reservation
     * @see ReservationDate
     * @author Piero Gonzalo Delgado Corrales
     */
    public Date getDateReservation() {
        return dateReservation.dateReservation();
    }

    /**
     * Getter for countPerson
     * <p>
     *     This method returns the number of people in the reservation.
     * </p>
     * @return Long with the number of people in the reservation
     * @see PersonCount
     * @author Piero Gonzalo Delgado Corrales
     */
    public Long getCountPerson() {
        return countPerson.countPerson();
    }
}
