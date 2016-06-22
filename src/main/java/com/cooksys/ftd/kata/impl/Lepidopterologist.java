package com.cooksys.ftd.kata.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import com.cooksys.ftd.kata.ILepidopterologist;
import com.cooksys.ftd.kata.model.Butterpillar;
import com.cooksys.ftd.kata.model.Catterfly;
import com.cooksys.ftd.kata.model.GrowthModel;
import com.cooksys.ftd.kata.model.Sample;
import com.cooksys.ftd.kata.model.Species;

public class Lepidopterologist implements ILepidopterologist {

	private List<Species> registeredSpecies = new ArrayList<Species>();
	private List<Sample> recordedSamples = new ArrayList<Sample>();
	
	@Override
	public boolean registerSpecies(Species species) {
		if (isSpeciesRegistered(species)) {
			return false;
		} else {
		registeredSpecies.add(species);
		return true;
		}
	}

	@Override
	public boolean isSpeciesRegistered(Species species) {
		if (registeredSpecies.contains(species)) {
			return true;
		} else {
		return false;
		}
	}
	private GrowthModel createGrowthModel(Sample sample) {
		GrowthModel testModel = new GrowthModel();
		Butterpillar testerPillar = sample.getButterpillar();
		Catterfly testerFly = sample.getCatterfly();
		testModel.setLengthToWingspan(testerFly.getWingspan() / testerPillar.getLength());
		testModel.setLeavesEatenToWeight(testerFly.getWeight() / testerPillar.getLeavesEaten());
		return testModel;
	}
	@Override
	public Optional<Species> findSpeciesForSample(Sample sample) {
		GrowthModel testModel = createGrowthModel(sample);
		for (Species s: registeredSpecies) {
			if (s.isMember(testModel));
				return Optional.of(s);
		}
		return Optional.empty();
	}

	@Override
	public boolean recordSample(Sample sample) {
		Optional<Species> optionalSpecies = findSpeciesForSample(sample);
		if (optionalSpecies.isPresent()) {
			Species sampleSpecies = optionalSpecies.get();
			sample.setSpecies(sampleSpecies.getName());
			recordedSamples.add(sample);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Sample> getSamplesForSpecies(Species species) {
		List<Sample> samplesList = new ArrayList<>();
		for (Sample s: recordedSamples) {
			if (s.getSpecies() == species.getName()) {
				samplesList.add(s);
			}
		}
		return samplesList;
	}

	@Override
	public List<Species> getRegisteredSpecies() {
		return registeredSpecies;
	}

	@Override
	public Map<Species, List<Sample>> getTaxonomy() {
		Map<Species, List<Sample>> taxonomy = new TreeMap<>();
		for (Species s: registeredSpecies) {
			taxonomy.put(s, getSamplesForSpecies(s));
		}
		return taxonomy;
	}

}
