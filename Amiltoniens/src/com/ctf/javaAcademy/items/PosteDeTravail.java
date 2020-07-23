package com.ctf.javaAcademy.items;

/*
Declaration du poste de travail
 */

public class PosteDeTravail {

    boolean isBroken = false;
    TypePost type;
    /**
    J'appelle mon enum TypePoste, et j'affecte un boolean pour déterminer si le poste est cassé ou pas
     */

    public PosteDeTravail(TypePost type, boolean broken){
        this.type = type;
        this.isBroken = broken;
    }


    //Getter & Setters

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }


}
