package com.ipo.analysis;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.ipo.analysis.model.OutputVariable;

import ilog.concert.IloException;

class ModelTest {

	@Test
	void test() throws IloException, IOException {
		Model model = new Model();
		
		OutputVariable output = model.createModelAndSolve("r_10_100_13.txt");
		
	}

}
