package com.example.capstone_project.controller.animal;

import com.example.capstone_project.dto.animal.AnimalDto;
import com.example.capstone_project.model.animal.Animal;
import com.example.capstone_project.model.animal.AnimalType;
import com.example.capstone_project.service.animal.IAnimalService;
import com.example.capstone_project.service.animal.IAnimalTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class AnimalControllor {

    @Autowired
    private IAnimalService animalService;
    @Autowired
    private IAnimalTypeService animalTypeService;

    @GetMapping("")
    public String displayBlog(Model model, @PageableDefault() Pageable pageable) {
        Page<Animal> animalList = animalService.getBlogPage(pageable);
        List<AnimalType> animalTypeList = animalTypeService.getAll();
        model.addAttribute("animalTypeList", animalTypeList);
        model.addAttribute("animalList", animalList);
        return "/index";
    }

    @GetMapping("/find/{id}")
    public String findAnimalByType(@PathVariable(value = "id") int id, Model model) {
        List<Animal> animalList = animalService.getAllByType(id);
        model.addAttribute("animalList", animalList);
        return "/index";
    }

    @GetMapping("/deleteAnimal")
    public String deleteAnimal(@RequestParam(value = "id") int id, RedirectAttributes redirectAttributes) {
        animalService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Xoá thành công");
        return "redirect:/home/success";
    }

    @GetMapping("/creatAnimal")
    public String createAnimal(Model model) {
        List<AnimalType> animalTypeList = animalTypeService.getAll();
        AnimalDto animalDto = new AnimalDto();
        model.addAttribute("animalTypeList", animalTypeList);
        model.addAttribute("animalDto", animalDto);
        return "/animal/animalCreat";
    }

    @GetMapping("/creat")
    public String create(@Validated @ModelAttribute(value = "animalDto") AnimalDto animalDto,
                         BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<AnimalType> animalTypeList = animalTypeService.getAll();
            model.addAttribute("animalTypeList", animalTypeList);
            model.addAttribute("animalDto", animalDto);
            return "/animal/animalCreat";
        }
        Animal animal = new Animal();
        BeanUtils.copyProperties(animalDto, animal);
        animalService.creat(animal);
        redirectAttributes.addFlashAttribute("message", "Thêm mới động vật thành công");
        return "redirect:/home/success";
    }

    @GetMapping("/updateAnimal/{id}")
    public String updateAnimal(@PathVariable int id, Model model) {
        Animal animal = animalService.getById(id);
        AnimalDto animalDto = new AnimalDto();
        BeanUtils.copyProperties(animal, animalDto);
        List<AnimalType> animalTypeList = animalTypeService.getAll();
        model.addAttribute("animalTypeList", animalTypeList);
        model.addAttribute("animalDto", animalDto);
        return "/animal/animalUpdate";
    }

    @GetMapping("/update")
    public String update(@Validated @ModelAttribute(value = "animalDto") AnimalDto animalDto,
                         BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<AnimalType> animalTypeList = animalTypeService.getAll();
            model.addAttribute("animalTypeList", animalTypeList);
            model.addAttribute("animalDto", animalDto);
            return "/animal/animalUpdate";
        }
        Animal animal = new Animal();
        BeanUtils.copyProperties(animalDto, animal);
        animalService.updateById(animal);
        redirectAttributes.addFlashAttribute("message", "Cập nhật động vật thành công");
        return "redirect:/home/success";
    }
}
