import javax.swing.*;

class Cone extends Figure3d {
    private double radius, height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    //Method to calculate area
    @Override
    double calculateArea() {
        // Existing area calculation logic
        if(radius>0 && height>0) {
            double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
            return Math.PI * radius * (radius + slantHeight);
        }
        else if (radius<=0 || height<=0)
        // If invalid information is not provided
        {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else {
            // If insufficient information is provided
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    //Method to calculate volume
    @Override
    double calculateVolume() {
        // Existing area calculation logic
        if(radius>0 && height>0) {
            return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
        }
        else if (radius<=0 || height<=0)
        // If invalid information is not provided
        {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else {
            // If insufficient information is provided
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate volume.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}