package com.cooksys.ftd.test.kata;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.cooksys.ftd.kata.model.*;

public class LepidopterologistTest {

	@Before
	public void before() {
		GrowthModel growthModel = new GrowthModel();
		growthModel.setLengthToWingspan(1.2);
		growthModel.setLeavesEatenToWeight(5.5);
		
		Species speciesTest = new Species();
		speciesTest.setName("Embracing");
		speciesTest.setGrowthModel(growthModel);
		speciesTest.setTolerance(1);
	}
	
	
	@Test
	public void testRegisterSpecies() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsSpeciesRegistered() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSpeciesForSample() {
		fail("Not yet implemented");
	}

	@Test
	public void testRecordSample() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSamplesForSpecies() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRegisteredSpecies() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTaxonomy() {
		fail("Not yet implemented");
	}

}
