/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapp.tools;

import java.awt.*;
import paintapp.CircleShape;
import paintapp.Shape;


/**
 *
 * @author Hussein
 */
public class CircleTool extends Tool {


    @Override
    public void updateShape(Shape shape, Point end) {
         if (shape instanceof CircleShape) {
            ((CircleShape) shape).setEndPoint(end);
        }
    }

    @Override
    public paintapp.Shape createShape(Point start, Color color, Stroke stroke, boolean fill) {
         return new CircleShape(start, color,stroke, fill);
    }
    
}
