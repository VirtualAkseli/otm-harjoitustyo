package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoOikein() {
        kortti = new Maksukortti(0);
        assertEquals("saldo: 0.0", kortti.toString());
    }
    
    @Test
    public void kortinSaldoKasvaaOikein() {
        kortti = new Maksukortti(0);
        kortti.lataaRahaa(500);
        assertEquals("saldo: 5.0", kortti.toString());
    }
    
    @Test
    public void kulutusToimii() {
        kortti = new Maksukortti(1000);
        kortti.otaRahaa(50);
        assertEquals(950, kortti.saldo());
    }
    
    @Test
    public void rahaaEiVaheneLiikaa() {
        kortti = new Maksukortti(100);
        kortti.otaRahaa(101);
        assertEquals("saldo: 1.0", kortti.toString());
    }
    
    
}

    
