package net.daviddasilva.adventofcode.day4;

import java.util.HashMap;
import java.util.Map;

public class Passport {
    private static final String BYR = "byr";
    private static final String IYR = "iyr";
    private static final String EYR = "eyr";
    private static final String HGT = "hgt";
    private static final String HCL = "hcl";
    private static final String ECL = "ecl";
    private static final String PID = "pid";
    private static final String CID = "cid";

    Map<String, String> fields = new HashMap<>();

    public Passport(String entry) {
        String[] keyValues = entry.split("[ \\n]");
        for (String keyValue : keyValues) {
            String[] split = keyValue.split(":");
            if(split.length == 2 && !split[1].isBlank()) {
                fields.put(split[0], split[1]);
            }
        }
    }

    public boolean hasMandatoryFields() {
        return this.fields.containsKey(BYR)
                && this.fields.containsKey(IYR)
                && this.fields.containsKey(EYR)
                && this.fields.containsKey(HGT)
                && this.fields.containsKey(HCL)
                && this.fields.containsKey(ECL)
                && this.fields.containsKey(PID);
    }

}
