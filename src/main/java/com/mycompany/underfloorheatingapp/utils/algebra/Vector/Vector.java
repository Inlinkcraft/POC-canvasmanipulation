/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.utils.algebra.vector;

/**
 *
 * @author Antoine
 */
public class Vector {
	
	protected double[] data;
	protected int size;

	public Vector(double[] data){
		this.data = data;
		this.size = data.length;
	}

	public static Vector zero(int nbElement){
		double[] result = new double[nbElement];
		for (int i = 0; i < nbElement; i++){
			result[i] = 0;
		}
		return new Vector(result);
	}

	public double get(int i){
		return data[i];
	}

	public void set(int i, double value){
		 data[i] = value;
	}

	public Vector add(double scalar){
		double[] result = new double[size];
		for (int i = 0; i < size; i++){
			result[i] = data[i] + scalar;
		}
		return new Vector(result);
	}

	public Vector add(Vector vector){
		double[] result = new double[size];
		for (int i = 0; i < size; i++){
			result[i] = data[i] + vector.get(i);
		}
		return new Vector(result);
	}

	public Vector sub(double scalar){
		double[] result = new double[size];
		for (int i = 0; i < size; i++){
			result[i] = data[i] - scalar;
		}
		return new Vector(result);
	}

	public Vector sub(Vector vector){
		double[] result = new double[size];
		for (int i = 0; i < size; i++){
			result[i] = data[i] - vector.get(i);
		}
		return new Vector(result);
	}

	public Vector mult(double scalar){
		double[] result = new double[size];
		for (int i = 0; i < size; i++){
			result[i] = data[i] * scalar;
		}
		return new Vector(result);
	}
	
	public double dot(Vector vector){
		double result = 0;
		for (int i = 0; i < size; i++){
			result += data[i] * vector.get(i);
		}
		return result;
	}

	// cross product ?

	public int lenght(){
		return size;
	}

	public void fill(double value){
		for (int i = 0; i < size; i++){
			data[i] = value;
		}
	}
}
