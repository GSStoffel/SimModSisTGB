package src;

public class Resource {

    private String name;
    private int id;
    private int quantity;

    public Resource(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Resource(int quantity) {
        this.quantity = quantity;
    }

    public boolean allocate(int quantity) {
        if (quantity < this.quantity) {
            this.quantity -= quantity;
            return true;
        }
        else {
            return false;
        }
    }

    public void release(int quantity) {
        this.quantity += quantity;
    }

    // TODO: implementar
    public double allocationRate() {
        return 0;
    }

    // TODO: implementar
    public double avarageAllocation() {
        return 0;
    }
}
