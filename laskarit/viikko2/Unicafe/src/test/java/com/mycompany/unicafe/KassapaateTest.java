/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author aknu
 */
public class KassapaateTest {
    Kassapaate kassa;
    Maksukortti visa;
    Maksukortti diners;
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        visa = new Maksukortti(1000);
        diners = new Maksukortti(100);
    }
    
    @Test
    public void kassassaRahaa() {
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void montakoEdullista() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void montakoMaukasta() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void toimiikoKateisEdu() {
        assertEquals(10, kassa.syoEdullisesti(250));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        kassa.syoEdullisesti(120);
        assertEquals(1,kassa.edullisiaLounaitaMyyty());
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    
    
   
    
    @Test
    public void toimiikoKateisMau() {
        assertEquals(20, kassa.syoMaukkaasti(420));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        kassa.syoMaukkaasti(120);
        assertEquals(1,kassa.maukkaitaLounaitaMyyty());
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void toimiikoKorttiMak() {
        kassa.syoEdullisesti(new Maksukortti(1000));
        kassa.syoMaukkaasti(new Maksukortti(1000));
        kassa.syoMaukkaasti(new Maksukortti(300));
        kassa.syoEdullisesti(new Maksukortti(200));
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        
        
    }
    
    @Test
    public void toimiikoLataus() {
        kassa.lataaRahaaKortille(visa, 500);
        kassa.lataaRahaaKortille(diners, -100);
        assertEquals(1500, visa.saldo());
        assertEquals(100500, kassa.kassassaRahaa());
        assertEquals(100, diners.saldo());
        assertEquals(100500, kassa.kassassaRahaa());
    }
    
    
    
}
