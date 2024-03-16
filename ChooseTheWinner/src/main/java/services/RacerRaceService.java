package services;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacerRaceService {

    public static void race() {

        boolean loop = true;

        while (loop) {
            int min = 1;
            int max = RacerRegisterService.racerCount;
            int randomWinner = (int) Math.floor(Math.random() * (max - min + 1) + min);

            try {
                if (max == 0) {
                    System.out.println("At first you must add racers!!!");
                    loop = false;
                } else {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Who do you think is the winner?  (please enter racer's number)");
                    System.out.print("Your choise: ");
                    int choise = sc.nextInt();

                    if (choise > max) {
                        System.out.println("Your number does not match any racer, please enter true number!!!");
                    } else if (choise == randomWinner) {
                        System.out.println("Congratulations you won!");
                        loop = false;

                    } else {
                        System.out.println("You failed!");
                        loop = false;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("You must enter a number!!!");
            }
        }
    }
}
