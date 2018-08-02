package com.zfz.springmvc.crud.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zfz.springmvc.crud.dao.DepartmentDao;
import com.zfz.springmvc.crud.dao.EmployeeDao;
import com.zfz.springmvc.crud.entities.Employee;

@Controller
public class EmployeeHandler {
     
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    
    @RequestMapping("/emps")
    public String list(Map<String, Object> map){
        map.put("employees", employeeDao.getAll());
        return "list";
    }
    @RequestMapping(value="/emp", method=RequestMethod.GET)
    public String input(Map<String, Object> map){
        map.put("departments", departmentDao.getDepartments());
        map.put("employee", new Employee());
        return "input";
    }
    @RequestMapping(value="/emp", method=RequestMethod.POST)
    public String save(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
