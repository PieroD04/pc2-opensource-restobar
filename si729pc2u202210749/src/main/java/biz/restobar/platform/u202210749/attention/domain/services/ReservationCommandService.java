package biz.restobar.platform.u202210749.attention.domain.services;

import biz.restobar.platform.u202210749.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u202210749.attention.domain.model.commands.CreateReservationCommand;

import java.util.Optional;

public interface ReservationCommandService {
    Optional<Reservation> handle(CreateReservationCommand command);
}
