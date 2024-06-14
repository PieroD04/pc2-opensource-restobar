package biz.restobar.platform.u202210749.attention.application.internal.eventhandlers;

import biz.restobar.platform.u202210749.attention.domain.model.commands.CreateClientCommand;
import biz.restobar.platform.u202210749.attention.domain.model.queries.GetAllClientsQuery;
import biz.restobar.platform.u202210749.attention.domain.services.ClientCommandService;
import biz.restobar.platform.u202210749.attention.domain.services.ClientQueryService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationReadyEventHandler {
    private final ClientQueryService clientQueryService;
    private final ClientCommandService clientCommandService;

    public ApplicationReadyEventHandler(ClientQueryService clientQueryService, ClientCommandService clientCommandService) {
        this.clientQueryService = clientQueryService;
        this.clientCommandService = clientCommandService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void on() {
        var clients = clientQueryService.handle(new GetAllClientsQuery());
        if (clients.isEmpty()) {
            clientCommandService.handle(new CreateClientCommand("John Doe"));
            clientCommandService.handle(new CreateClientCommand("Jane Doe"));
            System.out.println("Created John Doe and Jane Doe as clients for the first time.");
        }
        else {
            System.out.println("Clients already exist in the system. Skipping creation.");
        }
    }
}
