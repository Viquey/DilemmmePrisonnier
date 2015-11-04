/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dilemmeprisionnier;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author etudiant
 */
public class Partie extends Observable {

    private ArrayList<boolean[]> liste;

    public Partie() {
        this.liste = new ArrayList<boolean[]>();
    }

    /**
     * Jouer un coup, avec le choix de A et B passé en parametre. true:coopere, false:defection
     */
    public void jouer(boolean aCoopereA, boolean aCoopereB) {
        boolean[] coup = {aCoopereA, aCoopereB};
        liste.add(coup);
        
        // Indiquer que l'objet a change
        setChanged();
        // Prevenir les observateurs pour qu'ils se mettent a jour
        notifyObservers();
    }

    /*
        recupere le nombre de tour joué total
    */
    public int getNbTours() {
        
        return this.liste.size();
    }

    /**
     * Gain au tour noTour du joueur noJoueur. Requiert 0 &lt;= noTour &lt;
     * getNbTours(), noJoueur est 0 ou 1
     */
    public int getGainJoueur(int noJoueur, int noTour) {
        assert noJoueur == 0 || noJoueur == 1;
        assert noTour >= 0;
        
        boolean[] coup = liste.get(noTour);
        int result = 3;                 //CC
        if (coup[0] && !coup[1]) {      //CD
            if (noJoueur == 0) {
                result = 0;
            }
            else {
                result = 5;
            }
        }
        if (!coup[0] && coup[1]) {      //DC
            if (noJoueur == 0) {
                result = 5;
            }
            else {
                result = 0;
            }
        }
        if (!coup[0] && !coup[1]) {      //DD
            if (noJoueur == 0) {
                result = 0;
            }
            else {
                result = 0;
            }
        }
        
        return result;    
    }

   
    /**
     * Le score Total du joueur A ou B, noJoueur passé en parametre. Requiert noJoueur est 0 ou 1
     */
    public int getScoreJoueur(int noJoueur) {
        assert noJoueur == 0 || noJoueur == 1;
        
        int scoreTotal = 0;
        
        int nbAllTours = getNbTours();
        
        for (int i = 0; i < nbAllTours; i++) {
            scoreTotal = scoreTotal + this.getGainJoueur(noJoueur, i);
        }
        
        return scoreTotal;
    }

    /**
     * Le coup du joueur A ou B. noJoueur et noTour passés en parametre. Requiert noTour >= 0, noJoueur est 0 ou 1.
     */
    boolean getCoupJoueur(int noJoueur, int noTour) {
        assert noJoueur == 0 || noJoueur == 1;
        assert noTour >= 0;
        
        return liste.get(noTour)[noJoueur];    
    }

}
