package com.bendrioue.expressmenu.controller;

import com.bendrioue.expressmenu.dto.SectionDto;
import com.bendrioue.expressmenu.service.SectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/section")
public class SectionController {

    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping
    public List<SectionDto> getAllSections() {
        return sectionService.getAllSections();
    }

    @GetMapping("/{id}")
    public SectionDto getSectionById(@PathVariable UUID id) {
        return sectionService.getSectionById(id);
    }

    @PostMapping
    public SectionDto createSection(@RequestBody SectionDto sectionDto) {
        return sectionService.createSection(sectionDto);
    }

    @PutMapping("/{id}")
    public SectionDto updateSection(@PathVariable UUID id, @RequestBody SectionDto sectionDto) {
        return sectionService.updateSection(id, sectionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSection(@PathVariable UUID id) {
        sectionService.deleteSection(id);
    }

}
