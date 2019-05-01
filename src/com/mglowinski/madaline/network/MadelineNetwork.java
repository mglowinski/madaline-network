package com.mglowinski.madaline.network;

import com.mglowinski.madaline.neuron.MadelineOutputNeuron;

import java.util.ArrayList;
import java.util.List;

public class MadelineNetwork {

    private List<MadelineOutputNeuron> outputMadelineOutputNeurons = new ArrayList<>();

    MadelineNetwork(int numberOfChars) {
        for (int i = 0; i < numberOfChars; i++) {
            outputMadelineOutputNeurons.add(new MadelineOutputNeuron());
        }
    }

    void setOutputNeuronsWeights(List<double[]> weights) {
        for (int i = 0; i < outputMadelineOutputNeurons.size(); i++) {
            for (Double weight : weights.get(i)) {
                outputMadelineOutputNeurons.get(i).getWeights().add(weight);
            }
        }
    }

    MadelineOutputNeuron getOutput(int i) {
        return outputMadelineOutputNeurons.get(i);
    }

}
