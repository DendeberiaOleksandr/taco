package com.dendeberia.taco.controller;

import com.dendeberia.taco.entities.Ingredient;
import com.dendeberia.taco.entities.Order;
import com.dendeberia.taco.entities.Taco;
import com.dendeberia.taco.entities.User;
import com.dendeberia.taco.repositories.IngredientRepository;
import com.dendeberia.taco.repositories.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;
    private final TacoRepository tacoRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository tacoRepository){
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }

    @ModelAttribute("order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute("taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping()
    public String showDesignForm(Model model, @AuthenticationPrincipal User user){
        System.out.println(user);
        List<Ingredient> ingredients = new ArrayList<>();

        for (Ingredient ingredient : ingredientRepository.findAll()) {
            ingredients.add(ingredient);
        }

        Ingredient.Type types[] = Ingredient.Type.values();

        for(Ingredient.Type type : types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }


        return "design";
    }

    @PostMapping
    public String saveDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order){

        if(errors.hasErrors()){
            for (ObjectError allError : errors.getAllErrors()) {
                System.out.println(allError.toString());
            }
            return "redirect:/design";
        }

        Taco savedTaco = tacoRepository.save(design);
        order.addDesign(savedTaco);


        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type){
        List<Ingredient> result = new ArrayList<>();

        for(Ingredient ingredient : ingredients){
            if(ingredient.getType().toString().equals(type.toString())){
                result.add(ingredient);
            }
        }

        return result;
    }

}
