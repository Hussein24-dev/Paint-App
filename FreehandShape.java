/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapp;

import java.awt.Graphics;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Hussein
 */
public class FreehandShape extends ShapeWithStroke {
    private int size = 20;
     private ArrayList<Point> points = new ArrayList<>();
      public FreehandShape(Point startPoint, Color color ,Stroke stroke,boolean fill) {
        super(startPoint, color,stroke);
        points.add(startPoint);
    }
      public void addPoint(Point point) {
        points.add(point);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(stroke);
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
    
}
