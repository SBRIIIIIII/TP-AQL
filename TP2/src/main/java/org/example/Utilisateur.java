package org.example;

public class Utilisateur {
    private String prenom;
    private String nom;
    private String email;

    public Utilisateur(String prenom, String nom, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "Utilisateur{" +
                "prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

