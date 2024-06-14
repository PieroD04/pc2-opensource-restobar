package biz.restobar.platform.u202210749.attention.domain.model.commands;


import java.util.Date;

/**
 * CreateReservationCommand
 * <p>
 *    This class represents the command to create a reservation.
 *    It contains the name of the restaurant, the id of the client, the date of the reservation and the number of people who will attend.
 * </p>
 * @param nameRestaurant represents the name of the restaurant where the reservation will be made
 * @param clientId represents the id of the client who will make the reservation
 * @param dateReservation represents the date of the reservation
 * @param countPerson represents the number of people who will attend the reservation
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
public record CreateReservationCommand(String nameRestaurant, Long clientId, Date dateReservation, Long countPerson) {
}
