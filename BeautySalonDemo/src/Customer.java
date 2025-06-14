public class Customer {
    private String name;
    private Discount memberType;

    public Customer(String name) {
        this.name = name;
        this.memberType = Discount.NONE;
    }

    public String getName() {
        return name;
    }

    public Discount getMemberType() {
        return memberType;
    }

    public void setMemberType(Discount memberType) {
        this.memberType = memberType;
    }

    public boolean isMember() {
        return memberType != Discount.NONE;
    }

    @Override
    public String toString() {
        return "Customer: " + name + 
               "\nMembership: " + memberType + 
               "\nMember: " + (isMember() ? "Yes" : "No");
    }
}