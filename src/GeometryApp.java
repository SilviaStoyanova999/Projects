import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GeometryApp extends JFrame implements ActionListener {
    private JComboBox<String> figureComboBox;
    private JPanel paramsPanel;
    private JTextField[] paramFields;
    private JLabel resultLabel;

    public GeometryApp() {
        setTitle("Geometry Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        figureComboBox = new JComboBox<>(new String[]{"Circle", "Cone", "Cube", "Cylinder", "Parallelepiped", "Parallelogram", "Polygon", "Pyramid", "Quadrilateral", "Rectangle", "Rhombus", "Sphere", "Square", "Trapezoid", "Triangle"});
        figureComboBox.setFont(new Font("Arial", Font.BOLD, 16));
        figureComboBox.setPreferredSize(new Dimension(300, 40));
        figureComboBox.addActionListener(this);

        JPanel comboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        comboPanel.add(figureComboBox);

        paramsPanel = new JPanel();
        paramsPanel.setLayout(new GridLayout(0, 2));

        resultLabel = new JLabel("Results will be shown here");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        add(comboPanel, BorderLayout.NORTH);
        add(paramsPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paramsPanel.removeAll();
        String figure = (String) figureComboBox.getSelectedItem();

        switch (figure) {
            case "Circle":
                addParamFields("Radius:");
                break;
            case "Cone":
                addParamFields("Radius:", "Height:");
                break;
            case "Cube":
                addParamFields("Side:");
                break;
            case "Cylinder":
                addParamFields("Radius:", "Height:");
                break;
            case "Parallelepiped":
                addParamFields("Length:", "Width:", "Height:");
                break;
            case "Parallelogram":
                addParamFields("Side 1:", "Side 2:", "Height 1:", "Height 2:", "Angle 1:", "Angle 2:", "Diagonal 1:", "Diagonal 2:");
                break;
            case "Polygon":
                addParamFields("Number of Sides:", "Side Length:");
                break;
            case "Pyramid":
                addParamFields("Number of sides(3 or 4):", "Side:", "Height:");
                break;
            case "Quadrilateral":
                addParamFields("Side 1:", "Side 2:", "Side 3:", "Side 4:");
                break;
            case "Rectangle":
                addParamFields("Length:", "Width:");
                break;
            case "Rhombus":
                addParamFields("Side:", "Height:", "Angle 1:", "Angle 2:", "Diagonal 1:", "Diagonal 2:");
                break;
            case "Sphere":
                addParamFields("Radius:");
                break;
            case "Square":
                addParamFields("Side:", "Diagonal:");
                break;
            case "Trapezoid":
                addParamFields("Base 1:", "Base 2:", "Height:");
                break;
            case "Triangle":
                addParamFields("Side 1:", "Side 2:", "Side 3:", "Angle 1:", "Angle 2:", "Angle 3:");
                break;
        }

        paramsPanel.revalidate();
        paramsPanel.repaint();
    }

    private void addParamFields(String... labels) {
        paramFields = new JTextField[labels.length];
        for (String label : labels) {
            JLabel fieldLabel = new JLabel(label);
            fieldLabel.setFont(new Font("Arial", Font.BOLD, 20));
            paramsPanel.add(fieldLabel);

            JTextField field = new JTextField();
            field.setFont(new Font("Arial", Font.BOLD, 20));
            field.setPreferredSize(new Dimension(200, 35));
            paramsPanel.add(field);
            paramFields[paramsPanel.getComponentCount() / 2 - 1] = field;
        }

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 20));
        calculateButton.setPreferredSize(new Dimension(150, 40));
        calculateButton.addActionListener(e -> calculate());
        paramsPanel.add(calculateButton);
    }

    private void calculate() {
        String figure = (String) figureComboBox.getSelectedItem();
        try {
            switch (figure) {
                case "Circle":
                    calculateCircle();
                    break;
                case "Cone":
                    calculateCone();
                    break;
                case "Cube":
                    calculateCube();
                    break;
                case "Cylinder":
                    calculateCylinder();
                    break;
                case "Parallelepiped":
                    calculateParallelepiped();
                    break;
                case "Parallelogram":
                    calculateParallelogram();
                    break;
                case "Polygon":
                    calculatePolygon();
                    break;
                case "Pyramid":
                    calculatePyramid();
                    break;
                case "Quadrilateral":
                    calculateQuadrilateral();
                    break;
                case "Rectangle":
                    calculateRectangle();
                    break;
                case "Rhombus":
                    calculateRhombus();
                    break;
                case "Sphere":
                    calculateSphere();
                    break;
                case "Square":
                    calculateSquare();
                    break;
                case "Trapezoid":
                    calculateTrapezoid();
                    break;
                case "Triangle":
                    calculateTriangle();
                    break;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateCircle() {
        double radius = getFieldValue(0);
        Circle circle = new Circle(radius);
        showResults2D(circle.calculateArea(), circle.calculatePerimeter());
    }

    private void calculateCone() {
        double radius = getFieldValue(0);
        double height = getFieldValue(1);
        Cone cone = new Cone(radius, height);
        showResults3D(cone.calculateArea(), cone.calculateVolume());
    }

    private void calculateCube() {
        double side = getFieldValue(0);
        Parallelepiped cube = new Parallelepiped(side, side, side);
        showResults3D(cube.calculateArea(), cube.calculateVolume());
    }

    private void calculateCylinder() {
        double radius = getFieldValue(0);
        double height = getFieldValue(1);
        Cylinder cylinder = new Cylinder(radius, height);
        showResults3D(cylinder.calculateArea(), cylinder.calculateVolume());
    }

    private void calculateParallelepiped() {
        double length = getFieldValue(0);
        double width = getFieldValue(1);
        double height = getFieldValue(2);
        Parallelepiped parallelepiped = new Parallelepiped(length, width, height);
        showResults3D(parallelepiped.calculateArea(), parallelepiped.calculateVolume());
    }

    private void calculateParallelogram() {
        double side1 = getFieldValue(0);
        double side2 = getFieldValue(1);
        double height1 = getFieldValue(2);
        double height2 = getFieldValue(3);
        double angle1 = getFieldValue(4);
        double angle2 = getFieldValue(5);
        double diagonal1 = getFieldValue(6);
        double diagonal2 = getFieldValue(7);
        Parallelogram parallelogram = new Parallelogram(side1, side2, height1, height2, angle1, angle2, diagonal1, diagonal2);
        showResults2D(parallelogram.calculateArea(), parallelogram.calculatePerimeter());
    }

    private void calculatePolygon() {
        double sides = getFieldValue(0);
        double length = getFieldValue(1);
        Polygon polygon = new Polygon(length, sides);
        showResults2D(polygon.calculateArea(), polygon.calculatePerimeter());
    }

    private void calculatePyramid() {
        int numberOfSides = (int) getFieldValue(0);
        double side = getFieldValue(1);
        double height = getFieldValue(2);
        Pyramid pyramid = new Pyramid(side, height, numberOfSides);
        showResults3D(pyramid.calculateArea(), pyramid.calculateVolume());

    }

    private void calculateQuadrilateral() {
        double side1 = getFieldValue(0);
        double side2 = getFieldValue(1);
        double side3 = getFieldValue(2);
        double side4 = getFieldValue(3);
    }

    private void calculateRectangle() {
        double length = getFieldValue(0);
        double width = getFieldValue(1);
        double diagonal = Math.sqrt(length * length + width * width);
        Parallelogram rectangle = new Parallelogram(length, width, width, length, 90, 90, diagonal, diagonal);
        showResults2D(rectangle.calculateArea(), rectangle.calculatePerimeter());
    }

    private void calculateRhombus() {
        double side1 = getFieldValue(0);
        double height1 = getFieldValue(1);
        double angle1 = getFieldValue(2);
        double angle2 = getFieldValue(3);
        double diagonal1 = getFieldValue(4);
        double diagonal2 = getFieldValue(5);
        Parallelogram rhombus = new Parallelogram(side1, side1, height1, height1, angle1, angle2, diagonal1, diagonal2);
        showResults2D(rhombus.calculateArea(), rhombus.calculatePerimeter());
    }

    private void calculateSphere() {
        double radius = getFieldValue(0);
        Sphere sphere = new Sphere(radius);
        showResults3D(sphere.calculateArea(), sphere.calculateVolume());
    }

    private void calculateSquare() {
        double side = getFieldValue(0);
        double diagonal = getFieldValue(1);
        Parallelogram square = new Parallelogram(side, side, side, side, 90, 90, diagonal, diagonal);
        showResults2D(square.calculateArea(), square.calculatePerimeter());
    }

    private void calculateTrapezoid() {
        double base1 = getFieldValue(0);
        double base2 = getFieldValue(1);
        double height = getFieldValue(2);
        Trapezoid trapezoid = new Trapezoid(base1, base2, height, 0,0,0,0,0);

    }

    private void calculateTriangle() {
        double side1 = getFieldValue(0);
        double side2 = getFieldValue(1);
        double side3 = getFieldValue(2);
        double angle1 = getFieldValue(3);
        double angle2 = getFieldValue(4);
        double angle3 = getFieldValue(5);
        Triangle triangle = new Triangle(side1, side2, side3, angle1, angle2, angle3);
        showResults2D(triangle.calculateArea(), triangle.calculatePerimeter());
    }

    private double getFieldValue(int index) {
        return paramFields[index].getText().trim().isEmpty() ? 0 : Double.parseDouble(paramFields[index].getText().trim());
    }

    private void showResults2D(double area, double perimeter) {
        resultLabel.setText(String.format("Area: %.2f; Perimeter: %.2f", area, perimeter));
    }

    private void showResults3D(double area, double volume) {
        resultLabel.setText(String.format("Surface Area: %.2f; Volume: %.2f", area, volume));
    }

    public static void main(String[] args) {
        new GeometryApp();
    }
}
