package com.anisimov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    public final ArrayList<Integer> list;
    public ArrayList<Integer> listClone;

    public Utils(String path) throws IOException {
        this.list = new ArrayList<>();
        loadFile(path);
    }

    public int findMax() {
        int max = Integer.MIN_VALUE;
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public int findMin() {
        int min = Integer.MAX_VALUE;
        for (int num : list) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public double findMedian() {
        double median = findAtK(list.size() / 2, new ArraySubListView(list));
        if (list.size() % 2 == 0) {
            int left = findAtK(list.size() / 2 - 1, new ArraySubListView(list));
            median = (median + left) / 2;
        }

        return median;
    }

    private int findAtK(int k, ArraySubListView view) {
        if (view.size() == 1) {
            return view.get(0);
        }

        int pivotIndex = partition(view);
        if (k == pivotIndex) {
            return view.get(pivotIndex);
        }

        if (pivotIndex < k) {
            ArraySubListView rightSublist = new ArraySubListView(view, pivotIndex + 1, view.size());
            return findAtK(k - pivotIndex - 1, rightSublist);
        } else {
            ArraySubListView leftSublist = new ArraySubListView(view, 0, pivotIndex);
            return findAtK(k, leftSublist);
        }


    }

    private int partition(ArraySubListView view) {
        int pivot = view.get(view.size() - 1);
        int index = 0;

        for (int i = 0; i < view.size(); i++) {
            if (view.get(i) <= pivot) {
                swap(view, i, index);
                index++;
            }
        }

        return index - 1;
    }

    public void swap(ArraySubListView view, int i, int j) {
        int temp = view.get(i);
        view.set(i, view.get(j));
        view.set(j, temp);
    }

    public double findAverage() {
        long sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum / (double) list.size();
    }

    private void loadFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            list.add(Integer.parseInt(line.trim()));
        }
        listClone = new ArrayList<>(list);
        br.close();
    }


    public ArrayList<Integer> findLongestIncreasingSequence() {
        ArrayList<Integer> longestSeq = new ArrayList<>();
        ArrayList<Integer> currentSeq = new ArrayList<>();

        for (Integer integer : listClone) {
            if (currentSeq.isEmpty() || integer > currentSeq.getLast()) {
                currentSeq.add(integer);
            } else {
                if (currentSeq.size() > longestSeq.size()) {
                    longestSeq = new ArrayList<>(currentSeq);
                }
                currentSeq.clear();
                currentSeq.add(integer);
            }
        }

        if (currentSeq.size() > longestSeq.size()) {
            longestSeq = currentSeq;
        }

        return longestSeq;
    }

    public ArrayList<Integer> findLongestDecreasingSequence() {
        ArrayList<Integer> longestSeq = new ArrayList<>();
        ArrayList<Integer> currentSeq = new ArrayList<>();

        for (Integer integer : listClone) {
            if (currentSeq.isEmpty() || integer < currentSeq.getLast()) {
                currentSeq.add(integer);
            } else {
                if (currentSeq.size() > longestSeq.size()) {
                    longestSeq = new ArrayList<>(currentSeq);
                }
                currentSeq.clear();
                currentSeq.add(integer);
            }
        }

        if (currentSeq.size() > longestSeq.size()) {
            longestSeq = currentSeq;
        }

        return longestSeq;
    }
}
