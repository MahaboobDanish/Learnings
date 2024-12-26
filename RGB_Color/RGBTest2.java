// public class RGBTest2 {
    
// }
import static org.junit.Assert.*;
import org.junit.Test;

import Main.RGB;

public class RGBTest2 {
    
    // Helper method to compare RGB objects
    private void assertRGBEquals(int expectedRed, int expectedGreen, int expectedBlue, RGB actual) {
        assertEquals(expectedRed, actual.getRed());
        assertEquals(expectedGreen, actual.getGreen());
        assertEquals(expectedBlue, actual.getBlue());
    }

    @Test
    public void testColorToHex() {
        assertEquals("#00ffff", new RGB(0, 255, 255).toHex()); // aqua
        assertEquals("#000000", new RGB(0, 0, 0).toHex()); // black
        assertEquals("#0000ff", new RGB(0, 0, 255).toHex()); // blue
        assertEquals("#ff00ff", new RGB(255, 0, 255).toHex()); // fuchsia
        // Add more known colors here
    }

    @Test
    public void testHexToColor() {
        assertRGBEquals(0, 255, 255, RGB.fromHex("#00ffff")); // aqua
        assertRGBEquals(0, 0, 0, RGB.fromHex("#000000")); // black
        assertRGBEquals(0, 0, 255, RGB.fromHex("#0000ff")); // blue
        assertRGBEquals(255, 0, 255, RGB.fromHex("#ff00ff")); // fuchsia
        // Add more known colors here
    }

    @Test
    public void testLuminance() {
        // Assuming luminance calculation is correct, but you could add specific checks here
        RGB color = new RGB(50, 100, 150);
        double luminance = color.calculateLuminance();
        // This is an expected luminance value based on the formula used in the calculateLuminance method.
        assertEquals(81.5, luminance, 0.1);
    }

    @Test
    public void testGrayscale() {
        RGB color = new RGB(50, 100, 150);
        int grayscale = color.calculateGrayscale();
        assertEquals(100, grayscale); // (50 + 100 + 150) / 3
    }

    @Test
    public void testRoundTripConversion() {
        // Test conversion to hex and back for a custom color
        RGB original = new RGB(123, 45, 67);
        String hex = original.toHex();
        RGB fromHex = RGB.fromHex(hex);
        assertRGBEquals(original.getRed(), original.getGreen(), original.getBlue(), fromHex);
    }
}