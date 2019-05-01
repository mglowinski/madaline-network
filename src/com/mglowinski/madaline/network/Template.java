package com.mglowinski.madaline.network;

import java.util.ArrayList;
import java.util.List;

public class Template {

    private static final char[][] xTemplate = {
            {'#', '-', '-', '#'},
            {'-', '#', '#', '-'},
            {'-', '#', '#', '-'},
            {'#', '-', '-', '#'},
    };

    private static final char[][] yTemplate = {
            {'#', '-', '-', '#'},
            {'-', '#', '#', '-'},
            {'-', '#', '-', '-'},
            {'#', '-', '-', '-'},
    };

    private static final char[][] zTemplate = {
            {'#', '#', '#', '#'},
            {'-', '-', '#', '-'},
            {'-', '#', '-', '-'},
            {'#', '#', '#', '#'},
    };

    private static final char[][] xFakeTemplate = {
            {'-', '-', '-', '-'},
            {'-', '#', '-', '#'},
            {'-', '-', '#', '-'},
            {'-', '#', '-', '#'},
    };

    private static final char[][] yFakeTemplate = {
            {'#', '-', '-', '#'},
            {'-', '-', '#', '-'},
            {'-', '#', '-', '-'},
            {'#', '-', '-', '-'},
    };

    private static final char[][] zFakeTemplate = {
            {'#', '#', '-', '#'},
            {'-', '-', '#', '-'},
            {'-', '#', '-', '-'},
            {'#', '#', '#', '#'},
    };

    public static List<char[][]> getAllTemplates() {
        return getChars(xTemplate, yTemplate, zTemplate);
    }

    public static List<char[][]> getAllFakeTemplates() {
        return getChars(xFakeTemplate, yFakeTemplate, zFakeTemplate);
    }

    private static List<char[][]> getChars(char[][] xTemplate,
                                           char[][] yTemplate,
                                           char[][] zTemplate) {
        List<char[][]> allTemplates = new ArrayList<>();

        allTemplates.add(xTemplate);
        allTemplates.add(yTemplate);
        allTemplates.add(zTemplate);

        return allTemplates;
    }

}
