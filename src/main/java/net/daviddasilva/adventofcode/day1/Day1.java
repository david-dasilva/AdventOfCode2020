package net.daviddasilva.adventofcode.day1;

import net.daviddasilva.adventofcode.utils.ReadUtils;

public class Day1 {

    public static void main(String[] args) {
        var filename = "/day1/input.txt";

        Day1 day1 = new Day1();

        System.out.println(day1.solvePart1(filename));
    }

    public int solvePart1(String filename) {

        var data = ReadUtils.asIntList(filename);

        for (Integer a : data) {
            for (Integer b : data) {
                if (a + b == 2020) {
                    return a * b;
                }
            }
        }

        throw new IllegalArgumentException("Could not solve solution");
    }
}
