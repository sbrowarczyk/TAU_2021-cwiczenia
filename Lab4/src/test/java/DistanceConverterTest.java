import converter.distance.DistanceConverter;
import converter.distance.DistanceUnit;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DistanceConverterTest {

    @Test
    public void TestDistanceConverter1() {
        Double expected = 20d;
        Map<String, Double> conversions = new DistanceConverter().convert(expected, DistanceUnit.CM);

        Double cm = conversions.get("cm");
        assertEquals(expected, cm);
    }

    @Test
    public void TestDistanceConverter2() {
        Map<String, Double> expectedMap = new HashMap<>();
        expectedMap.put("mm", 1d);
        expectedMap.put("cm", 0.1d);
        expectedMap.put("m", 0.001d);
        expectedMap.put("km", 0.00000000001);

        Map<String, Double> conversions = new DistanceConverter().convert(1d, DistanceUnit.MM);
        assertEquals(expectedMap, conversions);

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestDistanceConverter3() {
        assertThrows(IllegalArgumentException.class, (ThrowingRunnable) new DistanceConverter().convert(-12d, DistanceUnit.KILOMETERS));
    }

}
