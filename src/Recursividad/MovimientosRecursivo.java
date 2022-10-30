/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursividad;

import othelloGame.BtnPersonalizado;
import Fichas.Ficha;

public class MovimientosRecursivo {

    public MovimientosRecursivo() {
    }

    //movimientos recursivos
    public int MovArriba(int turno, int f, int c, BtnPersonalizado MatrizDeBotones[][], boolean b, Ficha matriz[][]) {

        //evita recorrer espacios vacios si la ficha actual esta vacia
        if (matriz[f][c].getTipo() == 0) {
            return -1;
        }

        //cuando llegamos al limte de arriba termina la recursvidad
        if (f - 1 < 0) {
            return -1;
        }
        //si la ficha siguiente hacia arriba es del mismo jugador que en la ficha que estamos.
        if (matriz[f - 1][c].getTipo() == turno) {
            //no seguimos buscando una siguiente ficha
            return -1;

        }

        //sino esta vacia 
        if (matriz[f - 1][c].getTipo() != 0) {

            //pasamos a la siguiente ficha de arriba
            return MovArriba(turno, f - 1, c, MatrizDeBotones, b, matriz);

        } else {

            //si la ficha de arriba esta vacia y en la ficha que estamos es del otro jugador
            if (matriz[f - 1][c].getTipo() == 0 & matriz[f][c].getTipo() != turno) {
                //retornamos esa ficha vacia
                return f - 1;

            } else {
                return -1;
            }

        }

    }

    public int MovDerecha(int turno, int f, int c, BtnPersonalizado MatrizDeBotones[][], boolean b, Ficha matriz[][]) {

        //evita recorrer espacios vacios si la ficha actual esta vacia
        if (matriz[f][c].getTipo() == 0) {
            return -1;
        }

        //comprueba si existe un espacio a la derecha de la posicion actual.
        if (c + 1 >= 12) {
            return -1;
        }

        //comprueba si la ficha siguiente es igual a la ficha en la que estamos
        if (matriz[f][c + 1].getTipo() == turno) {
            return -1;

        }

        //si la ficha es del otro jugador
        if (matriz[f][c + 1].getTipo() != 0 & matriz[f][c + 1].getTipo() != turno) {
            return MovDerecha(turno, f, c + 1, MatrizDeBotones, b, matriz);

            //si esta vacia la ficha siguiente retorna false   
        } else {

            if (matriz[f][c + 1].getTipo() == 0) {
                //valida que la ficha actual sea del jugador contrario
                if (matriz[f][c].getTipo() != turno) {
                    return c + 1;
                }
                return -1;

                //si esta vacia retorna -1   
            } else {
                return -1;
            }

        }

    }

    public int MovAbajo(int turno, int f, int c, BtnPersonalizado MatrizDeBotones[][], boolean b, Ficha matriz[][]) {

        //System.out.println("movimiento abajo");
        if (matriz[f][c].getTipo() == 0) {
            return -1;
        }

        //limite de abajo
        if (f + 1 >= 12) {
            return -1;

        }
        //si la ficha de actual es igual a la Ficha de Abajo
        if (matriz[f + 1][c].getTipo() == turno) {
            return -1;

        }
        //si la ficha es del otro jugador
        if (matriz[f + 1][c].getTipo() != 0 & matriz[f + 1][c].getTipo() != turno) {
            return MovAbajo(turno, f + 1, c, MatrizDeBotones, b, matriz);

            //si esta vacia retorna false   
        } else {
            if (matriz[f + 1][c].getTipo() == 0 & matriz[f][c].getTipo() != turno) {
                return f + 1;

                //si esta vacia retorna -1   
            } else {
                return -1;
            }
        }
    }

    public int MovIzquierda(int turno, int f, int c, BtnPersonalizado MatrizDeBotones[][], boolean b, Ficha matriz[][]) {

        //System.out.println("movimiento izquierda");
        if (matriz[f][c].getTipo() == 0) {
            return -1;
        }
        //limite de la izquierda
        if (c - 1 < 0) {
            return -1;
        }
        //si la ficha actual es igual a la ficha de la izquierda
        if (matriz[f][c - 1].getTipo() == turno) {
            return -1;

        }
        //si la ficha es del otro jugador
        if (matriz[f][c - 1].getTipo() != 0 & matriz[f][c - 1].getTipo() != turno) {
            return MovIzquierda(turno, f, c - 1, MatrizDeBotones, b, matriz);

            //si esta vacia retorna false   
        } else {
            if (matriz[f][c - 1].getTipo() == 0 & matriz[f][c].getTipo() != turno) {
                return c - 1;

                //si esta vacia retorna -1   
            } else {
                return -1;
            }
        }

    }

    public int[] MovArribaIzquierda(int turno, int f, int c, BtnPersonalizado MatrizDeBotones[][], boolean b, Ficha matriz[][]) {
        int vect[] = {-1, -1};

        //System.out.println("movArribaIzquierda");
        if (matriz[f][c].getTipo() == 0) {
            vect[0] = f - 1;
            vect[1] = c - 1;
            return vect;
        }

        //limite de arribaIzquierda
        if (c - 1 >= 0 & f - 1 >= 0) {
            //si la ficha de arribaizquierda es igual a la actual
            if (matriz[f - 1][c - 1].getTipo() == turno) {

                return vect;

            } else {
                //si la ficha es del otro jugador
                if (matriz[f - 1][c - 1].getTipo() != 0) {
                    return MovArribaIzquierda(turno, f - 1, c - 1, MatrizDeBotones, b, matriz);

                    //si esta vacia retorna false   
                } else {
                    if (matriz[f - 1][c - 1].getTipo() == 0 & matriz[f][c].getTipo() != turno) {
                        vect[0] = f - 1;
                        vect[1] = c - 1;
                        return vect;

                        //si esta vacia retorna -1   
                    } else {
                        return vect;
                    }

                }

            }

        } else {
            return vect;
        }

    }

    public int[] MovArribaDerecha(int turno, int f, int c, BtnPersonalizado MatrizDeBotones[][], boolean b, Ficha matriz[][]) {
        int vect[] = {-1, -1};
        //System.out.println("movArribaDerecha");

        if (matriz[f][c].getTipo() == 0) {
            vect[0] = f - 1;
            vect[1] = c - 1;
            return vect;
        }

        //limite de arriba
        if (c + 1 <= 11 & f - 1 >= 0) {
            //si la ficha de arribaDerecha es igual a la actual
            if (matriz[f - 1][c + 1].getTipo() == turno) {
                //devolvemos la fila y la columna 
                return vect;

            } else {
                //si la ficha es del otro jugador
                if (matriz[f - 1][c + 1].getTipo() != 0) {
                    return MovArribaDerecha(turno, f - 1, c + 1, MatrizDeBotones, b, matriz);

                } else {

                    //si la ficha de siguiente esta vacia y la actual es del otro jugador
                    if (matriz[f - 1][c + 1].getTipo() == 0 & matriz[f][c].getTipo() != turno) {
                        vect[0] = f - 1;
                        vect[1] = c + 1;
                        return vect;

                        //si esta vacia retorna -1   
                    } else {
                        return vect;
                    }

                }

            }

        } else {
            return vect;
        }

    }

    public int[] MovAbajoIzquierda(int turno, int f, int c, BtnPersonalizado MatrizDeBotones[][], boolean b, Ficha matriz[][]) {
        int vect[] = {-1, -1};
        //System.out.println("movAbajoIzquierda");

        if (matriz[f][c].getTipo() == 0) {
            vect[0] = f - 1;
            vect[1] = c - 1;
            return vect;
        }

        //limite de abajo
        if (c - 1 >= 0 & f + 1 <= 11) {
            //si la ficha de arribaDerecha es igual a la actual
            if (matriz[f + 1][c - 1].getTipo() == turno) {
                //devolvemos la fila y la columna 
                return vect;

            } else {
                //si la ficha es del otro jugador
                if (matriz[f + 1][c - 1].getTipo() != 0) {
                    return MovAbajoIzquierda(turno, f + 1, c - 1, MatrizDeBotones, b, matriz);

                } else {

                    //si la ficha de siguiente esta vacia y la actual es del otro jugador
                    if (matriz[f + 1][c - 1].getTipo() == 0 & matriz[f][c].getTipo() != turno) {
                        vect[0] = f + 1;
                        vect[1] = c - 1;
                        return vect;

                        //si esta vacia retorna -1   
                    } else {
                        return vect;
                    }

                }

            }

        } else {
            return vect;
        }

    }

    public int[] MovAbajoDerecha(int turno, int f, int c, BtnPersonalizado MatrizDeBotones[][], boolean b, Ficha matriz[][]) {
        int vect[] = {-1, -1};
        //System.out.println("movAbajoDerecha");

        if (matriz[f][c].getTipo() == 0) {
            vect[0] = f - 1;
            vect[1] = c - 1;
            return vect;
        }

        //limite de abajo
        if (c + 1 <= 11 & f + 1 <= 11) {
            //si la ficha de arribaDerecha es igual a la actual
            if (matriz[f + 1][c + 1].getTipo() == turno) {
                //devolvemos la fila y la columna 
                return vect;

            } else {
                //si la ficha es del otro jugador
                if (matriz[f + 1][c + 1].getTipo() != 0) {
                    return MovAbajoDerecha(turno, f + 1, c + 1, MatrizDeBotones, b, matriz);

                } else {

                    //si la ficha de siguiente esta vacia y la actual es del otro jugador
                    if (matriz[f + 1][c + 1].getTipo() == 0 & matriz[f][c].getTipo() != turno) {
                        vect[0] = f + 1;
                        vect[1] = c + 1;
                        return vect;

                        //si esta vacia retorna -1   
                    } else {
                        return vect;
                    }

                }

            }

        } else {
            return vect;
        }

    }
}
