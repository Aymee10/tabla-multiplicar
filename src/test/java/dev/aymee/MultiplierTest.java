package dev.aymee;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultiplierTest {
    

    @Test
    public void EntryIsInteger(){
       String simulatedEntry="5\n";
       System.setIn( new ByteArrayInputStream(simulatedEntry.getBytes()));
       ByteArrayOutputStream out=new ByteArrayOutputStream();
       System.setOut(new PrintStream(out));

       Multiplier multi=new Multiplier();
       multi.Multiply();

       String output=out.toString();

       assertThat(output,containsString("5 x 1 = 5"));
       assertThat(output,containsString("5 x 3 = 15"));
       assertThat(output,containsString("5 x 4 = 20"));
       assertThat(output,containsString("5 x 5 = 25"));
       assertThat(output,containsString("5 x 6 = 30"));
       assertThat(output,containsString("5 x 9 = 45"));
       assertThat(output,containsString("5 x 10 = 50"));
       assertThat(output, containsString("Escribe el número:"));

    }

    
    @Test
    public void EntryIsNotInteger(){
         String simulatedEntry="H\nAA\n2\n";
       System.setIn( new ByteArrayInputStream(simulatedEntry.getBytes()));
       ByteArrayOutputStream out=new ByteArrayOutputStream();
       System.setOut(new PrintStream(out));

       Multiplier multi=new Multiplier();
       multi.Multiply();

       String output=out.toString();

       assertThat(output, containsString("Debe escribir un número, intente de nuevo"));

    }

}
