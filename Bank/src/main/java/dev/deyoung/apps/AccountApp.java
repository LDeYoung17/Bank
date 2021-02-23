package dev.deyoung.apps;

import dev.deyoung.controllers.AccountController;
import dev.deyoung.controllers.ClientController;
import io.javalin.Javalin;

public class AccountApp {

    public static void main(String[] args) {
        Javalin app = Javalin.create();
        AccountController accountController = new AccountController();

        app.post("clients/:id/accounts", accountController.createAccountHandler);
        app.get("clients/accounts", accountController.getAllAccountsHandler);
        app.get("clients/accounts/:id", accountController.AccountByIdHandler);
        app.get("clients/:id/accounts", accountController.AccountByClientIdHandler);
        app.get("clients/:id/accounts/:id2", accountController.AccountByAccountandClientIdHandler);
        app.get("clients/accountsbynumber/:accountNumber", accountController.AccountByNumberHandler);
        app.put("clients/:id/accounts/:id2", accountController.updateAccountHandler);
//        app.delete("clients/:id", accountController.deleteClientHandler);
        app.start();
    }
}
