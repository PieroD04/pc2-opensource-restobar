package biz.restobar.platform.u202210749.attention.application.internal.commandservices;

import biz.restobar.platform.u202210749.attention.domain.exceptions.ClientNotFoundException;
import biz.restobar.platform.u202210749.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u202210749.attention.domain.model.commands.CreateReservationCommand;
import biz.restobar.platform.u202210749.attention.domain.services.ReservationCommandService;
import biz.restobar.platform.u202210749.attention.infrastructure.persistence.jpa.repositories.ClientRepository;
import biz.restobar.platform.u202210749.attention.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationCommandServiceImpl implements ReservationCommandService {
    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    public ReservationCommandServiceImpl(ReservationRepository reservationRepository, ClientRepository clientRepository){
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
    }
    @Override
    public Optional<Reservation> handle(CreateReservationCommand command) {
        if(reservationRepository.existsByNameRestaurant_NameRestaurantAndDateReservation_DateReservation(command.nameRestaurant(), command.dateReservation())){
            throw new IllegalArgumentException("Reservation with Restaurant Name: " + command.nameRestaurant() + " and Date of Reservation: " + command.dateReservation() + " already exists");
        }

        var client = clientRepository.findById(command.clientId())
                .orElseThrow(() -> new ClientNotFoundException(command.clientId()));

        var reservation = new Reservation(command, client);

        try{
            reservationRepository.save(reservation);
         } catch (Exception e){
            throw new IllegalArgumentException("Error while saving user: " + e.getMessage());
        }
        return Optional.of(reservation);
    }

}
