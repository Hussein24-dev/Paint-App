/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapp;

import java.awt.*;

/**
 *
 * @author Hussein
 */
public class CircleShape extends ShapeWithStroke {
    private boolean fill;
    private Point endPoint;
    
     public CircleShape(Point startPoint, Color color,Stroke stroke, boolean fill) {
        super(startPoint, color,stroke);
        this.endPoint = startPoint;
        this.fill=fill;
    }
     public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public void draw(Graphics g) {
         Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(stroke);
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        int diameter = Math.max(Math.abs(startPoint.x - endPoint.x), Math.abs(startPoint.y - endPoint.y));
        if(fill){
          g2d.fillOval(x, y, diameter, diameter);
        } else
        g2d.drawOval(x, y, diameter, diameter);
    }
    
}
