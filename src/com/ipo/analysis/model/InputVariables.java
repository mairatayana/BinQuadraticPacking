package com.ipo.analysis.model;

import java.util.ArrayList;
import java.util.List;

public class InputVariables {

	private List<List<Float>> quadBenefit; //simetric matrix with benefit values, qii is the benefit of item i, qij is the benefit of having item i and j together
	private List<Float> capacity; // size of each item
	private Float maxCapacity; // backpack capacity
	private int size;
	
	public InputVariables(int size) {
		this.size = size;
		this.quadBenefit = new ArrayList<>();
		this.capacity = new ArrayList<>();
		for (int i = 0; i < this.size; i++) {
			this.quadBenefit.add(new ArrayList<>());
			this.capacity.add(0f);
			for (int j = 0; j < this.size; j++) {
				this.quadBenefit.get(i).add(0f);
			}
		}
	}	
	
	public Float getQuadBenefit(int indexRow, int indexCol) {
		checkNullRow(indexRow);
		return this.quadBenefit.get(indexRow).get(indexCol);
	}
	public void setQuadBenefit(int indexRow, int indexCol, Float quadBenefit) {
		checkNullRow(indexRow);
		this.quadBenefit.get(indexRow).set(indexCol, quadBenefit);
	}
	public Float getCapacity(int index) {
		return capacity.get(index);
	}
	public void setCapacity(int index, Float capacity) {
		this.capacity.set(index, capacity);
	}
	public float getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(Float maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	private void checkNullRow(int indexRow) {
		if (this.quadBenefit.get(indexRow) == null) {
			this.quadBenefit.set(indexRow, new ArrayList<>(this.size));
		}
	}
	public int getCapacitySize() {
		return this.capacity.size();
	}
	public int getQuadBenefitRowSize() {
		return this.quadBenefit.size();
	}
	public int getQuadBenefitColSizeFor(int row) {
		checkNullRow(row);
		return this.quadBenefit.get(row).size();
	}
	
}
