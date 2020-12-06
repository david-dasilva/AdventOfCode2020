package net.daviddasilva.adventofcode.day4;

import net.daviddasilva.adventofcode.utils.ReadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day4 {

    private static final Logger logger = LoggerFactory.getLogger(Day4.class);

    private final List<String> data;


    public static void main(String[] args) {
        Day4 day4 = new Day4("/day4/input.txt");

        logger.info("Part 1 Solution \t⭐\t\t{} ", day4.solvePart1());
        logger.info("Part 2 Solution \t⭐⭐\t{}", day4.solvePart2()); // 139 too low
    }

    public Day4(String filename) {
        this.data = ReadUtils.asGroupList(filename);
    }

    public long solvePart1() {
        return extractPassportEntries().stream()
                .map(Validator::passportHasMandatoryFields)
                .filter(valid -> valid)
                .count();
    }

    public long solvePart2() {
        return extractPassportEntries().stream()
                .map(Validator::validatePassport)
                .filter(valid -> valid)
                .count();
    }

    List<Passport> extractPassportEntries() {
        return data.stream()
                .map(Day4::buildPassport)
                .collect(Collectors.toList());
    }

    static Passport buildPassport(String entry) {
        Map<String, String> fields = new HashMap<>();
        String[] keyValues = entry.split("[ \\n]");
        for (String keyValue : keyValues) {
            String[] split = keyValue.split(":");
            if(split.length == 2 && !split[1].isBlank()) {
                fields.put(split[0], split[1]);
            }
        }
        return new Passport(fields);
    }


}
