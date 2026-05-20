package models;

public class Commande {

    public static final int MAX_CAGEOT = 8;

    private final Client client;

    private Cageot[] cageots;
    private int nbCageot;

    public Commande(Client client) {
        this.client = client;
        this.cageots = new Cageot[MAX_CAGEOT];
        this.nbCageot = 0;
    }

    public boolean ajouterCageot(Cageot cageot) {
        if (nbCageot >= MAX_CAGEOT)
            return false;
        cageots[nbCageot] = cageot;
        nbCageot++;
        return true;
    }

    public boolean supprimerCageot(Cageot cageot) {
        for (int i = 0; i < nbCageot; i++) {
            if (cageots[i] == cageot) {
                for (int j = i; j < nbCageot - 1; j++) {
                    cageots[j] = cageots[j + 1];
                }
                cageots[nbCageot - 1] = null;
                nbCageot--;
                return true;
            }
        }
        return false;
    }

    public void annuler() {
        for (int i = 0; i < nbCageot; i++) {
            cageots[i] = null;
        }
        nbCageot = 0;
    }

    public Cageot[] cageotALivrer() {
        Cageot[] result = new Cageot[nbCageot];
        for (int i = 0; i < nbCageot; i++) {
            result[i] = cageots[i];
        }
        return result;
    }

    public double prixTotal() {
        double total = 0;
        for (int i = 0; i < nbCageot; i++) {
            total += cageots[i].getPrixTotal();
        }
        return total;
    }

    public Client getClient() {
        return client;
    }
}
