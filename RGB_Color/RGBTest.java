
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RGBTest {

    @Test
    void testRGBConstructorAndGetters() {
        RGB color = new RGB(100, 150, 200);
        assertEquals(100, color.getRed());
        assertEquals(150, color.getGreen());
        assertEquals(200, color.getBlue());
    }

    @Test
    void testCalculateLuminance() {
        RGB color = new RGB(100, 150, 200);
        assertEquals(155.7, color.calculateLuminance(), 0.01);
    }

    @Test
    void testCalculateGrayscale() {
        RGB color = new RGB(100, 150, 200);
        assertEquals(150, color.calculateGrayscale());
    }

    @Test
    void testToHex() {
        RGB color = new RGB(100, 150, 200);
        assertEquals("#6496c8", color.toHex());
    }

    @Test
    void testFromHex() {
        RGB color = RGB.fromHex("#6496c8");
        assertEquals(100, color.getRed());
        assertEquals(150, color.getGreen());
        assertEquals(200, color.getBlue());
    }

    @Test
    void testHexConversionRoundtrip() {
        RGB originalColor = new RGB(50, 100, 150);
        String hex = originalColor.toHex();
        RGB convertedColor = RGB.fromHex(hex);

        assertEquals(originalColor.getRed(), convertedColor.getRed());
        assertEquals(originalColor.getGreen(), convertedColor.getGreen());
        assertEquals(originalColor.getBlue(), convertedColor.getBlue());
        assertEquals(originalColor.calculateLuminance(), convertedColor.calculateLuminance(), 0.01);
        assertEquals(originalColor.calculateGrayscale(), convertedColor.calculateGrayscale());
    }

    @Test
    void testCommonColors() {
        Map<String, RGB> colorMap = new HashMap<>();
        colorMap.put("aqua", new RGB(0, 255, 255));
        colorMap.put("black", new RGB(0, 0, 0));
        colorMap.put("blue", new RGB(0, 0, 255));
        colorMap.put("fuchsia", new RGB(255, 0, 255));
        colorMap.put("gray", new RGB(128, 128, 128));
        colorMap.put("green", new RGB(0, 128, 0));
        colorMap.put("lime", new RGB(0, 255, 0));
        colorMap.put("maroon", new RGB(128, 0, 0));
        colorMap.put("navy", new RGB(0, 0, 128));
        colorMap.put("olive", new RGB(128, 128, 0));
        colorMap.put("purple", new RGB(128, 0, 128));
        colorMap.put("red", new RGB(255, 0, 0));
        colorMap.put("silver", new RGB(192, 192, 192));
        colorMap.put("teal", new RGB(0, 128, 128));
        colorMap.put("white", new RGB(255, 255, 255));
        colorMap.put("yellow", new RGB(255, 255, 0));

        for (Map.Entry<String, RGB> entry : colorMap.entrySet()) {
            String colorName = entry.getKey();
            RGB color = entry.getValue();
            String hex = color.toHex();
            RGB fromHex = RGB.fromHex(hex);

            assertEquals(color.getRed(), fromHex.getRed(), "Red mismatch for " + color

