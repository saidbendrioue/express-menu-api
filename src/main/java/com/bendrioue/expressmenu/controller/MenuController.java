package com.bendrioue.expressmenu.controller;

import com.bendrioue.expressmenu.dto.FastFoodDto;
import com.bendrioue.expressmenu.dto.MenuDto;
import com.bendrioue.expressmenu.service.FastFoodService;
import com.bendrioue.expressmenu.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class MenuController {

    private final MenuService menuService;
    private final FastFoodService fastFoodService;

    public MenuController(MenuService menuService,
                          FastFoodService fastFoodService) {
        this.menuService = menuService;
        this.fastFoodService = fastFoodService;
    }

    @GetMapping("/menu/{menuUUID}")
    public String getMenu(@PathVariable UUID menuUUID, Model model) {
        // The menuUUID is now correctly passed from the URL
        MenuDto menu = menuService.getMenuById(menuUUID);

        // Assumes FastFoodDto's ID is a UUID, which is good practice.
        FastFoodDto fastFood = fastFoodService.getFastFoodById(menu.getFastFoodId());

        model.addAttribute("menu", menu);
        model.addAttribute("fastFood", fastFood);

        // Your new template name is correctly used here
        return "menu-page";
    }
    
}