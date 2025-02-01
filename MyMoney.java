// You work at ‘MyMoney’, a platform that lets investors track their consolidated portfolio value across equity, debt, and gold.

// Portfolio rebalancing is an activity done to reduce the gains from one asset class and investing them in another, to ensure that the desired weight for each asset class doesn't deviate because of market gains/losses.

// If we consider an investor who has invested in an equity fund, a debt/gilt fund, and gold, over the course of 5 years, with a desired weight of 60%, 30% and 10%, without rebalancing the portfolio would look like this:

// Debt	Equity	Gold		Total
// 3,00,000	6,00,000	1,00,000	Dec-05	10,00,000
// 30%	60%	10%	Allocation	100%
 
// 3,13,305	8,51,584	1,19,384	Dec-06	12,84,836
// 25%	66%	9%	Allocation	100%
 
// 3,35,124	13,35,324	1,38,730	Dec-07	18,09,178
// 18%	74%	8%	Allocation	100%
 
// 3,97,317	6,50,684	1,76,097	Dec-08	12,24,098
// 32%	53%	14%	Allocation	100%
 
// 32%	53%	14%	Allocation	100%
// 3,43,246	11,55,555	2,18,795	Dec-09	17,17,595
// It’s clear that due to changing markets, the desired allocation has deviated.

// You need to design a system that will suggest actions to ensure that the desired allocation percentages are equal to the actual percentages invested. The desired allocation percentage should be derived from the initial allocation made. If 5000, 2000, 3000 is initial allocation, then desired percentage is 50%, 20% and 30%. The rebalanced portfolio would look like this:

// Debt	Equity	Gold		Total
// 3,00,000	6,00,000	1,00,000	Dec-05	10,00,000
// 30%	60%	10%	Allocation	100%
 
// 3,13,305	8,51,584	1,19,384	Dec-06	12,84,836
// 25%	66%	9%	Allocation	100%
// 3,85,451	7,70,901	1,28,484	Dec-06 (Post Rebalancing)	12,84,836
// 30%	60%	10%	Allocation	100%
 
// 4,12,295	12,08,811	1,48,602	Dec-07	17,69,708
// 23%	68%	9%	Allocation	100%
// 5,30,912	10,61,825	1,76,971	Dec-07 (Post Rebalancing)	17,69,708
// 30%	60%	10%	Allocation	100%
 
// 6,29,439	5,17,412	2,24,639	Dec-08	13,71,490
// 46%	38%	16%	Allocation	100%
// 4,11,447	8,22,894	1,37,149	Dec-08 (Post Rebalancing)	13,71,490
// 30%	60%	10%	Allocation	100%
 
// 3,56,116	14,51,396	1,70,011	Dec-09	19,77,523
// Your program should take as input:

// 1. The money allocated in equity, debt and gold funds.
// 2. Monthly SIP payments.
// 3. Monthly change rate (loss or growth) for each type of fund.
// The output should be

// 1. Balanced amount of each fund for a certain month.
// 2. Rebalanced amount of each month if applicable.
// Input Commands
// There are 5 input commands defined to separate out the actions. Your input format will start with either of these commands i.e ALLOCATE, SIP, CHANGE, BALANCE, REBALANCE


// ALLOCATE
// The ALLOCATE command receives the initial investment amounts for each fund.
// Format - ALLOCATE AMOUNT_EQUITY AMOUNT_DEBT AMOUNT_GOLD
// Example- ALLOCATE 6000 3000 1000 means that an amount of 6000, 3000 and 1000 is initially invested in equity, debt and gold fund respectively.

// SIP
// The SIP command receives the investment amount on a monthly basis for each fund.
// Format - SIP AMOUNT_EQUITY AMOUNT_DEBT AMOUNT_GOLD
// Example - SIP 2000 1000 500 means a monthly payment of 2000, 1000 and 500 is done against each of equity, debt and gold funds respectivelty.

// CHANGE
// The CHANGE command receives the monthly rate of change (growth or loss) for each fund type. A negative value represents a loss.
// Format - CHANGE AMOUNT_EQUITY AMOUNT_DEBT AMOUNT_GOLD MONTH Example - CHANGE 8.00% -3.00% 7.00% APRIL means in the month of April equity received a growth of 8%, debt has taken a loss by 3% and gold received a growth of 7%.

// BALANCE
// The BALANCE command receives a month name.
// Format - BALANCE MONTH
// Example - BALANCE APRIL means - print the balance for each fund as on April month.

// REBALANCE
// The REBALANCE command receives no additional inputs.
// Input Format - REBALANCE
// Example - REBALANCE - Rebalance happens compulsorily after 6 months in June and December.
// The REBALANCE command shows the last rebalanced amount for each fund at the time of
// rebalancing. If 6 months data is not available then print CANNOT_REBALANCE.
// Output format - EQUITY DEBT GOLD
// Example - 10593 7898 2273
// Assumptions
// 1. Balances are always floored to the nearest integers.
// 2. The rebalancing happens on 6th (June) and 12th (December) month.
// 3. The allocation always happens from January, and SIP from February.


// Enum for months to maintain consistency and type safety
enum Month {
    JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6),
    JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);
    
    private final int value;
    
    Month(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}

// Value object to store fund data
class FundAllocation {
    private long equity;
    private long debt;
    private long gold;
    
    public FundAllocation(long equity, long debt, long gold) {
        this.equity = equity;
        this.debt = debt;
        this.gold = gold;
    }
    
    // Getters and setters
    public long getEquity() { return equity; }
    public long getDebt() { return debt; }
    public long getGold() { return gold; }
    public void setEquity(long equity) { this.equity = equity; }
    public void setDebt(long debt) { this.debt = debt; }
    public void setGold(long gold) { this.gold = gold; }
    
    public long getTotal() {
        return equity + debt + gold;
    }
}

// Interface for portfolio operations following Interface Segregation Principle
interface PortfolioOperations {
    void allocate(long equity, long debt, long gold);
    void setSIP(long equity, long debt, long gold);
    void change(double equityChange, double debtChange, double goldChange, Month month);
    FundAllocation getBalance(Month month);
    FundAllocation rebalance();
}

// Main portfolio class implementing operations
class Portfolio implements PortfolioOperations {
    private final Map<Month, FundAllocation> monthlyBalance;
    private FundAllocation sip;
    private final double[] desiredAllocation;
    private Month currentMonth;
    
    public Portfolio() {
        this.monthlyBalance = new TreeMap<>(); // TreeMap for ordered months
        this.desiredAllocation = new double[3];
        this.currentMonth = Month.JANUARY;
    }
    
    @Override
    public void allocate(long equity, long debt, long gold) {
        FundAllocation initial = new FundAllocation(equity, debt, gold);
        monthlyBalance.put(Month.JANUARY, initial);
        
        // Calculate desired allocation percentages
        long total = initial.getTotal();
        desiredAllocation[0] = (double) equity / total;
        desiredAllocation[1] = (double) debt / total;
        desiredAllocation[2] = (double) gold / total;
    }
    
    @Override
    public void setSIP(long equity, long debt, long gold) {
        this.sip = new FundAllocation(equity, debt, gold);
    }
    
    @Override
    public void change(double equityChange, double debtChange, double goldChange, Month month) {
        FundAllocation previousBalance = monthlyBalance.get(currentMonth);
        FundAllocation newBalance = calculateNewBalance(previousBalance, equityChange, debtChange, goldChange);
        
        // Add SIP if not January
        if (month != Month.JANUARY && sip != null) {
            newBalance.setEquity(newBalance.getEquity() + sip.getEquity());
            newBalance.setDebt(newBalance.getDebt() + sip.getDebt());
            newBalance.setGold(newBalance.getGold() + sip.getGold());
        }
        
        monthlyBalance.put(month, newBalance);
        currentMonth = month;
    }
    
    private FundAllocation calculateNewBalance(FundAllocation previous, double equityChange, 
                                             double debtChange, double goldChange) {
        long newEquity = Math.round(previous.getEquity() * (1 + equityChange/100));
        long newDebt = Math.round(previous.getDebt() * (1 + debtChange/100));
        long newGold = Math.round(previous.getGold() * (1 + goldChange/100));
        return new FundAllocation(newEquity, newDebt, newGold);
    }
    
    @Override
    public FundAllocation getBalance(Month month) {
        return monthlyBalance.get(month);
    }
    
    @Override
    public FundAllocation rebalance() {
        if (currentMonth != Month.JUNE && currentMonth != Month.DECEMBER) {
            return null;
        }
        
        FundAllocation current = monthlyBalance.get(currentMonth);
        long total = current.getTotal();
        
        long newEquity = Math.round(total * desiredAllocation[0]);
        long newDebt = Math.round(total * desiredAllocation[1]);
        long newGold = Math.round(total * desiredAllocation[2]);
        
        FundAllocation rebalanced = new FundAllocation(newEquity, newDebt, newGold);
        monthlyBalance.put(currentMonth, rebalanced);
        return rebalanced;
    }
}

// Command processor following Command pattern
class PortfolioCommandProcessor {
    private final Portfolio portfolio;
    
    public PortfolioCommandProcessor() {
        this.portfolio = new Portfolio();
    }
    
    public void processCommand(String command) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "ALLOCATE":
                portfolio.allocate(
                    Long.parseLong(parts[1]),
                    Long.parseLong(parts[2]),
                    Long.parseLong(parts[3])
                );
                break;
                
            case "SIP":
                portfolio.setSIP(
                    Long.parseLong(parts[1]),
                    Long.parseLong(parts[2]),
                    Long.parseLong(parts[3])
                );
                break;
                
            case "CHANGE":
                portfolio.change(
                    Double.parseDouble(parts[1].replace("%", "")),
                    Double.parseDouble(parts[2].replace("%", "")),
                    Double.parseDouble(parts[3].replace("%", "")),
                    Month.valueOf(parts[4])
                );
                break;
                
            case "BALANCE":
                FundAllocation balance = portfolio.getBalance(Month.valueOf(parts[1]));
                System.out.println(balance.getEquity() + " " + balance.getDebt() + " " + balance.getGold());
                break;
                
            case "REBALANCE":
                FundAllocation rebalanced = portfolio.rebalance();
                if (rebalanced == null) {
                    System.out.println("CANNOT_REBALANCE");
                } else {
                    System.out.println(rebalanced.getEquity() + " " + rebalanced.getDebt() + " " + rebalanced.getGold());
                }
                break;
        }
    }
}


import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

// ... existing code ...

public class Main {
    public static void main(String[] args) {
        PortfolioCommandProcessor processor = new PortfolioCommandProcessor();
        Scanner scanner = new Scanner(System.in);
        
        // Process commands until "EXIT" is entered
        while (true) {
            String command = scanner.nextLine().trim();
            if (command.equals("EXIT")) {
                break;
            }
            processor.processCommand(command);
        }
        
        scanner.close();
    }
    
    // Example test cases
    public static void runTestCases() {
        PortfolioCommandProcessor processor = new PortfolioCommandProcessor();
        
        // Test Case 1: As per the example in problem statement
        System.out.println("Test Case 1:");
        processor.processCommand("ALLOCATE 6000 3000 1000");
        processor.processCommand("SIP 2000 1000 500");
        processor.processCommand("CHANGE 4.00% 10.00% 2.00% JANUARY");
        processor.processCommand("CHANGE -10.00% 40.00% 0.00% FEBRUARY");
        processor.processCommand("CHANGE 12.50% 12.50% 12.50% MARCH");
        processor.processCommand("CHANGE 8.00% -3.00% 7.00% APRIL");
        processor.processCommand("CHANGE 13.00% 21.00% 10.50% MAY");
        processor.processCommand("CHANGE 10.00% 8.00% -5.00% JUNE");
        
        processor.processCommand("BALANCE MARCH");
        processor.processCommand("REBALANCE");
        
        // Test Case 2: Testing with different initial allocation
        System.out.println("\nTest Case 2:");
        PortfolioCommandProcessor processor2 = new PortfolioCommandProcessor();
        processor2.processCommand("ALLOCATE 10000 5000 5000");
        processor2.processCommand("SIP 3000 2000 1000");
        processor2.processCommand("CHANGE 5.00% 5.00% 5.00% JANUARY");
        processor2.processCommand("CHANGE 5.00% 5.00% 5.00% FEBRUARY");
        processor2.processCommand("BALANCE FEBRUARY");
        processor2.processCommand("REBALANCE"); // Should print CANNOT_REBALANCE
    }
}