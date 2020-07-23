package com.ctf.javaAcademy.items;

/**
 * La classe programme va permettre d'avoir un programme construi et rattaché à un dev
 */

public class Programme {

    String name = "";
    int nbBug =0;

    /**
     * Un programme possède un nom et un nombre de bugs
     * @param nm le nom
     * @param bug le nombre de bug
     */

    public Programme(String nm, int bug){
        this.name = nm;
        this.nbBug = bug;
    }

    // getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbBug() {
        return nbBug;
    }

    public void setNbBug(int nbBug) {
        this.nbBug = nbBug;
    }

    /**
     * Description du programme en fonction de leur nombre de bugs
     * Gestion du singulier et du pluriel
     * @return l'intro et la phrase concernant les bugs de manière adaptable
     */

    public String toString(){

        String intro = "Le Programme s'appelle : " + this.name +"\r\n";
        String bugWord ="";

        if(this.nbBug == 0 || this.nbBug == 1){
            bugWord = "Il contient actuellement  : " + String.valueOf(this.nbBug) + " bug \r\n";
        } else if (this.nbBug > 1){
            bugWord = "Il contient actuellement  : " + String.valueOf(this.nbBug) + " bugs \r\n";
        } else if (this.nbBug < 0){
            bugWord = "Si un programme contient des bugs négatifs, c'est que le problème se situe entre la chaise et le clavier";
        }

        return intro  + bugWord;
    }
}
