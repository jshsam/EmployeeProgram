import java.text.NumberFormat;

public class PaycheckGenerator extends CommissionEmployee {
        private final double FEDERAL_TAX = .11;
        private final double STATE_TAX = .04;
        private final double SOCIAL_SECURITY = .062;
        private final double MEDICARE = .0145;
        private final int INSURANCE = 50;
        private double hourlyWage;
        private double hoursWorked;
        private double commissionRate;
        private double salesRevenue;
        private double netPay;
        private double grossPay;
        private double commissionEarned;
        private double federalTaxAmount;
        private double stateTaxAmount;
        private double socialSecurityAmount;
        private double medicareAmount;

        public PaycheckGenerator(double payRate, double hours) {
            setHourlyWage(payRate);
            setHoursWorked(hours);
            setCommissionRate(0);
            setSalesRevenue(0);
            calculatePaycheck();
        }

        public PaycheckGenerator(double payRate, double hours, double commission, double revenue) {
            setHourlyWage(payRate);
            setHoursWorked(hours);
            setCommissionRate(commission);
            setSalesRevenue(revenue);
            calculatePaycheck();
        }

        public void setHourlyWage(double wage) {
            hourlyWage = wage;
        }

        public double getHourlyWage() {
            return hourlyWage;
        }

        public void setHoursWorked(double hours) {
            hoursWorked = hours;
        }

        public double getHoursWorked() {
            return hoursWorked;
        }
        
        public void setCommissionRate(double rate) {
            commissionRate = rate / 100;
        }

        public double getCommissionRate() {
            return commissionRate;
        }

        public void setSalesRevenue(double revenue) {
            salesRevenue = revenue;
        }

        public double getSalesRevenue() {
            return salesRevenue;
        }

        public void calculatePaycheck() {

            grossPay = calculateGrossPay(hourlyWage, hoursWorked);

            commissionEarned = calculateCommission(commissionRate, salesRevenue);

            federalTaxAmount = calculateFederalTax(grossPay, FEDERAL_TAX);

            stateTaxAmount = calculateStateTax(grossPay, STATE_TAX);

            socialSecurityAmount = calculateSocialSecurity(grossPay, SOCIAL_SECURITY);

            medicareAmount = calculateMedicare(grossPay, MEDICARE);

            netPay = calculateNetPay(grossPay, commissionEarned, federalTaxAmount, stateTaxAmount, socialSecurityAmount, medicareAmount, INSURANCE);
            
        }

        public void displayPaycheck() {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            System.out.println("\nEarnings");
            System.out.println("Gross Pay:          " + formatter.format(grossPay));
            System.out.println("Commission earned:  " + formatter.format(commissionEarned));
            System.out.println("\nWitholdings");
            System.out.println("Federal Tax:        " + formatter.format(federalTaxAmount));
            System.out.println("State Tax:          " + formatter.format(stateTaxAmount));
            System.out.println("Social Security:    " + formatter.format(socialSecurityAmount));
            System.out.println("Medicare:           " + formatter.format(medicareAmount));
            System.out.println("Insurance:          " + formatter.format(INSURANCE));
            System.out.println("______________________________");
            System.out.println("Net pay             " + formatter.format(netPay) + "\n");
        }

        public static double calculateGrossPay(double hourlyWage, double hoursWorked) {
            return hourlyWage * hoursWorked;
        }

        public static double calculateCommission(double commissionRate, double salesRevenue) {
            return commissionRate * salesRevenue;
        }
    
        public static double calculateFederalTax(double grossPay, double fedTaxPercentage) {
            return grossPay * fedTaxPercentage;
        }
    
        public static double calculateStateTax(double grossPay, double stateTaxPercentage) {
            return grossPay * stateTaxPercentage;       
        }
    
        public static double calculateSocialSecurity(double grossPay, double socialSecurityPercentage) {
            return grossPay * socialSecurityPercentage;        
        }
    
        public static double calculateMedicare(double grossPay, double medicarePercentage) {
            return grossPay * medicarePercentage;
        }
    
        public static double calculateNetPay(double grossPay, double commissionEarned, double federalTaxAmount, double stateTaxAmount, double socialSecurityAmount, 
                                                double medicareAmount, double INSURANCE) {
            return grossPay + commissionEarned - federalTaxAmount - stateTaxAmount - socialSecurityAmount - medicareAmount - INSURANCE;
        }
    
        
}