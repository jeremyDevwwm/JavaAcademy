package com.ctf.javaAcademy.tools;

/**
 * Creation d'une classe contenant une méthode statique randBool()
 renvoyant aléatoirement 0 ou 1
 */

public class Outils {
    public static int randBool(){
        int rendered = (int)(Math.random()*2);
        return rendered;
    }
}
