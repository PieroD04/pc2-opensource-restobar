package biz.restobar.platform.u202210749.attention.infrastructure.persistence.jpa.repositories;

import biz.restobar.platform.u202210749.attention.domain.model.aggregates.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Repository for the Reservation aggregate.
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    /**
     * Method to check if a reservation exists by the name of the restaurant and the date of the reservation.
     * @param nameRestaurant represents the name of the restaurant for the reservation.
     * @param dateReservation represents the date of the reservation.
     * @return a boolean value indicating if that reservation exists.
     * @author Piero Gonzalo Delgado Corrales
     */
    boolean existsByNameRestaurant_NameRestaurantAndDateReservation_DateReservation(String nameRestaurant, Date dateReservation);
}
