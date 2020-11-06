package converter;

import java.util.HashMap;
import java.util.Map;

public class distanceConverter {

    private final  Unit mm = new Unit(1d,0.1,0.001,0.00000000001);
    private final  Unit cm = new Unit(10d,1d,0.01,0.0000000001);
    private final  Unit meters = new Unit(1000d,100d,1d,0.001);
    private final  Unit kilometers = new Unit(10000000000d,100000d,1000d,1d);


    public Map<String,Double> convert (Double val, Unit Unit){
        Map<String,Double> conversions = new HashMap<String, Double>();
        conversions.put("mm",val*Unit.getToMm());
        conversions.put("cm",val*Unit.getToCm());
        conversions.put("meters",val*Unit.getToMeters());
        conversions.put("kilometers",val*Unit.getToKilometers());
        return conversions;
    }
}
