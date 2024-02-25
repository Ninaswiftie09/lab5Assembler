import java.util.Scanner;

public class Conversiones {
    // Método para convertir un número en formato IEEE 754 de precisión simple a decimal

    public static void IEEE_754_a_decimal(String binario) {
        if (binario.length() != 32) {
            System.err.println("El número binario debe ser de 32 bits.");
            return;
        }
        // Se extrae el signo, el exponente y la mantisa del número binario

        int signo = binario.charAt(0) == '0' ? 1 : -1;
        String exponente = binario.substring(1, 9);
        int exponentee = Integer.parseInt(exponente, 2) - 127;
        String mantisa = binario.substring(9);
        double mantisaa = 1.0;
        // para  calcular la mantisa del número
        for (int i = 0; i < mantisa.length(); i++) {
            if (mantisa.charAt(i) == '1') {
                mantisa += Math.pow(2, -(i + 1));
            }
        }
        //Calcula el resultado final en decimal

        double resultado = signo * mantisaa * Math.pow(2, exponentee);
        System.out.println("El resultado en decimal es: " + resultado);
    }
    //   Método para convertir un número decimal a formato IEEE 754 de precisión simple

    public static String decimal_a_IEEE_754(double numero) {
        int signo;
        if (numero < 0) {
            signo = 1;
            numero = Math.abs(numero);
        } else {
            signo = 0;
        }
               // Divide el número decimal en parte entera y parte decimal

        int parteEntera = (int) numero;
        double parteDecimal = numero - parteEntera;

        String binarioParteEntera = Integer.toBinaryString(parteEntera);
        // Convierte la parte entera a binario

        StringBuilder binarioParteDecimal = new StringBuilder();
        for (int i = 0; i < 23; i++) {
            parteDecimal *= 2;
            int bit = (int) parteDecimal;
            if (bit == 1) {
                parteDecimal -= bit;
            }
            binarioParteDecimal.append(bit);
            

        }
         
        // Convierte la parte decimal a binario

        String exponente = Integer.toBinaryString(127 + binarioParteEntera.length() - 1);
        while (exponente.length() < 8) {
            exponente = "0" + exponente;
        }
        // Imprime el número decimal a convertir

        System.out.println("El número decimal es: " + numero);

        String mantisa = binarioParteEntera.substring(1) + binarioParteDecimal.toString();

        return signo + exponente + mantisa;
        

        
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
            System.out.println("Ingrese el número decimal a convertir: ");
            double numero = leer.nextDouble();
            String resultado = decimal_a_IEEE_754(numero);
            System.out.println("El resultado en binario IEEE 754 es: " + resultado);
        } else {
            System.err.println("Opción no válida. Intente nuevamente.");
        }
        leer.close();

}
}
