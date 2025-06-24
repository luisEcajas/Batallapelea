package batallafinal;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BatallaFinal {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Configurar la vida de los personajes
        System.out.print("Ingresa la vida inicial de Deadpool: ");
        int vidaDeadpool = scanner.nextInt();
        System.out.print("Ingresa la vida inicial de Wolverine: ");
        int vidaWolverine = scanner.nextInt();

        Personaje deadpool = new Personaje("Deadpool", vidaDeadpool, 10, 100, 25, false);
        Personaje wolverine = new Personaje("Wolverine", vidaWolverine, 10, 120, 20, false);

        int turno = 1;
        boolean turnoDeadpool = true;

        System.out.println("La batalla comienza");
        while (deadpool.estaVivo() && wolverine.estaVivo()) {
            System.out.println("--- TURNO " + turno + " ---");
            Personaje atacante = turnoDeadpool ? deadpool : wolverine;
            Personaje defensor = turnoDeadpool ? wolverine : deadpool;

            System.out.println("Turno de: " + atacante.getNombre());
            if (atacante.isRegeneracion()) {
                System.out.println(atacante.getNombre() + " está regenerándose y pierde este turno.");
                atacante.setRegeneracion(false);

            } else {
                if (defensor.evade()) {
                    System.out.println(defensor.getNombre() + " evadio el ataque.");
                } else {
                    int dano = atacante.atacar();
                    System.out.println(atacante.getNombre() + "ataca e inflige " + dano + " de daño");
                    defensor.setVida(defensor.getVida() - dano);

                    if (dano == atacante.getAtaquemax()) {
                        System.out.println("golpe critico" + defensor.getNombre() + " pierde su turno");
                        defensor.setRegeneracion(true);
                    }

                    //Mostrar estado
                    System.out.println("Vida de " + deadpool.getNombre() + ":" + deadpool.getVida());
                    System.out.println("Vida de " + wolverine.getNombre() + ":" + wolverine.getVida());

                }

            }
            // Esperar 1 segundo
            TimeUnit.SECONDS.sleep(1);
            turno++;
            turnoDeadpool = !turnoDeadpool;

        }
        //Resultaod final
        System.out.println("Fin de la batalla");

        if (deadpool.estaVivo()) {
            System.out.println("" + deadpool.getNombre() + " ha ganado");

        } else {
            System.out.println("" + wolverine.getNombre() + " ha ganado");
        }
    }
}
