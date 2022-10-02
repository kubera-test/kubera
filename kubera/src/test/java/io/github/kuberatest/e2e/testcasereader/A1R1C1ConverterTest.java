package io.github.kuberatest.e2e.testcasereader;

import io.github.kuberatest.e2e.testcasereader.excel.A1R1C1Converter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class A1R1C1ConverterTest {
    @Test
    public void column() {
        assertEquals(0, A1R1C1Converter.column("A1"));
        assertEquals(26, A1R1C1Converter.column("AA1"));
    }

    @Test
    public void row() {
        assertEquals(0, A1R1C1Converter.row("A1"));
        assertEquals(10, A1R1C1Converter.row("AB11"));
    }
}
