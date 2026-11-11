package Serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import Service.ConversionImpl;

public class ConversionServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);


            ConversionImpl od = new ConversionImpl();
            System.out.println(od.toString());


            Naming.rebind("rmi://localhost:1099/conversion", od);

            System.out.println("Serveur de conversion démarré, en attente des clients...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
