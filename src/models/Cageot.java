package models;

public class Cageot {
    public static final int MAX_BOUTEILLE = 12;

    private String identifiant;

    private Bouteille[] bouteilles;
    private int nbBouteille;

    public Cageot(String identifiant) {
        this.identifiant = identifiant;
        this.bouteilles = new Bouteille[MAX_BOUTEILLE];
        this.nbBouteille = 0;
    }

    public boolean rangerBouteille(Bouteille bouteille) {
        if (nbBouteille >= MAX_BOUTEILLE)
            return false;
        bouteilles[nbBouteille] = bouteille;
        nbBouteille++;
        return true;
    }

    public boolean prendreBouteille(Bouteille bouteille) {
        for (int i = 0; i < nbBouteille; i++) {
            if (bouteilles[i] == bouteille) {
                for (int j = i; j < nbBouteille - 1; j++) {
                    bouteilles[j] = bouteilles[j + 1];
                }
                bouteilles[nbBouteille - 1] = null;
                nbBouteille--;
                return true;
            }
        }
        return false;
    }

    public int getNbBouteille() {
        return nbBouteille;
    }

    public Bouteille[] getBouteilles() {
        Bouteille[] liste = new Bouteille[nbBouteille];
        for (int i = 0; i < liste.length; i++) {
            liste[i] = bouteilles[i];
        }
        return liste;
    }

    public double getPrixTotal() {
        double total = 0;
        for (int i = 0; i < nbBouteille; i++) {
            total += bouteilles[i].getPrix();
        }
        return total;
    }

    public int getPlaceDisponible() {
        return MAX_BOUTEILLE - nbBouteille;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public String toString() {
        return "Cageot '" + identifiant + "' avec " + String.format("%02d", nbBouteille) + "/"
                + String.format("%02d", MAX_BOUTEILLE) + "bouteilles";
    }
}
