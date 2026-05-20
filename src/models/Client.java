package models;

public class Client {
    
    private String nom;
    private String prenom;
    private String ville;

    public Client(String nom, String prenom, String ville){
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
    }

    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public String getVille(){
        return ville;
    }

    @Override
    public String toString() {
        return "Client " + nom.toUpperCase() + " " + prenom + " - " + ville ;
    }

}
