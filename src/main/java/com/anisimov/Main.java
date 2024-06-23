package com.anisimov;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/10m.txt";
        Utils utils = new Utils(path);

        System.out.println(utils.findMax());
        System.out.println(utils.findMin());
        System.out.println(utils.findMedian());
        System.out.println(utils.findAverage());
        System.out.println(utils.findLongestDecreasingSequence());
        System.out.println(utils.findLongestIncreasingSequence());

    }




}