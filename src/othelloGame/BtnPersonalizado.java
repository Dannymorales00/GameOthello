/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othelloGame;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class BtnPersonalizado extends JButton {
    
    private boolean activado;
    
    public BtnPersonalizado() {
        this.activado = false;
        this.setContentAreaFilled(false);
        this.setBorder(new RoundedBorder(10));
        ImageIcon iconobtn = new ImageIcon("src/Imagenes/EspacioVacio.png");
        ImageIcon iconoEscala = new ImageIcon(iconobtn.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_FAST));
        this.setIcon(iconoEscala );
    }

    

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }


}



