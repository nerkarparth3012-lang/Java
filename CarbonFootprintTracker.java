import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class CarbonFootprintTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalEmissions = 0;

        System.out.println("🌍 Welcome to the Carbon Footprint Tracker!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
      
        System.out.print("How many kilometers do you drive per week? ");
        double kmDriven = scanner.nextDouble();
        double carEmissions = kmDriven * 0.192; 
        totalEmissions += carEmissions;

        System.out.print("How many kWh of electricity do you use per month? ");
        double kWh = scanner.nextDouble();
        double electricityEmissions = kWh * 0.417; 
        totalEmissions += electricityEmissions;

        System.out.print("How many meat-based meals do you eat per week? ");
        int meatMeals = scanner.nextInt();
        double meatEmissions = meatMeals * 7; 
        totalEmissions += meatEmissions;

        System.out.printf("\nHi %s! 🌱 Your estimated monthly carbon footprint is: %.2f kg CO₂\n", name, totalEmissions);
        giveSuggestions(totalEmissions);

        saveToFile(name, totalEmissions);
        scanner.close();
    }

    public static void giveSuggestions(double emissions) {
        System.out.println("\n💡 Tips to reduce your carbon footprint:");
        if (emissions > 1000) {
            System.out.println("- Consider using public transportation or carpooling.");
            System.out.println("- Reduce meat consumption and try plant-based meals.");
            System.out.println("- Switch to energy-efficient appliances or renewable energy sources.");
        } else {
            System.out.println("- Great job! Keep up your low-emission lifestyle!");
        }
    }

    public static void saveToFile(String name, double emissions) {
        try {
            FileWriter writer = new FileWriter("carbon_footprint_report.txt", true);
            writer.write("User: " + name + ", Emissions: " + emissions + " kg CO₂\n");
            writer.close();
            System.out.println("\n📁 Your data has been saved to 'carbon_footprint_report.txt'.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
