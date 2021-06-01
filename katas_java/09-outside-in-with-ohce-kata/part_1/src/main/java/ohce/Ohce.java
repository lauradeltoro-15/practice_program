package ohce;

public class Ohce {
    private final Clock clock;
    private final UserInput userInput;
    private final Printer printer;

    public Ohce(Clock clock, UserInput userInput, Printer printer) {

        this.clock = clock;
        this.userInput = userInput;
        this.printer = printer;
    }

    public void run(String name) {
        greet(name);
        while (true) {
            String input = userInput.get();
            if(shouldStop(input)) {
                sayByeTo(name);
                return;
            }
            printer.print(reverse(input));
            if(isPalindrome(input)) {
                celebratePalindrome();
            }

        }


    }

    private void greet(String name) {
        printer.print("¡Buenos días " + name + "!");
    }

    private void celebratePalindrome() {
        printer.print("¡Bonita palabra!");
    }

    private boolean isPalindrome(String input) {
        return input.equals(reverse(input));
    }

    private void sayByeTo(String name) {
        printer.print("Adios " + name);
    }

    private boolean shouldStop(String input) {
        return input.equals("Stop!");
    }

    private String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

}
