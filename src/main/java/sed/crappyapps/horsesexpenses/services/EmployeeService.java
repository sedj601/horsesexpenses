package sed.crappyapps.horsesexpenses.services;

import org.springframework.stereotype.Service;
import sed.crappyapps.horsesexpenses.model.Employees;
import sed.crappyapps.horsesexpenses.repositories.BillsRepository;
import sed.crappyapps.horsesexpenses.repositories.EmployeesRepository;

import java.util.List;

@Service
public class EmployeeService
{
    private final EmployeesRepository employeeRepository;

    public EmployeeService(EmployeesRepository employeesRepository)
    {
        this.employeeRepository = employeesRepository;
    }

    public List<Employees> findAll()
    {
        return employeeRepository.findAll();
    }

    public Employees save(Employees employee)
    {
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id)
    {
        employeeRepository.deleteById(id);
    }

}
