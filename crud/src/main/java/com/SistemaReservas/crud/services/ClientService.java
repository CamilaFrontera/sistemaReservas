package com.SistemaReservas.crud.services;

import com.SistemaReservas.crud.models.ClientModel;
import com.SistemaReservas.crud.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    IClientRepository clientRepository;

    public ArrayList<ClientModel> getClients(){
        return (ArrayList<ClientModel>) clientRepository.findAll();
    }

    public ClientModel saveClient(ClientModel client){
        return clientRepository.save(client);
    }

    public Optional<ClientModel> getById(Long id){
        return clientRepository.findById(id);
    }

    public ClientModel updateById(ClientModel request, Long id){
        ClientModel client = clientRepository.findById(id).get();
        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        client.setEmail(request.getEmail());
        client.setPhoneNumber(request.getPhoneNumber());
        return clientRepository.save(client);

    }

    public Boolean deleteClient(Long id){
        try{
            clientRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
