package util;

import java.util.InputMismatchException;
import java.util.Scanner;
import services.RacerRaceService;
import services.RacerRegisterService;

public class MenuUtil {
    public static void loginMenu() {
        int wrongLogin = 0;
        boolean loop = true;

        while (loop) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Sign in!");
            System.out.print("Username: ");
            String username = sc.next();
            System.out.print("Password: ");
            String password = sc.next();

            if (username.equals("Admin") && password.equals("12345")) {
                System.out.println("Succesfuly login!!!");
                menu();
                loop = false;
            } else {
                System.out.println("Username or password is wrong!");
                wrongLogin++;
            }

            if (wrongLogin > 2) {
                System.out.println("You banned!!!");
                loop = false;
            }
        }
    }

    public static void menu() {
        boolean loop = true;

        while (loop) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n================= Main Menu =================");
            System.out.println("1. Register racers");
            System.out.println("2. Start race");
            System.out.println("3. Logout");
            System.out.println("4. Exit");

            try {
                System.out.print("\nSelect: ");
                int input = sc.nextInt();

                switch (input) {
                    case 1:
                        RacerRegisterService.registerRacers();
                        break;
                    case 2:
                        RacerRaceService.race();
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    default:
                        System.out.println("You must enter true number!!!");
                        break;
                        
                }
            } catch (InputMismatchException e) {
                System.out.println("You must enter a number!!!");
            }

        }
    }
}
