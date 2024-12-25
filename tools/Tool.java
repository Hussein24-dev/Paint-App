/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapp.tools;
import java.awt.*;
import paintapp.Shape;
/**
 *
 * @author Hussein
 */
public abstract class Tool {
    public abstract Shape createShape(Point start, Color color, Stroke stroke, boolean fill);
     public abstract void updateShape(Shape shape, Point end);
     
}
