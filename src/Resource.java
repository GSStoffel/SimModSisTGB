package src;

public class Resource {

    protected int id;
    protected String name;
    protected int maxQuantity;
    protected int quantity;
    protected double totalTimeAllocated;
    protected int totalAllocation;

    public Resource(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.maxQuantity = quantity;
        this.totalTimeAllocated = 0;
        this.totalAllocation = 0;
    }

    public boolean allocate(int quantity) {
        if (quantity <= this.quantity) {
            this.quantity -= quantity;
            this.totalAllocation++;
            return true;
        }
        else {
            return false;
        }
    }

    public void release(int quantity) {
        this.quantity += quantity;
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

    public double getTotalTimeAllocated() {
        return totalTimeAllocated;
    }

    public void setTotalTimeAllocated(double totalTimeAllocated) {
        this.totalTimeAllocated = totalTimeAllocated;
    }

    public int getTotalAllocation() {
        return totalAllocation;
    }

    public void setTotalAllocation(int totalAllocation) {
        this.totalAllocation = totalAllocation;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", totalTimeAllocated=" + totalTimeAllocated +
                ", totalAllocation=" + totalAllocation +
                '}';
    }
}
