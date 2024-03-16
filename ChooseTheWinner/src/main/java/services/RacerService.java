package services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import util.Racer;

public class RacerService {

    private static List<Racer> racers = new ArrayList<>();

    public static List<Racer> getRacers() {
        return racers;
    }

    public static void registerRacers() {
        boolean loop = true;

        while (loop) {
            int racerCount = 0;
            System.out.println("How many racers will participate?");

            Scanner sc = new Scanner(System.in);
            try {
                racerCount = sc.nextInt();

                if (racerCount < 2) {
                    System.out.println("You must enter minimum 2 racer!!!");
                } else {
                    for (int i = 0; i < racerCount; i++) {
                        System.out.print(i + 1 + ". Racer: ");
                        Racer racer = new Racer();
                        String fullName = sc.next();
                        racer.setFullName(fullName);
                        racers.add(racer);
                    }

                    System.out.println("\nParticipants of the competition have successfully registered.\n");

                    showRegisteredRacers();

                    loop = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("You must enter a number!!!");
            }

        }
    }

    public static void showRegisteredRacers() {
        for (int i = 0; i < racers.size(); i++) {
            System.out.println(i + 1 + ". " + racers.get(i).getFullName());
        }
    }
}
