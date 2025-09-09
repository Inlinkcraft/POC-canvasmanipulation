/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.utils.transform;

/**
 *
 * @author Antoine
 */
public class Unit {
	private double inch;
	
	public Unit(double inch){
		this.inch = inch;
	}
	
	public double getUnit() {
		return inch;
	}
	
	public static Unit fromInch(double inch){
		return new Unit(inch);
	}

	public static Unit fromFeet(double feet){
		return new Unit(feet * 12);
	}
	
	public static Unit fromCm(double cm){
		return new Unit(cm * 0.393701);
	}

	public static Unit fromMeters(double meters){
		return new Unit(meters * 39.3701);
	}
	
}