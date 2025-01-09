import javax.swing.*;
import java.lang.Math;

class Circle extends Figure2d {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;

    }

    //Method to calculate area
    @Override
    double calculateArea() {
        // Existing area calculation logic
        if(radius>0) {
            return Math.PI * Math.pow(radius, 2);
        }
        // If invalid information is provided
        else if (radius<=0)
        {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        // If insufficient information is provided
        else {
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    //Method to calculate perimeter
    @Override
    double calculatePerimeter() {
        // Existing area calculation logic
        if(radius>0) {
            return 2 * Math.PI * radius;
        }
        else if (radius<=0)
        // If invalid information is provided
        {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else {
            // If insufficient information is provided
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate perimeter.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}