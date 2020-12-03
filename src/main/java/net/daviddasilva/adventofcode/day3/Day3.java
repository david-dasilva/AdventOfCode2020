package net.daviddasilva.adventofcode.day3;

import net.daviddasilva.adventofcode.utils.ReadUtils;

import java.util.List;

public class Day3 {

    public static char TREE = '#';

    public static void main(String[] args) {
        var filename = "/day3/input.txt";

        var day3 = new Day3();

        System.out.println("Part 1 : " + day3.solvePart1(filename));
    }

    public int solvePart1(String filename) {
        // right 3 down 1
        List<String> lines = ReadUtils.asStringList(filename);
        var startPosition = 0;
        var trees = 0;

        System.out.println(lines.get(0)); // for pretty display

        for (int i = 1; i < lines.size(); i++) {
            startPosition += 3;
            if (getElementAtPosition(lines.get(i), startPosition) == TREE) {
                trees++;
            }
        }
        return trees;
    }


    char getElementAtPosition(String line, int pos) {
        int length = line.length();
        if (pos >= length) {
            System.out.print(line);
            return getElementAtPosition(line,pos - length);
        }

        char element = line.charAt(pos);
        var debugLine = line.toCharArray();
        debugLine[pos] = element == TREE ? 'X' : 'O';
        System.out.println(debugLine);
        return element;
    }
}
