/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursividad;

import Fichas.Ficha;
import Fichas.FichaBlanca;
import Fichas.FichaNegra;

public class CambiosRecursivo {
    
    public void FichasFilas(int f,int ColumnaAux,int c,int turno,Ficha matriz[][]) {
        if(ColumnaAux<c)
        {
            RemplazarFichas(turno,f,ColumnaAux,matriz);
            //recursivo
            FichasFilas(f ,ColumnaAux+1 ,c ,turno ,matriz );            
        }
    }
    
    public void FichasColumnas(int FilaAux,int f,int c,int turno,Ficha matriz[][]) {
        if(FilaAux<f)
        {  
            RemplazarFichas(turno,FilaAux,c,matriz);
            //recursivo
            FichasColumnas(FilaAux+1 ,f ,c,turno ,matriz );            
        }
    }
    
      //cambia las fichas de la matriz de juego segun el jugador que coma
      public void RemplazarFichas(int turno,int f,int c,Ficha matriz[][]) {
        if(turno==1){
            matriz[f][c]= new FichaNegra();
        }else{
            matriz[f][c]= new FichaBlanca();
        
        }   
      }
    
}
