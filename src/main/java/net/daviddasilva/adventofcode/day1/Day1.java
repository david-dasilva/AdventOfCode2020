package net.daviddasilva.adventofcode.day1;

import net.daviddasilva.adventofcode.utils.ReadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Day1 {

    private static final Logger logger = LoggerFactory.getLogger(Day1.class);

    private final List<Integer> data;

    public Day1(String filename) {
        this.data = ReadUtils.asIntList(filename);
    }

    public static void main(String[] args) {
        Day1 day1 = new Day1("/day1/input.txt");

        logger.info("Part 1 Solution \t⭐\t\t{} ", day1.solvePart1());
        logger.info("Part 2 Solution \t⭐⭐\t{}", day1.solvePart2());
    }

    public int solvePart1() {
        var checks = 0;
        long start = System.nanoTime();

        for (Integer a : data) {
            for (Integer b : data) {
                if (b.equals(a)) {
                    continue;
                }
                checks++;
                if (a + b == 2020) {
                    logger.debug("Solved part 1 in {} checks and {} ms", checks, (System.nanoTime() - start) / 1000000);
                    return a * b;
                }
            }
        }

        throw new IllegalArgumentException("Could not solve solution");
    }

    public int solvePart2() {
        var checks = 0;
        long start = System.nanoTime();


        for (Integer a : data) {
            for (Integer b : data) {
                if (b.equals(a)) {
                    continue;
                }
                for (Integer c : data) {
                    if (c.equals(b) || c.equals(a)) {
                        continue;
                    }
                    checks++;
                    if (a + b + c == 2020) {
                        logger.debug("Solved part 2 in {} checks and {} ms", checks, (System.nanoTime() - start) / 1000000);
                        return a * b * c;
                    }
                }
            }
        }

        throw new IllegalArgumentException("Could not solve solution");
    }
}
