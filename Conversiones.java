import java.util.Scanner;

public class Conversiones {

    public static void IEEE_754_a_decimal(String binario) {
        if (binario.length() != 32) {
            System.err.println("El número binario debe ser de 32 bits.");
            return;
        }

        int signo = binario.charAt(0) == '0' ? 1 : -1;
        String exponente = binario.substring(1, 9);
        int exponentee = Integer.parseInt(exponente, 2) - 127;
        String mantisa = binario.substring(9);
        double mantisaa = 1.0;
        for (int i = 0; i < mantisa.length(); i++) {
            if (mantisa.charAt(i) == '1') {
                mantisaa += Math.pow(2, -(i + 1));
            }
        }
        double resultado = signo * mantisaa * Math.pow(2, exponentee);
        System.out.println("El resultado en decimal es: " + resultado);
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Bienvenido al programa de conversiones");
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Binario en formato IEEE 754 de precisión simple (32 bits) a decimal.");
        System.out.println("2. Decimal a binario en formato IEEE 754 de precisión simple (32 bits).");
        int opcion = leer.nextInt();

        if (opcion == 1) {
            System.out.println("Ingrese el número binario en formato IEEE 754 de precisión simple (32 bits): ");
            String binario = leer.next();
            IEEE_754_a_decimal(binario);
        } else if (opcion == 2) {
            // corre metodo
        } else {
            System.err.println("Opción no válida. Intente nuevamente.");
        }
        leer.close();
    }

}
