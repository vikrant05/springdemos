package com.vikrant.main;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {

        int row = crossword.length;
        int col = crossword[0].length();
        char[][] crosswordMatrix = new char[row][col];
        Map<String,Boolean> listOfWords = new TreeMap<String, Boolean>();

        listOfWords = Arrays.asList(words.split(";")).stream().collect(Collectors.toMap(Function.identity(), str -> Boolean.FALSE));

        for(int i=0; i<row; i++) {
            crosswordMatrix[i] = crossword[i].toCharArray();
        }

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                final int currentRow = i;
                final int currentCol = j;

                for (Map.Entry<String, Boolean> entry : listOfWords.entrySet()) {
                    if(tryInLeft(crosswordMatrix,currentRow,currentCol,entry.getKey())) {
                        entry.setValue(Boolean.TRUE);
                    } else if(tryBelow(crosswordMatrix,currentRow,currentCol,entry.getKey())) {
                        entry.setValue(Boolean.TRUE);
                    }
                }
            }
        }




        return null;

    }

    public static boolean tryInLeft(char[][] crossWord, int row, int col, String word) {
        for(int i=col; i<crossWord[row].length; i++) {
            if(crossWord[row][i] == '-')
        }
    }

    public static boolean tryBelow(char[][] crossWord, int row, int col, String word) {

    }

}