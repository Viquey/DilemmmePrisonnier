/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dilemmeprisionnier;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author etudiant
 */
public class PartieTest {
    
    private Partie instance;
    
    @Before
    public void testConstructeur() {
        instance = new Partie();
        assertEquals(0,instance.getNbTours());
    }
    
    public PartieTest() {
    }
    
    @Test
    public void testCC() {
        instance.jouer(true, true);// 3-3
        assertEquals(1, instance.getNbTours());
        assertEquals(3, instance.getScoreJoueur(0));
        assertEquals(3, instance.getGainJoueur(0,0));
        assertTrue(instance.getCoupJoueur(0,0));
    }
    
    @Test
    public void testCD() {
        instance.jouer(true, false);//1-5
        assertEquals(1, instance.getNbTours());
        assertEquals(5, instance.getScoreJoueur(1));
        assertEquals(0, instance.getGainJoueur(0,0));
        assertTrue(!instance.getCoupJoueur(1,0));
    }
    
    @Test
    public void testDC() {
        instance.jouer(false, true);//5-1
        assertEquals(1, instance.getNbTours());
        assertEquals(5, instance.getScoreJoueur(0));
        assertEquals(0, instance.getGainJoueur(1,0));
        assertTrue(!instance.getCoupJoueur(0,0));
    }
    
    @Test
    public void testDD() {
        instance.jouer(false, false);//1-1
        assertEquals(1, instance.getNbTours());
        assertEquals(0, instance.getScoreJoueur(1));
        assertEquals(0, instance.getGainJoueur(0,0));
        assertTrue(!instance.getCoupJoueur(0,0));
    }
    
    @Test
    public void testGetNbToursTotal() {
        instance.jouer(true, true);
        instance.jouer(true, false);
        assertEquals(2, instance.getNbTours());
    }
    
    @Test
    public void testGetGainJoueur() {
        instance.jouer(true, false);
        assertEquals(0,instance.getGainJoueur(0, 0));
        assertEquals(5,instance.getGainJoueur(1, 0));  
    }
    
    @Test
    public void testScoreTotalJoueur() {
        instance.jouer(true, true); //3-3
        instance.jouer(false, true);//5-0
        instance.jouer(true, true); //3-3
        instance.jouer(true, false);//0-5
        instance.jouer(true, false);//0-5
        
        assertEquals(11,instance.getScoreJoueur(0));
        assertEquals(16,instance.getScoreJoueur(1));        
    }
    
    @Test
    public void testGetCoupJoueur() {
        instance.jouer(true, true); //tour 0
        instance.jouer(false, true);//tour 1
        instance.jouer(true, true); //tour 2
        instance.jouer(true, false);//tour 3
        instance.jouer(true, false);//tour 4
        
        assertTrue(instance.getCoupJoueur(0, 2));
        assertTrue(!instance.getCoupJoueur(0, 1));
        assertTrue(instance.getCoupJoueur(1, 0));
        assertTrue(!instance.getCoupJoueur(1, 4));
        
    }
    
    @Test(expected = AssertionError.class)
    public void testExceptionGetGainJoueur() {
        instance.jouer(true, false);
        assertEquals(0,instance.getGainJoueur(3, 0));
        assertEquals(0,instance.getCoupJoueur(1, 5));
    }
    
    @Test(expected = AssertionError.class)
    public void testExceptionGetScoreTotal() {
        instance.jouer(true, false);
        assertEquals(0,instance.getScoreJoueur(3));
    }
    
    @Test(expected = AssertionError.class)
    public void testExceptionGetCoupJoueur() {
        instance.jouer(true, false);
        assertEquals(0,instance.getCoupJoueur(3,0));
        assertTrue(instance.getCoupJoueur(0, 5));  
    }
    
}
