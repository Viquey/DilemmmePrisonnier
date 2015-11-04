/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dilemmeprisionnier;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author etudiant
 */
public class PartiePanelTable  extends JPanel
    implements Observer {
    
    private final Partie partie;
    private final JTable table;
    
    public PartiePanelTable(Partie partie) {
        this.partie = partie;
        // Indiquer qu'on observer la partie
        partie.addObserver(this);
        // et la création des composants graphiques
        this.table = new JTable();
        this.table.setModel(null);
    }

    @Override
    public void update(Observable objet, Object arg) {
        if (partie == objet) {
        // mettre a jour les composants graphiques
        }    
    }
    
}
