package biz.restobar.platform.u202210749.attention.application.internal.queryservices;

import biz.restobar.platform.u202210749.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u202210749.attention.domain.model.queries.GetAllReservationsQuery;
import biz.restobar.platform.u202210749.attention.domain.model.queries.GetReservationByIdQuery;
import biz.restobar.platform.u202210749.attention.domain.services.ReservationQueryService;
import biz.restobar.platform.u202210749.attention.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationQueryServiceImpl implements ReservationQueryService {
    private final ReservationRepository reservationRepository;

    public ReservationQueryServiceImpl(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }
    @Override
    public List<Reservation> handle(GetAllReservationsQuery query){
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> handle(GetReservationByIdQuery query){
        return reservationRepository.findById(query.reservationId());
    }


}
