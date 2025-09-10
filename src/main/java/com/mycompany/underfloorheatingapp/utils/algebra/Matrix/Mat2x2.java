/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.utils.algebra.Matrix;

/**
 *
 * @author Antoine
 */
public class Mat2x2 extends Matrix{
	
	public Mat2x2(double value){
		super(2, 2, value);
	}
	
	public Mat2x2(double a, double b, double c, double d){
		super(2, 2, new double[]{a, b, c, d});
	}
	
}
