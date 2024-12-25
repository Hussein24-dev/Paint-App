/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapp;

import java.awt.*;


/**
 *
 * @author Hussien Mohamed
 */
public class triangleShape extends ShapeWithStroke {
    
    private boolean fill;
     private Point secondPoint;
    private Point thirdPoint;
    
    
     public triangleShape(Point startPoint, Point secondPoint, Point thirdPoint, Color color,Stroke stroke, boolean fill) {
        super(startPoint, color,stroke);
         this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fill = fill;
        this.fill=fill;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
    }
    

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(stroke);

        int[] xPoints = {startPoint.x, secondPoint.x, thirdPoint.x};
        int[] yPoints = {startPoint.y, secondPoint.y, thirdPoint.y};

        if (fill) {
            g2d.fillPolygon(xPoints, yPoints, 3);
        } else {
            g2d.drawPolygon(xPoints, yPoints, 3);
        }
    }
    
}
