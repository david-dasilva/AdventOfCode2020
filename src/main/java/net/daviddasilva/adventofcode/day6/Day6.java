package net.daviddasilva.adventofcode.day6;

import net.daviddasilva.adventofcode.utils.ReadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day6 {
    private static final Logger logger = LoggerFactory.getLogger(Day6.class);

    private final List<String> data;

    public static void main(String[] args) {
        Day6 day6 = new Day6("/day6/input.txt");

        logger.info("Part 1 Solution \t⭐\t\t{} ", day6.solvePart1());
        logger.info("Part 2 Solution \t⭐⭐\t{}", day6.solvePart2());
    }


    public Day6(String filename) {
        this.data = ReadUtils.asGroupList(filename);
    }

    public long solvePart1() {
        return countDistinctResponses().reduce(0L, Long::sum);
    }


    Stream<Long> countDistinctResponses() {
        return data.stream()
                .map(group -> group.replaceAll("[\n\r]", ""))
                .map(Day6::countDistinctResponseForGroup);
    }

    static Long countDistinctResponseForGroup(String group) {
        return group.chars().distinct().count();
    }

    public long solvePart2() {
        return countCommonResponses().reduce(0L, Long::sum);
    }

    Stream<Long> countCommonResponses() {
        return data.stream()
                .map(Day6::countCommonResponseForGroup);
    }

    static long countCommonResponseForGroup(String group) {
        var answers = group.lines().collect(Collectors.toList());

        String commonResponses = answers.get(0);
        for (int i = 1; i < answers.size(); i++) {
            var commonResponsesWithPrevious = getCommonResponses(answers.get(i), answers.get(i-1));
            commonResponses = getCommonResponses(commonResponsesWithPrevious, commonResponses);
        }

        return countDistinctResponseForGroup(commonResponses);
    }

    static String getCommonResponses(String answer1, String answer2) {
        if (answer2.isEmpty()) { // Regex would fail with empty string
            return "";
        }
        return answer1.replaceAll("[^" + answer2 + "]", "");
    }
}
