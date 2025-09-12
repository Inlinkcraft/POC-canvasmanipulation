/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.utils.algebra.vector;

/**
 *
 * @author Antoine
 */
public class Vec2 extends Vector{
	
	public Vec2(double x, double y) {
		super(new double[]{x, y});
	}

	public double getX(){
		return data[0];
	}

	public double getY(){
		return data[1];
	}

	public void setX(double value){
		data[0] = value;
	}

	public void setY(double value){
		data[1] = value;
	}
	
}
