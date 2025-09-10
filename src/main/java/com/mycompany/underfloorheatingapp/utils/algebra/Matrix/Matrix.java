/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.utils.algebra.Matrix;

import com.mycompany.underfloorheatingapp.utils.algebra.Vector.Vector;
import java.util.List;

/**
 *
 * @author Antoine
 */
public class Matrix {
	
	private Vector[] rows;
	private Vector[] cols;
	private int nbRow;
	private int nbCol;
	private int size;

	public Matrix(int nbRow, int nbCol){
		this(nbRow, nbCol, null);
	}
	
	public Matrix(int nbRow, int nbCol, double value){
		this(nbRow, nbCol, null);
		this.fill(value);
	}
	
	public Matrix(int nbRow, int nbCol, double[] data){
		this.nbRow = nbRow;
		this.nbCol = nbCol;
		this.size = nbRow * nbCol;		
		
		this.rows = new Vector[nbRow];
		this.cols = new Vector[nbCol];
		
		if (data != null){
                    
                }
	}

	public void fill(double value){
		for (int i = 0; i < nbRow; i++){
			rows[i].fill(value);
		}
		for (int i = 0; i < nbCol; i++){
			cols[i].fill(value);
		}
	}
	
	public void set(int row, int col, double value){
		rows[row].set(col, value);
		cols[col].set(row, value);
	}
	
	public void set(double[] data){
		if (data.length == size){
			for (int i = 0; i < data.length; i++){
				int row = i / nbCol;
				int col = i % nbCol;
				this.set(row, col, data[i]);
			}
		}else{
			throw new RuntimeException("data inserted in a matrix should be the same lenght: " + data.length + " != " + size);
		}
	}

	public void setRow(int row, Vector value){
		if (value.lenght() == nbCol){
			rows[row] = value;
			for (int col = 0; col < nbCol; col++){
				this.set(row, col, value.get(col));
			}
		}else{
			throw new RuntimeException("Vector should be the same lenght has the number of columns: " + value.lenght() + " |= " + nbCol);
		}
		
	}

	public void setCol(int col, Vector value){
		if (value.lenght() == nbRow){
			cols[col] = value;
			for (int row = 0; row < nbRow; row++){
				this.set(row, col, value.get(row));
			}
		}else{
			throw new RuntimeException("Vector should be the same lenght has the number of rows: " + value.lenght() + " |= " + nbRow);
		}
	}

	public double get(int row, int col){
		return rows[row].get(col);
	}
	
	public Vector getRow(int row){
		return rows[row];
	}

	public Vector getCol(int col){
		return cols[col];
	}

	public Matrix add(double scalar){
		Matrix result = new Matrix(nbRow, nbCol, 0.0);
		for (int row = 0; row < nbRow; row++){
			for (int col = 0; col < nbCol; col++){
				result.set(row, col, this.get(row, col) + scalar);
			}
		}
		return result;
	}

	public Matrix add(Matrix matrix){
		if (this.nbCol != matrix.nbCol || this.nbRow != matrix.nbRow){
			throw new RuntimeException("Matrix must match for addition");
		}
		Matrix result = new Matrix(nbRow, nbCol, 0.0);
		for (int row = 0; row < nbRow; row++){
			for (int col = 0; col < nbCol; col++){
				result.set(row, col, this.get(row, col) + matrix.get(row, col));
			}
		}
		return result;
	}

	public Matrix sub(double scalar){
		Matrix result = new Matrix(nbRow, nbCol, 0.0);
		for (int row = 0; row < nbRow; row++){
			for (int col = 0; col < nbCol; col++){
				result.set(row, col, this.get(row, col) - scalar);
			}
		}
		return result;
	}

	public Matrix sub(Matrix matrix){
		if (this.nbCol != matrix.nbCol || this.nbRow != matrix.nbRow){
			throw new RuntimeException("Matrix must match for substraction");
		}
		Matrix result = new Matrix(nbRow, nbCol, 0.0);
		for (int row = 0; row < nbRow; row++){
			for (int col = 0; col < nbCol; col++){
				result.set(row, col, this.get(row, col) - matrix.get(row, col));
			}
		}
		return result;
	}

	public Matrix mult(double scalar){
		Matrix result = new Matrix(nbRow, nbCol, 0.0);
		for (int row = 0; row < nbRow; row++){
			for (int col = 0; col < nbCol; col++){
				result.set(row, col, this.get(row, col) * scalar);
			}
		}
		return result;
	}
	
	public Matrix dot(Matrix matrix){
		if (this.nbCol != matrix.nbRow){
			throw new RuntimeException("Matrix row must math the matrix col of the doted matrix");
		}
		Matrix result = new Matrix(nbRow, matrix.nbCol, 0.0);
		for (int row = 0; row < result.nbRow; row++){
			for (int col = 0; col < result.nbCol; col++){
				result.set(row, col, this.getRow(row).dot(matrix.getCol(col)));
			}
		}
		return result;
	}

        public Matrix Transpose(){
            Matrix result = new Matrix(nbCol, nbRow);
            for (int i = 0; i < nbRow; i++){
                result.setCol(i, rows[i]);
            }
            return result;
        }
        
	// cross product ??
}