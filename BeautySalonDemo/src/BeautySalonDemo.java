public class BeautySalonDemo {
    public static void main(String[] args) {
        Customer premiumCustomer = new Customer("Alice Johnson");
        premiumCustomer.setMemberType(Discount.PREMIUM);
        
        Customer goldCustomer = new Customer("Bob Smith");
        goldCustomer.setMemberType(Discount.GOLD);
        
        Customer silverCustomer = new Customer("Carol Williams");
        silverCustomer.setMemberType(Discount.SILVER);
        
        Customer nonMember = new Customer("David Brown");

        Visit premiumVisit = new Visit(premiumCustomer);
        premiumVisit.addServiceExpense(100.0);
        premiumVisit.addProductExpense(50.0);
        
        Visit goldVisit = new Visit(goldCustomer);
        goldVisit.addServiceExpense(100.0);
        goldVisit.addProductExpense(50.0);
        
        Visit silverVisit = new Visit(silverCustomer);
        silverVisit.addServiceExpense(100.0);
        silverVisit.addProductExpense(50.0);
        
        Visit nonMemberVisit = new Visit(nonMember);
        nonMemberVisit.addServiceExpense(100.0);
        nonMemberVisit.addProductExpense(50.0);

        System.out.println("=== Premium Member Visit ===");
        System.out.println(premiumVisit);
        
        System.out.println("\n=== Gold Member Visit ===");
        System.out.println(goldVisit);
        
        System.out.println("\n=== Silver Member Visit ===");
        System.out.println(silverVisit);
        
        System.out.println("\n=== Non-Member Visit ===");
        System.out.println(nonMemberVisit);
    }
}