package sed.crappyapps.horsesexpenses.service;

import org.springframework.stereotype.Service;
import sed.crappyapps.horsesexpenses.model.Employee;
import sed.crappyapps.horsesexpenses.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService
{
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeesRepository)
    {
        this.employeeRepository = employeesRepository;
    }

    public List<Employee> findAll()
    {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id)
    {
        employeeRepository.deleteById(id);
    }

}
