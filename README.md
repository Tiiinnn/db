# I Project Overview
The HealthActTrack is a Java-based application designed to help users log and track their health activities, including exercises and meals. It allows users to monitor their daily physical activities, calculate the total number of reps and sets for exercises, and view summarized insights such as the intensity of workouts and food consumption. By promoting awareness of health habits, the system helps users make informed decisions to maintain a healthier lifestyle.

# II OOP Principles Applied
1. Encapsulation
The project uses encapsulation to restrict access to the internal state of the HealthActivity class. Fields such as startTime, endTime, exerciseType, reps, sets, and intensity are declared as private, providing controlled access via getter methods. This ensures the internal state remains protected and only accessed in controlled ways.

2. Inheritance
The HealthActivity class demonstrates inheritance with two different constructors: one for Exercise activities and another for Meal activities. This allows flexibility in handling different types of health activities while reducing code duplication.

3. Polymorphism
Polymorphism is applied in the HealthActivityDAO class, where a single method addHealthActivity handles different types of activities (Exercise or Meal) using overloaded constructors and SQL queries. This allows the same method to process different types of data seamlessly.

4. Abstraction
Abstraction is achieved through the HealthActivity class, which defines a base structure for all health activities, hiding complex implementation details from the user. The DAO classes abstract away the data access logic, providing a simplified interface for data operations.

# III. Chosen SDG and Its Integration into the Project
This project contributes primarily to SDG 3: Good Health and Well-being by encouraging individuals to track and maintain healthier lifestyles. By providing insights into daily physical activity and food intake, users are empowered to make better health-related decisions. The system helps reduce sedentary behavior, monitor exercise intensity, and promote balanced diets, ultimately contributing to improved physical health and well-being.

# IV. Instructions for Running the Program
Prerequisites:
Java Development Kit (JDK) version 8 or later.
MySQL database setup with necessary tables (health_activities).
A MySQL database username and password (root and Jstn_Mgl1210 as specified in the Database.java file).

# Steps:
1. Clone this repository to your local machine
2. Configure the Database.java file with your MySQL database connection details
3. Compile the project
4. Run the main class
5. Follow the on-screen instructions to log activities or summarize daily health data.
