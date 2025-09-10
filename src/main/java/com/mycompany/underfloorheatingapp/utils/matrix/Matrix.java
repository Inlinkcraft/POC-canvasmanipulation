/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.utils.matrix;

import java.util.List;

/**
 *
 * @author Antoine
 */
public class Matrix {
	
	private double[][] matrix;
	private int row;
	private int col;
	private int size;

	public Matrix(int row, int col, List<Double> data){
		this.row = row;
		this.col = col;
		this.size = row * col;		
		
		this.matrix = new double[col][row];
		
		if (data != null){
                    
                        if (data.size() == row * col) {
			
                                for (int i = 0; i < size; i++){
                                        int cur_row = i / col;
                                        int cur_col = i % col;
                                        matrix[cur_col][cur_row] = data.get(i);
                                }
			
                        } else if (data.size() != row * col){
                                throw new RuntimeException("data length must match row x col size");
                        }
                }
	}

	public void set(int row, int col, double value){
		matrix[col][row] = value;
	}

	public double get(int row, int col){
		return matrix[col][row];
	}

	public static Matrix dot(Matrix a, Matrix b){
		if (a.col != b.row){
			throw new RuntimeException("Matrix multiplication is not possible if the a.col and b.row don't match");
		}
		Matrix c = new Matrix(a.row, b.col, null);
		for (int curRow = 0; curRow < a.row; curRow++){
			for (int curCol = 0; curCol < b.col; curCol++){
				double sum = 0;
				for (int step = 0; step < a.col; step++){
					sum += a.get(curRow, step) * b.get(step, curCol);
				}
				c.set(curRow, curCol, sum);
			}
		}
		return c;
	}
	
}