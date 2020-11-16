package converter.time;

import java.util.HashMap;
import java.util.Map;

public class TimeConverter {


    public void calculate(Double val, TimeUnit timeUnit) {
        switch (timeUnit) {
            case S:
                convert(val, TimeUnit.S);
                break;
            case MIN:
                convert(val, TimeUnit.MIN);
                break;
            case H:
                convert(val, TimeUnit.H);
                break;
            case DAY:
                convert(val, TimeUnit.DAY);
        }
    }


    public Map<String, Double> convert(Double val, TimeUnit timeUnit) throws IllegalArgumentException {
        if (val < 1d) {
            throw new IllegalArgumentException();
        }
        Map<String, Double> conversion = new HashMap<>();
        conversion.put("s", val * timeUnit.getToS());
        conversion.put("min", val * timeUnit.getToMin());
        conversion.put("h", val * timeUnit.getToH());
        conversion.put("day", timeUnit.getToDay());
        return conversion;
    }
}
