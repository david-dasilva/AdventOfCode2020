package net.daviddasilva.adventofcode.day3;

import net.daviddasilva.adventofcode.utils.ReadUtils;

import java.util.List;

public class Day3 {

    public static char TREE = '#';
    private final String filename;

    public static void main(String[] args) {
        var day3 = new Day3("/day3/input.txt");

        System.out.println("Part 1 : " + day3.solvePart1());
        System.out.println("Part 2 : " + day3.solvePart2());
    }

    public Day3(String filename) {
        this.filename = filename;
    }

    public long solvePart1() {
        // right 3 down 1
        return ride( 3, 1);
    }

    public long solvePart2() {
        return ride(1, 1)
                * ride(3, 1)
                * ride(5, 1)
                * ride(7, 1)
                * ride(1, 2);
    }

    long ride(int right, int down) {
        List<String> lines = ReadUtils.asStringList(filename);
        var startPosition = 0;
        var trees = 0;

        System.out.println(lines.get(0)); // for pretty display

        for (int i = 0; i < lines.size() -down; i = i+down) {
            startPosition += right;
            var lineToRead = i+down;
            if (getElementAtPosition(lines.get(lineToRead), startPosition) == TREE) {
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
