public class Exercise7_FinancialForecast {

    public static double futureValueRecursive(double principal, double growthRate, int years) {
        if (years == 0) {
            return principal;
        }
        return futureValueRecursive(principal, growthRate, years - 1) * (1 + growthRate);
    }

    public static double futureValueIterative(double principal, double growthRate, int years) {
        double value = principal;
        for (int i = 0; i < years; i++) {
            value *= (1 + growthRate);
        }
        return value;
    }

    public static double futureValueFormula(double principal, double growthRate, int years) {
        return principal * Math.pow(1 + growthRate, years);
    }

    public static void main(String[] args) {
        double principal = 10000.0;
        double annualGrowthRate = 0.07;
        int years = 10;

        System.out.printf("%.2f%n", futureValueRecursive(principal, annualGrowthRate, years));
        System.out.printf("%.2f%n", futureValueIterative(principal, annualGrowthRate, years));
        System.out.printf("%.2f%n", futureValueFormula(principal, annualGrowthRate, years));
    }
}
