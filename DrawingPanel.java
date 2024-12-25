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
import paintapp.tools.Tool;
import paintapp.tools.PencilTool;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import javax.imageio.ImageIO;

public class DrawingPanel  extends JPanel {
    
    DrawingPanel drawingpanel;
     private ArrayList<Shape> shapes = new ArrayList<>();
     private Stack<Shape> undoStack = new Stack<>();
     private final Stack<Shape> redoStack = new Stack<>();
      private Tool currentTool = new PencilTool();
    private Color currentColor = Color.BLACK;
    private Shape currentShape = null;
     private Stroke currentStroke = new BasicStroke(2.0f);
     private boolean fillShapes = false;
    public DrawingPanel() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentShape = currentTool.createShape(e.getPoint(), currentColor,currentStroke,fillShapes);
                if (currentShape != null) {
                    if (currentShape instanceof ShapeWithStroke) {
                        ((ShapeWithStroke) currentShape).setStroke(currentStroke);
                    }
                    shapes.add(currentShape);
                    undoStack.push(currentShape);
                    redoStack.clear();
                }
                repaint();
            }
            

            @Override
            public void mouseReleased(MouseEvent e) {
                currentShape = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentShape != null) {
                    currentTool.updateShape(currentShape, e.getPoint());
                    repaint();
                }
            }
        });
    }

    public void setFillShapes(boolean fill) {
        this.fillShapes = fill;
    }
    
    public void setCurrentTool(Tool tool) {
        currentTool = tool;
    }
    

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public Color getCurrentColor() {
        return currentColor;
    }
    public void redoLastAction() {
        if (!redoStack.isEmpty()) {
            Shape redoAction = redoStack.pop(); 
            undoStack.push(redoAction); 
            repaint();
        }
    }
    public void setCurrentStroke(Stroke stroke) {
        this.currentStroke = stroke;
    }

    
    public void undoLastAction() {
        if (!undoStack.isEmpty()) {
            Shape lastAction = undoStack.pop(); 
            redoStack.push(lastAction); 
            repaint();
        }
    }
    public void clearActions(){
      // Clear all shapes from the list
        undoStack.clear(); // Clear all shapes
        redoStack.clear(); // Clear the redo stack
        repaint();
            
    }
    
     public void saveAsPNG() {
        // Create a BufferedImage to capture the panel content
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Paint the drawing panel's content onto the BufferedImage
        paint(g2d);

        // Release the graphics object
        g2d.dispose();

        // Prompt the user for a file location to save the image
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save as PNG");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PNG Image", "png"));

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                // Ensure the file has a .png extension
                if (!fileToSave.getName().endsWith(".png")) {
                    fileToSave = new File(fileToSave.getParentFile(), fileToSave.getName() + ".png");
                }
                
                // Save the image to the selected file
                ImageIO.write(image, "PNG", fileToSave);
                JOptionPane.showMessageDialog(this, "Drawing saved as PNG successfully!", "Save Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    
     
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : undoStack) {
            shape.draw(g);
        }
       
    }
}


