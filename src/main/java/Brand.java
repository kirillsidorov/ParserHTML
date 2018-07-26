public class Brand {
    String name;
    String quantity;

    public Brand(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Brand " + name + " количество " + quantity;
    }


}



