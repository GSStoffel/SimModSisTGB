package src;

public class Resource {

    private int id;
    private String name;
    private int quantity;

    public Resource(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
