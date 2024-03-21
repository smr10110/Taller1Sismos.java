import java.util.Scanner;

public class Main {
    private static final int DIAS = 7;
    private static final int HORAS = 24; // Número de horas por día
    private static double[][] sismos = new double[DIAS][HORAS];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("1. Ingresar datos");
        System.out.println("2. Mostrar sismo de mayor magnitud");
        System.out.println("3. Contar sismos mayores o iguales a 5.0");
        System.out.println("4. Enviar SMS por sismo mayor o igual a 7.0");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                ingresarDatos();
                break;
            case 2:
                System.out.println("Sismo de mayor magnitud: " + String.format("%,.2f", buscarMayorSismo()));
                break;
            case 3:
                System.out.println("Número de sismos >= 5.0: " + contarSismos());
                break;
            case 4:
                enviarSMS();
                break;
            case 5:
                System.out.println("Saliendo del programa");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
        }
    }

    public static void ingresarDatos() {
        for (int dia = 0; dia < DIAS; dia++) {
            for (int hora = 0; hora < HORAS; hora++) {
                sismos[dia][hora] = Math.round((1.1 + (Math.random() * 8.8)) * 100.0) / 100.0;
            }
        }
        System.out.println("Datos ingresados correctamente.");
    }

    public static double buscarMayorSismo() {
        double mayor = 0;
        for (int dia = 0; dia < DIAS; dia++) {
            for (int hora = 0; hora < HORAS; hora++) {
                if (sismos[dia][hora] > mayor) {
                    mayor = sismos[dia][hora];
                }
            }
        }
        return mayor;
    }

    public static int contarSismos() {
        int contador = 0;
        for (int dia = 0; dia < DIAS; dia++) {
            for (int hora = 0; hora < HORAS; hora++) {
                if (sismos[dia][hora] >= 5.0) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static void enviarSMS() {
        for (int dia = 0; dia < DIAS; dia++) {
            for (int hora = 0; hora < HORAS; hora++) {
                if (sismos[dia][hora] >= 7.0) {
                    System.out.println("Alerta!!! se debe evacuar zona costera!");
                }
            }
        }
    }
}