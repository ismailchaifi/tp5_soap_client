package org.example;

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

public class Main {
    public static void main(String[] args) {
        BanqueService proxy = new BanqueWS().getBanqueServicePort();
        System.out.println(proxy.conversionEuroToDH(90));
        Compte compte = proxy.getCompte(4);
        System.out.println("----------------------");
        System.out.println(compte.getCode());
        System.out.println(compte.getSolde());
        System.out.println(compte.getDateCreation());
        System.out.println("----------------------");

        proxy.listComptes().forEach(cm -> {
            System.out.println("----------------------");
            System.out.println(cm.getCode());
            System.out.println(cm.getSolde());
            System.out.println(cm.getDateCreation());
            System.out.println("----------------------");
        });
    }
}