package biz.restobar.platform.u202210749.attention.interfaces.rest.resources;

import java.util.Date;

public record CreateReservationResource(String nameRestaurant, Long clientId, Date dateReservation, Long countPerson) {
}
