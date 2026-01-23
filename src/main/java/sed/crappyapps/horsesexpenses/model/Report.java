package sed.crappyapps.horsesexpenses.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Report
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numberOfHorses", precision = 16, scale = 2, nullable = false)
    BigDecimal numberOfHorses = new BigDecimal("0.00");
    @Column(name = "pricePerHorse", precision = 16, scale = 2, nullable = false)
    BigDecimal pricePerHorse = new BigDecimal("0.00");
    @Column(name = "expensesTotal", precision = 16, scale = 2, nullable = false)
    BigDecimal expensesTotal = new BigDecimal("0.00");
    @Column(name = "incomeTotalMinusHorseBoarding", precision = 16, scale = 2, nullable = false)
    BigDecimal incomeTotalMinusHorseBoarding = new BigDecimal("0.00");

    @Transient
    BigDecimal incomeTotal = new BigDecimal("0.00");
    @Transient
    BigDecimal difference = new BigDecimal("0.00");

    public Report(){};

    public Report(BigDecimal numberOfHorses, BigDecimal pricePerHorse, BigDecimal expensesTotal, BigDecimal incomeTotalMinusHorseBoarding)
    {
        this.numberOfHorses = numberOfHorses;
        this.pricePerHorse = pricePerHorse;
        this.expensesTotal = expensesTotal;
        this.incomeTotalMinusHorseBoarding = incomeTotalMinusHorseBoarding;

    }

    public BigDecimal getNumberOfHorses() {
        return numberOfHorses;
    }

    public void setNumberOfHorses(BigDecimal numberOfHorses) {
        this.numberOfHorses = numberOfHorses;
    }

    public BigDecimal getIncomeTotalMinusHorseBoarding() {
        return incomeTotalMinusHorseBoarding;
    }

    public void setIncomeTotalMinusHorseBoarding(BigDecimal incomeTotalMinusHorseBoarding) {
        this.incomeTotalMinusHorseBoarding = incomeTotalMinusHorseBoarding;
    }

    public BigDecimal getExpensesTotal() {
        return expensesTotal;
    }

    public void setExpensesTotal(BigDecimal expensesTotal) {
        this.expensesTotal = expensesTotal;
    }

    public BigDecimal getIncomeTotal()
    {
        this.incomeTotal = incomeTotalMinusHorseBoarding.add(numberOfHorses.multiply(pricePerHorse));

        return incomeTotal;
    }

    public BigDecimal getDifference() {
        this.difference = incomeTotal.subtract(expensesTotal);
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
