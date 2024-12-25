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
public abstract class ShapeWithStroke extends Shape {
    protected Stroke stroke;

    public ShapeWithStroke(Point startPoint, Color color, Stroke stroke) {
        super(startPoint, color);
        this.stroke = stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }
}
