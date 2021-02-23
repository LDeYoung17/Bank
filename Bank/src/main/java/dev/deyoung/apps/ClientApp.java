package dev.deyoung.apps;

import com.google.gson.Gson;
import dev.deyoung.controllers.ClientController;
import dev.deyoung.entities.Client;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ClientApp {

    public static void main(String[] args) {
        Javalin app = Javalin.create();
        ClientController clientController = new ClientController();

        app.get("clients", clientController.getAllClientsHandler);
        app.post("clients", clientController.createClientHandler);
        app.get("clients/:id", clientController.ClientByIdHandler);
        app.get("clientssocial/:ssn", clientController.ClientBySSNHandler);
        app.put("clients/:id", clientController.updateClientHandler);
        app.delete("clients/:id", clientController.deleteClientHandler);
        app.start();
    }


}
