package biz.restobar.platform.u202210749.attention.interfaces.rest.transform;

import biz.restobar.platform.u202210749.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u202210749.attention.interfaces.rest.resources.ReservationResource;

public class ReservationResourceFromEntityAssembler {
    public static ReservationResource toResourceFromEntity(Reservation entity){
        return new ReservationResource(
                entity.getId(),
                entity.getNameRestaurant(),
                entity.getClient().getId(),
                entity.getDateReservation(),
                entity.getCountPerson()
        );
    }
}
