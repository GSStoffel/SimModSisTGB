package src;

public class LogPair {
    private Double valueA;
    private Integer valueB;

    public LogPair(Double valueA, Integer valueB) {
        this.valueA = valueA;
        this.valueB = valueB;
    }

    public Double getValueA() {
        return valueA;
    }

    public void setValueA(Double valueA) {
        this.valueA = valueA;
    }

    public Integer getValueB() {
        return valueB;
    }

    public void setValueB(Integer valueB) {
        this.valueB = valueB;
    }

    @Override
    public String toString() {
        return "LogPair{" +
                "valueA=" + valueA +
                ", valueB=" + valueB +
                '}';
    }
}
