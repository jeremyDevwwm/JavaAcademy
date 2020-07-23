package com.ctf.javaAcademy.tools;

import com.ctf.javaAcademy.items.Cafe;
import com.ctf.javaAcademy.persons.Amiltonien;
import com.ctf.javaAcademy.persons.Developper;
import com.ctf.javaAcademy.persons.RessourcesHumaines;
import com.ctf.javaAcademy.persons.SysAdmin;

/**
 * Creation de l'interface permettant à un RH d'engager un individu
 * cette fonction sera override dans la classe RessourcesHumaines afin de lui être exclusive
 */
public interface AmiltonianGenerator {

    public Amiltonien engager(String nom, String prenom, String date, String poste);
}
