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
public class LineShape extends ShapeWithStroke{
    
     private Point endPoint;
     
     public LineShape(Point startPoint, Color color, Stroke stroke) {
        super(startPoint, color,stroke);
        this.endPoint = startPoint;
    }

   
      public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public void draw(Graphics g) {
         Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(stroke);
        g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
    
}
