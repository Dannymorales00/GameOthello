
package Hilos;

import Fichas.Ficha;
import Recursividad.CambiosRecursivo;



public class CambioDeFichas extends Thread {
    private CambiosRecursivo cambiosrecursivo; 
    private int turno;
    private Ficha matriz[][];
    private int[] filaColumnaBtn;
   
    

    
    public CambioDeFichas( int turno, Ficha[][] matriz,int[] FilaColumnaBtn) {
        this.cambiosrecursivo = new CambiosRecursivo();
        this.turno = turno;
        this.matriz = matriz;
        this.filaColumnaBtn = FilaColumnaBtn;
    }

    @Override
    public void run()
    {
        CambiarFichasFila();
        CambiarFichasColumna();
        CambiarFichasOblicuasDecreciente();
        CambiarFichasOblicuasCreciente();
    }
    
      
 
    //cambia las ficha de una sola fila 
     public void CambiarFichasFila() {
        
        boolean unavez=true;
        int ColumnaAuxiliar=0;
        int f = filaColumnaBtn[0];
        for(int c=0;c<=11;c++)
        {
            if(matriz[f][c].getTipo()==turno)
            {
                 //System.out.println("es el turno correcto: " + f +" c: "+ c);
                if (unavez)
                {
                    //aquí guardamos la primera ficha
                    ColumnaAuxiliar=c;
                    unavez=false;            
                }else{
                    //si entra la primera ficha y la segunda no hay fichas vacias pintamos las fichas de enmedio.   
                    if(DiferenteDeVacioFilas(f,c,ColumnaAuxiliar,matriz)  )
                    { 
                        cambiosrecursivo.FichasFilas(f, ColumnaAuxiliar, c, turno, matriz);   
                    }          
                }//else
            }else{
                 //System.out.println("no es el turno correcto: " + turno);
            }
            
        }
    }    
   
  //Cambia las fichas de un sola columna   
  public void CambiarFichasColumna() {
        
        int FilaAux=0;  //variable auxiliar
        boolean unavez=true;
        int c=filaColumnaBtn[1];  //columna del boton
        for(int f=0;f<12;f++){          
            if(matriz[f][c].getTipo()==turno)
            {
                System.out.println("es el turno correcto: " + f +" c: "+ c);
                if (unavez)
                {
                    FilaAux=f;
                    unavez=false;   
                }else{
                    //c= colunma fija  , f= segunda ficha encontrada ,fila= primeraficha 
                    if(  DiferenteDeVacioColumnas(c,f,FilaAux,matriz)  )
                    { 
       
                        cambiosrecursivo.FichasColumnas(FilaAux, f, c, turno, matriz);
                    }     
                }
            }else{
                System.out.println("no es el turno correcto: " + turno);
            }
//else#1      
        }
    }  
    
    // cambia las fichas oblicuas de arriba a abajo de forma decrenciente
    public void CambiarFichasOblicuasDecreciente() {
        
        boolean unavez=true;
        int f = filaColumnaBtn[0];
        int c = filaColumnaBtn[1];
        
        //variables para ficha auxiliar
        int c1=0;
        int f1=0;
        
        
        //calculamos las posiciones iniciales en F y C
        int Ficha[] =   FichaInicialDecreciente(f,c);
        f = Ficha[0];
        c = Ficha[1];
        
        while(f<11 & c<11)
        {   
            if(matriz[f][c].getTipo()==turno)
            {
                if (unavez)
                {
                    //guardamos la primera ficha encontrada del jugador
                    f1=f;
                    c1=c;
                    unavez=false;
                }else{
                    //comprueba si hay fichas vacias entre la primera y la segunda ficha 
                    if(DiferenteDeVacioDecreciente(f1,c1,f,c,matriz)  )
                    { 
                        while(f1<f & c1<c)
                        {
                            //System.out.println("pintando fila obli: "+f1+" colum obli: "+c1);
                             cambiosrecursivo.RemplazarFichas(turno,f1,c1,matriz);
                         
                            f1++;
                            c1++;
                        }
                    }else{//System.out.println("hay fichas vacias en la oblicua");
                    }          
                }//else
            }  
            f++;
            c++;
        }
    }    
    
    
     // cambia las fichas oblicuas de abajo a arriba de forma creciente
    public void CambiarFichasOblicuasCreciente() {
        
        boolean unavez=true;
        int filaInicial = filaColumnaBtn[0];
        int columnaInicial = filaColumnaBtn[1];
        
        //ficha auxiliar
        int c1=0;
        int f1=0;
        
        //calculamos las posiciones iniciales en F y C
        int Ficha[] =   FichaInicialCreciente(filaInicial,columnaInicial);
        int f = Ficha[0];
        int c = Ficha[1];
        
        //establecemos los limites de la matriz
        while(f>0 & c<11)
        {   
            if(matriz[f][c].getTipo()==turno)
            {
                if (unavez)
                {
                    //guardamos la primera ficha del mismo turno
                    f1=f;
                    c1=c;
                    unavez=false;
                }else{
                    //comprueba si hay fichas vacias entre la primera y la segunda ficha 
                    if(DiferenteDeVacioCreciente(f1,c1,f,c,matriz)  )
                    { 
                        //pintamos desde la primera fichas encontrada hasta la segunda
                        while(f1>f & c1<c )
                        {
                            //System.out.println("pintando fila obli: "+f1+" colum obli: "+c1);
                            if(f1 != filaInicial && c1 != columnaInicial){
                                cambiosrecursivo.RemplazarFichas(turno,f1,c1,matriz);
                            }
                            f1--;
                            c1++;
                        }         
                    }else{//System.out.println("hay fichas vacias en la oblicua");
                    }            
                }//else
            }  
            f--;
            c++;
        }
    }    
    
    
        public boolean DiferenteDeVacioDecreciente(int f,int c,int f1,int c1,Ficha matriz[][]) {
        boolean result = false;   
        while(f<f1 & c<c1)
        {
            if(matriz[f][c].getTipo()!=0)
            {
                result = true;
            }else{return false;}
            f++;
            c++;
            }
        return result;
        }
        
        public boolean DiferenteDeVacioCreciente(int f,int c,int f1,int c1,Ficha matriz[][]) {
        boolean result = false;   
        while(f>f1 & c<c1)
        {
            if(matriz[f][c].getTipo()!=0)
            {
                result = true;  
            }else{return false;}
            f--;
            c++;
        }
        return result;
        }
    
    public boolean DiferenteDeVacioFilas(int f,int Termina,int Inicia,Ficha matriz[][]) {
        boolean result = false;   
        for(int k=Inicia;k<=Termina;k++)
        {
            if(matriz[f][k].getTipo()!=0)
            {
                result = true; 
            }else{return false;}
        }
        return result;
    }
    
    public boolean DiferenteDeVacioColumnas(int c,int Termina,int Inicia,Ficha matriz[][]) {
        boolean result = false;   
        for(int k=Inicia;k<=Termina;k++)
        {
            if(matriz[k][c].getTipo()!=0)
            {
                result = true;
            }else{return false;}
        }  
        return result;
    }
    
    
   
    
     //calcula la primera ficha de donde iniciar el recorrido
    public int[] FichaInicialDecreciente(int f, int c) {
       int vector[] = {0,0}; 
        while(f>0 & c>0)
        {
            f--;
            c--;
        }
        vector[0]=f;
        vector[1]=c;
        return vector; 
    }
    
    
    //calcula la primera ficha de donde iniciar el recorrido
    public int[] FichaInicialCreciente(int f, int c) {
       int vector[] = {0,0}; 
        while(f<11 & c>0)
        {
            f++;
            c--;
        }
        vector[0]=f;
        vector[1]=c;
        return vector;
    }
    

    
    
}
