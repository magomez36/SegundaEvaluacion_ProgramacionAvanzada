package SegundaEvaluacion;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException  {
        Random rand = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<String>[] ganadoresOctavos = new Future[8];
        Future<String>[] ganadoresCuartos = new Future[4];
        Future<String>[] ganadoresSemifinal = new Future[2];
        Future<String> ganadorFinal;


        List<String> jugadores = List.of(
                "Jugador 1", "Jugador 2", "Jugador 3", "Jugador 4",
                "Jugador 5", "Jugador 6", "Jugador 7", "Jugador 8",
                "Jugador 9", "Jugador 10", "Jugador 11", "Jugador 12",
                "Jugador 13", "Jugador 14", "Jugador 15", "Jugador 16"
        );


       System.out.println("===== OCTAVOS DE FINAL =====");
       for (int i = 0; i < 8; i++) {
           String jugador1 = jugadores.get(i);
           String jugador2 = jugadores.get(jugadores.size()-(i+1));
           Callable<String> jugarPartido = () -> {
               String ganadorPartido = "";
               String[] sets = new String[3];
               System.out.println(jugador1 + " vs " + jugador2);
               Thread.sleep(2000);
               for (int j = 0; j < 3; j++) {
                    sets[j] = ((rand.nextInt(2) + 1) == 1) ? jugador1 : jugador2;
                    System.out.println("Set " + (j+1) +" " +sets[j]);
                    if (sets[0] == sets[1]) {
                        j = 4;
                        ganadorPartido = sets[0];
                    } else if (j == 2) {
                        ganadorPartido = sets[2];
                    }
               }
               System.out.println("Ganador del partido: " + ganadorPartido);
               System.out.println("");
               return ganadorPartido;
           };
           ganadoresOctavos[i] = executor.submit(jugarPartido);
       }

       List<String> jugadores02 = new ArrayList<>();

        try {
            for (int i = 0; i < 8; i++) {
                jugadores02.add(ganadoresOctavos[i].get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

       System.out.println("===== CUARTOS DE FINAL =====");
        for (int i = 0; i < 4; i++) {
            String jugador1 = jugadores02.get(i);
            String jugador2 = jugadores02.get(jugadores02.size()-(i+1));
            Callable<String> jugarPartido = () -> {
                String ganadorPartido = "";
                String[] sets = new String[3];
                System.out.println(jugador1 + " vs " + jugador2);
                Thread.sleep(2000);
                for (int j = 0; j < 3; j++) {
                    sets[j] = ((rand.nextInt(2) + 1) == 1) ? jugador1 : jugador2;
                    System.out.println("Set " + (j+1) +" " +sets[j]);
                    if (sets[0] == sets[1]) {
                        j = 4;
                        ganadorPartido = sets[0];
                    } else if (j == 2) {
                        ganadorPartido = sets[2];
                    }
                }
                System.out.println("Ganador del partido: " + ganadorPartido);
                System.out.println("");
                return ganadorPartido;
            };
            ganadoresCuartos[i] = executor.submit(jugarPartido);
        }

        List<String> jugadores03 = new ArrayList<>();

        try {
            for (int i = 0; i < 4; i++) {
                jugadores03.add(ganadoresCuartos[i].get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("===== SEMIFINAL =====");
        for (int i = 0; i < 2; i++) {
            String jugador1 = jugadores03.get(i);
            String jugador2 = jugadores03.get(jugadores03.size()-(i+1));
            Callable<String> jugarPartido = () -> {
                String ganadorPartido = "";
                String[] sets = new String[3];
                System.out.println(jugador1 + " vs " + jugador2);
                Thread.sleep(2000);
                for (int j = 0; j < 3; j++) {
                    sets[j] = ((rand.nextInt(2) + 1) == 1) ? jugador1 : jugador2;
                    System.out.println("Set " + (j+1) +" " +sets[j]);
                    if (sets[0] == sets[1]) {
                        j = 4;
                        ganadorPartido = sets[0];
                    } else if (j == 2) {
                        ganadorPartido = sets[2];
                    }
                }
                System.out.println("Ganador del partido: " + ganadorPartido);
                System.out.println("");
                return ganadorPartido;
            };
            ganadoresSemifinal[i] = executor.submit(jugarPartido);
        }

        List<String> jugadores04 = new ArrayList<>();

        try {
            for (int i = 0; i < 2; i++) {
                jugadores04.add(ganadoresSemifinal[i].get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("===== FINAL =====");
        String jugador1 = jugadores04.get(0);
        String jugador2 = jugadores04.get(1);
        Callable<String> jugarPartido = () -> {
            String ganadorPartido = "";
            String[] sets = new String[3];
            System.out.println(jugador1 + " vs " + jugador2);
            Thread.sleep(2000);
            for (int j = 0; j < 3; j++) {
                sets[j] = ((rand.nextInt(2) + 1) == 1) ? jugador1 : jugador2;
                System.out.println("Set " + (j+1) +" " +sets[j]);
                if (sets[0] == sets[1]) {
                    j = 4;
                    ganadorPartido = sets[0];
                } else if (j == 2) {
                    ganadorPartido = sets[2];
                }
            }
            System.out.println("Ganador del partido: " + ganadorPartido);
            System.out.println("");
            return ganadorPartido;
        };
        ganadorFinal = executor.submit(jugarPartido);

        System.out.println("¡Campeón del torneo: " + ganadorFinal.get() + " !");

        executor.shutdown();
    }
}
