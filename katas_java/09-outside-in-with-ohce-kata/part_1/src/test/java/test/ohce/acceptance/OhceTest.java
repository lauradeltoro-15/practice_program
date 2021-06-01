package test.ohce.acceptance;

import ohce.Clock;
import ohce.Ohce;
import ohce.Printer;
import ohce.UserInput;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OhceTest {
    @Test
    public void ohce_during_the_morning() {
        Clock clock = mock(Clock.class);
        UserInput userInput = mock(UserInput.class);
        Printer printer = mock(Printer.class);
        Ohce ohce = new Ohce(clock, userInput, printer);
        when(clock.getTime()).thenReturn(11);
        when(userInput.get()).thenReturn("hola", "oto", "stop", "Stop!");

        ohce.run("Pedro");

        verify(printer).print("¡Buenos días Pedro!");
        verify(printer).print("aloh");
        verify(printer).print("oto");
        verify(printer).print("¡Bonita palabra!");
        verify(printer).print("pots");
        verify(printer).print("Adios Pedro");

    }
}
