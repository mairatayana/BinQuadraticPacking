package com.ipo.analysis.model;

import java.util.ArrayList;
import java.util.List;

public class InputVariables {

	private float[][] quadBenefit; //simetric matrix with benefit values, qii is the benefit of item i, qij is the benefit of having item i and j together
	private float[] capacity; // size of each item
	private float maxCapacity; // backpack capacity
	private int size;
	
	public InputVariables(int size) {
		this.size = size;
		this.quadBenefit = new float[size][size];
		this.capacity = new float[size];
	}	
	
	public float getQuadBenefit(int indexRow, int indexCol) {
		return this.quadBenefit[indexRow][indexCol];
	}
	public void setQuadBenefit(int indexRow, int indexCol, float quadBenefit) {
		this.quadBenefit[indexRow][indexCol] = quadBenefit;
	}
	public Float getCapacity(int index) {
		return capacity[index];
	}
	public void setCapacity(int index, float capacity) {
		this.capacity[index] = capacity;
	}
	public float getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(float maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public int getCapacitySize() {
		return this.capacity.length;
	}
	public int getQuadBenefitRowSize() {
		return this.quadBenefit.length;
	}
	public int getQuadBenefitColSizeFor(int row) {
		return this.quadBenefit[row].length;
	}
	
}
