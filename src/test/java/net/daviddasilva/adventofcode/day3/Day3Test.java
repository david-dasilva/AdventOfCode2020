package net.daviddasilva.adventofcode.day3;
import net.daviddasilva.adventofcode.day2.Day2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3Test {

    @Test
    void shouldSolveExample1() {
        var filename = "/day3/example1.txt";

        var day3 = new Day3();

        assertThat(day3.solvePart1(filename)).isEqualTo(7);
    }

    @Test
    void shouldGetTheCharAtPositionWithinLine() {
        var line = "..#........";
        var day3 = new Day3();
        assertThat(day3.getElementAtPosition(line, 2)).isEqualTo('#');
    }

    @Test
    void shouldGetTheCharAtPositionByLoopingTheLineOneTime() {
        var line = "..#........";
        var day3 = new Day3();
        assertThat(day3.getElementAtPosition(line, 13)).isEqualTo('#');
    }

    @Test
    void shouldGetTheCharAtPositionByLoopingTheLineMultipleTimes() {
        var line = "..#........";
        var day3 = new Day3();
        assertThat(day3.getElementAtPosition(line, 24)).isEqualTo('#');
    }

    @Test
    void shouldGetTheCharAtPositionCaseLastChar() {
        var line = "..........#";
        var day3 = new Day3();
        assertThat(day3.getElementAtPosition(line, 10)).isEqualTo('#');
    }

    @Test
    void shouldGetTheCharAtPositionCasePosIsLineLenght() {
        var line = "#..........";
        var day3 = new Day3();
        assertThat(day3.getElementAtPosition(line, line.length())).isEqualTo('#');
    }

/*    @Test
    void shouldSolveExample2() {
        var filename = "/day3/example1.txt";

        var day3 = new Day3();

        assertThat(day3.solvePart2(filename)).isEqualTo(1);
    }*/
}