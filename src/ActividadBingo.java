import java.util.Scanner;


public class ActividadBingo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡ Bienvenido al juego del BINGO !");
        System.out.println("Te deseamos mucha suerte");
        System.out.println("Por favor, introduce tu apuesta en €:");
        int apuesta = scanner.nextInt();
        System.out.println("Ingresa la cantidad de números que se prevé acertar en el bingo:");
        int numIntentos = scanner.nextInt();
        System.out.println("Un momento por favor, estamos generando tu cartón...");
        System.out.println();
        int numAleatorio;
        int numLinea = 0;
        int numBingo = 0;
        boolean repetido;
        int intentosLinea = 0;
        int intentosBingo = 0;
        int premio;
        //Vamos crear el cartón de bingo

        int[] carton = new int[10];
        for (int i = 0; i < carton.length; i++) {
            do {
                numAleatorio = (int) (Math.random() * 99) + 1;
                repetido = false;
                for (int j = 0; j < i; j++) {
                    if (carton[j] == numAleatorio) {
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);
            carton[i] = numAleatorio;
        }
        System.out.println("Tu cartón generado ha sido: ");
        for (int item : carton) {
            System.out.print("\t" + item);
        }
        System.out.println();
        //Vamos a ir sacando los números aleatorios hasta que se cante bingo
        int[] bingo = new int[99];
        for (int i = 0; i < bingo.length && numBingo < carton.length; i++) {
            int numSacados;
            repetido = false;
            do {
                numSacados = (int) (Math.random() * 99) + 1;
                repetido = false;
                for (int j = 0; j < i; j++) {
                    if (bingo[j] == numSacados) {
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);
            bingo[i] = numSacados;
            for (int j = 0; j < carton.length; j++) {
                if (carton[j] == numSacados) {
                    intentosLinea++;
                    if (intentosLinea == 5) {
                        numLinea = i + 1;
                        System.out.println();
                        System.out.println("¡ LINEA !");
                    }
                    intentosBingo++;
                    if (intentosBingo == 10) {
                        numBingo = i + 1;
                    }
                }

            }
            System.out.println();
            System.out.println("Bola número " + (i + 1) + " :" + bingo[i]);


        }

        System.out.println();
        System.out.println("¡ BINGO !");
        System.out.println("Para cantar línea has necesitado " + numLinea + " intentos");
        System.out.println("Para cantar bingo has necesitado " + numBingo + " intentos");
        if (numIntentos == numBingo) {
            premio = apuesta * 10;
            System.out.println("Has acertado la apuesta, has ganado un premio de " + premio + " €.");
        } else {
            System.out.println("Lo sentimos, tu apuesta no ha sido premiada, suerte la próxima vez");
        }
        System.out.println("Pulsa enter para continuar...");
    }
}
