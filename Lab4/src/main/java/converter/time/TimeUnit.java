package converter.time;

public enum TimeUnit {

    S(1d, (1d / 60), 0.000278, 0.000012),
    MIN(60d, 1d, 0.016667d, 0.016667d),
    H(3600d, 60d, 1d, 0.041667d),
    DAY(86400d, 1440d, 24d, 1d);


    private final double toS;
    private final double toMin;
    private final double toH;
    private final double toDay;

    TimeUnit(double toS, double toMin, double toH, double toDay) {
        this.toS = toS;
        this.toMin = toMin;
        this.toH = toH;
        this.toDay = toDay;
    }

    public double getToS() {
        return toS;
    }

    public double getToMin() {
        return toMin;
    }

    public double getToH() {
        return toH;
    }

    public double getToDay() {
        return toDay;
    }
}
