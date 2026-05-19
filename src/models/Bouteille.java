package models;

public class Bouteille {

    private final String nom;
    private final double prix;
    private final double contenance;
    private final boolean enVerre;

    private double remplissage;

    public Bouteille(String nom, double prix, double contenance, boolean enVerre) {
        this.nom = nom;
        this.prix = prix;
        this.contenance = contenance;
        this.enVerre = enVerre;
        this.remplissage = 100.0;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public double getContenance() {
        return contenance;
    }

    public boolean getEnverre() {
        return enVerre;
    }

    public double getRemplissage() {
        return remplissage;
    }

    public void setRemplissage(double remplissage) {
        this.remplissage = remplissage;
    }

    @Override
    public String toString() {

        String etat;
        if (remplissage == 100.0) {
            etat = "pleine";
        } else if (remplissage == 0.0) {
            etat = "vide";
        } else {
            etat = "entamée";
        }

        String matiere = enVerre ? "en Verre" : "en plastique";
        return "Bouteille '" + nom + "' de " + contenance + "L " + matiere + " à " + String.format("%.2f", prix)
                + " Frs - " + etat;
    }
}
