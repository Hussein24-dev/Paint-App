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
public class PencilTool extends Tool  {
    


    @Override
    public void updateShape(Shape shape, Point end) {
         if (shape instanceof FreehandShape) {
            ((FreehandShape) shape).addPoint(end);
        }
    }

    @Override
    public paintapp.Shape createShape(Point start, Color color, Stroke stroke, boolean fill) {
       return new FreehandShape(start, color , stroke,fill);
    }
    
}
