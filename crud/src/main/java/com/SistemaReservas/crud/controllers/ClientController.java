package com.SistemaReservas.crud.controllers;

import com.SistemaReservas.crud.models.ClientModel;
import com.SistemaReservas.crud.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ArrayList<ClientModel> getClients(){
        return this.clientService.getClients();
    }

    @PostMapping
    public ClientModel saveClient(@RequestBody ClientModel client){
        return this.clientService.saveClient(client);
    }

    @GetMapping(path = "/{id}")
    public Optional<ClientModel> getClientById(@PathVariable Long id){
        return this.clientService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public ClientModel updateClientById(@RequestBody ClientModel request, @PathVariable("id") Long id){
        return this.clientService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteClientById(@PathVariable("id") Long id){
        boolean ok = this.clientService.deleteClient(id);
        if(ok){
            return "Cliente con ID " + id + " eliminado correctamente.";
        }else{
            return "Error al intentar eliminar cliente con ID " + id + ".";
        }
    }

}
