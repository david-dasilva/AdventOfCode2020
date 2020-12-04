package net.daviddasilva.adventofcode.day4;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String BYR = "byr";
    private static final String IYR = "iyr";
    private static final String EYR = "eyr";
    private static final String HGT = "hgt";
    private static final String HCL = "hcl";
    private static final String ECL = "ecl";
    private static final String PID = "pid";

    private static final Pattern HEIGHT_PATTERN = Pattern.compile("^([0-9]+)(in|cm)$");
    private static final Pattern HEXA_COLOR_PATTERN = Pattern.compile("^#[0-9a-f]{6}$");
    private static final Pattern EYE_COLOR_PATTERN = Pattern.compile("^(amb|blu|brn|gry|grn|hzl|oth)$");
    private static final Pattern PID_PATTERN = Pattern.compile("^[0-9]{9}$");


    public static boolean passportHasMandatoryFields(Passport passport) {
        Map<String, String> fields = passport.fields();
        return fields.containsKey(BYR)
                && fields.containsKey(IYR)
                && fields.containsKey(EYR)
                && fields.containsKey(HGT)
                && fields.containsKey(HCL)
                && fields.containsKey(ECL)
                && fields.containsKey(PID);
    }

    public static boolean validatePassport(Passport passport) {
        return passportHasMandatoryFields(passport)
                && validateByr(passport.fields().get(BYR))
                && validateIyr(passport.fields().get(IYR))
                && validateEyr(passport.fields().get(EYR))
                && validateHgt(passport.fields().get(HGT))
                && validateHcl(passport.fields().get(HCL))
                && validateEcl(passport.fields().get(ECL))
                && validatePid(passport.fields().get(PID));
    }

    public static boolean validateByr(String byr) {
        int year = Integer.parseInt(byr);
        return between(1920, 2002, year);
    }

    public static boolean validateIyr(String iyr) {
        int year = Integer.parseInt(iyr);
        return between(2010, 2020, year);
    }

    public static boolean validateEyr(String eyr) {
        int year = Integer.parseInt(eyr);
        return between(2020, 2030, year);
    }

    public static boolean validateHgt(String hgt) {

        Matcher matcher = HEIGHT_PATTERN.matcher(hgt);
        if (!matcher.find() || matcher.groupCount() != 2) {
            return false;
        }
        String unit = matcher.group(2);
        int size = Integer.parseInt(matcher.group(1));

        if (unit.equals("in")) {
            return between(59, 76, size);
        } else if (unit.equals("cm")) {
            return between(105, 193, size);
        }
        return false;
    }

    public static boolean validateHcl(String hcl) {
        return HEXA_COLOR_PATTERN.matcher(hcl).matches();
    }

    public static boolean validateEcl(String ecl) {
        return EYE_COLOR_PATTERN.matcher(ecl).matches();
    }

    public static boolean validatePid(String pid) {
        return PID_PATTERN.matcher(pid).matches();
    }

    private static boolean between(int min, int max, int value) {
        return value >= min && value <= max;
    }
}
