package dev.aymee;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultiplierTest {
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    private ByteArrayOutputStream out;
    private Multiplier multi;
    
    @BeforeEach
    public void setUp() {
       out=new ByteArrayOutputStream();
       System.setOut(new PrintStream(out));      
    }

    @AfterEach
    public void restoreSystemIO() {
      System.setOut(originalOut);
      System.setIn(originalIn);
    }

    @Test
    public void EntryIsInteger(){
       String simulatedEntry="5\n";
       ByteArrayInputStream in= new ByteArrayInputStream(simulatedEntry.getBytes());
       
       multi = new Multiplier(in);
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
       ByteArrayInputStream in = new ByteArrayInputStream(simulatedEntry.getBytes());
       
       multi = new Multiplier(in);
       multi.Multiply();

       String output=out.toString();

       assertThat(output, containsString("Debe escribir un número, intente de nuevo"));

    }

}
