package biz.restobar.platform.u202210749.attention.domain.model.queries;

/**
 * Query to get a reservation by its id
 * @param reservationId The reservation id
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
public record GetReservationByIdQuery(Long reservationId) {
}
