package biz.restobar.platform.u202210749.attention.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.Date;

/**
 * Value object DateReservation
 * <p>
 *   This value object represents the date of the reservation.
 *   It validates that the date of the reservation is not null.
 * </p>
 * @param dateReservation the date of the reservation. That's why its required and cannot be null.
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
@Embeddable
public record ReservationDate(Date dateReservation) {
    /**
     * Default constructor
     * <p>
     *    It sets the date of the reservation to the current date if no value is provided.
     * </p>
     * @author Piero Gonzalo Delgado Corrales
     */
    public ReservationDate(){
        this(new Date());
    }
    /**
     * Constructor
     * <p>
     *     It creates a new instance of ReservationDate with the provided date of the reservation.
     *     It validates that the date of the reservation is not null.
     * </p>
     * @param dateReservation represents the date of the reservation.
     * @throws IllegalArgumentException if the dateReservation is null.
     * @author Piero Gonzalo Delgado Corrales
     */
    public ReservationDate {
        if (dateReservation == null) {
            throw new IllegalArgumentException("dateReservation cannot be empty");
        }
    }
}
