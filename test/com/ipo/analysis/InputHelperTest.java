package com.ipo.analysis;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.ipo.analysis.model.InputVariables;

class InputHelperTest {

	@Test
	void test() throws IOException {

		String file = "resource"+File.separatorChar+"r_10_100_13.txt";

		InputVariables input = InputHelper.readAndFill(file);
				
		assertEquals(10, input.getQuadBenefitRowSize());
		assertEquals(10, input.getQuadBenefitColSizeFor(0));
		assertEquals(91, input.getQuadBenefit(0,0), 0.0001);
		assertEquals(26, input.getQuadBenefit(9,9), 0.0001);
		assertEquals(23, input.getQuadBenefit(0,2), 0.0001);
		assertEquals(57, input.getQuadBenefit(4,6), 0.0001);
		assertEquals(145, input.getMaxCapacity(), 0.0001);
		assertEquals(34, input.getCapacity(0), 0.0001);
		assertEquals(39, input.getCapacity(9), 0.0001);
		
		/*r_10_100_13
		10
		91 78 22 4 48 85 46 81 3 26
		55 23 35 44 5 91 95 26 40
		92 11 20 43 71 83 27 65
		7 57 33 38 57 63 82
		100 87 91 83 44 48
		69 57 79 89 21
		9 40 22 26
		50 6 7
		71 52
		17

		0
		145
		34 33 12 3 43 26 10 2 48 39*/
	}

}
