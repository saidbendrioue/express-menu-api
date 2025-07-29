package com.bendrioue.expressmenu.controller;

import com.bendrioue.expressmenu.dto.FastFoodDto;
import com.bendrioue.expressmenu.service.FastFoodService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/fastfood")
public class FastFoodController {

    private final FastFoodService fastFoodService;

    public FastFoodController(FastFoodService fastFoodService) {
        this.fastFoodService = fastFoodService;
    }

    @GetMapping
    public List<FastFoodDto> getAllFastFoods() {
        return fastFoodService.getAllFastFoods();
    }

    @GetMapping("/{id}")
    public FastFoodDto getFastFoodById(@PathVariable UUID id) {
        return fastFoodService.getFastFoodById(id);
    }

    @PostMapping
    public FastFoodDto createFastFood(@RequestBody FastFoodDto fastFoodDto) {
        return fastFoodService.createFastFood(fastFoodDto);
    }

    @PutMapping("/{id}")
    public FastFoodDto updateFastFood(@PathVariable UUID id, @RequestBody FastFoodDto fastFoodDto) {
        return fastFoodService.updateFastFood(id, fastFoodDto);
    }

    @DeleteMapping("/{id}")
    public void deleteFastFood(@PathVariable UUID id) {
        fastFoodService.deleteFastFood(id);
    }
}
