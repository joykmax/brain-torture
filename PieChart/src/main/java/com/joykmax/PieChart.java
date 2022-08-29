package com.joykmax;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PieChart {

    public static BufferedImage createChart(ChartData[] chartData){
        Integer width = 400;
        Integer height = 400;
        Integer startChartX = 0;
        Integer startChartY = 20;
        Integer startTextX = 20;
        Integer startTextY = height + startChartY * 2;
        Integer lineHeight = 48;
        Integer fullwidth = width;
        Integer fullheight = startTextY + chartData.length * lineHeight;

        BufferedImage bImage = new BufferedImage(fullwidth,fullheight,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bImage.createGraphics();
        Font font = new Font("Verdana", Font.BOLD, 16);
        g2d.setFont(font);
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        g2d.setColor(new Color(255, 255, 255));
        g2d.fillRect(0,0,fullwidth,fullheight);
        Color[] colors = new Color[6];
        colors[0] = new Color(205,60,60);
        colors[1] = new Color(20,130,20);
        colors[2] = new Color(60,60,255);
        colors[3] = new Color(205,160,0);
        colors[4] = new Color(0,100,140);
        colors[5] = new Color(150,0,140);

        Integer currentAngle = 0;
        Integer nextAngle = 0;
        Integer index = 0;
        Integer allChartSum = 0;
        for (ChartData item:chartData) {
            allChartSum += item.getPercentVal();
        }

        Double koef = (double) 360/allChartSum;

        for (ChartData item:chartData) {
            g2d.setColor(colors[index]);
            nextAngle = (int) (item.getPercentVal() * koef);
            g2d.fillArc(startChartX, startChartY, startChartX+width, startChartY+height, currentAngle, nextAngle);
            currentAngle += nextAngle;

            g2d.fillRect(startTextX,startTextY+lineHeight*index,40,40);

            g2d.setColor(new Color(0, 0, 0));
            g2d.drawString(item.getText(), startTextX + lineHeight, (int)(startTextY+lineHeight*index+lineHeight/2));

            index++;
        }

        /*
        try {
            ImageIO.write(bImage,"jpg",new File("testimage1.jpg"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        */
        return bImage;
    }

}