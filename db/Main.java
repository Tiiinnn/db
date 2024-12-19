import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        User user = new User(username);

        while (true) {
            System.out.println("\n=== Health Tracker System ===");
            System.out.println("1. Log Health Activity");
            System.out.println("2. Summarize Daily Activities");
            System.out.println("3. Exit");
            int choice = getValidInteger(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter activity type (Exercise or Meal): ");
                    String activityType = scanner.nextLine();

                    if (activityType.equalsIgnoreCase("Meal")) {
                        System.out.print("Enter food type (e.g., Protein, Carbs, Mixed): ");
                        String foodType = scanner.nextLine();
                        System.out.print("Enter amount of " + foodType + " (in grams): ");
                        int foodAmount = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        HealthActivity mealActivity = new HealthActivity(user.getUsername(), activityType, foodType, foodAmount);
                        HealthActivityDAO.addHealthActivity(mealActivity);
                    } else if (activityType.equalsIgnoreCase("Exercise")) {
                        LocalTime startTime = getValidTime(scanner, "Enter start time (HH:MM): ");
                        LocalTime endTime = getValidTime(scanner, "Enter end time (HH:MM): ");
                        System.out.print("Enter type of exercise (e.g., Push-ups, etc.): ");
                        String exerciseType = scanner.nextLine();
                        System.out.print("Enter number of reps: ");
                        int reps = scanner.nextInt();
                        System.out.print("Enter number of sets: ");
                        int sets = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        System.out.print("Enter intensity (e.g., Low, Medium, High): ");
                        String intensity = scanner.nextLine(); // Ask for intensity

                        HealthActivity exerciseActivity = new HealthActivity(
                                user.getUsername(),
                                activityType,
                                startTime,
                                endTime,
                                exerciseType,
                                reps,
                                sets,
                                intensity // Pass intensity to the constructor
                        );
                        HealthActivityDAO.addHealthActivity(exerciseActivity);
                    }

             else {
                        System.out.println("Invalid activity type. Please choose 'Exercise' or 'Meal'.");
                    }
                    break;
                case 2:
                    HealthActivityDAO.summarizeActivities(user.getUsername());
                    break;
                case 3:
                    System.out.print("Are you sure you want to exit? (yes/no): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        System.out.println("Exiting the system. Stay healthy!");
                        System.exit(0);
                    } else {
                        System.out.println("Returning to the main menu.");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static LocalTime getValidTime(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return LocalTime.parse(input);
            } catch (Exception e) {
                System.out.println("Invalid time format. Please enter time in HH:MM format.");
            }
        }
    }

    private static int getValidInteger(Scanner scanner) {
        while (true) {
            System.out.print("Choose an option: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
