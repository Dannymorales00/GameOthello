package othelloGame;
import Fichas.Ficha;
import Recursividad.MovimientosRecursivo;
import java.awt.Color;

public class Movimientos {

    private int CantMovimientos;
    private MovimientosRecursivo movimientosrecursivo;

    //constructor, inicializa atributo
    public Movimientos() {
        this.movimientosrecursivo = new MovimientosRecursivo();
    }

    public void MostrarPosiblesPosiciones(int turno, boolean b, Ficha matriz[][], BtnPersonalizado MatrizDeBotones[][]) {
        setCantMovimientos(0);

        for (int f = 0; f < 12; f++) {
            for (int c = 0; c < 12; c++) {

                if (matriz[f][c].getTipo() == turno) {

                    int FArriba = movimientosrecursivo.MovArriba(turno, f, c, MatrizDeBotones, b, matriz);
                    if (FArriba >= 0) {
//                        System.out.println("activando f="+(FArriba)+" c="+c);
                        MatrizDeBotones[FArriba][c].setActivado(b);
                        MatrizDeBotones[FArriba][c].setBackground(Sombra(b));
                        MatrizDeBotones[FArriba][c].setOpaque(b);

                        setCantMovimientos(getCantMovimientos() + 1);

                    }

                    int CDerecha = movimientosrecursivo.MovDerecha(turno, f, c, MatrizDeBotones, b, matriz);
                    if (CDerecha >= 0) {
//                        System.out.println("activando f="+f+" c="+(CDerecha));
                        MatrizDeBotones[f][CDerecha].setActivado(b);
                        MatrizDeBotones[f][CDerecha].setBackground(Sombra(b));
                        MatrizDeBotones[f][CDerecha].setOpaque(b);

                        setCantMovimientos(getCantMovimientos() + 1);

                    }

                    int FAbajo = movimientosrecursivo.MovAbajo(turno, f, c, MatrizDeBotones, b, matriz);
                    if (FAbajo >= 0) {
//                        System.out.println("activando f="+(FAbajo)+" c="+c);
                        MatrizDeBotones[FAbajo][c].setActivado(b);
                        MatrizDeBotones[FAbajo][c].setOpaque(b);
                        MatrizDeBotones[FAbajo][c].setBackground(Sombra(b));
                        setCantMovimientos(getCantMovimientos() + 1);

                    }

                    int CIzquierda = movimientosrecursivo.MovIzquierda(turno, f, c, MatrizDeBotones, b, matriz);
                    if (CIzquierda >= 0) {
//                        System.out.println("activando f="+(f)+" c="+CIzquierda);
                        MatrizDeBotones[f][CIzquierda].setActivado(b);
                        MatrizDeBotones[f][CIzquierda].setOpaque(b);
                        MatrizDeBotones[f][CIzquierda].setBackground(Sombra(b));
                        setCantMovimientos(getCantMovimientos() + 1);

                    }
                    
                    //recorre la matriz en forma oblicua
                    int AI[] = movimientosrecursivo.MovArribaIzquierda(turno, f, c, MatrizDeBotones, b, matriz);
                    if (AI[0] >= 0 & AI[1] >= 0) {
//                        System.out.println("activando f="+AI[0]+" c="+AI[1]);
                        MatrizDeBotones[(AI[0])][(AI[1])].setActivado(b);
                        MatrizDeBotones[(AI[0])][(AI[1])].setOpaque(b);
                        MatrizDeBotones[(AI[0])][(AI[1])].setBackground(Sombra(b));
                        setCantMovimientos(getCantMovimientos() + 1);
               
                    }

                    int AD[] = movimientosrecursivo.MovArribaDerecha(turno, f, c, MatrizDeBotones, b, matriz);
                    if (AD[0] >= 0 & AD[1] >= 0 ) {
//                        System.out.println("activando f="+AD[0]+" c="+AD[1]);
                        MatrizDeBotones[(AD[0])][(AD[1])].setActivado(b);
                        MatrizDeBotones[(AD[0])][(AD[1])].setOpaque(b);
                        MatrizDeBotones[(AD[0])][(AD[1])].setBackground(Sombra(b));
                        setCantMovimientos(getCantMovimientos() + 1);
      

                    }

                    int ABI[] = movimientosrecursivo.MovAbajoIzquierda(turno, f, c, MatrizDeBotones, b, matriz);
                    if (ABI[0] >= 0 & ABI[1] >= 0 ) {
//                        System.out.println("activando f=" + ABI[0] + " c=" + ABI[1]);
                        MatrizDeBotones[(ABI[0])][(ABI[1])].setActivado(b);
                        MatrizDeBotones[(ABI[0])][(ABI[1])].setOpaque(b);
                        MatrizDeBotones[(ABI[0])][(ABI[1])].setBackground(Sombra(b));
                             setCantMovimientos(getCantMovimientos() + 1);
          
                    }

                    int ABD[] = movimientosrecursivo.MovAbajoDerecha(turno, f, c, MatrizDeBotones, b, matriz);
                    if (ABD[0] >= 0 & ABD[1] >= 0 && CDerecha != ABD[0]) {
//                        System.out.println("activando f=" + ABD[0] + " c=" + ABD[1]);
                        MatrizDeBotones[(ABD[0])][(ABD[1])].setActivado(b);
                        MatrizDeBotones[(ABD[0])][(ABD[1])].setOpaque(b);
                        MatrizDeBotones[(ABD[0])][(ABD[1])].setBackground(Sombra(b));
                        setCantMovimientos(getCantMovimientos() + 1);
              
                    }
                    
                }
            }
        }
    }
    

    public Color Sombra(boolean valor) {

        if (valor) {
            return Color.LIGHT_GRAY;
        }
        return null;

    }

    public int getCantMovimientos() {
        return CantMovimientos;
    }

    public void setCantMovimientos(int CantMovimientos) {
        this.CantMovimientos = CantMovimientos;
    }

}
