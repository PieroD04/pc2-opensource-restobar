package biz.restobar.platform.u202210749.attention.application.internal.queryservices;

import biz.restobar.platform.u202210749.attention.domain.model.entities.Client;
import biz.restobar.platform.u202210749.attention.domain.model.queries.GetAllClientsQuery;
import biz.restobar.platform.u202210749.attention.domain.services.ClientQueryService;
import biz.restobar.platform.u202210749.attention.infrastructure.persistence.jpa.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientQueryServiceImpl implements ClientQueryService {
    private final ClientRepository clientRepository;

    public ClientQueryServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> handle(GetAllClientsQuery query){
        return clientRepository.findAll();
    }
}
