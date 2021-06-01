package test.ohce.unit;

import ohce.Clock;
import ohce.Ohce;
import ohce.Printer;
import ohce.UserInput;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OhceTest {

    private Clock clock;
    private UserInput userInput;
    private Printer printer;
    private Ohce ohce;

    @Before
    public void setUp() throws Exception {
        clock = mock(Clock.class);
        userInput = mock(UserInput.class);
        printer = mock(Printer.class);
        ohce = new Ohce(clock, userInput, printer);

    }

    @Test
    public void starts_and_stops() {
        when(clock.getTime()).thenReturn(11);
        when(userInput.get()).thenReturn("Stop!");

        ohce.run("Paco");

        verify(printer).print("¡Buenos días Paco!");
        verify(printer).print("Adios Paco");
        verify(printer, times(2)).print(anyString());
    }

    @Test
    public void reverses_words() {
        when(clock.getTime()).thenReturn(11);
        when(userInput.get()).thenReturn("hola","Stop!");

        ohce.run("Paco");

        verify(printer).print("¡Buenos días Paco!");
        verify(printer).print("aloh");
        verify(printer).print("Adios Paco");
        verify(printer, times(3)).print(anyString());
    }

    @Test
    public void detects_palindromes() {
        when(clock.getTime()).thenReturn(11);
        when(userInput.get()).thenReturn("hannah","Stop!");

        ohce.run("Paco");

        verify(printer).print("¡Buenos días Paco!");
        verify(printer).print("hannah");
        verify(printer).print("¡Bonita palabra!");
        verify(printer).print("Adios Paco");
        verify(printer, times(4)).print(anyString());
    }
}
