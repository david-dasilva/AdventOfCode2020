package net.daviddasilva.adventofcode.day5;

import net.daviddasilva.adventofcode.utils.ReadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Day5 {
    private static final Logger logger = LoggerFactory.getLogger(Day5.class);

    private final List<String> data;


    public static void main(String[] args) {
        Day5 day5 = new Day5("/day5/input.txt");

        logger.info("Part 1 Solution \t⭐\t\t{} ", day5.solvePart1());
        logger.info("Part 2 Solution \t⭐⭐\t{}", day5.solvePart2());
    }

    public Day5(String filename) {
        data = ReadUtils.asStringList(filename);
    }


    public long solvePart1() {

        return data.stream()
                .map(this::getSeatId)
                .max(Long::compareTo)
                .orElseThrow();
    }

    public long solvePart2() {
        List<Long> seatsId = data.stream()
                .map(this::getSeatId)
                .sorted()
                .collect(Collectors.toList());

        return seatsId.stream()
                .filter(seatId -> !(seatsId.contains(seatId + 1) && seatsId.contains(seatId - 1)))
                .skip(1) // skip the first seat as instructed
                .findFirst()
                .map(aLong -> ++aLong)
                .orElseThrow();
    }

    long getSeatId(String input) {
        String binaryInput = input.replace('F', '0')
                .replace('B', '1')
                .replace('L', '0')
                .replace('R', '1');
        return Long.parseLong(binaryInput, 2);
    }
}
