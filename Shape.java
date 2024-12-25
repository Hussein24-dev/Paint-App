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
public abstract class Shape     {
    public Point startPoint;
    public Color color;    
    public Shape(Point startPoint, Color color) {
        this.startPoint = startPoint;
        this.color = color;
    }
     public abstract void draw(Graphics g);
     
}
