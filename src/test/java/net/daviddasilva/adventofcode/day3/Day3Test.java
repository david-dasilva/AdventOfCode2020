package net.daviddasilva.adventofcode.day3;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3Test {

    String filename = "/day3/example1.txt";

    @Test
    void shouldSolveExample1() {
        var day3 = new Day3(filename);

        assertThat(day3.solvePart1()).isEqualTo(7);
    }

    @Test
    void shouldSolveExample2() {
        var day3 = new Day3(filename);

        assertThat(day3.solvePart2()).isEqualTo(336);
    }

    @Test
    void shouldSolveRide1Right1Down() {
        var day3 = new Day3(filename);

        assertThat(day3.ride(1, 1)).isEqualTo(2);
    }

    @Test
    void shouldSolveRide3Right1Down() {
        var day3 = new Day3(filename);

        assertThat(day3.ride(3, 1)).isEqualTo(7);
    }

    @Test
    void shouldSolveRide5Right1Down() {
        var day3 = new Day3(filename);

        assertThat(day3.ride(5, 1)).isEqualTo(3);
    }

    @Test
    void shouldSolveRide7Right1Down() {
        var day3 = new Day3(filename);

        assertThat(day3.ride(7, 1)).isEqualTo(4);
    }

    @Test
    void shouldSolveRide1Right2Down() {
        var day3 = new Day3(filename);

        assertThat(day3.ride(1, 2)).isEqualTo(2);
    }

    @Test
    void shouldGetTheCharAtPositionWithinLine() {
        var line = "..#........";
        var day3 = new Day3(filename);
        assertThat(day3.getElementAtPosition(line, 2)).isEqualTo('#');
    }

    @Test
    void shouldGetTheCharAtPositionByLoopingTheLineOneTime() {
        var line = "..#........";
        var day3 = new Day3(filename);
        assertThat(day3.getElementAtPosition(line, 13)).isEqualTo('#');
    }

    @Test
    void shouldGetTheCharAtPositionByLoopingTheLineMultipleTimes() {
        var line = "..#........";
        var day3 = new Day3(filename);
        assertThat(day3.getElementAtPosition(line, 24)).isEqualTo('#');
    }

    @Test
    void shouldGetTheCharAtPositionCaseLastChar() {
        var line = "..........#";
        var day3 = new Day3(filename);
        assertThat(day3.getElementAtPosition(line, 10)).isEqualTo('#');
    }

    @Test
    void shouldGetTheCharAtPositionCasePosIsLineLenght() {
        var line = "#..........";
        var day3 = new Day3(filename);
        assertThat(day3.getElementAtPosition(line, line.length())).isEqualTo('#');
    }
}