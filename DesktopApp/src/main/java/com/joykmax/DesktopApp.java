package com.joykmax;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DesktopApp extends JFrame {
    public DesktopApp(String sayIt, ChartData[] chartData) {
        super("Brain Torture");
        setLayout(new FlowLayout());
        add(new JLabel(sayIt));
        add(new JLabel(" Just do it and die."));
        ImageIcon icon = new ImageIcon(PieChart.createChart(chartData));
        JLabel pLabel = new JLabel();
        pLabel.setIcon(icon);
        add(pLabel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,460);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        String addInfo = World.Tick();
        ChartData[] chartData = new ChartData[6];
        chartData[0] = new ChartData("Swearing English",10);
        chartData[1] = new ChartData("Swearing Russian",10);
        chartData[2] = new ChartData("Swearing Czech",5);
        chartData[3] = new ChartData("Googling and reading",20);
        chartData[4] = new ChartData("Coding",10);
        chartData[5] = new ChartData("Banging head on the table",45);


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DesktopApp(addInfo, chartData).setVisible(true);
            }
        });
    }
}