/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.Fourniture;

import com.mycompany.underfloorheatingapp.actions.Interactable;
import com.mycompany.underfloorheatingapp.rendering.Renderable;
import com.mycompany.underfloorheatingapp.utils.algebra.Matrix.Matrix;
import com.mycompany.underfloorheatingapp.utils.transform.Transform;
import com.mycompany.underfloorheatingapp.utils.transform.Unit;
import java.awt.Graphics2D;
import java.util.List;

/**
 *
 * @author Antoine
 */
public class GenericFourniture implements Renderable, Interactable{
	
	private Transform transform;
	private Unit width;
	private Unit height;
	
	public GenericFourniture(Unit width, Unit height, Transform transform){
		this.transform = transform;
		this.width = width;
		this.height = height;
	}

	@Override
	public void render(Graphics2D g2d) {
		//double x = transform.getX().getUnit();
                //double y = transform.getY().getUnit();
                double halfwidth = width.getUnit() / 2.0;
                double halfHeight = height.getUnit() / 2.0;
            
                Matrix vertex_def = new Matrix(3, 4, List.of(
                        -halfwidth,  halfwidth,  halfwidth, -halfwidth,
                        -halfHeight, -halfHeight, halfHeight, halfHeight,
                        1.0, 1.0, 1.0, 1.0
                ));
                
                Matrix vertex = Matrix.dot(transform.getTransformMatrix(), vertex_def);
                
                // row / col
                g2d.drawLine((int)vertex.get(0, 0), (int)vertex.get(1, 0), (int)vertex.get(0, 1), (int)vertex.get(1, 1));
                g2d.drawLine((int)vertex.get(0, 1), (int)vertex.get(1, 1), (int)vertex.get(0, 2), (int)vertex.get(1, 2));
                g2d.drawLine((int)vertex.get(0, 2), (int)vertex.get(1, 2), (int)vertex.get(0, 3), (int)vertex.get(1, 3));
                g2d.drawLine((int)vertex.get(0, 3), (int)vertex.get(1, 3), (int)vertex.get(0, 0), (int)vertex.get(1, 0));
            
	}

	@Override
	public boolean isInteracted() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void action() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	
}
