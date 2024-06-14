package biz.restobar.platform.u202210749.attention.infrastructure.persistence.jpa.repositories;

import biz.restobar.platform.u202210749.attention.domain.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 * Repository for the Client entity.
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    /**
     * Method to check if a client exists by the fullname.
     * @param fullname represents the fullname of the client.
     * @return a boolean value indicating if that client exists.
     */
    boolean existsByFullname(String fullname);
}
