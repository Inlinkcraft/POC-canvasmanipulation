/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.Fourniture;

import com.mycompany.underfloorheatingapp.actions.Interactable;
import com.mycompany.underfloorheatingapp.rendering.Renderable;
import com.mycompany.underfloorheatingapp.rendering.Viewport;
import com.mycompany.underfloorheatingapp.rendering.renderelements.Mesh;
import com.mycompany.underfloorheatingapp.rendering.renderelements.RenderElement;
import com.mycompany.underfloorheatingapp.utils.algebra.matrix.Matrice;
import com.mycompany.underfloorheatingapp.utils.algebra.vector.Vec3;
import com.mycompany.underfloorheatingapp.utils.transform.Transform;
import com.mycompany.underfloorheatingapp.utils.transform.Unit;
import java.awt.Graphics2D;
import java.util.List;

/**
 *
 * @author Antoine
 */
public class GenericFourniture implements Renderable, Interactable{
	
	private Mesh mesh;
	private Transform transform;
	private Unit width;
	private Unit height;
	
	public GenericFourniture(Unit width, Unit height, Transform transform){
		this.transform = transform;
		this.width = width;
		this.height = height;
		/*this.mesh = new Mesh(
			transform,
			new Vec3[]{
				new Vec3(-1, -1, 0),
				new Vec3(1, -1, 0),
				new Vec3(1, 1, 0),
				new Vec3(-1, 1, 0)
			},
			new int[]{
				0, 1, 2,
				1, 3, 2
			}
		);*/

		this.mesh = new Mesh(
			transform,
			new Vec3[]{
    				new Vec3(-1, -1, -1),
    				new Vec3(1, -1, -1),
    				new Vec3(1, 1, -1),
    				new Vec3(-1, 1, -1),
    				new Vec3(-1, -1, 1),
    				new Vec3(1, -1, 1),
    				new Vec3(1, 1, 1),
    				new Vec3(-1, 1, 1)
			},
			new int[]{
				4, 5, 6,
				4, 6, 7,
				0, 2, 1,
				0, 3, 2,
				0, 7, 3,
				0, 4, 7,
				1, 6, 2,
				1, 5, 6,
				3, 6, 2,
				3, 7, 6,
				0, 5, 1,
				0, 4, 5
			}
		);
	}

	public Transform getTransform() {
		return transform;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
		this.mesh.setTransform(transform);
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

	@Override
	public RenderElement[] getRenderElements() {
		return new RenderElement[]{mesh};
	}
	
}
