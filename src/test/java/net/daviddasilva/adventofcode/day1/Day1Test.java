package net.daviddasilva.adventofcode.day1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1Test {

    @Test
    void shouldSolveExample() {
        var filename = "/day1/example1.txt";

        var day1 = new Day1();
        assertThat(day1.solvePart1(filename)).isEqualTo(514579);
    }
}
