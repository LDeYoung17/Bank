package dev.deyoung.controllers;

import com.google.gson.Gson;
import dev.deyoung.daos.ClientDaoLocal;
import dev.deyoung.entities.Client;
import dev.deyoung.services.ClientService;
import dev.deyoung.services.ClientServiceImpl;
import io.javalin.http.Handler;
import java.util.Set;

public class ClientController {

    private ClientService clientService = new ClientServiceImpl(new ClientDaoLocal());

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

            Set<Client> allClients = this.clientService.getClients();
            Gson gson = new Gson();
            String clientsJSON = gson.toJson(allClients);
            ctx.result(clientsJSON);
            ctx.status(200);
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

//        int id = Integer.parseInt(ctx.pathParam("id"));
//        Client client1 = clientService.getClientById(id);
//        String body = ctx.body();
//        Gson gson = new Gson();
//        Client client = gson.fromJson(body,Client.class);
//        String ssn = client.getSSN();
//        client1.setSSN(ssn);
//        String name = client.getClientName();
//        client1.setClientName(name);
//
//        this.clientService.updateClient(client1);
        ctx.result("Clients cannot be updated once implemented!");
        ctx.status(403);

    };

    //Deleting clients
    public Handler deleteClientHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean deleted = this.clientService.deleteClientByIdOnly(id);
    };
}
