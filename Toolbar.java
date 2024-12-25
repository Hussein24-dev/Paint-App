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
import paintapp.tools.RectangleTool;
import paintapp.tools.TriangleTool;
import paintapp.tools.PencilTool;
import paintapp.tools.OvalTool;
import paintapp.tools.LineTool;
import paintapp.tools.EraseTool;
import paintapp.tools.CircleTool;
import javax.swing.*;
import java.awt.*;

public class Toolbar extends JPanel {
    public Toolbar(DrawingPanel drawingPanel) {
        
       setLayout(new FlowLayout(FlowLayout.LEFT));
      //   setBackground(Color.WHITE);

        
        // Add color chooser
        ImageIcon icon_color= new ImageIcon("C:\\\\Users\\\\Hussien Mohamed\\\\Desktop\\\\true_color_iconpng.png");
        Image scaledImage = icon_color.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JButton colorButton = new JButton(scaledIcon);
        colorButton.setBorderPainted(false);      
        colorButton.setContentAreaFilled(false);  
        colorButton.setFocusPainted(false); 
        colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(this, "Choose a color", drawingPanel.getCurrentColor());
            if (selectedColor != null) {
                drawingPanel.setCurrentColor(selectedColor);
            }
        });
        add(colorButton);
        
         //eraser button
         ImageIcon eraser_icon = new ImageIcon("C:\\\\Users\\\\Hussien Mohamed\\\\Desktop\\\\eraserpng.png");
         Image scaled_eraser = eraser_icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
         ImageIcon eraserIcon = new ImageIcon(scaled_eraser);
        JButton eraseButton = new JButton(eraserIcon);
          eraseButton.setBorderPainted(false);      
        eraseButton.setContentAreaFilled(false);  
        eraseButton.setFocusPainted(false);
        eraseButton.addActionListener(e -> drawingPanel.setCurrentTool(new EraseTool()));
        add(eraseButton);
        
        
        // Add pencil tools
         ImageIcon pencil_icon = new ImageIcon("C:\\\\Users\\\\Hussien Mohamed\\\\Desktop\\\\pencilpng.png");
         Image scaled_pencil = pencil_icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
         ImageIcon pencilIcon = new ImageIcon(scaled_pencil);
        JButton pencil_btn = new JButton(pencilIcon);
          pencil_btn.setBorderPainted(false);      
        pencil_btn.setContentAreaFilled(false);  
        pencil_btn.setFocusPainted(false);
        pencil_btn.addActionListener(e -> drawingPanel.setCurrentTool(new PencilTool()));
        add(pencil_btn);
        
    

        //rectangle button
         ImageIcon rectangle_icon = new ImageIcon("C:\\\\Users\\\\Hussien Mohamed\\\\Desktop\\\\rectanglepng.png");
         Image scaled_rectangle = rectangle_icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
         ImageIcon rectangleIcon = new ImageIcon(scaled_rectangle);
        JButton rectangle_btn = new JButton(rectangleIcon);
          rectangle_btn.setBorderPainted(false);      
        rectangle_btn.setContentAreaFilled(false);  
        rectangle_btn.setFocusPainted(false);
        rectangle_btn.addActionListener(e -> drawingPanel.setCurrentTool(new RectangleTool()));
        add(rectangle_btn);
        
        
        //Triangle button
          ImageIcon triangle_icon = new ImageIcon("C:\\\\Users\\\\Hussien Mohamed\\\\Desktop\\\\tr11.png");
         Image scaled_triangle = triangle_icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
         ImageIcon triangleleIcon = new ImageIcon(scaled_triangle);
        JButton triangle_btn = new JButton(triangleleIcon);
          triangle_btn.setBorderPainted(false);      
        triangle_btn.setContentAreaFilled(false);  
        triangle_btn.setFocusPainted(false);
        triangle_btn.addActionListener(e -> drawingPanel.setCurrentTool(new TriangleTool()));
        add(triangle_btn);
        
        

        //circle button
        
         ImageIcon circle_icon = new ImageIcon("C:\\\\Users\\\\Hussien Mohamed\\\\Desktop\\\\circlepng.png");
         Image scaled_circel = circle_icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
         ImageIcon circleIcon = new ImageIcon(scaled_circel);
        JButton circleButton = new JButton(circleIcon);
          circleButton.setBorderPainted(false);      
        circleButton.setContentAreaFilled(false);  
        circleButton.setFocusPainted(false);
        circleButton.addActionListener(e -> drawingPanel.setCurrentTool(new CircleTool()));
        add(circleButton);

        
        //line button
       ImageIcon line_icon = new ImageIcon("C:\\\\Users\\\\Hussien Mohamed\\\\Desktop\\\\linepng.png");
         Image scaled_line = line_icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
         ImageIcon lineIcon = new ImageIcon(scaled_line);
        JButton lineButton = new JButton(lineIcon);
          lineButton.setBorderPainted(false);      
        lineButton.setContentAreaFilled(false);  
        lineButton.setFocusPainted(false);
        lineButton.addActionListener(e -> drawingPanel.setCurrentTool(new LineTool()));
        add(lineButton);
        
        
        //oval button

        ImageIcon oval_icon = new ImageIcon("C:\\\\Users\\\\Hussien Mohamed\\\\Desktop\\\\finaloval.png");
         Image scaled_oval = oval_icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
         ImageIcon ovalIcon = new ImageIcon(scaled_oval);
        JButton ovalButton = new JButton(ovalIcon);
          ovalButton.setBorderPainted(false);      
        ovalButton.setContentAreaFilled(false);  
        ovalButton  .setFocusPainted(false);
        ovalButton.addActionListener(e -> drawingPanel.setCurrentTool(new OvalTool()));
        add(ovalButton);
        
          JRadioButton normalButton = new JRadioButton("Normal");
        JRadioButton solidButton = new JRadioButton("Solid");
        JRadioButton dottedButton = new JRadioButton("Dotted");

        ButtonGroup strokeGroup = new ButtonGroup();
        strokeGroup.add(normalButton);
        strokeGroup.add(solidButton);
        strokeGroup.add(dottedButton);
        normalButton.setSelected(true);

        normalButton.addActionListener(e -> drawingPanel.setCurrentStroke(new BasicStroke()));
        solidButton.addActionListener(e -> drawingPanel.setCurrentStroke(new BasicStroke(2.0f)));
        dottedButton.addActionListener(e -> drawingPanel.setCurrentStroke(
            new BasicStroke(
                2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5.0f, 5.0f}, 0
            )
        ));

        add(new JLabel("Stroke Type:"));
        add(normalButton);
        add(solidButton);
        add(dottedButton);

        // Add slider for stroke size
        JSlider fontSizeSlider = new JSlider(1, 20, 2);
        fontSizeSlider.setMajorTickSpacing(5);
        fontSizeSlider.setMinorTickSpacing(1);
        fontSizeSlider.setPaintTicks(true);
        fontSizeSlider.setPaintLabels(true);

        fontSizeSlider.addChangeListener(e -> {
            int fontSize = fontSizeSlider.getValue();
            drawingPanel.setCurrentStroke(new BasicStroke(fontSize));
        });

        add(new JLabel("Font Size:"));
        add(fontSizeSlider);
        
        
        // fill and outline shapes
        JRadioButton fillButton = new JRadioButton("Fill");
        JRadioButton outlineButton = new JRadioButton("Outline");
        ButtonGroup fillGroup = new ButtonGroup();
        fillGroup.add(fillButton);
        fillGroup.add(outlineButton);
        outlineButton.setSelected(true);
        fillButton.addActionListener(e -> drawingPanel.setFillShapes(true));
        outlineButton.addActionListener(e -> drawingPanel.setFillShapes(false));
        add(new JLabel("Shape Fill:"));
        add(fillButton);
        add(outlineButton);
        
        
        // undo button
        ImageIcon undo_icon = new ImageIcon("C:\\\\Users\\\\Hussien Mohamed\\\\Desktop\\\\undolast2.png");
        Image scaled_undo = undo_icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon undoIcon = new ImageIcon(scaled_undo);  // Use scaled_undo here
        JButton undo_btn = new JButton(undoIcon);          // Corrected to use undoIcon
        undo_btn.setBorderPainted(false);      
        undo_btn.setContentAreaFilled(false);  
        undo_btn.setFocusPainted(false);
        undo_btn.addActionListener(e -> drawingPanel.undoLastAction());
        add(undo_btn);
        
        
        //redo button
         ImageIcon redo_icon = new ImageIcon("C:\\\\Users\\\\Hussien Mohamed\\\\Desktop\\\\true_redo1.png");
         Image scaled_redo = redo_icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
          ImageIcon redoIcon = new ImageIcon(scaled_redo);
           JButton redo_btn = new JButton(redoIcon);
            redo_btn.setBorderPainted(false);      
        redo_btn.setContentAreaFilled(false);  
        redo_btn.setFocusPainted(false);
        redo_btn.addActionListener(e->drawingPanel.redoLastAction());
        add(redo_btn);
        
        
       
        
        // clear button
        ImageIcon clear_icon = new ImageIcon("C:\\\\Users\\\\Hussien Mohamed\\\\Desktop\\\\clearpng.png");
         Image scaled_clear = clear_icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
         ImageIcon clearIcon = new ImageIcon(scaled_clear);
        JButton clearButton = new JButton(clearIcon);
          clearButton.setBorderPainted(false);      
        clearButton.setContentAreaFilled(false);  
        clearButton.setFocusPainted(false);
        clearButton.addActionListener(e -> drawingPanel.clearActions());
        add(clearButton);
        
        
        
        //save button
        ImageIcon save_icon = new ImageIcon("C:\\\\Users\\\\Hussien Mohamed\\\\Desktop\\\\savepng.png");
         Image scaled_save = save_icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
          ImageIcon saveIcon = new ImageIcon(scaled_save);
           JButton saveButton = new JButton(saveIcon);
            saveButton.setBorderPainted(false);      
        saveButton.setContentAreaFilled(false);  
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(e->drawingPanel.saveAsPNG());
        add(saveButton);
        
      
    }
    
}
         
    




