/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.rendering.renderelements;

import com.mycompany.underfloorheatingapp.rendering.Frame;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Antoine
 */
public class Renderer extends Thread{

	private boolean stop;	
	public LinkedList<Frame> frames2Render;
	public LinkedList<Frame> renderedFrames;

	public Renderer(){
		this.stop = false;
		this.frames2Render = new LinkedList<Frame>();
		this.renderedFrames = new LinkedList<Frame>();
	}
	
	public void run(){
		while (!stop){
			try {
				Frame frame = frames2Render.peek();
				if (frame != null && frame.getStatus() == Frame.State.READY){
					
					frame.setStatus(Frame.State.LOCK);
					frames2Render.remove();
					frame.render();
					renderedFrames.add(frame);
					frame.setStatus(Frame.State.RENDERED);
					
				} else {
					Thread.sleep(1);
				}
			} catch (InterruptedException e){
				stop = true;
			}
		}
	}
	
}
