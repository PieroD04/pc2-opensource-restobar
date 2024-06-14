package biz.restobar.platform.u202210749.attention.domain.services;

import biz.restobar.platform.u202210749.attention.domain.model.commands.CreateClientCommand;
import biz.restobar.platform.u202210749.attention.domain.model.entities.Client;

import java.util.Optional;

public interface ClientCommandService {
    Optional<Client> handle(CreateClientCommand command);
}
