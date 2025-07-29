package com.bendrioue.expressmenu.controller;

import com.bendrioue.expressmenu.dto.FastFoodDto;
import com.bendrioue.expressmenu.dto.MenuDto;
import com.bendrioue.expressmenu.service.FastFoodService;
import com.bendrioue.expressmenu.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

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
        MenuDto menu = menuService.getMenuById(menuUUID);

        FastFoodDto fastFood = fastFoodService.getFastFoodById(menu.getFastFoodId());
        
        if (fastFood.getMenus() == null) {
            fastFood.setMenus(new ArrayList<>());
        }
        model.addAttribute("fastFood", fastFood);

        model.addAttribute("menu", menu);
        model.addAttribute("isOpen", true);
        model.addAttribute("now", LocalTime.now());
        return "menu-page";
    }

    @GetMapping("/api/menu")
    public List<MenuDto> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/api/menu/{menuUUID}")
    public MenuDto getMenuById(@PathVariable UUID menuUUID) {
        return menuService.getMenuById(menuUUID);
    }

    @PostMapping("/api/menu")
    public MenuDto createMenu(@RequestBody MenuDto menu) {
        return menuService.createMenu(menu);
    }

    @PutMapping("/api/menu/{menuUUID}")
    public MenuDto updateMenu(@PathVariable UUID menuUUID, @RequestBody MenuDto menu) {
        return menuService.updateMenu(menuUUID, menu);
    }

    @DeleteMapping("/api/menu/{menuUUID}")
    public void deleteMenu(@PathVariable UUID menuUUID) {
        menuService.deleteMenu(menuUUID);
    }

}