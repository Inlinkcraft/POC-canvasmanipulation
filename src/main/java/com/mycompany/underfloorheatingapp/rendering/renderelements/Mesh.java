/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.underfloorheatingapp.rendering.renderelements;

import com.mycompany.underfloorheatingapp.rendering.Viewport;
import com.mycompany.underfloorheatingapp.utils.algebra.matrix.Matrice;
import com.mycompany.underfloorheatingapp.utils.algebra.vector.Vec3;
import com.mycompany.underfloorheatingapp.utils.algebra.vector.Vec4;
import com.mycompany.underfloorheatingapp.utils.algebra.vector.Vector;
import com.mycompany.underfloorheatingapp.utils.transform.Transform;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author antoi
 */
public class Mesh extends RenderElement{
    	
	public final static Color DEFAULT_COLOR = Color.MAGENTA;
	
	private Transform transform;
    	private Vec3[] vertices;
    	private int[] triIndex;
	private Color[] triColor;

	private boolean isWireframe = false;
	
	
	public Mesh(Transform transform, Vec3[] vertex, int[] triIndex, Color[] triColor){
		this.transform = transform;
		this.vertices = vertex;
		this.triIndex = triIndex;
		this.triColor = triColor;
	}

	public Mesh(Transform transform, Vec3[] vertex, int[] triIndex, Color color){
		this(transform, vertex, triIndex, getUniColorArray((int) triIndex.length/3, color));
	}

	public Mesh(Transform transform, Vec3[] vertex, int[] triIndex){
		this(transform, vertex, triIndex, DEFAULT_COLOR);
	}

	private static Color[] getUniColorArray(int lenght, Color color){
		Color[] uniColorArray = new Color[lenght];
		for (int i = 0; i < uniColorArray.length; i++){
			uniColorArray[i] = color;
		}
		return uniColorArray;
	}
	
	public Transform getTransform() {
		return transform;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
	}

	public Vec3[] getVertices() {
		return vertices;
	}

	public void setVertices(Vec3[] vertex) {
		this.vertices = vertex;
	}

	public int[] getTriIndex() {
		return triIndex;
	}

	public void setTriIndex(int[] triIndex) {
		this.triIndex = triIndex;
	}
    
    	@Override
    	public void render(Graphics2D canvas){
    		
	    	// Convert vertex to matrix (And homogenised)
		Matrice vertices_matrix = new Matrice(4, vertices.length, 1);
		for (int i = 0; i < vertices.length; i++){
			vertices_matrix.setCol(i, new Vec4(vertices[i].getX(), vertices[i].getY(), vertices[i].getZ(), 1));
		}
		
		// Transform point
		Matrice transformed_vertices = transform.getTransformMatrix().dot(vertices_matrix);
		
		// Show the mesh
		for (int i = 0; i < triIndex.length; i += 3){
			Vector v1 = transformed_vertices.getCol(triIndex[i]);
			Vector v2 = transformed_vertices.getCol(triIndex[i + 1]);
			Vector v3 = transformed_vertices.getCol(triIndex[i + 2]);
			
			canvas.setColor(triColor[(int) i / 3]);

			int[] posX = new int[]{(int)(v1.get(0)), (int)(v2.get(0)), (int)(v3.get(0))};
			int[] posY = new int[]{(int)(v1.get(1)), (int)(v2.get(1)), (int)(v3.get(1))};
			
			if (!isWireframe){
				canvas.fillPolygon( posX, posY, 3);
			} else{
				canvas.drawPolyline(posX, posY, 3);
			}
		}
		
    	}
    
}
