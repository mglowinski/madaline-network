package com.mglowinski.madaline.neuron;

import java.util.List;

public class DefaultNeuronProcessor {

    public double process(double[] inputs, MadelineOutputNeuron madelineOutputNeuron) {
        double sumResult = 0;
        List<Double> weights = madelineOutputNeuron.getWeights();

        for (int i = 0; i < inputs.length; i++) {
            sumResult += inputs[i] * weights.get(i);
        }

        return sumResult;
    }
}
