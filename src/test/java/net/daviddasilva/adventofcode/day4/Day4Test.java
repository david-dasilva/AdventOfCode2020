package net.daviddasilva.adventofcode.day4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day4Test {

    @DisplayName("For Part 1")
    @Nested
    class Part1 {

        String filename = "/day4/example1.txt";

        @DisplayName("It should solve example")
        @Test
        void shouldSolveExample1() {
            var day4 = new Day4(filename);

            assertThat(day4.solvePart1()).isEqualTo(2);
        }

        @DisplayName("It should solve to validated solution")
        @Test
        void shouldSolvePart1() {
            var filename = "/day4/input.txt";

            var day4 = new Day4(filename);
            assertThat(day4.solvePart1()).isEqualTo(213);
        }

        @DisplayName("It should validate passport will all fields")
        @Test
        void correctPasswordShouldBeValid() {
            Passport passport = new Passport("""
                ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
                byr:1937 iyr:2017 cid:147 hgt:183cm""");

            assertThat(passport.hasMandatoryFields()).isTrue();
        }

        @DisplayName("It should invalidate incomplete passports")
        @Test
        void incorrectPasswordShouldBeInValid() {
            Passport passport2= new Passport("""
               iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
               hcl:#cfa07d byr:1929""");

            Passport passport4 = new Passport("""
                hcl:#cfa07d eyr:2025 pid:166559648
                iyr:2011 ecl:brn hgt:59in""");

            assertThat(passport2.hasMandatoryFields()).isFalse();
            assertThat(passport4.hasMandatoryFields()).isFalse();
        }

        @DisplayName("It should should validate North Pole Credentials")
        @Test
        void NPCPasswordShouldBeValid() {
            Passport passport = new Passport("""
                                            hcl:#ae17e1 iyr:2013
                                            eyr:2024
                                            ecl:brn pid:760753108 byr:1931
                                            hgt:179cm""");

            assertThat(passport.hasMandatoryFields()).isTrue();
        }
    }

}
