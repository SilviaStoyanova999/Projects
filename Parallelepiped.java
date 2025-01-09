import javax.swing.*;

class Parallelepiped extends Figure3d {
    private double length, width, height;

    public Parallelepiped(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea()
    {
        if(length>0 && width>0 && height>0) {
            // Existing area calculation logic
                return 2 * (length * width + length * height + width * height);
            }
                else if(length<=0 || width<=0 || height<=0)
            {
            // If invalid information is provided
                JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
            else
            {
            // If insufficient information is provided
                JOptionPane.showMessageDialog(null, "Insufficient information to calculate area.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
                return -1;
        }

    }

    @Override
    double calculateVolume() {
        if(length>0 && width>0 && height>0)
        {
            // Existing area calculation logic
            return length * width * height;
        }
        else if(length<=0 ||width<=0 || height<=0)
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