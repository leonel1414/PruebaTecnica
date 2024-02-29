package reservadeasientos;

import java.util.Scanner;

public class ReservaDeAsientos {

    public static void main(String[] args) {

        char asientos[][] = new char[10][10];
        boolean bandera = false;
        int asiento = 0, fila = 0;
        String respuesta;
        String verMapa;

        Scanner teclado = new Scanner(System.in);

        for (int f = 0; f < asientos.length; f++) {
            for (int c = 0; c < asientos.length; c++) {
                asientos[f][c] = 'L';

            }
        }
        System.out.println("----BIENVENIDO AL SISTEMAS DE RESERVA----");

        while (bandera != true) {
            //Visualizacion de MAPA
            System.out.println("¿Desea ver los ASIENTOS? S:si, cualquier tecla NO");
            verMapa = teclado.next();

            if (verMapa.equalsIgnoreCase("S")) {
                dibujarMapa(asientos);
            }
            //reserva
            boolean estaOk = false;
            while (estaOk != true) {

                System.out.println("Ingrese FILA y ASIENTO a reservar");
                System.out.print("FILA entre (0 - 9)");
                fila = teclado.nextInt();

                System.out.print("ASIENTO entre (0 - 9)");
                asiento = teclado.nextInt();

                if (fila <= 9 && fila >= 0) {
                    if (asiento <= 9 && asiento >= 0) {
                        estaOk = true;
                    } else {
                        System.out.println("El numero de FILA es invalido.");
                    }
                } else {
                    System.out.println("El numero de Asiento es invalido.");
                }

            }

            if (asientos[fila][asiento] == 'L') {

                asientos[fila][asiento] = 'X';
                System.out.println("Su asiento ya fue RESERVADO");

            } else {
                System.out.println("El ASIENTO está OCUPADO. Elija otro.");
            }

            System.out.println("¿Desea finalizar con la RESERVA?: S: si. Cualquier otra tecla NO.");
            respuesta = teclado.next();
            if (respuesta.equalsIgnoreCase("S")) {
                bandera = true;

            }
        }

    }

    static void dibujarMapa(char asientos[][]) {

        for (int f = 0; f < asientos.length; f++) {
            System.out.print(f);
            for (int c = 0; c < asientos.length; c++) {
                System.out.print(" [" + asientos[f][c] + "] ");
            }
            System.out.println("");
        }
    }

}
