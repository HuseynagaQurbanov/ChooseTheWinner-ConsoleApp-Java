package services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import util.Racer;

public class RacerRegisterService {

    private static List<Racer> racers = new ArrayList<>();
    public static int racerCount = 0;
    private static int selectedRacerCount =0;

    
    public static List<Racer> getRacers() {
        return racers;
    }

    public static void registerRacers() {
        boolean loop = true;

        while (loop) {
            System.out.println("How many racers will participate?");

            Scanner sc = new Scanner(System.in);
            try {
                selectedRacerCount = sc.nextInt();

                if (selectedRacerCount < 2) {
                    System.out.println("You must enter minimum 2 racer!!!");
                } else {
                    for (int i = 0; i < selectedRacerCount; i++) {
                        System.out.print(i + 1 + ". Racer: ");
                        Racer racer = new Racer();
                        String fullName = sc.next();
                        racer.setFullName(fullName);
                        racers.add(racer);
                        racerCount++;
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
