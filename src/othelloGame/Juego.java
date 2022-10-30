package othelloGame;

import Hilos.CambioDeFichas;
import Fichas.Ficha;
import Fichas.FichaBlanca;
import Fichas.FichaNegra;
import Fichas.FichaVacia;
import java.awt.Color;

public class Juego {
    //turno comienza de 1 porque los numeros impares son del jugador 1 y los pares jugador 2

    private boolean Activado;
    private int contador = 0;
    private int turno = 0;
    private Movimientos movimientos;
    private Ficha matriz[][] = new Ficha[12][12];
    private int CantFichasNegras = 0;
    private int CantFichasBlancas = 0;
    private CambioDeFichas hiloCambiaFichas;

    public Juego() {
        this.setActivado(true);
        LlenarMatriz();
        InicializarFichas();
//        this.setTurno(1);
        this.setContador(1);
        movimientos = new Movimientos();
        this.ActualizarCantFichas();

    }

    public boolean isActivado() {
        return Activado;
    }

    public void setActivado(boolean Activado) {
        this.Activado = Activado;
    }

    public int getCantFichasNegras() {
        return CantFichasNegras;
    }

    public void setCantFichasNegras(int CantFichasNegras) {
        this.CantFichasNegras = CantFichasNegras;
    }

    public int getCantFichasBlancas() {
        return CantFichasBlancas;
    }

    public void setCantFichasBlancas(int CantFichasBlancas) {
        this.CantFichasBlancas = CantFichasBlancas;
    }

    public Movimientos getMovimientos() {
        return movimientos;
    }

    public Ficha[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Ficha[][] matriz) {
        this.matriz = matriz;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {

        this.turno = turno;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;

        if (this.contador % 2 == 0) {
            this.setTurno(2);

        } else {
            this.setTurno(1);

        }

        System.out.println(" ");
        System.out.println("jugador#: " + this.getTurno());
    }

    public CambioDeFichas getHiloCambiaFichas() {
        return hiloCambiaFichas;
    }

    public void cont() {
        this.setContador(contador + 1);
        System.out.println("cont " + this.contador);
    }

    public void InicializarFichas() {

        matriz[5][5] = new FichaNegra();
        matriz[5][6] = new FichaBlanca();
        matriz[6][5] = new FichaBlanca();
        matriz[6][6] = new FichaNegra();

    }

    public Color cargarColor(int f, int c, BtnPersonalizado btn) {

        //para cargar el color de las primeras 4 fichas
        if (f == 5 & c == 5 | f == 5 & c == 6 | f == 6 & c == 5 | f == 6 & c == 6) {
            btn.setActivado(false);
            return this.getMatriz()[f][c].getColor();
        }

        return null;

    }

    private void LlenarMatriz() {

        for (int f = 0; f < 12; f++) {
            for (int c = 0; c < 12; c++) {
                matriz[f][c] = new FichaVacia();

            }

        }

    }

    public void Movimientos(boolean b, BtnPersonalizado MatrizDeBotones[][]) {

        movimientos.MostrarPosiblesPosiciones(turno, b, matriz, MatrizDeBotones);
    }

    public void CambiodeFichas(int filaColunmaBtn[]) {
        //cambiamos las fichas donde comieron
        hiloCambiaFichas = new CambioDeFichas(turno, matriz, filaColunmaBtn);
        hiloCambiaFichas.start();

    }

    public void ActualizarCantFichas() {
        int cont1 = 0;
        int cont2 = 0;
        for (int f = 0; f < 12; f++) {
            for (int c = 0; c < 12; c++) {
                if (matriz[f][c].getTipo() == 1) {
                    this.setCantFichasNegras(++cont1);

                } else {
                    if (matriz[f][c].getTipo() == 2) {
                        this.setCantFichasBlancas(++cont2);

                    }

                }
            }
        }
        
        System.out.println("CantFichas Negras: " + this.getCantFichasNegras());
        System.out.println("CantFichas Blancas: " + this.getCantFichasBlancas());
        mostrarMatrizJuego();
    }

    public void mostrarMatrizJuego() {
        System.out.print("----------------------------------------\n");
        for (Ficha[] matriz1 : matriz) {
            System.out.print("| ");
            for (int c = 0; c < matriz1.length; c++) {
                System.out.print(matriz1[c].getTipo());
                if (c != matriz[c].length - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println(" |");
        }
        System.out.print("----------------------------------------\n");
    }
}
