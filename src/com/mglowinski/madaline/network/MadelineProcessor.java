package com.mglowinski.madaline.network;

import com.mglowinski.madaline.neuron.DefaultNeuronProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.sqrt;

public class MadelineProcessor {

    public MadelineNetwork teach(List<char[][]> characters) {
        MadelineNetwork madelineNetwork = new MadelineNetwork(characters.size());
        List<Integer[]> flattenChars = getFlattenChars(characters);
        List<double[]> normalized = normalize(flattenChars);
        madelineNetwork.setOutputNeuronsWeights(normalized);
        return madelineNetwork;
    }

    private List<double[]> normalize(List<Integer[]> flattenChars) {
        List<double[]> normalizedVectors = new ArrayList<>();

        for (Integer[] values : flattenChars) {
            int ones = countOnes(values);
            normalizedVectors.add(normalize(values, ones));
        }

        return normalizedVectors;
    }

    private double[] normalize(Integer[] values, int blackPointsNumber) {
        double[] normalized = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            normalized[i] = values[i].equals(1) ? 1 / sqrt(blackPointsNumber) : 0;
        }

        return normalized;
    }

    private int countOnes(Integer[] values) {
        int result = 0;

        for (Integer value : values) {
            result += value == 1 ? 1 : 0;
        }

        return result;
    }

    private List<Integer[]> getFlattenChars(List<char[][]> characters) {
        return characters.stream()
                .map(this::flatten)
                .collect(Collectors.toList());
    }

    private Integer[] flatten(char[][] chars) {
        List<Integer> flattenVector = new ArrayList<>();

        for (char[] row : chars) {
            for (char character : row) {
                flattenVector.add(character == '#' ? 1 : 0);
            }
        }

        return flattenVector.toArray(new Integer[0]);
    }

    public List<List<Double>> process(MadelineNetwork madelineNetwork,
                                      List<char[][]> characters) {
        List<Integer[]> flattenChars = getFlattenChars(characters);
        List<double[]> normalized = normalize(flattenChars);
        return processNormalizedCharacters(madelineNetwork, normalized);
    }


    private List<List<Double>> processNormalizedCharacters(MadelineNetwork madelineNetwork,
                                                           List<double[]> normalizedCharacters) {
        DefaultNeuronProcessor neuronProcessor = new DefaultNeuronProcessor();
        List<List<Double>> results = new ArrayList<>();

        for (double[] normalizedCharacter : normalizedCharacters) {
            List<Double> neuronAnswers = new ArrayList<>();
            //check normalized character for each neuron output
            for (int j = 0; j < normalizedCharacters.size(); j++) {
                neuronAnswers.add(neuronProcessor.process(normalizedCharacter, madelineNetwork.getOutput(j)));
            }
            results.add(neuronAnswers);
        }

        return results;
    }
}
