package com.tekleo.utils.text;

import org.junit.Test;

import static org.junit.Assert.*;

public class TextFileParserTest {
    @Test
    public void test() {
        TextFileParser parser = TextFileParser.buildForFileInResourcesFolder("test.txt");
        parser.read();
        String text = parser.getText().trim();

        assertNotNull(text);
        assertFalse(text.isEmpty());
        assertEquals("sample text file", text);
    }
}
