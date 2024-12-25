/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapp.tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;
import paintapp.Shape;
import paintapp.triangleShape;
import static java.util.concurrent.ThreadLocalRandom.current;


/**
 *
 * @author Hussien Mohamed
 */
public class TriangleTool extends Tool {

    @Override
    public Shape createShape(Point start, Color color, Stroke stroke, boolean fill) {
         return new triangleShape(start,start,start, color,stroke, fill);
    }

    @Override
    public void updateShape(Shape shape, Point current) {
         if (shape instanceof triangleShape) {
            triangleShape triangle = (triangleShape) shape;

            // Example: Determine the second and third points based on dragging
            Point secondPoint = new Point(current.x, shape.startPoint.y); // Same Y as start, X as current
            Point thirdPoint = new Point(
                (shape.startPoint.x + current.x) / 2, // Middle X between start and current
                current.y // Same Y as current
            );

            triangle.setSecondPoint(secondPoint);
            triangle.setThirdPoint(thirdPoint);
        }
    }
    
}
