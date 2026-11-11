package client;



import java.rmi.Naming;

import Service.IConversion;

public class ConversionClient {
    public static void main(String[] args) {
        try {
            // Chercher la référence de l'objet distant dans le RMIRegistry
            IConversion stub = (IConversion) Naming.lookup("rmi://localhost:1099/conversion");

            // Invoquer la méthode distante
            double res = stub.convertirMontant(500);
            System.out.println("500 EUR = " + res + " TND");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
