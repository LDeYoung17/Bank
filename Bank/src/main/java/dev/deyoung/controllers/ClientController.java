package dev.deyoung.controllers;

import com.google.gson.Gson;

import dev.deyoung.daos.ClientDaoPostgres;
import dev.deyoung.entities.Client;
import dev.deyoung.services.ClientService;
import dev.deyoung.services.ClientServiceImpl;
import io.javalin.http.Handler;
import java.util.Set;

public class ClientController {

    private ClientService clientService = new ClientServiceImpl(new ClientDaoPostgres());

    //Creating clients
    public Handler createClientHandler = (ctx) ->{
        String body = ctx.body();
        Gson gson = new Gson();
        Client client = gson.fromJson(body, Client.class);
        this.clientService.newClient(client);
        String json = gson.toJson(client);
        ctx.result(json);
        ctx.status(201);
    };


    //Getting all clients
    public Handler getAllClientsHandler = (ctx) ->{

        Set<Client > allClients = this.clientService.getClients();
            if (allClients.isEmpty()){
                ctx.result("Sorry! could not get clients!");
                ctx.status(404);
            }else{
                Gson gson = new Gson();
                String clientsJSON = gson.toJson(allClients);
                ctx.result(clientsJSON);
                ctx.status(200);
            }

    };


    //Getting clients by Client ID
    public Handler ClientByIdHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        Client client = this.clientService.getClientById(id);
        if(client == null){
            ctx.result("Client not found");
            ctx.status(404);
        }else{
            Gson gson = new Gson();
            String clientJSON = gson.toJson(client);
            ctx.result(clientJSON);
            ctx.status(200);
        }

    };


    //Getting clients by Social Security Number
    public Handler ClientBySSNHandler = (ctx) ->{
        int SSN = Integer.parseInt(ctx.pathParam("ssn"));

        Client client = this.clientService.getClientBySocial(SSN);


            if (client == null) {
                ctx.result("Client not found");
                ctx.status(404);
            } else {
                Gson gson = new Gson();
                String clientJSON = gson.toJson(client);
                ctx.result(clientJSON);
                ctx.status(200);

            }


    };
    //Update Client. Intentionally gives error. Clients should not be updated after they are implemented
    public Handler updateClientHandler = (ctx) ->{
        Set<Client > allClients = this.clientService.getClients();
        if (allClients.isEmpty()){
            ctx.result("Sorry! could not find client!");
            ctx.status(404);
        }else{
            ctx.result("Clients cannot be updated once implemented!");
            ctx.status(403);
        }

    };

    //Deleting clients
    public Handler deleteClientHandler = (ctx) ->{

        Set<Client > allClients = this.clientService.getClients();
        if (allClients.isEmpty()){
            ctx.result("Sorry! Could not find client!");
            ctx.status(404);
        }else{
            int id = Integer.parseInt(ctx.pathParam("id"));
            boolean deleted = this.clientService.deleteClientByIdOnly(id);
            ctx.status(200);
            ctx.result("Client deleted!");
        }

    };
}
