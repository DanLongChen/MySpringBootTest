package com.controller;

import com.dao.DepartmentDao;
import com.dao.EmployeeDao;
import com.entity.Department;
import com.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by DanLongChen on 2018/11/26
 **/
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;


    //员工列表
    @GetMapping("/emps")
    public String list(Model model) {//放入请求域<request>中(Model,ModelMap,Map这些都是在请求域中)
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    //员工列表页面
    @GetMapping(value = "/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";//寻找add页面
    }

    //员工添加页面   SpringMvc自动将请求参数和入参对象进行一一绑定（参数的名字和javaBean的属性的名字要一致）
    @PostMapping(value = "/emp")
    public String addEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";//直接return “/emps” 则会启用模板引擎找到类路径下的模板，使用forward：/emps才是真正的执行转发，加上forward之后thymeleaf引擎会自动创建一个forwardModelAndView
    }

    //员工修改页面，查出当前员工，再回写
    @GetMapping(value = "/emp/{id}")
    public String toEditEmp(@PathVariable("id") Integer empId,Model model){
        Employee employee=employeeDao.get(empId);
        Collection<Department> departments=departmentDao.getDepartments();//查出部门
        model.addAttribute("emp",employee);
        model.addAttribute("depts",departments);
        return "emp/add";//这个add页面就相当于修改添加二合一的页面
    }

    //员工修改
    @PutMapping(value = "/emp")
    public String updateEp(@RequestBody Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping(value = "/emp/{id}")
    public String deleteEp(@PathVariable("id") Integer uid){
        employeeDao.delete(uid);
        return "redirect:/emps";
    }
}
