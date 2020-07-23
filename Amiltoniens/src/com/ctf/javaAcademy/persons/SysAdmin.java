package com.ctf.javaAcademy.persons;

import com.ctf.javaAcademy.items.Cafe;
import com.ctf.javaAcademy.items.PosteDeTravail;

/**
 * Creation de l'administrateur systeme héritant de la classe Amiltonien
 */

public class SysAdmin extends Amiltonien {
    //déclaration d'un compteur de réparation
    int reparations = 0;

    /**
     * Construction de l'adminstrateur système
     * @param nom le nom
     * @param prenom le prenom
     * @param date la date d'embauche
     * @param moral le moral
     * @param cafe le café
     * @param posteDeTravail le poste de travail
     */
    public SysAdmin(String nom, String prenom, String date, int moral, Cafe cafe, PosteDeTravail posteDeTravail) {
        super(nom, prenom, date, moral, cafe, TypeAmiltonien.SysAdmin, posteDeTravail);
    }

    /**
     * Cette fonction permet de réparer le PC d'un amiltonien si jamais ce dernier se brise
     * Ou si le developpeur rage quit
     * @param amiltonien l'amiltonien ciblé
     */

    public void repairPC(Amiltonien amiltonien){
        if(amiltonien.posteDeTravail.isBroken()){
            System.out.println("Et voilà ! Essayez de faire attention quand même...\r\n");
            int res =  this.getReparations() + 1;
            this.setReparations(res);
            amiltonien.posteDeTravail.setBroken(false);
        } else{
            System.out.println("Il va très bien votre poste ... \r\n");
        }
    }

    //getters Setters

    public void setReparations(int reparations) {
        this.reparations = reparations;
    }

    public int getReparations() {
        return reparations;
    }

    /**
     * description propre à la classe
     * @return la description
     */

    public String describe(){
        return "En tant que SysAdmin, "+ this.getNom() + " répare beaucoup de postes de travail\r\n";
    }
    // To string hérité de la classe mère + la description de la classe fille

    public String toString(){
        return super.toString() + this.describe();
    }
}
