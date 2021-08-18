package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ICustomerService;

import java.util.ArrayList;

@Controller
public class CustomerController {
    ArrayList<Customer> list = new ArrayList<>();
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        list = iCustomerService.findAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/edit/{index}")
    public ModelAndView showEdit(@PathVariable int index) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer", list.get(index));
        return modelAndView;
    }

    @GetMapping("/delete/{index}")
    public String delete(@PathVariable int index) {
        iCustomerService.Delete(list.get(index));
        return "redirect:/show";
    }

    @PostMapping("/edit/{index}")
    public String edit(@ModelAttribute Customer customer) {
        iCustomerService.edit(customer);
        return "redirect:/show";
    }
}
