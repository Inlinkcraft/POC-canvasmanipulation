/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.rendering;

import com.mycompany.underfloorheatingapp.rendering.renderelements.Mesh;
import com.mycompany.underfloorheatingapp.rendering.renderelements.RenderElement;
import com.mycompany.underfloorheatingapp.rendering.renderelements.Renderer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Antoine
 */
public class Viewport extends JPanel{

	public static final Color BACKGROUND_COLOR = Color.BLACK;
	
	private Renderer renderer;
	
	
	public Viewport(){
		setPreferredSize(new Dimension(1600, 900));
		renderer = new Renderer();
		renderer.start();
	}
	
	public void sendFrame(Frame frame){
		renderer.frames2Render.add(frame);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		Graphics2D g2d = (Graphics2D) g;

    		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    		Frame frame = null;

    		// Drain queue and keep only the last rendered frame
    		while (!renderer.renderedFrames.isEmpty()) {
        		frame = renderer.renderedFrames.poll();
    		}

    		if (frame != null && frame.getStatus() == Frame.State.RENDERED) {
        		g2d.drawImage(frame.getImage(), 0, 0, getWidth(), getHeight(), null);
    		} else {
        		g2d.setColor(BACKGROUND_COLOR);
        		g2d.fillRect(0, 0, getWidth(), getHeight());
    		}
	}

	
}
