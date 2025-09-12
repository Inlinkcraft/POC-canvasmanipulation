/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.rendering;

import com.mycompany.underfloorheatingapp.rendering.renderelements.RenderElement;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Antoine
 */
public class Frame {
	
	private State status;
	private Renderable[] renderables;
	private BufferedImage image;
	private Graphics2D canvas;

	public Frame(Renderable[] renderables, int width, int height){
		this.status = State.LOCK;
		this.renderables = renderables;

		this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        	this.canvas = image.createGraphics();
		
		this.status = State.READY;
		
	}

	public State getStatus() {
		return status;
	}

	public Renderable[] getRenderables() {
		return renderables;
	}

	public void setStatus(State status) {
		this.status = status;
	}

	public void setRenderables(Renderable[] renderables) {
		this.renderables = renderables;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void render() {
		
		canvas.setBackground(java.awt.Color.BLACK);
        	canvas.clearRect(0, 0, image.getWidth(), image.getHeight());
		
		for (Renderable renderable: renderables){
			//Should add sorting here
			for (RenderElement renderElm : renderable.getRenderElements()){
				renderElm.render(canvas);
			}
		}
	}
	
	public enum State{
		LOCK,
		READY,
		RENDERED
	}
}
