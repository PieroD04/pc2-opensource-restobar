package biz.restobar.platform.u202210749.attention.interfaces.rest;

import biz.restobar.platform.u202210749.attention.domain.model.queries.GetAllReservationsQuery;
import biz.restobar.platform.u202210749.attention.domain.model.queries.GetReservationByIdQuery;
import biz.restobar.platform.u202210749.attention.domain.services.ReservationCommandService;
import biz.restobar.platform.u202210749.attention.domain.services.ReservationQueryService;
import biz.restobar.platform.u202210749.attention.interfaces.rest.resources.CreateReservationResource;
import biz.restobar.platform.u202210749.attention.interfaces.rest.resources.ReservationResource;
import biz.restobar.platform.u202210749.attention.interfaces.rest.transform.CreateReservationCommandFromResourceAssembler;
import biz.restobar.platform.u202210749.attention.interfaces.rest.transform.ReservationResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * ReservationsController
 * <p>
 *     This class is the entry point for all the REST endpoints related to the Reservation entity.
 *     It handles the creation of new Reservations, the retrieval of all Reservations and the retrieval of a Reservation by its ID.
 * </p>
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */

@RestController
@RequestMapping(value="/api/v1/reservations", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Reservations", description = "Reservation Endpoints")
public class ReservationsController {
    private final ReservationCommandService reservationCommandService;
    private final ReservationQueryService reservationQueryService;

    public ReservationsController(ReservationCommandService reservationCommandService, ReservationQueryService reservationQueryService) {
        this.reservationCommandService = reservationCommandService;
        this.reservationQueryService = reservationQueryService;
    }

    /**
     * Get all Reservations from the database
     * @return a list of all Reservations
     * @author Piero Gonzalo Delgado Corrales
     */
    @Operation(summary="Get all Reservations", description="Get all Reservations.")
    @GetMapping
    public ResponseEntity<List<ReservationResource>> getAllReservations() {
        var getAllReservationsQuery = new GetAllReservationsQuery();
        var reservations = reservationQueryService.handle(getAllReservationsQuery);
        var reservationResources = reservations.stream()
                .map(ReservationResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(reservationResources);
    }
    /**
     * Get a Reservation by its ID from the database
     * @param reservationId the ID of the Reservation
     * @return the Reservation with the given ID or a 404 if it does not exist
     * @author Piero Gonzalo Delgado Corrales
     */
    @Operation(summary="Get a Reservation by its ID", description="Get a Reservation by its ID.")
    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservationResource> getReservation(@PathVariable("reservationId")
                                                              @Parameter(name = "reservationId", description = "The ID of the Reservation", required = true, example = "1")
                                                                  Long reservationId)
    {
        var getReservationByIdQuery = new GetReservationByIdQuery(reservationId);
        var reservation = reservationQueryService.handle(getReservationByIdQuery);
        if (reservation.isEmpty()) return ResponseEntity.notFound().build();
        var reservationResource = ReservationResourceFromEntityAssembler.toResourceFromEntity(reservation.get());
        return ResponseEntity.ok(reservationResource);
    }

    /**
     * Create a new Reservation with the input data in the request body and return the created Reservation
     * @param resource the resource containing the data to create the Reservation
     * @return the created Reservation or a 400 if the input data is invalid
     * @author Piero Gonzalo Delgado Corrales
     */

    @Operation(summary="Create a new Reservation", description="Create a new Reservation with the input data.")
    @PostMapping
    public ResponseEntity<ReservationResource> createReservation(@RequestBody CreateReservationResource resource) {
        var createReservationCommand = CreateReservationCommandFromResourceAssembler.toCommandFromResource(resource);
        var reservation = reservationCommandService.handle(createReservationCommand);
        if(reservation.isEmpty()) return ResponseEntity.badRequest().build();
        var reservationResource = ReservationResourceFromEntityAssembler.toResourceFromEntity(reservation.get());
        return new ResponseEntity<>(reservationResource, HttpStatus.CREATED);
    }
}
