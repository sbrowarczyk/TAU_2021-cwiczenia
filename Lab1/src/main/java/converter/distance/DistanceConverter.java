package converter.distance;

import java.util.HashMap;
import java.util.Map;

public class DistanceConverter {

    public void calculate(Double val, DistanceUnit distanceUnit){
        switch (distanceUnit){
            case CM:
                convert(val,DistanceUnit.CM);
                break;
            case MM:
                convert(val,DistanceUnit.MM);
                break;
            case METERS:
                convert(val,DistanceUnit.METERS);
                break;
            case KILOMETERS:
                convert(val,DistanceUnit.KILOMETERS);
        }

    }


    public Map<String,Double> convert(Double val, DistanceUnit distanceUnit) throws IllegalArgumentException{
        if (val<1d){
            throw new IllegalArgumentException();
        }
        Map<String,Double> conversions = new HashMap<>();
        conversions.put("mm",val* distanceUnit.getToMm());
        conversions.put("cm",val* distanceUnit.getToCm());
        conversions.put("m",val* distanceUnit.getToMeters());
        conversions.put("km",val* distanceUnit.getToKilometers());
        return conversions;
    }
}
