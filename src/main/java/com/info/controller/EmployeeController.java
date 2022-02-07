package com.info.controller;

import com.info.PropertyEditors.CustomLocalDateTime;
import com.info.PropertyEditors.CustomLocalTime;
import com.info.entity.Employee;
import com.info.service.IEmployeeService;
import com.info.utils.EmployeeValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeValidator employeeValidator;



    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }
//    @GetMapping("/emp_reports")
//    public String getEmpReports(ModelMap modelMap){
//        Iterable<Employee> empDetails=employeeService.getEmpReports();
//        modelMap.addAttribute("empDetails",empDetails);
//        return "Reports";
//    }

    @GetMapping("/emp_reports")
    public String getEmpReportsByPage(@PageableDefault(page = 0,size = 10,sort = "empNo",direction = Sort.Direction.ASC) Pageable pageable,
                                      ModelMap modelMap){
        Page<Employee> page=employeeService.getEmpReportsByPage(pageable);
        modelMap.addAttribute("page",page);
        return "Reports";
    }

    @GetMapping("/emp_register")
    public String employeeRegister(ModelMap modelMap,
                                   @RequestParam(value = "id",defaultValue = "-1")Long id,
                                   @ModelAttribute("emp")Employee emp) throws Exception {
        if(id !=-1){
            Employee employee=employeeService.getEmpDetails(id);
            BeanUtils.copyProperties(employee,emp);
        }else {
        }
        return "register";
    }

    @PostMapping("/emp_register")
    public String insertEmployee(Map<String,Object> bindingAwareModelMap,
                                 @ModelAttribute("emp")Employee emp,
                                 RedirectAttributes redirectAttributes,
                                 BindingResult errors){
        if(!emp.isVflag()){
            employeeValidator.validate(emp,errors);
            if (errors.hasErrors()){
                return "register";
            }
        }
        if(errors.hasErrors()){
            return "register";
        }
        String resultMsg=employeeService.insertEmployee(emp);
        redirectAttributes.addFlashAttribute("resultMsg",resultMsg);
        return "redirect:emp_reports";
    }

    @ModelAttribute("genders")
    public List<String> getGenders(){
        return employeeService.getGenders();

    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor=new CustomDateEditor(simpleDateFormat,true);
        binder.registerCustomEditor(Date.class,editor);
        binder.registerCustomEditor(LocalDateTime.class,new CustomLocalDateTime());
        binder.registerCustomEditor(LocalTime.class,new CustomLocalTime());
    }
}
