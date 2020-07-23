package com.ctf.javaAcademy.items;

/**

L'objet Café sera affecté dans le constructeur d'un amiltonien lambda

 */

public class Cafe {

    // Je déclare les attributs de mon café
    /**
    @tauxRpTasse correspond au remplissage de la tasse
    @isTooHot = Si le café est trop chaud
    @isEmpty, si la tasse est vide
     */

    int nbSucre = 0;
    double tauxRpTasse = 0;
    double temperature = 0;
    boolean isTooHot = false;
    boolean isEmpty = false;

    /**
    Cosntructeur par défaut si le café ne prend aucun paramètre
     */

    public Cafe() {
        System.out.println("Creating coffee");
    }

    public Cafe(int sucre, int remplit, double temperature) {
        this.nbSucre = sucre;
        this.tauxRpTasse = remplit;
        this.temperature = temperature;

        if (this.temperature >= 50) {
            this.isTooHot = true;
        } else {
            this.isTooHot = false;
        }

        if (this.tauxRpTasse > 15) {
            this.isEmpty = false;
        } else {
            this.isEmpty = true;
        }

    }
//Getters & Setters

    public int getNbSucre() {
        return nbSucre;
    }

    public void setNbSucre(int nbSucre) {
        this.nbSucre = nbSucre;
    }

    public double getTauxRpTasse() {
        return tauxRpTasse;
    }

    public void setTauxRpTasse(double tauxRpTasse) {
        this.tauxRpTasse = tauxRpTasse;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isTooHot() {
        return isTooHot;
    }

    public void setTooHot(boolean tooHot) {
        isTooHot = tooHot;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    // Description de l'object café

    public String toString() {
        String intro = "Le café est prêt ! \r\n";
        String temperatureState = "Sa température est de : ";
        String heatStatus = "";
        String containing = "La tasse est : ";
        String containerStatus = "";

        if (this.isTooHot == true) {
            heatStatus = "Le café est trop chaud \r\n";
        } else {
            heatStatus = "Le café est trop froid \r\n";
        }

        if (this.isEmpty == true) {
            containerStatus = "vide \r\n";
        } else {
            containerStatus = "pleine \r\n";
        }

        return intro + temperatureState + this.temperature+ "°\r\n"+ heatStatus + containing + containerStatus;
    }
}
