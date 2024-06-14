package biz.restobar.platform.u202210749.attention.domain.model.queries;

import java.util.Date;

/**
 * GetReservationByNameRestaurantAndDateReservationQuery
 * @param nameRestaurant
 * @param dateReservation
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
public record GetReservationByNameRestaurantAndDateReservationQuery(String nameRestaurant, Date dateReservation) {
}
