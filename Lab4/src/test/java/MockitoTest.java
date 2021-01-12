import converter.distance.DistanceConverter;
import converter.distance.DistanceUnit;
import converter.time.TimeConverter;
import converter.time.TimeUnit;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.BDDMockito.*;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MockitoTest {

    @Test
    public void mockTimeConverter1() {
        Double expected = 67d;
        TimeConverter timeConverterMock = Mockito.mock(TimeConverter.class);
        when(timeConverterMock.convert(expected, TimeUnit.H)).thenReturn(Mockito.mock(HashMap.class));
        Map<String, Double> conversions = timeConverterMock.convert(expected, TimeUnit.H);
        when(conversions.get("h")).thenReturn(67.0);
        Double h = conversions.get("h");
        assertEquals(expected, h);
    }


    @Test
    public void mockTimeConverter2() {
        Map<String, Double> expectedMap = new HashMap<>();
        expectedMap.put("s", 1d);
        expectedMap.put("min", (1d / 60));
        expectedMap.put("h", 0.000278d);
        expectedMap.put("day", 0.000012d);

        TimeConverter timeConverterMock = Mockito.mock(TimeConverter.class);
        when(timeConverterMock.convert(1d, TimeUnit.S)).thenReturn(expectedMap);

        Map<String, Double> conversions = timeConverterMock.convert(1d, TimeUnit.S);
        assertEquals(expectedMap, conversions);

    }

    @Test(expected = IllegalArgumentException.class)
    public void mockTimeConverter3() {
        TimeConverter timeConverterMock = Mockito.mock(TimeConverter.class);
        when(timeConverterMock.convert(-12d, TimeUnit.DAY)).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, (ThrowingRunnable) timeConverterMock.convert(-12d, TimeUnit.DAY));

    }

    @Test
    public void TestDistanceConverter1() {
        Double expected = 20d;
        DistanceConverter distanceConverterMock = Mockito.mock(DistanceConverter.class);
        given(distanceConverterMock.convert(expected, DistanceUnit.CM)).willReturn(Mockito.mock(HashMap.class));
        Map<String, Double> conversions = distanceConverterMock.convert(expected, DistanceUnit.CM);
        given(conversions.get("cm")).willReturn(20d);
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

        DistanceConverter distanceConverterMock = Mockito.mock(DistanceConverter.class);
        given(distanceConverterMock.convert(1d, DistanceUnit.MM)).willReturn(expectedMap);

        Map<String, Double> conversions = distanceConverterMock.convert(1d, DistanceUnit.MM);
        assertEquals(expectedMap, conversions);

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestDistanceConverter3() {

        DistanceConverter distanceConverterMock = Mockito.mock(DistanceConverter.class);
        given(distanceConverterMock.convert(-12d, DistanceUnit.KILOMETERS)).willThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, (ThrowingRunnable) distanceConverterMock.convert(-12d, DistanceUnit.KILOMETERS));
    }


}
