package converter;

public class Unit {

    private Double toMm;
    private Double toCm;
    private Double toMeters;
    private Double toKilometers;

    public Unit(Double toMm, Double toCm, Double toMeters, Double toKilometers) {
        this.toMm = toMm;
        this.toCm = toCm;
        this.toMeters = toMeters;
        this.toKilometers = toKilometers;
    }

    public Double getToMm() {
        return toMm;
    }

    public void setToMm(Double toMm) {
        this.toMm = toMm;
    }

    public Double getToCm() {
        return toCm;
    }

    public void setToCm(Double toCm) {
        this.toCm = toCm;
    }

    public Double getToMeters() {
        return toMeters;
    }

    public void setToMeters(Double toMeters) {
        this.toMeters = toMeters;
    }

    public Double getToKilometers() {
        return toKilometers;
    }

    public void setToKilometers(Double toKilometers) {
        this.toKilometers = toKilometers;
    }
}
