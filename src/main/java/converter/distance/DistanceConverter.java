package converter.distance;

import java.util.HashMap;
import java.util.Map;

public class DistanceConverter {


    public static Map<String,Double> convert (Double val, DistanceUnit DistanceUnit){
        Map<String,Double> conversions = new HashMap<String, Double>();
        conversions.put("mm",val* DistanceUnit.getToMm());
        conversions.put("cm",val* DistanceUnit.getToCm());
        conversions.put("m",val* DistanceUnit.getToMeters());
        conversions.put("km",val* DistanceUnit.getToKilometers());
        return conversions;
    }

}
