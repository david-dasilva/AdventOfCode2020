package net.daviddasilva.adventofcode.day2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day2Test {

    @Test
    void shouldSolveExample1() {
        var filename = "/day2/example1.txt";

        var day2 = new Day2();

        assertThat(day2.solvePart1(filename)).isEqualTo(2);
    }

    @Test
    void shouldSolveExample2() {
        var filename = "/day2/example1.txt";

        var day2 = new Day2();

        assertThat(day2.solvePart2(filename)).isEqualTo(1);
    }
}
