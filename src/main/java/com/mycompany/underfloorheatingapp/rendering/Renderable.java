/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.underfloorheatingapp.rendering;

import com.mycompany.underfloorheatingapp.rendering.renderelements.RenderElement;

/**
 *
 * @author Antoine
 */
public interface Renderable{

	public boolean isVisible();
	public RenderElement[] getRenderElements();
        
}
