package net.daviddasilva.adventofcode.day6;

import net.daviddasilva.adventofcode.day4.Day4;
import net.daviddasilva.adventofcode.utils.ReadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day6 {
    private static final Logger logger = LoggerFactory.getLogger(Day6.class);

    private final String data;

    public static void main(String[] args) {
        Day6 day6 = new Day6("/day6/input.txt");

        logger.info("Part 1 Solution \t⭐\t\t{} ", day6.solvePart1());
        //logger.info("Part 2 Solution \t⭐⭐\t{}", day6.solvePart2());
    }


    public Day6(String filename) {
        this.data = ReadUtils.asString(filename);
    }

    public long solvePart1() {
        return extractGroupResponses().stream()
                .reduce(0L, Long::sum);
    }


    List<Long> extractGroupResponses() {
        return Arrays.stream(data.split("\\n\\n"))
                .map(group -> group.replaceAll("[\n\r]", ""))
                .map(String::chars)
                .map(chars -> chars.distinct().count())
                .collect(Collectors.toList());
    }

}
