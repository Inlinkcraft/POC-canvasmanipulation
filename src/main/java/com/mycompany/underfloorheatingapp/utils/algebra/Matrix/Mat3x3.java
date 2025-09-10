/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.utils.algebra.Matrix;

/**
 *
 * @author Antoine
 */
public class Mat3x3 extends Matrix{
	
	public Mat3x3(double value){
		super(3, 3, value);
	}
	
	public Mat3x3(double a, double b, double c, double d, double e, double f, double g, double h, double i){
		super(3, 3, new double[]{a, b, c, d, e, f, g, h, i});
	}
	
}
