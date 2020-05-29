package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    CarRepository carRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/home")
    public String carlist(Model model){
        model.addAttribute("allcats", categoryRepository.findAll());
        model.addAttribute("allcars", carRepository.findAll());
        return "catslist";
    }
    @RequestMapping("/")
    public String categorylist(Model model){
        //model.addAttribute("allcats", categoryRepository.findAll());
        model.addAttribute("allcats", categoryRepository.findAll());
        return "categorylist";
    }
    @GetMapping("/add")
    public String addcatgory(Model model){
        model.addAttribute("category", new Category());
        return "catsform";
    }
    @GetMapping("/addcar")
    public String addcar(Model model){
        model.addAttribute("car", new Car());
        model.addAttribute("allcats", categoryRepository.findAll());
        return "carform";
    }
    @PostMapping("/process")
    public String catogryprocessing(@ModelAttribute Category category, Model model){
        categoryRepository.save(category);

        return "redirect:/home";
    }
    @RequestMapping("/carlist")
    public String carlisting(Model model){

        model.addAttribute("allcars", carRepository.findAll());
        return "categorylist";
    }

    @PostMapping("/carprocess")
    public String carprocessing(@ModelAttribute Car car, Model model){
        carRepository.save(car);
        return "redirect:/home";
    }

    @RequestMapping("/detail/{id}")
    public String detaillist(@PathVariable("id")long id, Model model){
     model.addAttribute("car", carRepository.findById(id).get());
        return "cardetail";
    }


    @RequestMapping("/delete/{id}")
    public String carDelete(@PathVariable("id") long id){
        carRepository.deleteById(id);
        return "redirect:/home";
    }

    @RequestMapping("/update/{id}")
    public String carupdate(@PathVariable("id")long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        model.addAttribute("allcats", categoryRepository.findAll());
        return "carform";
    }



    @RequestMapping("/catdelete/{id}")
    public String cateDelete(@PathVariable("id") long id){
        categoryRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/catupdate/{id}")
    public String cateupdate(@PathVariable("id")long id, Model model){
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "catsform";
    }
}

