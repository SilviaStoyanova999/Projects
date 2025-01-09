import javax.swing.JOptionPane;
import java.lang.Math;

class Parallelogram extends Figure2d {
    private double side1, side2, height1, height2;
    private double angle1, angle2;
    private double diagonal1, diagonal2;

    public Parallelogram(double side1, double side2, double height1, double height2, double angle1, double angle2, double diagonal1, double diagonal2) {
        this.side1 = side1;
        this.side2 = side2;
        this.height1 = height1;
        this.height2 = height2;
        this.angle1 = angle1;
        this.angle2 = angle2;
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;

        // Validate if the parameters can form a parallelogram
        if (!isValidParallelogram()) {
            JOptionPane.showMessageDialog(null, "Invalid parameters: These values cannot form a parallelogram.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to validate if the parameters can form a parallelogram
    private boolean isValidParallelogram() {

        if (angle1 == 90 && angle2 == 90) {
            return true;
        }
        // Check if opposite sides are equal (if provided)
        if (side1 > 0 && side2 > 0) {
            // For a parallelogram, opposite sides must be equal
            // Assuming side1 and side2 are adjacent sides, we need to ensure the diagonals satisfy the parallelogram law
            if (diagonal1 > 0 && diagonal2 > 0) {
                double diagonalSumSquares = diagonal1 * diagonal1 + diagonal2 * diagonal2;
                double sideSumSquares = 2 * (side1 * side1 + side2 * side2);
                if (Math.abs(diagonalSumSquares - sideSumSquares) > 1e-6) { // Allow for floating-point precision errors
                    return false;
                }
            }
        }

        // Check if opposite angles are equal (if provided)
        if (angle1 > 0 && angle2 > 0) {
            // For a parallelogram, opposite angles must be equal
            if (Math.abs(angle1 - angle2) > 1e-6) { // Allow for floating-point precision errors
                return false;
            }
        }

        // Check if heights are consistent with sides and angles (if provided)
        if (side1 > 0 && height1 > 0 && angle1 > 0) {
            double expectedHeight = side1 * Math.sin(Math.toRadians(angle1));
            if (Math.abs(height1 - expectedHeight) > 1e-6) {
                return false;
            }
        }
        if ((side1 > 0 && height2 > 0) || (side2 > 0 && height1 > 0)) {
            if (height1 > side2 || height2 > side1) {
                return false;
            }
        }

        // Specific case for rectangles
        if (angle1 == 90 && angle2 == 90) {
            return side1 == height2 && side2 == height1;
        }

        return true;
    }

    //Method to calculate area
    @Override
    double calculateArea() {

        if (side1 <= 0 || side2 <= 0 || height1 <= 0 || height2 <= 0 || angle1 <= 0 || angle2 <= 0 || diagonal1 <= 0 || diagonal2 <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        // Method 1: Base and Height
        if (side1 > 0 && height1 > 0) {
            return side1 * height1;
        }
        // Method 2: Base and Height (alternative)
        else if (side2 > 0 && height2 > 0) {
            return side2 * height2;
        }
        // Method 3: Two Sides and the Included Angle
        else if (side1 > 0 && side2 > 0 && angle1 > 0) {
            double angleRad = Math.toRadians(angle1);
            return side1 * side2 * Math.sin(angleRad);
        }
        // Method 4: Diagonals and the Included Angle
        else if (diagonal1 > 0 && diagonal2 > 0 && angle2 > 0 && angle2 < 90) {
            double angleRad = Math.toRadians(angle2);
            return 0.5 * diagonal1 * diagonal2 * Math.sin(angleRad);
        }
        // Method 5: Two Heights and the Included Angle
        else if (height1 > 0 && height2 > 0 && angle1 > 0) {
            double angleRad = Math.toRadians(angle1);
            return (height1 * height2) / Math.sin(angleRad);
        }
        // If insufficient information is provided
        else {
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    //Method to calculate area
    @Override
    double calculatePerimeter() {
        // Existing perimeter calculation logic
        if (side1 <= 0 || side2 <= 0 || height1 <= 0 || height2 <= 0 || angle1 <= 0 || angle2 <= 0 || diagonal1 <= 0 || diagonal2 <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        // Method 1: Two Adjacent Sides
        if (side1 > 0 && side2 > 0) {
            return 2 * (side1 + side2);
        }
        // Method 2: One Side and the Diagonals
        else if (side1 > 0 && diagonal1 > 0 && diagonal2 > 0) {
            double side2 = Math.sqrt((diagonal1 * diagonal1 + diagonal2 * diagonal2 - 2 * side1 * side1) / 2);
            return 2 * (side1 + side2);
        }
        // Method 3: One Side, One Height, and the Included Angle
        else if (side1 > 0 && height1 > 0 && angle1 > 0) {
            double angleRad = Math.toRadians(angle1);
            double side2 = height1 / Math.sin(angleRad);
            return 2 * (side1 + side2);
        }
        // If insufficient information is provided
        else {
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate perimeter.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}