import java.sql.*;

public class HealthActivityDAO {
    // Method to add health activity
    public static void addHealthActivity(HealthActivity activity) {
        String sql = activity.getActivityType().equalsIgnoreCase("Meal") ?
                "INSERT INTO health_activities (username, activity_type, date, food_type, quantity) VALUES (?, ?, ?, ?, ?)" :
                "INSERT INTO health_activities (username, activity_type, date, start_time, end_time, exercise_type, reps, sets, intensity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, activity.getUsername());
            pstmt.setString(2, activity.getActivityType());
            pstmt.setDate(3, Date.valueOf(activity.getDate()));

            if (activity.getActivityType().equalsIgnoreCase("Meal")) {
                pstmt.setString(4, activity.getFoodType());
                pstmt.setDouble(5, activity.getQuantity());
            } else { // For Exercise
                pstmt.setTime(4, Time.valueOf(activity.getStartTime()));
                pstmt.setTime(5, Time.valueOf(activity.getEndTime()));
                pstmt.setString(6, activity.getExerciseType());
                pstmt.setInt(7, activity.getReps());
                pstmt.setInt(8, activity.getSets());
                pstmt.setString(9, activity.getIntensity()); // Intensity field
            }

            pstmt.executeUpdate();
            System.out.println("Health activity logged successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to summarize daily activities
    public static void summarizeActivities(String username) {
        // SQL for summarizing exercises
        String sqlExercise = """
                SELECT date, exercise_type, SUM(reps * sets) AS total_reps, SUM(sets) AS total_sets, intensity, COUNT(*) AS exercise_count
                FROM health_activities
                WHERE username = ? AND activity_type = 'Exercise'
                GROUP BY date, exercise_type, intensity
                """;

        // SQL for summarizing meals
        String sqlMeal = """
                SELECT date, food_type, SUM(quantity) AS total_grams, COUNT(*) AS meal_count
                FROM health_activities
                WHERE username = ? AND activity_type = 'Meal'
                GROUP BY date, food_type
                """;

        try (Connection conn = Database.connect()) {
            // Summarize exercises
            System.out.println("\n=== Exercise Summary ===");
            try (PreparedStatement pstmt = conn.prepareStatement(sqlExercise)) {
                pstmt.setString(1, username);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (!rs.isBeforeFirst()) {
                        System.out.println("No exercise data found.");
                    } else {
                        while (rs.next()) {
                            System.out.printf("Date: %s, Exercise Type: %s, Total Reps: %d, Total Sets: %d, Intensity: %s%n",
                                    rs.getDate("date"),
                                    rs.getString("exercise_type"),
                                    rs.getInt("total_reps"),
                                    rs.getInt("total_sets"),
                                    rs.getString("intensity"));
                        }
                    }
                }
            }

            // Summarize meals
            System.out.println("\n=== Meal Summary ===");
            try (PreparedStatement pstmt = conn.prepareStatement(sqlMeal)) {
                pstmt.setString(1, username);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (!rs.isBeforeFirst()) {
                        System.out.println("No meal data found.");
                    } else {
                        while (rs.next()) {
                            System.out.printf("Date: %s, Food Type: %s, Total Grams Consumed: %.2f, Number of Meals: %d%n",
                                    rs.getDate("date"),
                                    rs.getString("food_type"),
                                    rs.getDouble("total_grams"),
                                    rs.getInt("meal_count"));
                        }
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
