/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import javax.swing.JLabel;

public class Cronometro extends Thread {

    JLabel lblSegundos;

    public Cronometro(JLabel lblTime) {
        this.lblSegundos = lblTime;
    }

    public void run() {
        int nuMin = 00;
        int nuSeg = 00;
        int nuHora = 00;
        try {

            for (;;) { //inicio del for infinito           
                if (nuSeg != 59) {//si no es el ultimo segundo
                    nuSeg++;
                } else {
                    if (nuMin != 59) {//si no es el ultimo minuto
                        nuSeg = 0;
                        nuMin++;
                    } else {//incremento el numero de horas
                        nuHora++;
                        nuMin = 0;
                        nuSeg = 0;
                    }
                }
                lblSegundos.setText(String.valueOf(nuHora) + ":" + String.valueOf(nuMin) + ":" + String.valueOf(nuSeg));
                //System.out.println(nuHora+":"+nuMin+":"+nuSeg);//Muestro en pantalla el Cronometro

                sleep(999);//Duermo el hilo durante 999 milisegundos
            }//Fin del for infinito        

        } catch (Exception ex) {
            System.out.println(ex.getMessage());//Imprima el error
        }
    }

}//Fin Clase
