package com.example.demothymeleaft.controller;

import com.example.demothymeleaft.model.dto.CategoryDto;
import com.example.demothymeleaft.model.entity.CategoryEntity;
import com.example.demothymeleaft.service.CategoriService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoriService categoriService;


    @GetMapping("/add")
    public String add(Model model){

        model.addAttribute("category", new CategoryDto());


        return "category/addOrEdit";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(ModelMap model, @PathVariable("id") Long id){
        Optional<CategoryEntity> opt = categoriService.findById(id);

        CategoryDto categoryDto = new CategoryDto();
        if(opt.isPresent()){// có thông tin trả về
            CategoryEntity entity = opt.get();// lấy thông tin của xategory

            BeanUtils.copyProperties(entity,categoryDto);// copy thông tin sang dto
            categoryDto.setIsEdit(true);

            model.addAttribute("category", categoryDto);

            return new ModelAndView( "category/addOrEdit",model);// chuyền dto sang view
        }
        model.addAttribute("message","Category is not exitted");
        return new ModelAndView( "forward:/categories",model);
    }

    @GetMapping("/delete/{id}")
    public String delete(){
        return "redirect:/categories";
    }

    @PostMapping("/saveOrUpdate")
    public ModelAndView saveOrUpdate(
            ModelMap model,
            @Valid @ModelAttribute("category") CategoryDto categoryDto, BindingResult result){

        if(result.hasErrors()){
            return new ModelAndView("category/addOrEdit");
        }

        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(categoryDto,categoryEntity);
        categoriService.create(categoryEntity);
        model.addAttribute("message","Category is saved");


        return new ModelAndView("forward:/categories",model);
    }

    @RequestMapping("")
    public String list(ModelMap model){
        List<CategoryEntity> list = categoriService.findAll();

        model.addAttribute("categories",list);

        return "category/list";
    }

    @GetMapping("/search")
    public String search(){
        return "category/search";
    }


}
