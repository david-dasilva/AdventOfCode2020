package net.daviddasilva.adventofcode.day5;

public record Seat(long column, long row) {

    public long getId() {
        return (column() * 8) + row();
    }
}
