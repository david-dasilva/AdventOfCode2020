package net.daviddasilva.adventofcode.utils;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReadUtils {

    private ReadUtils() {}

    public static String asString(final String path) {
        try {
            final URL resource = ReadUtils.class.getResource(path);
            return Files.readString(Path.of(resource.getFile()));
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to read file from: " + path, e);
        }
    }

    public static List<String> asStringList(final String path) {
        try {
            final URL resource = ReadUtils.class.getResource(path);
            return Files.readAllLines(Path.of(resource.getFile()));
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to read file from: " + path, e);
        }
    }

    public static List<String> asGroupList(final String path) {
        try {
            final URL resource = ReadUtils.class.getResource(path);
            String allLines = Files.readString(Path.of(resource.getFile()));
            return List.of(allLines.split("\\n\\n"));
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to read file from: " + path, e);
        }
    }

    public static List<Integer> asIntList(final String path) {
        try {
            final URL resource = ReadUtils.class.getResource(path);
            return Files.readAllLines(Path.of(resource.getFile()))
                    .stream()
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to read file from: " + path, e);
        }
    }

}
