package net.daviddasilva.adventofcode.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ReadUtilsTest {

    @Test
    public void shouldReadSimpleFile() {
        var filepath = "/utils/samplefile.txt";

        var content = ReadUtils.asString(filepath);

        assertThat(content).isEqualTo("this is data");
    }

/*    @Test
    public void shouldReadMultipleLines() {
        var filepath = "/utils/multilinefile.txt";

        var content = ReadUtils.asString(filepath);

        assertThat(content).isEqualTo("""
                this is
                on
                multiple lines""");
    }*/
}
