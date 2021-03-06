package net.daviddasilva.adventofcode.day6;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class Day6Test {

    @DisplayName("For part 1")
    @Nested
    class Part1 {

        @DisplayName("Should solve example 1")
        @Test
        void shouldSolveExample1() {

            var filename = "/day6/example1.txt";
            var day6 = new Day6(filename);

            assertThat(day6.solvePart1()).isEqualTo(11);
        }

        @DisplayName("It should solve to validated solution")
        @Test
        void shouldSolvePart1() {
            var filename = "/day6/input.txt";
            var day6 = new Day6(filename);

            assertThat(day6.solvePart1()).isEqualTo(6778);
        }

        @Test
        void shouldCountDistinctResponsesPerGroups() {

            var filename = "/day6/example1.txt";
            var day6 = new Day6(filename);
            var actual = day6.countDistinctResponses().collect(Collectors.toList());
            assertThat(actual.size()).isEqualTo(5);
            assertThat(actual.get(0)).isEqualTo(3);
            assertThat(actual.get(1)).isEqualTo(3);
            assertThat(actual.get(2)).isEqualTo(3);
            assertThat(actual.get(3)).isEqualTo(1);
            assertThat(actual.get(4)).isEqualTo(1);
        }
    }


    @DisplayName("For part 2")
    @Nested
    class Part2 {

        @DisplayName("Should solve example 2")
        @Test
        void shouldSolveExample2() {

            var filename = "/day6/example1.txt";
            var day6 = new Day6(filename);

            assertThat(day6.solvePart2()).isEqualTo(6);
        }

        @DisplayName("It should solve to validated solution")
        @Test
        void shouldSolvePart2() {
            var filename = "/day6/input.txt";
            var day6 = new Day6(filename);

            assertThat(day6.solvePart2()).isEqualTo(3406);
        }


        @Test
        void shouldCountCommonResponsePerGroup() {
            var filename = "/day6/example1.txt";
            var day6 = new Day6(filename);
            var actual = day6.countCommonResponses().collect(Collectors.toList());
            assertThat(actual.size()).isEqualTo(5);
            assertThat(actual.get(0)).isEqualTo(3);
            assertThat(actual.get(1)).isEqualTo(0);
            assertThat(actual.get(2)).isEqualTo(1);
            assertThat(actual.get(3)).isEqualTo(1);
            assertThat(actual.get(4)).isEqualTo(1);
        }
    }
}
