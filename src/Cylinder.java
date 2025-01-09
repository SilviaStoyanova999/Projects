import javax.swing.*;

class Cylinder extends Figure3d {
    private double radius, height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    //Method to calculate area
    @Override
    double calculateArea() {
        if(radius>0 && height>0) {
            // Existing area calculation logic
            return 2 * Math.PI * radius * (radius + height);
        }
        else if (radius<=0 || height<=0)
        {
            // If invalid information is provided
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
        if(radius>0 && height>0) {
            // Existing area calculation logic
            return Math.PI * Math.pow(radius, 2) * height;
        }
        else if (radius<=0 || height<=0)
        {
            // If invalid information is provided
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