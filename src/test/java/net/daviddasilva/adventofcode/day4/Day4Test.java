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
            Passport passport = Day4.buildPassport("""
                ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
                byr:1937 iyr:2017 cid:147 hgt:183cm""");

            assertThat(Validator.passportHasMandatoryFields(passport)).isTrue();
        }

        @DisplayName("It should invalidate incomplete passports")
        @Test
        void incorrectPasswordShouldBeInValid() {
            Passport passport2 = Day4.buildPassport("""
               iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
               hcl:#cfa07d byr:1929""");

            Passport passport4 = Day4.buildPassport("""
                hcl:#cfa07d eyr:2025 pid:166559648
                iyr:2011 ecl:brn hgt:59in""");

            assertThat(Validator.passportHasMandatoryFields(passport2)).isFalse();
            assertThat(Validator.passportHasMandatoryFields(passport4)).isFalse();
        }

        @DisplayName("It should should validate North Pole Credentials")
        @Test
        void NPCPasswordShouldBeValid() {
            var day4 = new Day4(filename);
            Passport passport = Day4.buildPassport("""
                                            hcl:#ae17e1 iyr:2013
                                            eyr:2024
                                            ecl:brn pid:760753108 byr:1931
                                            hgt:179cm""");

            assertThat(Validator.passportHasMandatoryFields(passport)).isTrue();
        }
    }

    @DisplayName("For Part 2")
    @Nested
    class Part2 {

        String example2 = "/day4/example2.txt";

        @DisplayName("It should solve example")
        @Test
        void shouldValidateExample2() {
            var day4 = new Day4(example2);

            assertThat(day4.solvePart2()).isEqualTo(4);
        }

        @DisplayName("It should solve to validated solution")
        @Test
        void shouldSolvePart2() {
            var filename = "/day4/input.txt";

            var day4 = new Day4(filename);
            assertThat(day4.solvePart2()).isEqualTo(147);
        }


        @DisplayName("should validate Birth Year")
        @Test
        void shouldValidateBYR() {
            assertThat(Validator.validateByr("2002")).isTrue();
           assertThat(Validator.validateByr("2003")).isFalse();
        }

        @DisplayName("should validate Issue Year")
        @Test
        void shouldValidateIYR() {
            assertThat(Validator.validateIyr("2010")).isTrue();
            assertThat(Validator.validateIyr("2009")).isFalse();
        }

        @DisplayName("should validate Expiration Year")
        @Test
        void shouldValidateEYR() {
            assertThat(Validator.validateEyr("2020")).isTrue();
            assertThat(Validator.validateEyr("2019")).isFalse();
        }

        @DisplayName("should validate Height")
        @Test
        void shouldValidateHgt() {
            assertThat(Validator.validateHgt("60in")).isTrue();
            assertThat(Validator.validateHgt("190cm")).isTrue();
            assertThat(Validator.validateHgt("190in")).isFalse();
            assertThat(Validator.validateHgt("190")).isFalse();
        }

        @DisplayName("should validate Hair color")
        @Test
        void shouldValidateHcl() {
            assertThat(Validator.validateHcl("#123abc")).isTrue();
            assertThat(Validator.validateHcl("123abz")).isFalse();
            assertThat(Validator.validateHcl("123abc")).isFalse();
        }

        @DisplayName("should validate Eye color")
        @Test
        void shouldValidateEcl() {
            assertThat(Validator.validateEcl("brn")).isTrue();
            assertThat(Validator.validateEcl("wat")).isFalse();
        }

        @DisplayName("should validate Passport id")
        @Test
        void shouldValidatePid() {
            assertThat(Validator.validatePid("000000001")).isTrue();
            assertThat(Validator.validatePid("0123456789")).isFalse();
        }
    }
}
