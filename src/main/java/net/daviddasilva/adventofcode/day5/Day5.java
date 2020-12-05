package net.daviddasilva.adventofcode.day5;

import net.daviddasilva.adventofcode.day4.Day4;
import net.daviddasilva.adventofcode.utils.ReadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {
    private static final Logger logger = LoggerFactory.getLogger(Day4.class);

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
                .map(this::getSeat)
                .max(Comparator.comparing(Seat::getId))
                .map(Seat::getId)
                .orElse(0L);
    }

    public long solvePart2() {
        List<Long> seatsId = data.stream()
                .map(this::getSeat)
                .map(Seat::getId)
                .sorted()
                .collect(Collectors.toList());

        var previousSeatId = seatsId.get(0);
        for (Long seat : seatsId) {
            if (seat - previousSeatId > 1) {
                return seat -1;
            }
            previousSeatId = seat;
        }

        throw new IllegalStateException("Should have found a missing seat");
    }


    Seat getSeat(String input) {

        String binaryInput = input.replace('F', '0')
                .replace('B', '1')
                .replace('L', '0')
                .replace('R', '1');

        var column = binaryInput.substring(0, 7);
        var row = binaryInput.substring(7, 10);

        return new Seat(Long.valueOf(column, 2), Long.valueOf(row, 2));
    }
}
