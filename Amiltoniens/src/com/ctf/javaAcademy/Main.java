package com.ctf.javaAcademy;

import com.ctf.javaAcademy.items.Cafe;
import com.ctf.javaAcademy.items.PosteDeTravail;

import com.ctf.javaAcademy.items.TypePost;
import com.ctf.javaAcademy.persons.*;


public class Main {

    /**

    Cette classe va gérer l'execution des méthodes et leur affichage dans la console.

     */

    public static void main(String[] args) {


        Cafe cafe = new Cafe(1, 50, 70);

        SysAdmin Jeremy = new SysAdmin("Dijoux", "Jeremy", "2021-09-06", 100, cafe, new PosteDeTravail(TypePost.Fixe, false));

        String[] progsBob = {"Hello World", "1", "Morpion", "5", "Grizzly", "20" } ;

        Developper Bob = new Developper(
                progsBob,
                "Bobbydi",
                "Bob",
                "2017-09-06",
                10,
                cafe,
                new PosteDeTravail(TypePost.Fixe, false),
                "Java");

        RessourcesHumaines Stephanie =  new RessourcesHumaines("Stef", "Stephanie", "2017-05-12", 100, cafe, new PosteDeTravail(TypePost.Portable, false));
        Stephanie.engager("Royer", "Alan", "2019-07-08","developpeur");

        Developper Alan = (Developper) Stephanie.engager("Royer", "Alan", "2019-07-08","developpeur");

        Stephanie.research("Royer", "Alan");


    }
}
