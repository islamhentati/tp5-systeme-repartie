package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import metier.Compte;

public class BanqueImpl extends UnicastRemoteObject implements IBanque {
    private static final long serialVersionUID = 1L;
    private Map<Integer, Compte> comptes = new HashMap<>();

    public BanqueImpl() throws RemoteException {
        super();
    }

    @Override
    public synchronized String creerCompte(Compte c) throws RemoteException {
        System.out.println("Requête reçue : creerCompte(" + c.getCode() + ")");
        if (comptes.containsKey(c.getCode())) {
            return "Erreur : le compte " + c.getCode() + " existe déjà.";
        }
        comptes.put(c.getCode(), c);
        return "Compte " + c.getCode() + " créé avec succès.";
    }

    @Override
    public synchronized String getInfoCompte(int code) throws RemoteException {
        System.out.println("Requête reçue : getInfoCompte(" + code + ")");
        Compte c = comptes.get(code);
        if (c == null) {
            return "Erreur : le compte " + code + " n'existe pas.";
        }
        return c.toString();
    }
}