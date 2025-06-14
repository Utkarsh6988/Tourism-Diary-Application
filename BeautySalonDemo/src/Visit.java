public class Visit {
    private Customer customer;
    private double serviceExpense;
    private double productExpense;

    public Visit(Customer customer) {
        this.customer = customer;
        this.serviceExpense = 0.0;
        this.productExpense = 0.0;
    }

    public void addServiceExpense(double expense) {
        this.serviceExpense += expense;
    }

    public void addProductExpense(double expense) {
        this.productExpense += expense;
    }

    public double getTotalExpense() {
        double serviceDiscount = serviceExpense * customer.getMemberType().getServiceDiscountRate();
        double productDiscount = productExpense * customer.getMemberType().getProductDiscountRate();
        
        return (serviceExpense - serviceDiscount) + (productExpense - productDiscount);
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    @Override
    public String toString() {
        return customer.toString() + 
               "\nService Expense: $" + String.format("%.2f", serviceExpense) +
               "\nProduct Expense: $" + String.format("%.2f", productExpense) +
               "\nTotal Bill: $" + String.format("%.2f", getTotalExpense());
    }
}