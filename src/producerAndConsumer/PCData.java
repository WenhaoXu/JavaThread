package producerAndConsumer;

public final class PCData {
    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }
    public PCData(String d) {
        this.intData = Integer.valueOf(d);
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}
