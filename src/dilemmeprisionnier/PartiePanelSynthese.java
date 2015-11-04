/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dilemmeprisionnier;

import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author etudiant
 */
public class PartiePanelSynthese extends JPanel implements Observer {
    
    private final Partie partie;
    private final JLabel labelTexteA, labelTexteB, labelTexteNbTours;
    
    public PartiePanelSynthese(Partie partie) {
    this.partie = partie;
    
    partie.addObserver(this);
    // La vue
    setLayout(new FlowLayout());
    labelTexteA = new JLabel();
    add(labelTexteA);
    labelTexteB = new JLabel();
    add(labelTexteB);
    labelTexteNbTours = new JLabel();
    add(labelTexteNbTours);
    // Afficher
    update(partie, null);
    }
    
    @Override
    public void update(Observable objet, Object arg) {
    if (partie == objet) {
      labelTexteA.setText("SCORE A : "+partie.getScoreJoueur(0));
      labelTexteB.setText("SCORE B : "+partie.getScoreJoueur(1));
      labelTexteNbTours.setText("Tours joués : "+partie.getNbTours());
    }
    
  }
}
