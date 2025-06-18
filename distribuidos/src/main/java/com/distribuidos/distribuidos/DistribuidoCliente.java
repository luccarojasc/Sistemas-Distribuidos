package com.distribuidos.distribuidos;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DistribuidoCliente {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1100);
            DistribuidoWorker worker = new DistribuidoWorker();
            Naming.rebind("rmi://localhost/Worker1", worker);
            System.out.println("Worker registrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
