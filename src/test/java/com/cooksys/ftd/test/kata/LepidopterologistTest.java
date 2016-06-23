package com.cooksys.ftd.test.kata;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import com.cooksys.ftd.kata.impl.Lepidopterologist;
import com.cooksys.ftd.kata.model.*;


public class LepidopterologistTest {
	
	private Butterpillar testerpillar = new Butterpillar(1.2, 37);
	private Catterfly testerfly = new Catterfly(2.76, 27.75);
	private Sample testSample = new Sample(testerpillar, testerfly);
	private GrowthModel growthModel = new GrowthModel(2.3, .75);
	private Species testSpecies = new Species("Embracing", growthModel, 1);
	private Lepidopterologist research = new Lepidopterologist();
	
	
	@Test
	public void testRegisterSpecies() {
		assertEquals(true, research.registerSpecies(testSpecies));
	}

	@Test
	public void testIsSpeciesRegistered() {
		assertEquals(true, research.registerSpecies(testSpecies));
	}

	@Test
	public void testFindSpeciesForSample() {
		boolean check = research.registerSpecies(testSpecies);
		if (check) {
			assertEquals(Optional.of(testSpecies), research.findSpeciesForSample(testSample));
		} else {
			assertEquals(Optional.empty(), research.findSpeciesForSample(testSample));
		}
	}

	@Test
	public void testRecordSample() {
		boolean check = research.registerSpecies(testSpecies);
		if (check) {
			assertEquals(true, research.recordSample(testSample));
		} else {	
			assertEquals(false, research.recordSample(testSample));
		}
	}

	@Test
	public void testGetSamplesForSpecies() {
		boolean check = research.registerSpecies(testSpecies) && research.recordSample(testSample);
		List<Sample> testList = new ArrayList<Sample>();
		if (check) {
			testList.add(testSample);
			assertEquals(testList, research.getSamplesForSpecies(testSpecies));
		} else {
			assertEquals(testList, research.getSamplesForSpecies(testSpecies));
		}
	}

	@Test
	public void testGetRegisteredSpecies() {
		List<Species> testList = new ArrayList<Species>();
		testList.add(testSpecies);
		
		research.registerSpecies(testSpecies);
		research.recordSample(testSample);
		assertEquals(testList, research.getRegisteredSpecies());
	}

	@Test
	public void testGetTaxonomy() {
		List<Sample> testList = new ArrayList<Sample>();
		testList.add(testSample);
		Map<Species, List<Sample>> testMap = new TreeMap<>();
		testMap.put(testSpecies, testList);
		research.registerSpecies(testSpecies);
		research.recordSample(testSample);
		assertEquals(testMap, research.getTaxonomy());
	}

}
