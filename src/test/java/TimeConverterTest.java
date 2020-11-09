import converter.distance.DistanceConverter;
import converter.distance.DistanceUnit;
import converter.time.TimeConverter;
import converter.time.TimeUnit;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TimeConverterTest {

    @Test
    public void TestTimeConverter1() {
        Double expected = 67d;
        Map<String, Double> conversions = new TimeConverter().convert(expected, TimeUnit.H );

        Double h = conversions.get("h");
        assertEquals(expected, h);
    }

    @Test
    public void TestTimeConverter2() {
        Map<String, Double> expectedMap = new HashMap<>();
        expectedMap.put("s", 1d);
        expectedMap.put("min", (1d / 60));
        expectedMap.put("h", 0.000278d);
        expectedMap.put("day", 0.000012d);

        Map<String, Double> conversions = new TimeConverter().convert(1d, TimeUnit.S);
        assertEquals(expectedMap, conversions);

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestTimeConverter3() {
        assertThrows(IllegalArgumentException.class, (ThrowingRunnable) new TimeConverter().convert(-12d, TimeUnit.DAY));
    }
}
