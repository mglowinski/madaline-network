package com.mglowinski.madaline;

import com.mglowinski.madaline.network.MadelineNetwork;
import com.mglowinski.madaline.network.MadelineProcessor;
import com.mglowinski.madaline.network.Template;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MadelineProcessor madelineProcessor = new MadelineProcessor();
        MadelineNetwork madelineNetwork = madelineProcessor.teach(Template.getAllTemplates());
        List<List<Double>> results = madelineProcessor.process(madelineNetwork, Template.getAllFakeTemplates());

        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + " wzorzec testowy");
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print("neuron " + (j + 1) + "=" + round(results.get(i).get(j)) + " ");
            }
            printResult(results.get(i));
        }
    }

    private static void printResult(List<Double> result) {
        Double max = Double.MIN_VALUE;
        int maxIndex = 0;

        for (int j = 0; j < result.size(); j++) {
            if (max < result.get(j)) {
                max = result.get(j);
                maxIndex = j;
            }
        }

        System.out.println();
        System.out.println("Sieć rozpoznała wzorzec: " + (maxIndex + 1));
        System.out.println("Stopień rozpoznania: " + round(max));
        System.out.println();
    }

    private static double round(double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }


}
