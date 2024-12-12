package com.fav.main;

import com.fav.api.ClienteHttp;

import java.text.NumberFormat;
import java.util.*;

public class Principal {

    public static void main(String[] args) {
        ClienteHttp clienteHttp = new ClienteHttp();
        Scanner scanner = new Scanner(System.in);
        List<String> historial = new ArrayList<>(); // Historial de conversiones

        // Configuración de formato numérico para separar miles
        NumberFormat formatoNumerico = NumberFormat.getNumberInstance(Locale.US);

        try {
            // Obtener las tasas filtradas
            Map<String, Double> tasasFiltradas = clienteHttp.filtrarMonedas();

            // Ordenar las monedas alfabéticamente
            Map<String, Double> tasasOrdenadas = new TreeMap<>(tasasFiltradas);

            // Iniciar el menú interactivo
            boolean continuar = true;
            while (continuar) {
                System.out.println("\n=== Conversor de Monedas ===");
                System.out.println("1. Ver tasas de conversión disponibles");
                System.out.println("2. Realizar una conversión");
                System.out.println("3. Ver historial de conversiones");
                System.out.println("9. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        // Mostrar las tasas de conversión
                        System.out.println("\nTasas de conversión disponibles:");
                        tasasOrdenadas.forEach((moneda, tasa) ->
                                System.out.println(moneda + ": " + formatoNumerico.format(tasa)));
                        break;

                    case 2:
                        // Realizar una conversión
                        System.out.println("\nIngrese la moneda de origen (ej: USD):");
                        String monedaOrigen = scanner.nextLine().toUpperCase();

                        System.out.println("Ingrese la moneda de destino (ej: ARS):");
                        String monedaDestino = scanner.nextLine().toUpperCase();

                        double monto = 0;
                        boolean montoValido = false;
                        while (!montoValido) {
                            System.out.println("Ingrese el monto a convertir:");
                            try {
                                monto = Double.parseDouble(scanner.nextLine().replace(",", ""));
                                montoValido = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Monto inválido. Por favor, ingrese un número válido.");
                            }
                        }

                        // Verificar que las monedas sean válidas
                        if (tasasOrdenadas.containsKey(monedaOrigen) && tasasOrdenadas.containsKey(monedaDestino)) {
                            double tasaOrigen = tasasOrdenadas.get(monedaOrigen);
                            double tasaDestino = tasasOrdenadas.get(monedaDestino);
                            double resultado = monto * (tasaDestino / tasaOrigen);

                            String montoFormateado = formatoNumerico.format(monto);
                            String resultadoFormateado = formatoNumerico.format(resultado);

                            String conversion = String.format("Se ha convertido %s %s a %s %s",
                                    montoFormateado, monedaOrigen, resultadoFormateado, monedaDestino);
                            historial.add(conversion);

                            // Mostrar el resultado de la conversión
                            System.out.println("\n**************************************");
                            System.out.printf("* %s %s -> %s %s *\n", montoFormateado, monedaOrigen, resultadoFormateado, monedaDestino);
                            System.out.println("**************************************");
                        } else {
                            System.out.println("Una o ambas monedas no son válidas.");
                        }
                        break;

                    case 3:
                        // Mostrar el historial de conversiones
                        System.out.println("\nHistorial de conversiones:");
                        if (historial.isEmpty()) {
                            System.out.println("No hay conversiones realizadas.");
                        } else {
                            historial.forEach(System.out::println);
                        }
                        break;

                    case 9:
                        // Salir del programa
                        System.out.println("Gracias por usar el conversor de monedas. ¡Hasta lueguito!");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
