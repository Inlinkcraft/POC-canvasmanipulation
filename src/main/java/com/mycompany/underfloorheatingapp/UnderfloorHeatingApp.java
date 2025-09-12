/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.underfloorheatingapp;

import com.mycompany.underfloorheatingapp.Fourniture.GenericFourniture;
import com.mycompany.underfloorheatingapp.rendering.Renderable;
import com.mycompany.underfloorheatingapp.rendering.Viewport;
import com.mycompany.underfloorheatingapp.rendering.Frame;
import com.mycompany.underfloorheatingapp.utils.algebra.vector.Vec3;
import com.mycompany.underfloorheatingapp.utils.algebra.vector.Vector;
import com.mycompany.underfloorheatingapp.utils.transform.Transform;
import com.mycompany.underfloorheatingapp.utils.transform.Unit;
import javax.swing.*;


/**
 * A Java Swing application for a smart underfloor heating system.
 * This class has been updated to include a room designer for modeling the heating cable.
 */
public class UnderfloorHeatingApp extends JFrame {

    public UnderfloorHeatingApp() {
        super("Smart Underfloor Heating System");

        // Set up the main window properties
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
	
	Viewport viewport = new Viewport();
        add(viewport);

	Transform transform = new Transform(
		new Vec3(500.0, 500.0, 500.0), 
		new Vec3(Math.PI/4, Math.PI/4, Math.PI/4), 
		new Vec3(100.0, 100.0, 100.0)
	);
	GenericFourniture fournit_1 = new GenericFourniture(Unit.fromInch( 20), Unit.fromInch(20), transform);
	
        setVisible(true);

	new Timer(16, e -> { // ~60 FPS
            	Transform curTransform = fournit_1.getTransform();

            	Vector rotation_g = curTransform.getRotation()
                    .add(new Vec3(Math.PI/100, Math.PI/100, Math.PI/100));
            	Vec3 rotation = new Vec3(rotation_g.get(0), rotation_g.get(1), rotation_g.get(2));

            	Transform newTransform = new Transform(
	                curTransform.getPosition(),
        	        	rotation,
               		curTransform.getScale()
            	);
            	fournit_1.setTransform(newTransform);

	    	Frame frame = new Frame(new Renderable[]{fournit_1}, 1600, 900);

		viewport.sendFrame(frame);
	    
                viewport.repaint();
        }).start();

        setVisible(true);

    }

    /**
     * The main method to start the application.
     * All Swing UI creation should be done on the Event Dispatch Thread (EDT).
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UnderfloorHeatingApp());
    }
}
