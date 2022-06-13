package src;

public final class Mode {
    public static final int FIFO = 0;
    public static final int LIFO = 1;
    public static final int PRIORITYBASED = 2;
    public static final int NONE = 3;

    private Mode() {}

    public static String Name(int mode){
        switch (mode) {
            case Mode.FIFO -> {
                return "FIFO";
            }
            case Mode.LIFO -> {
                return "LIFO";
            }
            case Mode.PRIORITYBASED -> {
                return "PRIORITY BASED";
            }
            default -> {
                return "NONE";
            }
        }
    }
}
