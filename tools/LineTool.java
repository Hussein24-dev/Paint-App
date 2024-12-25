/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapp.tools;

import java.awt.*;
import java.awt.Point;
import paintapp.LineShape;
import paintapp.Shape;

/**
 *
 * @author Hussein
 */
public class LineTool  extends Tool  {

    @Override
    public void updateShape(Shape shape, Point end) {
        if (shape instanceof LineShape) {
            ((LineShape) shape).setEndPoint(end);
        }
    } 

    @Override
    public Shape createShape(Point start, Color color, Stroke stroke, boolean fill) {
       return new LineShape(start, color, stroke);
    }
}
