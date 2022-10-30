/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fichas;

import java.awt.Color;

public abstract class Ficha {
    
    private int tipo;//1=negra  2=Blanca
    private Color color;

    public Ficha(int tipo, Color color) {
        this.tipo = tipo;
        this.color = color;
    }

    public int getTipo() {
        return tipo;
    }

    public Color getColor() {
        return color;
    }
    
    
    

    
    
    
    
    
    
    
    
    
    
    
}
