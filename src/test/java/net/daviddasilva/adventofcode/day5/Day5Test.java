package net.daviddasilva.adventofcode.day5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day5Test {

    @DisplayName("For part 1")
    @Nested
    class Part1 {

        String filename = "/day5/example1.txt";

        @DisplayName("It should solve example")
        @Test
        void shouldSolveExample() {
            var day5 = new Day5(filename);

            assertThat(day5.solvePart1()).isEqualTo(820);
        }

        @DisplayName("It should solve to validated solution")
        @Test
        void shouldSolvePart1() {
            var filename = "/day5/input.txt";
            var day5 = new Day5(filename);

            assertThat(day5.solvePart1()).isEqualTo(989);
        }
    }
}
