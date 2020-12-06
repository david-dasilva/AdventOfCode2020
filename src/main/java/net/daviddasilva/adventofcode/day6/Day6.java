package net.daviddasilva.adventofcode.day6;

import net.daviddasilva.adventofcode.utils.ReadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {
    private static final Logger logger = LoggerFactory.getLogger(Day6.class);

    private final String data;

    public static void main(String[] args) {
        Day6 day6 = new Day6("/day6/input.txt");

        logger.info("Part 1 Solution \t⭐\t\t{} ", day6.solvePart1());
        logger.info("Part 2 Solution \t⭐⭐\t{}", day6.solvePart2());
    }


    public Day6(String filename) {
        this.data = ReadUtils.asString(filename);
    }

    public long solvePart1() {
        return countDistinctResponses().stream()
                .reduce(0L, Long::sum);
    }


    public long solvePart2() {
        return countCommonResponses().stream()
                .reduce(0L, Long::sum);
    }

    List<Long> countDistinctResponses() {
        return Arrays.stream(data.split("\\n\\n"))
                .map(group -> group.replaceAll("[\n\r]", ""))
                .map(Day6::countDistinctResponseForGroup)
                .collect(Collectors.toList());
    }

    static Long countDistinctResponseForGroup(String group) {
        return group.chars().distinct().count();
    }

    List<Long> countCommonResponses() {
        return Arrays.stream(data.split("\\n\\n"))
                .map(Day6::countCommonResponseForGroup)
                .collect(Collectors.toList());
    }

    static long countCommonResponseForGroup(String group) {
        var answers = group.lines()
                .map(Day6::sortAnswer)
                .collect(Collectors.toList());
        var nbOfAnswers = answers.size();
        if (nbOfAnswers == 1) {
            return answers.get(0).length();
        }

        String commonChars = answers.get(0);
        for (int i = 1; i < answers.size(); i++) {
            var commonAnswerWithPrevious = answers.get(i).replaceAll("[^" + answers.get(i-1) + "]", "");
            if (!commonChars.isEmpty()) {
                commonChars = commonAnswerWithPrevious.replaceAll("[^" + commonChars + "]", "");
            }
        }

        return countDistinctResponseForGroup(commonChars);
    }

    static String sortAnswer(String answer) {
        return answer.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
