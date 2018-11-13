package com.ipo.analysis;

import java.io.File;
import java.io.IOException;

import com.ipo.analysis.model.InputVariables;
import com.ipo.analysis.model.OutputVariable;

import ilog.concert.IloException;
import ilog.concert.IloIntVar;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloQuadNumExpr;
import ilog.cplex.IloCplex;

public class Model {
	
	private IloCplex cplex;
	private IloIntVar[]x; // binary decision variable, 0 if the item is not in the pack, 1 if it is
	
	public OutputVariable createModelAndSolve(String fileName) throws IloException, IOException {
		
		String file = "resource"+File.separatorChar+fileName;
		
		InputVariables input = InputHelper.readAndFill(file);
		
		// start model
		cplex = new IloCplex(); 
		
		//define cplex binary variables
		int size = input.getCapacitySize();
		x = new IloIntVar[size];
		for (int i = 0; i < size; i++) {
			x[i] = cplex.intVar(0, 1, "x"+i);
		}
		
		//define objective function
		IloQuadNumExpr objective = cplex.quadNumExpr();
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				objective.addTerm(input.getQuadBenefit(i,j),x[i], x[j]);
			}
		}
		cplex.addMaximize(objective);
		
		//define capacity restriction
		IloLinearNumExpr cap = cplex.linearNumExpr();
		for(int i = 0; i < size; i++) {
			cap.addTerm(input.getCapacity(i), x[i]);
		}
		cplex.addLe(cap, input.getMaxCapacity());
		
		cplex.solve();
		
		cplex.exportModel("teste.lp");
		
		OutputVariable output = new OutputVariable();
		
		for (int i = 0; i < x.length; i++) {
			output.getItemUsed().add((int)cplex.getValue(x[i]));
			System.out.println(cplex.getValue(x[i]));
		}
		return output;
		
	}
	
	public double getObjFunctionResult() throws IloException {
		return cplex.getObjValue();
	}
	
}
