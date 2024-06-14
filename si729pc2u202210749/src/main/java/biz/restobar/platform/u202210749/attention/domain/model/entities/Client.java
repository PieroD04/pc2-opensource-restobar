package biz.restobar.platform.u202210749.attention.domain.model.entities;

import biz.restobar.platform.u202210749.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u202210749.attention.domain.model.commands.CreateClientCommand;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

/**
 * Client entity
 * <p>
 *     It represents a client that can make reservations.
 * </p>
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
@Getter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String fullname;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    /**
     * Default constructor
     * @author Piero Gonzalo Delgado Corrales
     */
    public Client() {
        fullname = "";
    }

    /**
     * Constructor with the command to create a client
     * @param command Command to create a client
     * @author Piero Gonzalo Delgado Corrales
     */
    public Client(CreateClientCommand command){
        this.fullname = command.fullname();
    }
}
