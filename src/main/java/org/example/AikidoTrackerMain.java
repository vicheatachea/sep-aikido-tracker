package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class AikidoTrackerMain {
    public static void main(String[] args) {
        AikidoTracker tracker = new AikidoTracker();
        Scanner scanner = new Scanner(System.in);
        run(tracker, scanner);
    }

    public static void run(AikidoTracker tracker, Scanner scanner) {
        while (true) {
            System.out.println("Aikido Practice Tracker");
            System.out.println("1. Add a training session");
            System.out.println("2. View total training time");
            System.out.println("3. Check Kyu graduation eligibility");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter session date (YYYY-MM-DD): ");
                    String dateInput = scanner.next();
                    LocalDate date = LocalDate.parse(dateInput);
                    System.out.print("Enter session duration (minutes): ");
                    int duration = scanner.nextInt();
                    tracker.addSession(date, duration);
                    System.out.println("Session added.");
                    break;
                case 2:
                    int totalTrainingTime = tracker.getTotalTrainingTime();
                    System.out.println("Total training time: " + totalTrainingTime + " minutes");
                    break;
                case 3:
                    boolean eligible = tracker.isEligibleForKyu(LocalDate.now());
                    if (eligible) {
                        System.out.println("You are eligible for Kyu graduation.");
                    } else {
                        System.out.println("You are not eligible for Kyu graduation yet.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}