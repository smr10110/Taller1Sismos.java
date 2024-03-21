public class Main {
    private static final int DIAS = 7;
    private static final int HORAS = 24; // Número de horas por día
    private static double[][] sismos = new double[DIAS][HORAS];

    public static void main(String[] args) {
        System.out.println("Inicio del programa de analisis sismico");
        ingresarDatos();

        System.out.println("Sismo de mayor magnitud: " + buscarMayorSismo());

        System.out.println("Número de sismos >= 5.0: " + contarSismos());

        System.out.println("Fin del programa");
    }

    public static void ingresarDatos() {
        for (int dia = 0; dia < DIAS; dia++) {
            for (int hora = 0; hora < HORAS; hora++) {
                sismos[dia][hora] = 1.1 + (Math.random() * 8.8);
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
        boolean alertaEnviada = false;
        for (int dia = 0; dia < DIAS; dia++) {
            for (int hora = 0; hora < HORAS; hora++) {
                if (sismos[dia][hora] >= 7.0) {
                    System.out.println("Alerta!!! se debe evacuar zona costera!");
                    alertaEnviada = true;
                }
            }
        }
        if (!alertaEnviada) {
            System.out.println("No se detectaron sismos mayores o iguales a 7.0.");
        }
    }
}
