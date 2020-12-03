package net.daviddasilva.adventofcode.day1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1Test {

    @Test
    void shouldSolveExample1() {
        var filename = "/day1/example1.txt";

        var day1 = new Day1(filename);
        assertThat(day1.solvePart1()).isEqualTo(514579);
    }

    @Test
    void shouldSolveExample2() {
        var filename = "/day1/example1.txt";

        var day1 = new Day1(filename);
        assertThat(day1.solvePart2()).isEqualTo(241861950);
    }


    @Test
    void shouldSolvePart1() {
        var filename = "/day1/input.txt";

        var day1 = new Day1(filename);
        assertThat(day1.solvePart1()).isEqualTo(786811);
    }

    @Test
    void shouldSolvePart2() {
        var filename = "/day1/input.txt";

        var day1 = new Day1(filename);
        assertThat(day1.solvePart2()).isEqualTo(199068980);
    }
}
