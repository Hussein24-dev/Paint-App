/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapp;

/**
 *
 * @author Hussein
 */
import java.awt.*;
import javax.swing.*;
public class PaintApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         SwingUtilities.invokeLater(PaintApp::createAndShowGUI);
    }
    
     private static void createAndShowGUI() {
        JFrame frame = new JFrame("Paint Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        DrawingPanel drawingPanel = new DrawingPanel();
        Toolbar toolbar = new Toolbar(drawingPanel);

        frame.add(toolbar, BorderLayout.NORTH);
        frame.add(drawingPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
    
}
