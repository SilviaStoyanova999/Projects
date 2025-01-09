import javax.swing.*;

class Sphere extends Figure3d {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;

    }

    @Override
    double calculateArea() {
        if(radius>0) {
            return 4 * Math.PI * Math.pow(radius, 2);
        }
        else if (radius<0)
        {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else {
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }


    @Override
    double calculateVolume() {
        if(radius>0) {
            return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        }
        else if (radius<=0)
        {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else {
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}
