package com.ctf.javaAcademy.persons;

import com.ctf.javaAcademy.items.Cafe;
import com.ctf.javaAcademy.items.PosteDeTravail;
import com.ctf.javaAcademy.items.TypePost;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * L'amiltonien est le profil type de l'employé de l'entreprise
 * Chacun d'entre eux possède un nom, un prenom, une date d'embauche, un café, un type, un poste de travail
 * Ces amiltoniens sont référencés dans une liste évolutive (qui pourrait par exemple s'exporter sur un csv par le biais d'une méthode)
 */


public abstract class Amiltonien {
    protected String nom = "";
    protected String prenom ="";
    protected  LocalDate date;
    protected int niveauDeMoral =0;
    protected Cafe cafe;
    protected TypeAmiltonien type;
    protected TypePost poste;
    protected static ArrayList<Amiltonien> listAmiltonien = new ArrayList<>();
    protected PosteDeTravail posteDeTravail;

    /**
     * Constructeur pour l'Amiltionien générique
     * @param nom le nom
     * @param prenom le prenom
     * @param date la date d'embauche
     * @param moral le niveau de moral
     * @param cafe l'object café
     * @param type le type (dev, rh, ou sysAdmin)
     * @param posteDeTravail fixe ou portable
     *
     * A la fin de l'affectation des paramètres, l'amiltonien fraichement construit est implémenté dans la ArrayList
     */

    public Amiltonien(String nom, String prenom, String date, int moral, Cafe cafe, TypeAmiltonien type, PosteDeTravail posteDeTravail){

        this.nom = nom;
        this.prenom = prenom;
        this.date = LocalDate.parse(date);
        this.niveauDeMoral = moral;
        this.cafe = cafe;
        this.type = type;
        this.posteDeTravail = posteDeTravail;
        this.listAmiltonien.add(this);
    }

// Getters et setters
    public static ArrayList<Amiltonien> getListAmiltonien(){
        return listAmiltonien;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNiveauDeMoral() {
        return niveauDeMoral;
    }

    public void setNiveauDeMoral(int niveauDeMoral) {
        this.niveauDeMoral = niveauDeMoral;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public TypeAmiltonien getType() {
        return type;
    }

    public void setType(TypeAmiltonien type) {
        this.type = type;
    }

    /**
     * La fonction permettant à tout amiltonien qui se respecte de pouvoir souffler sur son café afin de diviser sa température par 2
     * @return description de l'action menée dans la fonction
     */

    public String blowCofee(){
        double temp = this.cafe.getTemperature()/2;
        if(temp < 50){
            this.cafe.setTooHot(false);
        }
        return "Je souffle sur mon café, faisant alors passer sa température de "+ String.valueOf(this.cafe.getTemperature())+ " à "+ String.valueOf(temp);

    }

    /**
     * Cette fonction permet à un amiltonien de boire du café, dépendant de l'état du breuvage et de la tasse
     * Si le café est trop chaud, il ne le boit pas
     * Si la tasse est vide, il ne peut rien boire
     * @return la description de l'action menée dans la fonction
     */

    public String drinkCofee(){
        if(this.cafe.isTooHot() == true){
            return "Aïe ! Je ne peux pas boire ça, c'est trop chaud ! Je dois souffler sur mon café pour faire baisser la température !";
        } else {
            double contain = this.cafe.getTauxRpTasse() - 10;
            this.cafe.setTauxRpTasse(contain);
            if(this.cafe.getTauxRpTasse() < 10){
                this.cafe.setEmpty(true);
                return "C'est vide, je devrais me faire un nouveau café...";
            }
            return "C'était bien bon ! Il me reste maintenant "+ String.valueOf(contain) + " % de mon café !";
        }
    }

    /**
     * La fonction de recherche des amiltonniens présent dans la liste s'incrémentant dans le constructeur
     * @param nom le nom de l'amiltonien recherché
     * @param prenom son prénom
     * L'utilisation des streams permet de parcourir le tableau d'objects et ainsi ramener une cellule contenant la valeur recherchée
     * Les méthodes streams facilitent la tâche
     */

    public void research(String nom, String prenom){
        Amiltonien single = this.listAmiltonien.stream()
                .filter(name->nom.equals(name.getNom()) && prenom.equals(name.getPrenom()))
                .findAny()
                .orElse(null);
        if(single == null){
            System.out.println("Je n'ai trouvé personne");

        } else{
            System.out.println(single);

        }

    }

    /**
     * Cette méthode permet de comparer deux amiltoniens par rapport à leur date d'entrée
     * @param first l'amiltonien 1
     * @param second le deuxième
     * La méthode isAfter renvoie un boolean qui permet de savoir si une date est arrivée après ou avant l'autre
     */

    public void compare(Amiltonien first, Amiltonien second){
        System.out.println("first : "+first.getDate());
        System.out.println("second : "+second.getDate());
        if(first.getDate().isAfter(second.getDate())){

            System.out.println(first.getPrenom() + " "+ first.getNom() + " a rejoint la faction après "+ second.getPrenom() + " "+ second.getNom()+ "\r\n");
        } else{
            System.out.println(first.getPrenom() + " "+ first.getNom() + " a rejoint la faction avant "+ second.getPrenom() + " "+ second.getNom()+ "\r\n");
        }
    }

    /**
     * Cette méthode décline l'identité d'un amiltonien lambda, sans prendre en compte les spécificités de son poste
     * En effet, cela arrive avec l'héritage
     * @return la description complète de l'amiltonien
     */

    public String toString(){
        String intro = "Je m'appelle " + this.nom + " " + this.prenom + "\r\n";
        String dateArrival = "Je suis Amiltonien depuis : " + this.getDate() + "\r\n";
        String cafeStatus = this.cafe.toString();
        String posteTypeFix = "Mon Poste est un PC Fixe\r\n";
        String posteTypeLap = "Mon Poste est un Laptop \r\n";
        String type = "";
        String pcBroken="";

        if(this.posteDeTravail.isBroken()){
            pcBroken = "Oups, mon PC est cassé, il faut le réparer\r\n";
        } else{
            pcBroken = "Mon poste va très bien !\r\n";
        }

        switch(this.type){
            case Developpeur:
                type = "Je suis Developpeur\r\n";
                return intro + dateArrival + cafeStatus + type + posteTypeFix + pcBroken;

            case RessourcesHumaines:
                type = "Je suis dans les RH \r\n";
                return intro + dateArrival + cafeStatus + type + posteTypeLap + pcBroken;

            case SysAdmin:
                type = "Je suis Administrateur Systeme\r\n";
                return intro + dateArrival + cafeStatus + type + posteTypeFix + pcBroken;

            default :
                type = "J'ai vu la lumière, et je suis rentré\r\n";
                return type;
        }

    }
}
