import javax.swing.*;

class Polygon extends Figure2d {
    private double side, numSides;

    public Polygon(double side, double numSides) {
        this.side = side;
        this.numSides = numSides;
    }

    //Method to calculate area
    @Override
    double calculateArea() {
        if(side>0 && numSides>2) {
            return (numSides * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / numSides));
        }
        else if (side<=0 || numSides<3)
        {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else {
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    //Method to calculate perimeter
    @Override
    double calculatePerimeter() {
        if(side>0 && numSides>2) {
            return numSides * side;
        }
        else if (side<=0 || numSides<3)
        {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else {
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate volume.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}
