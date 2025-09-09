/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.Fourniture;

import com.mycompany.underfloorheatingapp.actions.Interactable;
import com.mycompany.underfloorheatingapp.rendering.Renderable;
import com.mycompany.underfloorheatingapp.utils.transform.Transform;
import com.mycompany.underfloorheatingapp.utils.transform.Unit;

/**
 *
 * @author Antoine
 */
public class GenericFourniture implements Renderable, Interactable{
	
	private Transform transform;
	private Unit width;
	private Unit height;
	
	public GenericFourniture(Unit width, Unit height, Transform transform){
		this.transform = transform;
		this.width = width;
		this.height = height;
	}

	@Override
	public void render() {
		// TODO:
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

	
	
}
