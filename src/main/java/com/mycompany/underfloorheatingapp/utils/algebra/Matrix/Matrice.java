/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.underfloorheatingapp.utils.algebra.matrix;

import com.mycompany.underfloorheatingapp.utils.algebra.vector.Vector;
import java.util.List;

/**
 *
 * @author Antoine
 */
public class Matrice {
	
	private Vector[] rows;
	private Vector[] cols;
	private int nbRow;
	private int nbCol;
	private int size;

	public Matrice(int nbRow, int nbCol){
		this(nbRow, nbCol, null);
	}
	
	public Matrice(int nbRow, int nbCol, double value){
		this(nbRow, nbCol, null);
		this.fill(value);
	}
	
	public Matrice(int nbRow, int nbCol, double[] data){
		this.nbRow = nbRow;
		this.nbCol = nbCol;
		this.size = nbRow * nbCol;		
		
		this.rows = new Vector[nbRow];
		this.cols = new Vector[nbCol];
		
		for (int row = 0; row < nbRow; row++ ){
			this.rows[row] = Vector.zero(nbCol);
		}

		for (int col = 0; col < nbCol; col++){
			this.cols[col] = Vector.zero(nbRow);
		}
		
		if (data != null){
                    if (data.length == size){
			    for (int i = 0; i < data.length; i++){
			    	int row = i / nbCol;
			    	int col = i % nbCol;
				this.set(row, col, data[i]);
			    }
		    } else {
			    throw new RuntimeException("Data and matrice size don't match");
		    }
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

	public Matrice add(double scalar){
		Matrice result = new Matrice(nbRow, nbCol, 0.0);
		for (int row = 0; row < nbRow; row++){
			for (int col = 0; col < nbCol; col++){
				result.set(row, col, this.get(row, col) + scalar);
			}
		}
		return result;
	}

	public Matrice add(Matrice matrix){
		if (this.nbCol != matrix.nbCol || this.nbRow != matrix.nbRow){
			throw new RuntimeException("Matrix must match for addition");
		}
		Matrice result = new Matrice(nbRow, nbCol, 0.0);
		for (int row = 0; row < nbRow; row++){
			for (int col = 0; col < nbCol; col++){
				result.set(row, col, this.get(row, col) + matrix.get(row, col));
			}
		}
		return result;
	}

	public Matrice sub(double scalar){
		Matrice result = new Matrice(nbRow, nbCol, 0.0);
		for (int row = 0; row < nbRow; row++){
			for (int col = 0; col < nbCol; col++){
				result.set(row, col, this.get(row, col) - scalar);
			}
		}
		return result;
	}

	public Matrice sub(Matrice matrix){
		if (this.nbCol != matrix.nbCol || this.nbRow != matrix.nbRow){
			throw new RuntimeException("Matrix must match for substraction");
		}
		Matrice result = new Matrice(nbRow, nbCol, 0.0);
		for (int row = 0; row < nbRow; row++){
			for (int col = 0; col < nbCol; col++){
				result.set(row, col, this.get(row, col) - matrix.get(row, col));
			}
		}
		return result;
	}

	public Matrice mult(double scalar){
		Matrice result = new Matrice(nbRow, nbCol, 0.0);
		for (int row = 0; row < nbRow; row++){
			for (int col = 0; col < nbCol; col++){
				result.set(row, col, this.get(row, col) * scalar);
			}
		}
		return result;
	}
	
	public Matrice dot(Matrice matrix){
		if (this.nbCol != matrix.nbRow){
			throw new RuntimeException("Matrix row must math the matrix col of the doted matrix");
		}
		Matrice result = new Matrice(nbRow, matrix.nbCol, 0.0);
		for (int row = 0; row < result.nbRow; row++){
			for (int col = 0; col < result.nbCol; col++){
				result.set(row, col, this.getRow(row).dot(matrix.getCol(col)));
			}
		}
		return result;
	}

        public Matrice Transpose(){
            Matrice result = new Matrice(nbCol, nbRow);
            for (int i = 0; i < nbRow; i++){
                result.setCol(i, rows[i]);
            }
            return result;
        }
        
	// cross product ??

	@Override
	public String toString() {
	
		String result = "--------------------------------------------\n";

		for (int row = 0; row < nbRow; row++){
			for (int col = 0; col < nbCol; col++){
				result += "\t" + this.get(row, col);
			}
			result += "\n";
		}

		return result + "--------------------------------------------";
		
	}

}