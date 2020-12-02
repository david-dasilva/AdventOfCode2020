package net.daviddasilva.adventofcode.day2;

import net.daviddasilva.adventofcode.utils.ReadUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {

    static final Pattern PATTERN = Pattern.compile("([0-9]+)-([0-9]+) ([a-z]): ([a-zA-Z]+)");

    public static void main(String[] args) {

        var filename = "/day2/input.txt";

        var day2 = new Day2();

        System.out.println("Part 1 : " + day2.solvePart1(filename));

    }

    public int solvePart1(String filename) {

        List<String> lines = ReadUtils.asStringList(filename);
        var validPasswords = 0;
        for (String line : lines) {
            Matcher matcher = PATTERN.matcher(line);

            if (!matcher.find() || matcher.groupCount() < 4) {
                throw new IllegalArgumentException("Line did not match pattern");
            }
            int min = Integer.parseInt(matcher.group(1));
            int max = Integer.parseInt(matcher.group(2));
            char letter = matcher.group(3).charAt(0);
            String password = matcher.group(4);

            long occurrences = countOccurrences(password, letter);

            if (occurrences <= max && occurrences >= min) {
                validPasswords++;
            }
        }
        return validPasswords;
    }

    private long countOccurrences(String password, char letter) {
        return password.chars()
                .filter(c -> c == letter)
                .count();
    }
}
