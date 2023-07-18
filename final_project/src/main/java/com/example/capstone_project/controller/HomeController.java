package com.example.capstone_project.controller;

import com.example.capstone_project.dto.cart.CartDTO;
import com.example.capstone_project.model.animal.Animal;
import com.example.capstone_project.model.customer.Customer;
import com.example.capstone_project.model.employee.Employee;
import com.example.capstone_project.model.animal.AnimalType;
import com.example.capstone_project.service.animal.IAnimalService;
import com.example.capstone_project.service.animal.IAnimalTypeService;
import com.example.capstone_project.service.blog.IBlogService;
import com.example.capstone_project.service.customer.ICustomerService;
import com.example.capstone_project.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/home")
@SessionAttributes(value = "cartDTO")
public class HomeController {
    @ModelAttribute(name = "cartDTO")
    private CartDTO initCartDTO() {
        return new CartDTO();
    }
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private IAnimalService animalService;
    @Autowired
    private IAnimalTypeService animalTypeService;
    @GetMapping("")
    public String index(@RequestParam(defaultValue = "", required = false) String searchAnimal,
                        @RequestParam(defaultValue = "", required = false) String searchBlog,
                        @RequestParam(required = false) Integer animalID, Model model,
                        @RequestParam(defaultValue = "0") int pagePro,
                        @RequestParam(defaultValue = "0") int pageBlog,
                        HttpServletRequest request) {
        Pageable pageProParams = PageRequest.of(pagePro, 6, Sort.Direction.DESC, "id");
        Pageable pageBlogParams = PageRequest.of(pageBlog, 2, Sort.Direction.DESC, "id");

        Page<Animal> animalList;
        if (animalID == null || animalID == 0) {
            animalList = animalService.getAnimalPageName(searchAnimal, pageProParams);
        } else {
            animalList = animalService.getAnimalByIdName(searchAnimal, animalID, pageProParams);
        }
        List<AnimalType> animalTypeList = animalTypeService.getAll();
        model.addAttribute("blogList", this.iBlogService.getBlog(searchBlog, pageBlogParams));
        model.addAttribute("animalTypeList", animalTypeList);
        model.addAttribute("animalList", animalList);
        model.addAttribute("request", request);
        return "index";
    }

    @GetMapping("/success")
    public String display(@RequestParam(defaultValue = "", required = false) String searchAnimal,
                          @RequestParam(defaultValue = "", required = false) String searchBlog,
                          @RequestParam(required = false) Integer animalID, Model model,
                          @RequestParam(defaultValue = "0") int pagePro,
                          @RequestParam(defaultValue = "0") int pageBlog,
                          HttpServletRequest request) {
        Pageable pageProParams = PageRequest.of(pagePro, 6, Sort.Direction.DESC, "id");
        Pageable pageBlogParams = PageRequest.of(pageBlog, 2, Sort.Direction.DESC, "id");

        Page<Animal> animalList;
        if (animalID == null || animalID == 0) {
            animalList = animalService.getAnimalPageName(searchAnimal, pageProParams);
        } else {
            animalList = animalService.getAnimalByIdName(searchAnimal, animalID, pageProParams);
        }
        List<AnimalType> animalTypeList = animalTypeService.getAll();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Customer customer = customerService.findByUsername(user.getUsername());
        Employee employee = employeeService.findByUsername(user.getUsername());
        model.addAttribute("blogList", iBlogService.getBlog(searchBlog, pageBlogParams));
        model.addAttribute("customer", customer);
        model.addAttribute("employee", employee);
        model.addAttribute("animalTypeList", animalTypeList);
        model.addAttribute("animalList", animalList);
        model.addAttribute("request", request);
        return "index";
    }
}
