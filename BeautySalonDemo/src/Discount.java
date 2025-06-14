//an enum (short for enumeration) is a special data type that represents a group of named constants. 
//It's used to define a set of predefined values, making code more readable and maintainable. 

public enum Discount {
    PREMIUM(0.20, 0.10),
    GOLD(0.15, 0.10),
    SILVER(0.10, 0.10),
    NONE(0.0, 0.0);

    private final double serviceDiscountRate;
    private final double productDiscountRate;

    Discount(double serviceDiscountRate, double productDiscountRate) {
        this.serviceDiscountRate = serviceDiscountRate;
        this.productDiscountRate = productDiscountRate;
    }

    public double getServiceDiscountRate() {
        return serviceDiscountRate;
    }

    public double getProductDiscountRate() {
        return productDiscountRate;
    }
}