package com.ctf.javaAcademy.persons;

import com.ctf.javaAcademy.items.Cafe;
import com.ctf.javaAcademy.items.PosteDeTravail;
import com.ctf.javaAcademy.items.TypePost;
import com.ctf.javaAcademy.tools.AmiltonianGenerator;

/**
 * Création d'une sous classe RH impélementant l'interface AmiltonienGenerator
 * Cette classe est donc la seule à pouvoir utiliser le pattern factory
 */

public class RessourcesHumaines extends Amiltonien implements AmiltonianGenerator {

    PosteDeTravail poste;

    /**
     * Construction de l'objet RH
     * @param nom le nom
     * @param prenom le prenom
     * @param date la date d'embauche
     * @param moral le niveau de moral
     * @param cafe café
     * @param poste le poste de travail
     */

    public RessourcesHumaines(String nom, String prenom, String date, int moral, Cafe cafe, PosteDeTravail poste) {

        super(nom, prenom, date, moral, cafe, TypeAmiltonien.RessourcesHumaines, poste);
        this.poste = new PosteDeTravail(TypePost.Portable, false);


    }

    /**
     * Heal permet de faire remonter les points de moral
     * @param amiltonien l'amiltonien ciblé par le "soin"
     */

    public void heal(Amiltonien amiltonien){
        if(amiltonien.getNiveauDeMoral()>90){
            System.out.println("Cet amiltonien se porte déjà comme un charme !");
        } else{
            int result =  amiltonien.getNiveauDeMoral() + 10;
            System.out.println("Là... là... ca va aller");
            amiltonien.setNiveauDeMoral(result);
            System.out.println(amiltonien.getNiveauDeMoral());
        }
    }

    /**
     * Override de la fonction présente dans mon interface AmiltonianGenerator
     * @param nom nom du future employé
     * @param prenom prénom
     * @param date la date de recrutement
     * @param poste le poste occupé par le futur employé
     * @return l'amiltonien déjà construit
     */

    @Override
    public Amiltonien engager(String nom, String prenom, String date, String poste) {
        Cafe cafe = new Cafe(2, 100, 50);
        int moral = 100;
        boolean broken = false;
        // Pour faciliter les traitements, le poste sera mit en majuscule
        String formattedPoste = poste.toUpperCase();

        /**
         * Selon le cas, un amiltonien différent sera généré, en ayant des valeurs par défauts injectées dans son constructeur
         */
        switch(formattedPoste){
            case "DEVELOPPEUR":
                String[] defaultBehavior = {};
                String language =  "Java";
                return new Developper(defaultBehavior, nom, prenom, date, moral, cafe, new PosteDeTravail(TypePost.Fixe, broken), language);

            case "SYSADMIN":
                return new SysAdmin(nom, prenom, date, moral, cafe, new PosteDeTravail(TypePost.Portable, broken));

            case "RESSOURCESHUMAINES":
                return new RessourcesHumaines(nom, prenom, date, moral, cafe, new PosteDeTravail(TypePost.Fixe, broken));

            default:
                return null;
        }
    }
}
