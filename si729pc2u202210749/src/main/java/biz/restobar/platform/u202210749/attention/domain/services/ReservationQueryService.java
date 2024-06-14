package biz.restobar.platform.u202210749.attention.domain.services;



import biz.restobar.platform.u202210749.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u202210749.attention.domain.model.queries.GetAllReservationsQuery;
import biz.restobar.platform.u202210749.attention.domain.model.queries.GetReservationByIdQuery;
import biz.restobar.platform.u202210749.attention.domain.model.queries.GetReservationByNameRestaurantAndDateReservationQuery;

import java.util.List;
import java.util.Optional;

public interface ReservationQueryService {
    List<Reservation> handle(GetAllReservationsQuery query);
    Optional<Reservation> handle(GetReservationByIdQuery query);
}
