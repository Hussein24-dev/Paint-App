/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapp.tools;

import java.awt.*;
import paintapp.FreehandShape;
import paintapp.Shape;

/**
 *
 * @author Hussein
 */
public class EraseTool extends Tool{
      private int size = 20;
    public Shape createShape(Point start, Color color, Stroke stroke, boolean fill) {
        return new FreehandShape(start, Color.WHITE,stroke,false); // Eraser works as white freehand
    }

    public void updateShape(Shape shape, Point end) {
        if (shape instanceof FreehandShape) {
            ((FreehandShape) shape).addPoint(end);
        }
    }

  
    
}
