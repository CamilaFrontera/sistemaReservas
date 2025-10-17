package com.SistemaReservas.crud.repositories;

import com.SistemaReservas.crud.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<ClientModel, Long> {

}
