package net.daviddasilva.adventofcode.day4;

import net.daviddasilva.adventofcode.utils.ReadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

    private static final Logger logger = LoggerFactory.getLogger(Day4.class);

    private final String data;


    public static void main(String[] args) {
        Day4 day4 = new Day4("/day4/input.txt");

        logger.info("Part 1 Solution \t⭐\t\t{} ", day4.solvePart1());
        //logger.info("Part 1 Solution \t⭐⭐\t{}", day1.solvePart1());
    }

    public Day4(String filename) {
        this.data = ReadUtils.asString(filename);
    }

    public long solvePart1() {
        return extractPassportEntries().stream()
                .map(Passport::hasMandatoryFields)
                .filter(valid -> valid)
                .count();
    }

    List<Passport> extractPassportEntries() {
        return Arrays.stream(data.split("\\n\\n"))
                .map(Passport::new)
                .collect(Collectors.toList());
    }
}
