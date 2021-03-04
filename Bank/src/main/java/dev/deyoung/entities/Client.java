package dev.deyoung.entities;

import javax.persistence.*;

@Entity
@Table(name= "ClientDaoPostgres")

public class Client {

    //JavaBean!



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientId")
    private int clientId;

    @Column(name = "clientName")
    private String clientName;

    @Column(name = "SSN")
    private int SSN;




    public Client(){
    }

    public Client(String clientName, int clientId, int SSN){

        this.clientName = clientName;

        this.clientId = clientId;
        this.SSN = SSN;

    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }



    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public int getClientId() {
        return clientId;
    }



    public void setClientId(int clientId) {
        this.clientId = clientId;
    }


    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                ", clientId=" + clientId +
                ", SSN='" + SSN + '\'' +
                '}';
    }
}

