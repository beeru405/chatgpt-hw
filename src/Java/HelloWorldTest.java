package com.Java
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class HelloWorldTest {
    @Test
    public void testHelloInput() {
        String input = "hello";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        HelloWorld.main(new String[]{});

        String output = "Hello, World!\n";
        assertEquals(output, systemOut());
    }

    @Test
    public void testNonHelloInput() {
        String input = "world";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        HelloWorld.main(new String[]{});

        String output = "Sorry, I only respond to 'hello'.\n";
        assertEquals(output, systemOut());
    }

    private String systemOut() {
        return outContent.toString();
    }
}
