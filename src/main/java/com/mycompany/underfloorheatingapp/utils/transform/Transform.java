/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.utils.transform;

import java.util.List;
import com.mycompany.underfloorheatingapp.utils.matrix.Matrix;

/**
 *
 * @author Antoine
 */
public class Transform {

	private Unit posx;
	private Unit posy;	
	private double rotationZ;

	public Transform(Unit posx, Unit posy, double rotationZ){
		this.posx = posx;
		this.posy = posy;
		this.rotationZ = rotationZ;
	}

	public Matrix getTransformMatrix() {
		return new Matrix(3, 3, List.of(
			Math.cos(rotationZ), -Math.sin(rotationZ), posx.getUnit(),
			Math.sin(rotationZ), Math.cos(rotationZ), posy.getUnit(),
			0.0, 0.0, 1.0
		));
	}
	
}
