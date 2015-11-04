/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dilemmeprisionnier;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author etudiant
 */
public class ModelTableau extends AbstractTableModel implements Observer{
    
    private final String[] entetes = {"Tour","Action A","Action B","Gain A","Gain B"};
    private final Partie partie;
    
    public ModelTableau(Partie partie) {
        super();
        this.partie = partie;
        partie.addObserver(this);
        update(partie, null);
        
    }

    @Override
    public int getRowCount() {
        return partie.getNbTours();    
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }
    
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return rowIndex+1;
            case 1:
                if(partie.getCoupJoueur(0, rowIndex)) {
                    return "C";
                }
                else {
                    return "D";
                }
                //return partie.getCoupJoueur(0, rowIndex);
            case 2:
                if(partie.getCoupJoueur(1, rowIndex)) {
                    return "C";
                }
                else {
                    return "D";
                }
                //return partie.getCoupJoueur(1, rowIndex);
            case 3:
                return partie.getGainJoueur(0, rowIndex);
            case 4:
                return partie.getGainJoueur(1, rowIndex);
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (partie == o) {
            this.fireTableDataChanged();
        } 
    }
    
    
    
}
