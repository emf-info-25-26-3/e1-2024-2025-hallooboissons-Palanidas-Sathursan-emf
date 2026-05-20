package app;

import models.Bouteille;
import models.Cageot;
import models.Client;
import models.Commande;

public class Application {

    public static void main(String[] args) {

        Commande[] commandes = new Commande[10];

        Client client1 = new Client("Ducobu", "Jean", "Bulle");
        Commande commande1 = new Commande(client1);

        Cageot cageot1 = new Cageot("X83H4");
        for (int i = 0; i < 6; i++)
            cageot1.rangerBouteille(new Bouteille("Henniez rouge", 2.60, 1, true));
        for (int i = 0; i < 6; i++)
            cageot1.rangerBouteille(new Bouteille("Henniez verte", 2.60, 1, true));

        Cageot cageot2 = new Cageot("X83H5");
        for (int i = 0; i < 2; i++)
            cageot2.rangerBouteille(new Bouteille("Coca-Cola", 3.85, 1.5, false));

        Cageot cageot3 = new Cageot("X83H6");
        cageot3.rangerBouteille(new Bouteille("Pepsi", 3.55, 1.5, false));
        cageot3.rangerBouteille(new Bouteille("Sinalco", 4.25, 1.5, false));

        commande1.ajouterCageot(cageot1);
        commande1.ajouterCageot(cageot2);
        commande1.ajouterCageot(cageot3);
        commandes[0] = commande1;

        Client client2 = new Client("Haroni", "Mac", "Fribourg");
        Commande commande2 = new Commande(client2);

        Cageot cageot4 = new Cageot("X83H7");
        cageot4.rangerBouteille(new Bouteille("Henniez", 2.60, 1, true));
        cageot4.rangerBouteille(new Bouteille("Coca-Cola", 3.85, 1.5, false));

        commande2.ajouterCageot(cageot4);
        commandes[1] = commande2;

        for (int i = 0; i < commandes.length; i++) {
            afficherCommande(commandes[i]);
        }
    }

    public static void afficherCommande(Commande commande) {

        if (commande != null) {
            System.out.println("---------------------------------------");
            System.out.println("Commande pour le client : " + commande.getClient());

            Cageot[] cageotALivrer = commande.cageotALivrer();

            System.out.println("La commande contient " + cageotALivrer.length + " cageots");
            System.out.println("Le prix total de la commande est de " + commande.prixTotal() + " Frs");
        }
    }
}
