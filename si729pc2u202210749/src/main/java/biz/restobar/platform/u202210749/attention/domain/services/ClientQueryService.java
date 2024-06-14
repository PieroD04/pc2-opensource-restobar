package biz.restobar.platform.u202210749.attention.domain.services;

import biz.restobar.platform.u202210749.attention.domain.model.entities.Client;
import biz.restobar.platform.u202210749.attention.domain.model.queries.GetAllClientsQuery;

import java.util.List;

public interface ClientQueryService {
    List<Client> handle(GetAllClientsQuery query);
}
