/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapp.tools;

import paintapp.tools.Tool;
import java.awt.*;
import paintapp.RectangleShape;
import paintapp.Shape;


/**
 *
 * @author Hussein
 */
public class RectangleTool extends Tool {
    
    @Override
    public void updateShape(Shape shape, Point end) {
         if (shape instanceof RectangleShape) {
            ((RectangleShape) shape).setEndPoint(end);
        }
    }

    @Override
    public Shape createShape(Point start, Color color, Stroke stroke, boolean fill) {
      return new RectangleShape(start, color,stroke,fill);
    }
    
}
