package biz.restobar.platform.u202210749.attention.application.internal.commandservices;

import biz.restobar.platform.u202210749.attention.domain.model.commands.CreateClientCommand;
import biz.restobar.platform.u202210749.attention.domain.model.entities.Client;
import biz.restobar.platform.u202210749.attention.domain.services.ClientCommandService;
import biz.restobar.platform.u202210749.attention.infrastructure.persistence.jpa.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientCommandServiceImpl implements ClientCommandService {
    private final ClientRepository clientRepository;

    public ClientCommandServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> handle(CreateClientCommand command) {
        if(clientRepository.existsByFullname(command.fullname())){
            throw new IllegalArgumentException("Client with Email Address: " + command.fullname() + " already exists");
        }

        var client = new Client(command);
        try{
            clientRepository.save(client);
        } catch (Exception e){
            throw new IllegalArgumentException("Error while saving user: " + e.getMessage());
        }
        return Optional.of(client);
    }

}
