public class CommissionEmployee extends Employee {
    private double commissionRate;
    private double salesRevenue;

    public void setCommissionRate(double rate) {
        commissionRate = rate;
    }

    public  double getCommissionRate() {
        return commissionRate;
    }

    public void setSalesRevenue(double revenue) {
        salesRevenue = revenue;
    }

    public double getSalesRevenue() {
        return salesRevenue;
    }
}