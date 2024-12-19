import java.time.LocalDate;
import java.time.LocalTime;

public class HealthActivity {
    private final String username;
    private final String activityType; // "Exercise" or "Meal"
    private final LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String foodType; // Specific to meal activities
    private double quantity; // Quantity of food in grams
    private String exerciseType; // Specific to exercise activities
    private int reps; // For exercises
    private int sets; // For exercises
    private String intensity; // Added intensity field for exercises

    // Constructor for exercise
    public HealthActivity(String username, String activityType, LocalTime startTime, LocalTime endTime, String exerciseType, int reps, int sets, String intensity) {
        this.username = username;
        this.activityType = activityType;
        this.date = LocalDate.now(); // Assuming you set the date to current
        this.startTime = startTime;
        this.endTime = endTime;
        this.exerciseType = exerciseType;
        this.reps = reps;
        this.sets = sets;
        this.intensity = intensity; // Set the intensity value
    }




    // Constructor for meal
    public HealthActivity(String username, String activityType, String foodType, double quantity) {
        this.username = username;
        this.activityType = activityType;
        this.date = LocalDate.now();
        this.foodType = foodType;
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public String getActivityType() {
        return activityType;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getFoodType() {
        return foodType;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    public String getIntensity() {
        return intensity;
    }
}
