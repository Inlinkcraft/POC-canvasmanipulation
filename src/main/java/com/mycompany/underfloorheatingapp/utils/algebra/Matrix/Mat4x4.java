/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.utils.algebra.matrix;

/**
 *
 * @author Antoine
 */
public class Mat4x4 extends Matrice{
	
	public Mat4x4(double value){
		super(4, 4, value);
	}
	
	public Mat4x4(double a, double b, double c, double d, double e, double f, double g, double h, double i, double j, double k, double l, double m, double n, double o, double p){
		super(4, 4, new double[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p});
	}
	
}
