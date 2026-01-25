package sed.crappyapps.horsesexpenses.service;

import sed.crappyapps.horsesexpenses.model.Bill;
import sed.crappyapps.horsesexpenses.model.Employee;
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
        return itemList.stream().map(item -> item.getQuantity().multiply(item.getCost())).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    static public BigDecimal CalculateEmployeesTotal(List<Employee> employeeList)
    {
        return employeeList.stream().map(employee -> employee.getHours().multiply(employee.getPay())).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    static public BigDecimal CalculateIncomeTotal(List<Income> incomeList)
    {
        return incomeList.stream().map(Income::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
//        BigDecimal employeesTotal =
//        model.addAttribute("employeesTotal", employeesTotal.setScale(2, RoundingMode.HALF_UP));
//
//        BigDecimal incomeTotal =
//        model.addAttribute("incomeTotal", incomeTotal.setScale(2, RoundingMode.HALF_UP));
}
