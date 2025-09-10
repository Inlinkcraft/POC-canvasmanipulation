/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.utils.transform;

import com.mycompany.underfloorheatingapp.utils.algebra.Matrix.Mat4x4;
import java.util.List;
import com.mycompany.underfloorheatingapp.utils.algebra.Matrix.Matrix;
import com.mycompany.underfloorheatingapp.utils.algebra.Vector.Vec3;

/**
 *
 * @author Antoine
 */
public class Transform {

	private Vec3 position;
        private Vec3 rotation;
        private Vec3 scale;

	public Transform(Vec3 position, Vec3 rotation, Vec3 scale){
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
	}

        public Vec3 getPosition(){
            return position;
        }
        
        public Vec3 getRotation(){
            return rotation;
        }
        
        public Vec3 getScale(){
            return scale;
        }
        
	public Mat4x4 getTransformMatrix() {
		Mat4x4 translation = new Mat4x4(
                        1.0, 0.0, 0.0, position.getX(),
                        0.0, 1.0, 0.0, position.getY(),
                        0.0, 0.0, 1.0, position.getZ(),
                        0.0, 0.0, 0.0, 1.0
                );
                
                return translation;
	}
	
}
