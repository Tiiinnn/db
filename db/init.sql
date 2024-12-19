-- Create the new schema named 'Database'
CREATE SCHEMA database;

-- Use the newly created schema
USE database;

-- Create the 'health_activities' table
CREATE TABLE health_activities (
    id INT AUTO_INCREMENT PRIMARY KEY,          -- Unique ID for each record
    username VARCHAR(50) NOT NULL,              -- Username (text-based identifier)
    activity_type ENUM('Exercise', 'Meal') NOT NULL, -- Type of activity (Exercise or Meal)
    date DATE NOT NULL,                         -- Date of the activity
    start_time TIME NULL,                       -- Start time for Exercise (NULL for Meals)
    end_time TIME NULL,                         -- End time for Exercise (NULL for Meals)
    exercise_type VARCHAR(50) NULL,             -- Type of exercise (NULL for Meals)
    reps INT NULL,                              -- Number of reps for Exercise (NULL for Meals)
    sets INT NULL,                              -- Number of sets for Exercise (NULL for Meals)
    intensity ENUM('Low', 'Medium', 'High') NULL, -- Intensity for Exercise (NULL for Meals)
    food_type VARCHAR(50) NULL,                 -- Food type for Meals (NULL for Exercises)
    quantity DOUBLE NULL                        -- Quantity of food in grams (NULL for Exercises)
);

-- Insert initial data into 'health_activities' table
-- Example Meal Records
INSERT INTO health_activities (username, activity_type, date, food_type, quantity)
VALUES 
    ('john_doe', 'Meal', '2024-12-18', 'Protein', 150),
    ('jane_smith', 'Meal', '2024-12-18', 'Carbs', 200);

-- Example Exercise Records
INSERT INTO health_activities (username, activity_type, date, start_time, end_time, exercise_type, reps, sets, intensity)
VALUES
    ('john_doe', 'Exercise', '2024-12-18', '08:00:00', '08:30:00', 'Push-ups', 20, 3, 'Medium'),
    ('alice_jones', 'Exercise', '2024-12-18', '10:00:00', '10:15:00', 'Squats', 15, 4, 'High');
