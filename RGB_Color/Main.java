import java.util.*; 
import java.lang.*; 
import java.io.*;

public class Main {
    // Let's dive into colors, shall we?
    public static class RGB {
        private int red;
        private int green;
        private int blue;

        // Constructor time! Mixing colors :)
        public RGB(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public int getRed() { return red; } // Getting the red component

        public int getGreen() { // How much green?
            return green;
        }

        public int getBlue() { return blue; } // And the blue...

        // Brightness? Let's see
        public double calculateLuminance() {
            return 0.299 * red + 0.587 * green + 0.114 * blue;
        }

        public int calculateGrayscale() { // Grayscale, like old TV shows lol
            return (red + green + blue) / 3;
        }

        public String toHex() { // HEX, because why not?
            return String.format("#%02x%02x%02x", red, green, blue);
        }

        // Hex to RGB, it's magic time!
        public static RGB fromHex(String hex) {
            int r = Integer.parseInt(hex.substring(1, 3), 16);
            int g = Integer.parseInt(hex.substring(3, 5), 16);
            int b = Integer.parseInt(hex.substring(5, 7), 16);
            return new RGB(r, g, b);
        }
    }

    // Main method - let's test this out
    public static void main(String[] args) {
        RGB coolColor = new RGB(102, 205, 170); // creating a cool color
        System.out.println("RGB Values: " + coolColor.getRed() + ", " + coolColor.getGreen() + ", " + coolColor.getBlue());

        System.out.println("Luminance: "+ coolColor.calculateLuminance()); // how bright?

        // grayscale value
        System.out.println("Grayscale Value: " + coolColor.calculateGrayscale());

        String hexCode = coolColor.toHex(); // to hex
        System.out.println("Hexadecimal Representation: " + hexCode);

        // And back from hex
        RGB hexColor = RGB.fromHex(hexCode);
        System.out.println("Back from Hex: " + hexColor.getRed() + ", " + hexColor.getGreen() + ", " + hexColor.getBlue());
    }

}
