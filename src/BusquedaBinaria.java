import java.util.Scanner;

public class BusquedaBinaria {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de elementos que desea en la lista: ");
        int tamanobusqueda = scanner.nextInt();
        int[] ordenlista = new int[tamanobusqueda];

        System.out.println("Ingrese los elementos de la lista en forma ordenada:");

        for (int i = 0; i < tamanobusqueda; i++) {

            System.out.print("Elemento No." + (i + 1) + ": ");
            ordenlista[i] = scanner.nextInt();
        }
        System.out.print("Ingrese el número que desea buscar en esta lista: ");
        int numero = scanner.nextInt();

        int datominimo = 0;
        int datomaximo = ordenlista.length - 1;
        int medida;
        int posicion = -1;

        while (datominimo <= datomaximo && posicion == -1) {
            medida = (datominimo + datomaximo) / 2;
            if (numero == ordenlista[medida]) {
                posicion = medida;
            }
            if (ordenlista[medida] > numero) {
                datomaximo = medida - 1;
            } else {
                datominimo = medida + 1;
            }
        }
        if (posicion == -1) {
            System.out.println("El número que agregaste a la lista no existe");
        } else {
            System.out.println("El número ingresado está en la posición: " + posicion + " de esta lista");
        }
        scanner.close();
    }
}