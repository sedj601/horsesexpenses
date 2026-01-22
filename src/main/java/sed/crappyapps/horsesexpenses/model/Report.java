package sed.crappyapps.horsesexpenses.model;

import java.math.BigDecimal;

public class Report
{
    BigDecimal numberOfHorses = new BigDecimal("0.00");
    BigDecimal expensesTotal = new BigDecimal("0.00");
    BigDecimal incomeTotal = new BigDecimal("0.00");
    BigDecimal difference = new BigDecimal("0.00");

    public Report(BigDecimal numberOfHorses, BigDecimal expensesTotal, BigDecimal incomeTotal)
    {
        this.numberOfHorses = numberOfHorses;
        this.expensesTotal = expensesTotal;
        this.incomeTotal = incomeTotal;
        this.difference = incomeTotal.subtract(difference);
    }

    public BigDecimal getNumberOfHorses() {
        return numberOfHorses;
    }

    public void setNumberOfHorses(BigDecimal numberOfHorses) {
        this.numberOfHorses = numberOfHorses;
    }

    public BigDecimal getIncomeTotal() {
        return incomeTotal;
    }

    public void setIncomeTotal(BigDecimal incomeTotal) {
        this.incomeTotal = incomeTotal;
    }

    public BigDecimal getExpensesTotal() {
        return expensesTotal;
    }

    public void setExpensesTotal(BigDecimal expensesTotal) {
        this.expensesTotal = expensesTotal;
    }

    public BigDecimal getDifference() {
        return difference;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Report{");
        sb.append("numberOfHorses=").append(numberOfHorses);
        sb.append(", expensesTotal=").append(expensesTotal);
        sb.append(", incomeTotal=").append(incomeTotal);
        sb.append(", difference=").append(difference);
        sb.append('}');
        return sb.toString();
    }
}
