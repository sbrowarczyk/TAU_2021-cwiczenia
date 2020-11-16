package converter.distance;

public enum DistanceUnit {
    MM (1d,0.1,0.001,0.00000000001),
    CM ( 10d,1d,0.01,0.0000000001),
    METERS ( 1000d,100d,1d,0.001),
    KILOMETERS (10000000000d,100000d,1000d,1d);

    private final Double toMm;
    private final Double toCm;
    private final Double toMeters;
    private final Double toKilometers;


    DistanceUnit(Double toMm, Double toCm, Double toMeters, Double toKilometers) {
        this.toMm = toMm;
        this.toCm = toCm;
        this.toMeters = toMeters;
        this.toKilometers = toKilometers;
    }

    public Double getToMm() {
        return toMm;
    }

    public Double getToCm() {
        return toCm;
    }

    public Double getToMeters() {
        return toMeters;
    }

    public Double getToKilometers() {
        return toKilometers;
    }
}
