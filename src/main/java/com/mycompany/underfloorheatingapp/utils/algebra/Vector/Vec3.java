/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.utils.algebra.Vector;

/**
 *
 * @author Antoine
 */
public class Vec3 extends Vector{
	
	public Vec3(double x, double y, double z) {
		super(new double[]{x, y, z});
	}
	
	public double getX(){
		return data[0];
	}

	public double getY(){
		return data[1];
	}

	public double getZ(){
		return data[2];
	}

	public void setX(double value){
		data[0] = value;
	}

	public void setY(double value){
		data[1] = value;
	}

	public void setZ(double value){
		data[2] = value;
	}
	
}
