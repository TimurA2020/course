package kz.burgerking.main.sku;

public class Order {
    private Long orderId;
    private String name;
    private String surname;
    private String product;

    public Order() {
    }

    public Order(Long orderId, String name, String surname, String product) {
        this.orderId = orderId;
        this.name = name;
        this.surname = surname;
        this.product = product;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
