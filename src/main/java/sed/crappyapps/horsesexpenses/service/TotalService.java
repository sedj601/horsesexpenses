package sed.crappyapps.horsesexpenses.service;

import sed.crappyapps.horsesexpenses.model.Bill;
import sed.crappyapps.horsesexpenses.model.Employee;
import sed.crappyapps.horsesexpenses.model.HorseExpense;
import sed.crappyapps.horsesexpenses.model.Income;
import sed.crappyapps.horsesexpenses.model.Item;

import java.math.BigDecimal;
import java.util.List;

public class TotalService
{
    static public BigDecimal CalculateBillsTotal(List<Bill> billList)
    {
        return billList.stream().map(Bill::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    static public BigDecimal CalculateItemsTotal(List<Item> itemList)
    {
        return itemList.stream().map(Item::getCost).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    static public BigDecimal CalculateEmployeesTotal(List<Employee> employeeList)
    {
        return employeeList.stream().map(Employee::getPay).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    static public BigDecimal CalculateIncomeTotal(List<Income> incomeList)
    {
        return incomeList.stream().map(Income::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    static public BigDecimal CalculateHorseExpenseTotal(List<HorseExpense> horseExpensesList, int numberOfHorses)
    {
        return horseExpensesList.stream().map(HorseExpense::getCostPerHorse).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
