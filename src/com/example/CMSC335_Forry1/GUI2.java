package com.example.CMSC335_Forry1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI2 {
    public static String menuSelection;
    public static JFrame frame;
    public static JPanel activatedPanel = new JPanel();
//    public static String basePath;

    public static void main(String[] args) {
//        basePath = new File("").getAbsolutePath();
        frame = new JFrame("Shape Constructor");
        setMenuSelection("Main Menu");
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static JPanel makeActivePanel(int buttonCount, int textCount) {
        return makeActivePanel(buttonCount, textCount, new GridLayout(buttonCount + textCount, 1, 0, 25));
    }

    public static JPanel makeActivePanel(int buttonCount, int textCount, LayoutManager layout) {
        if(layout == null){
           layout = new GridLayout(buttonCount + textCount, 1, 0, 25);
        }
        JPanel a = activatedPanel;
        activatedPanel = new JPanel();
        activatedPanel.setBounds(0, 0, 600, 600);
        activatedPanel.setLayout(layout);
        frame.add(activatedPanel);
        a.setVisible(false);
        return activatedPanel;
    }

    public static JTextField textfield(String label, boolean editable) {
        JTextField tf = new JTextField(label);
        tf.setEditable(editable);
        activatedPanel.add(tf);
        return tf;
    }

    public static void button(String action) {
        JButton button = new JButton(action);
        button.addActionListener(e -> setMenuSelection(action));
        activatedPanel.add(button);
    }

    public static void quitButton() {
        JButton quitButtoned = new JButton("Quit?");
        quitButtoned.addActionListener(e -> frame.dispose());
        activatedPanel.add(quitButtoned);
    }

    private static void setMenuSelection(String option) {
        menuSelection = option;
        getMenu();
    }

    private static String getShapePath(){
        return new File("").getAbsolutePath().concat("\\src\\Pictures\\"+menuSelection+".png");
    }

    public static void paint() {
        makeActivePanel(2, 0, new BorderLayout());
        try {
            BufferedImage myPicture = ImageIO.read(new File(getShapePath()));
            JLabel l = new JLabel(new ImageIcon(myPicture));
            activatedPanel.add(l, BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JButton b = new JButton("Previous");
        b.addActionListener(e -> setMenuSelection(menuSelection));
        activatedPanel.add(b, BorderLayout.SOUTH);
    }
    public static void pictureButton(){
        JButton pictureButton = new JButton("Show "+menuSelection);
        pictureButton.addActionListener(e -> paint());
        activatedPanel.add(pictureButton);
    }

    public static void getMenu() {
        int buttonCount;
        int textCount;

        if (menuSelection.equals("Main Menu")) {
            textCount = 2;
            buttonCount = 3;
            makeActivePanel(textCount, buttonCount);
            button("Two Dimensional");
            button("Three Dimensional");
            quitButton();

        } else if (menuSelection.equals("Two Dimensional")) {
            buttonCount = 5;
            textCount = 1;
            makeActivePanel(textCount, buttonCount);
            button("Triangle");
            button("Square");
            button("Rectangle");
            button("Circle");
            button("Main Menu");
            quitButton();
        } else if (menuSelection.equals("Triangle")) {
            buttonCount = 3;
            textCount = 4;
            makeActivePanel(textCount, buttonCount);
            JTextField baseTF = textfield("Enter Your Desired Base", true);
            JTextField heightTF = textfield("Enter Your Desired Height", true);
            JTextField areaTF = textfield("Area to be Calculated...", false);
            JButton areaButton = new JButton("Calculate Area");
            areaButton.addActionListener(e -> {
                double base = Double.parseDouble(baseTF.getText());
                double height = Double.parseDouble(heightTF.getText());
                Triangle t = new Triangle(base, height);
                areaTF.setText("Your area is: " + t.getArea());
            });
            activatedPanel.add(areaButton);
            pictureButton();
            button("Main Menu");
        } else if (menuSelection.equals("Square")) {
            buttonCount = 3;
            textCount = 3;
            makeActivePanel(textCount, buttonCount);
            JTextField sideTF = textfield("Enter Your Desired Side Length", true);
            JTextField areaTF = textfield("Area to be Calculated...", false);
            JButton areaButton = new JButton("Calculate Area");
            areaButton.addActionListener(e -> {
                double side = Double.parseDouble(sideTF.getText());
                final Square s = new Square(side);
                areaTF.setText("Your area is: " + s.getArea());
            });
            activatedPanel.add(areaButton);
            pictureButton();
            button("Main Menu");

        } else if (menuSelection.equals("Rectangle")) {
            buttonCount = 3;
            textCount = 4;
            makeActivePanel(textCount, buttonCount);
            JTextField baseTF = textfield("Enter Your Desired Base", true);
            JTextField heightTF = textfield("Enter Your Desired Height", true);
            JTextField areaTF = textfield("Area to be Calculated...", false);
            JButton areaButton = new JButton("Calculate Area");
            areaButton.addActionListener(e -> {
                double base = Double.parseDouble(baseTF.getText());
                double height = Double.parseDouble(heightTF.getText());
                Rectangle r = new Rectangle(base, height);
                areaTF.setText("Your area is: " + r.getArea());
            });
            activatedPanel.add(areaButton);
            pictureButton();
            button("Main Menu");

        } else if (menuSelection.equals("Circle")) {
            buttonCount = 3;
            textCount = 3;
            makeActivePanel(textCount, buttonCount);
            JTextField radiusTF = textfield("Enter Your Desired Radius", true);
            JTextField areaTF = textfield("Area to be Calculated...", false);
            JButton areaButton = new JButton("Calculate Area");
            areaButton.addActionListener(e -> {
                double radius = Double.parseDouble(radiusTF.getText());
                final Circle c = new Circle(radius);
                areaTF.setText("Your area is: " + c.getArea());
            });
            activatedPanel.add(areaButton);
            pictureButton();
            button("Main Menu");

        } else if (menuSelection.equals("Three Dimensional")) {
            buttonCount = 6;
            textCount = 1;
            makeActivePanel(textCount, buttonCount);
            button("Torus");
            button("Sphere");
            button("Cylinder");
            button("Cube");
            button("Cone");
            button("Main Menu");
            quitButton();
        } else if (menuSelection.equals("Torus")) {
            buttonCount = 3;
            textCount = 4;
            makeActivePanel(textCount, buttonCount);
            JTextField radiusTF = textfield("Enter Your Desired Small Radius", true);
            JTextField radiusBigTF = textfield("Enter Your Desired Big Radius", true);
            JTextField volumeTF = textfield("Volume to be Calculated...", false);
            JButton volumeButton = new JButton("Calculate Volume");
            volumeButton.addActionListener(e -> {
                double radius = Double.parseDouble(radiusTF.getText());
                double radiusBig = Double.parseDouble(radiusBigTF.getText());
                final Torus tor = new Torus(radius, radiusBig);
                volumeTF.setText("Your volume is: " + tor.getVolume());
            });
            activatedPanel.add(volumeButton);
            pictureButton();
            button("Main Menu");
        } else if (menuSelection.equals("Sphere")) {
            buttonCount = 3;
            textCount = 3;
            makeActivePanel(textCount, buttonCount);
            JTextField radiusTF = textfield("Enter Your Desired Radius", true);
            JTextField volumeTF = textfield("Volume to be Calculated...", false);
            JButton volumeButton = new JButton("Calculate Volume");
            volumeButton.addActionListener(e -> {
                double radius = Double.parseDouble(radiusTF.getText());
                final Sphere sph = new Sphere(radius);
                volumeTF.setText("Your volume is: " + sph.getVolume());
            });
            activatedPanel.add(volumeButton);
            pictureButton();
            button("Main Menu");
        } else if (menuSelection.equals("Cylinder")) {
            buttonCount = 3;
            textCount = 4;
            makeActivePanel(textCount, buttonCount);
            JTextField radiusTF = textfield("Enter Your Desired Radius", true);
            JTextField heightTF = textfield("Enter Your Desired Height", true);
            JTextField volumeTF = textfield("Volume to be Calculated...", false);
            JButton volumeButton = new JButton("Calculate Volume");
            volumeButton.addActionListener(e -> {
                double radius = Double.parseDouble(radiusTF.getText());
                double height = Double.parseDouble(heightTF.getText());
                final Cylinder cyl = new Cylinder(radius, height);
                volumeTF.setText("Your volume is: " + cyl.getVolume());
            });
            activatedPanel.add(volumeButton);
            pictureButton();
            button("Main Menu");
        } else if (menuSelection.equals("Cube")) {
            buttonCount = 3;
            textCount = 3;
            makeActivePanel(textCount, buttonCount);
            JTextField sideTF = textfield("Enter Your Desired Side Length", true);
            JTextField volumeTF = textfield("Volume to be Calculated...", false);
            JButton volumeButton = new JButton("Calculate Volume");
            volumeButton.addActionListener(e -> {
                double side = Double.parseDouble(sideTF.getText());
                final Cube cub = new Cube(side);
                volumeTF.setText("Your volume is: " + cub.getVolume());
            });
            activatedPanel.add(volumeButton);
            pictureButton();
            button("Main Menu");
        } else if (menuSelection.equals("Cone")) {
            buttonCount = 3;
            textCount = 4;
            makeActivePanel(textCount, buttonCount);
            JTextField radiusTF = textfield("Enter Your Desired Radius", true);
            JTextField heightTF = textfield("Enter Your Desired Height", true);
            JTextField volumeTF = textfield("Volume to be Calculated...", false);
            JButton volumeButton = new JButton("Calculate Volume");
            volumeButton.addActionListener(e -> {
                double radius = Double.parseDouble(radiusTF.getText());
                double height = Double.parseDouble(heightTF.getText());
                final Cone con = new Cone(radius, height);
                volumeTF.setText("Your volume is: " + con.getVolume());
            });
            activatedPanel.add(volumeButton);
            pictureButton();

            button("Main Menu");
        } else {
            setMenuSelection("Main Menu");
        }
    }
}

