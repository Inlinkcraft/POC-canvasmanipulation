/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.utils.transform;

import com.mycompany.underfloorheatingapp.utils.algebra.Matrix.Mat4x4;
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
        
	public Matrix getTransformMatrix() {
		
                Mat4x4 t_scale = new Mat4x4(
                        scale.getX(), 0.0, 0.0, 0.0,
                        0.0, scale.getY(), 0.0, 0.0,
                        0.0, 0.0, scale.getZ(), 0.0,
                        0.0, 0.0, 0.0, 1.0
                );
            
                Mat4x4 t_translation = new Mat4x4(
                        1.0, 0.0, 0.0, position.getX(),
                        0.0, 1.0, 0.0, position.getY(),
                        0.0, 0.0, 1.0, position.getZ(),
                        0.0, 0.0, 0.0, 1.0
                );
                
                Mat4x4 t_rotation_x = new Mat4x4(
                        1.0, 0.0, 0.0, 0.0,
                        0.0, Math.cos(rotation.getX()), - Math.sin(rotation.getX()), 0.0,
                        0.0, Math.sin(rotation.getX()), Math.cos(rotation.getX()), 0.0,
                        0.0, 0.0, 0.0, 1.0
                );
                
                Mat4x4 t_rotation_y = new Mat4x4(
                        Math.cos(rotation.getY()), 0.0, Math.sin(rotation.getY()), 0.0,
                        0.0, 1.0, 0.0, 0.0,
                        - Math.sin(rotation.getY()), 0.0, Math.cos(rotation.getY()), 0.0,
                        0.0, 0.0, 0.0, 1.0
                );
                
                Mat4x4 t_rotation_z = new Mat4x4(
                        Math.cos(rotation.getX()), - Math.sin(rotation.getX()), 0.0, 0.0,
                        Math.sin(rotation.getX()), Math.cos(rotation.getX()), 0.0, 0.0,
                        0.0, 0.0, 1.0, 0.0,
                        0.0, 0.0, 0.0, 1.0
                );
                
                return t_translation.dot( t_rotation_x.dot(t_rotation_y.dot(t_rotation_z.dot(t_scale))));
	}
	
}
