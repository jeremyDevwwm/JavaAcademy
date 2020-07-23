package com.ctf.javaAcademy.persons;

import com.ctf.javaAcademy.items.Cafe;
import com.ctf.javaAcademy.items.PosteDeTravail;
import com.ctf.javaAcademy.items.Programme;
import com.ctf.javaAcademy.tools.Outils;
import java.util.ArrayList;

/**
 * Creation du poste de développeur découlant directement de la classe Amiltonien
 *
 */


public class Developper extends Amiltonien {
    // déclaration des attributs
    ArrayList<Programme> programmes = new ArrayList<>();
    String language = "";
    PosteDeTravail poste;

    /**
     *
     * @param progr la liste de programmes
     * @param nom le nom
     * @param prenom le prénom
     * @param date la date d'embauche
     * @param moral le niveau de moral
     * @param cafe le café
     * @param poste le poste de travail
     * @param language le language préféré
     */

    public Developper(String[] progr , String nom, String prenom, String date, int moral, Cafe cafe, PosteDeTravail poste, String language) {
        super(nom, prenom, date, moral, cafe, TypeAmiltonien.Developpeur, poste);

        for(int i = 0; i<progr.length; i+=2) {
            Programme temp = new Programme(String.valueOf(progr[i]),Integer.parseInt(progr[i+1]));
            this.programmes.add(temp);
        }

        this.language = language;
    }

    //Getter de la liste de programme

    public ArrayList<Programme> getProgrammes() {
        return this.programmes;
    }

    /**
     * Creation d'un programme à la volée
     * @param name le nom du programme
     * @param nbBug le nombre de bugs
     */

    public void createProgram(String name, int nbBug){
        if(this.poste.isBroken()){
            System.out.println("Mon poste est cassé, je ne peux pas travailler");
        } else{
            this.programmes.add(new Programme(name, nbBug));
        }
    }

    /**
     * la fonction permettant de casser un poste de travail
     * le booléen témoignant de l'état du poste de travail
     */

    public void breakPost(){
        if(this.posteDeTravail.isBroken()){
            System.out.println("Je ne peux pas casser quelques chose qui l'est déjà !");
        } else{
            this.posteDeTravail.setBroken(true);
            System.out.println("... Je crois que je viens de casser mon poste");
        }
    }

    /**
     * Fonction permettant de rechercher un programme dans la liste
     * Elle ressemble beaucoup à la fonction research
     * @param nom nom du programme
     * @return le programme
     */

    public Programme find(String nom){
         Programme single = this.programmes.stream()
                .filter(name -> nom.equals(name.getName()))
                .findAny()
                .orElse(null);
         return single;
    }

    /**
     * Fonction permettant de supprimer un programme
     * @param nom nom du programme qui va etre passé dans l'appel de @find()
     */

    public void deleteProgramm(String nom){
        Programme single = this.find(nom);
        int indexProg = this.programmes.indexOf(single);
        this.programmes.remove(indexProg);
        System.out.println(this.programmes);
    }


    /**
     * correction des bugs
     * @param nom le nom du programme qui va etre passé directement dans la fonction find()
     */
    public void correctBugs(String nom) {

        // dclaration des variables locales qui ont être utilisées dans les conditions

        Programme single = this.find(nom);
        int randomizer = 0;

        System.out.println("Nombre de bugs "+ single.getNbBug());

        /**
         * Si le nombre de bugs dans le programme est supérieur à 0, le traitement peut commencer
         */
        if (single.getNbBug()>0) {
            // Si le nombre de bug est égal à 1, le math random devra pouvoir envoyer un chiffre entre 0 et 1.
            // Math random renvoyant des chiffres entre 0 et 1, si je le multiplie par 1, il me renverra toujours 0, ce qui n'a aucun sens en l'état
            // puisque cela signifie que le developpeur ne réglera jamais ce seul bug.
            if (single.getNbBug() == 1) {
                randomizer = (int) (Math.random() * (single.getNbBug() + 1));

            } else if (single.getNbBug() > 1) {
                randomizer = (int) (Math.random() * (single.getNbBug()));
            }

            // Si la valeur du single renvoie null, cela signifie que le programme n'existe pas, ou qu'il y a eu faute de frappe

            if (single == null) {
                System.out.println("Je n'ai pas trouvé de programme de ce nom");

                // Si single possède bien une valeur, les traitements suivant peuvent s'exécuter

            } else {

                // Injection de la valeur aléatoire envoyée par le tool

                int diceRoll = Outils.randBool();

                // Si le jet de dé vaut 0, on soustrait la valeur aléatoire déclarée en amont
                // Le developpeur va régler les bugs
                if (diceRoll == 0) {

                    int result = single.getNbBug() - randomizer;

                    System.out.println(randomizer);
                    if (randomizer == 0){
                        System.out.println("quelques chose m'échappe, je n'ai pu régler aucun bug...");
                    } else {
                        System.out.println("J'ai pu régler : " + randomizer + " Bugs !");
                    }
                    single.setNbBug(result);

                // Sinon, le dev rajoute des bugs
                } else if (diceRoll == 1) {
                    int result = single.getNbBug() + randomizer;


                    System.out.println(randomizer);
                    if (randomizer == 0){
                        System.out.println("quelques chose m'échappe, je n'ai pu régler aucun bug...");
                    } else {
                        System.out.println("J'hallucine ! Il y a " + randomizer + " bugs de plus !! >_<");
                    }
                    single.setNbBug(result);

                }
            }
        } else {
            System.out.println("Il n'y a plus de bugs à corriger");
        }
    }

    // getter de language
    public String getLanguage(){
        return "Mon langage préféré est le : " + this.language;
    }
    // To String hérité de la superClasse Amiltonien
    public String toString(){
        return super.toString() + this.getLanguage();
    }
}
