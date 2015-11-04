/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dilemmeprisionnier;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

/**
 *
 * @author etudiant
 */
public class PartieFenetre extends JFrame{
    
    Partie partie;
    JButton btnCC, btnCD, btnDC, btnDD;
    PartiePanelSynthese panelSynthese;
    JTable tableau;
    
    public PartieFenetre() {
        
        //Model
        partie = new Partie();
        
        // Composants
        initComposants();
        // Centrer sur l'écran
        setLocationRelativeTo(null);
        // Permettre le redimensionnement
        setResizable(true);
        // Fermer lors du clic sur la croix
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Ajuster la taille au contenu
        pack();
        setTitle("Dilemme Du Prisonnier");
        // La rendre visible
        setVisible(true);
        
    }

    private void initComposants() {
        // Vue
    JPanel haut = new JPanel();
    add(haut, BorderLayout.NORTH);
    
    btnCC = new JButton("CC");
    haut.add(btnCC);
    btnCD = new JButton("CD");
    haut.add(btnCD);
    btnDC = new JButton("DC");
    haut.add(btnDC);
    btnDD = new JButton("DD");
    haut.add(btnDD);
    
    panelSynthese = new PartiePanelSynthese(partie);
    panelSynthese.setBorder(new TitledBorder("Synthese des scores"));
    add(panelSynthese, BorderLayout.CENTER);
    
    final ModelTableau model = new ModelTableau(partie);
    tableau = new JTable(model);
    add(new JScrollPane(tableau), BorderLayout.SOUTH);
    
    
    btnCC.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        partie.jouer(true, true);
       // model.addRow();
        model.update(partie, e);
      }
    });
    btnCD.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        partie.jouer(true, false);
        
      }
    });
    btnDC.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        partie.jouer(false, true);
        
      }
    });
    btnDD.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        partie.jouer(false, false);        
      }
    });
    
   }
    
   public static void main(String[] args) {
    new PartieFenetre();
  } 
    
}
