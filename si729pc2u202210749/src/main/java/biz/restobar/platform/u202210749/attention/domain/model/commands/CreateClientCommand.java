package biz.restobar.platform.u202210749.attention.domain.model.commands;

/**
 * CreateClientCommand
 * <p>
 *    This command is used to create a new client.
 *    It contains the fullname of the client.
 * </p>
 * @param fullname Fullname of the client
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
public record CreateClientCommand(String fullname) {
}
