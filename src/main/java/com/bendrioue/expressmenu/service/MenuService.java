package com.bendrioue.expressmenu.service;

import com.bendrioue.expressmenu.dto.MenuDto;
import com.bendrioue.expressmenu.exception.MenuNotFoundException;
import com.bendrioue.expressmenu.mapper.AppMapper;
import com.bendrioue.expressmenu.model.Menu;
import com.bendrioue.expressmenu.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MenuService {
    
    private final MenuRepository menuRepository;
    private final AppMapper appMapper;
    
    public MenuService(MenuRepository menuRepository, AppMapper appMapper) {
        this.menuRepository = menuRepository;
        this.appMapper = appMapper;
    }
    
    public List<MenuDto> getAllMenus() {
        return menuRepository.findAll().stream()
                .map(appMapper::menuToMenuDto)
                .toList();
    }
    
    public MenuDto getMenuById(UUID id) {
        return menuRepository.findById(id)
                .map(appMapper::menuToMenuDto)
                .orElseThrow(() -> new MenuNotFoundException(id));
    }
    
    public MenuDto createMenu(MenuDto menuDto) {
        Menu menu = appMapper.menuDtoToMenu(menuDto);
        return appMapper.menuToMenuDto(menuRepository.save(menu));
    }
    
    public MenuDto updateMenu(UUID id, MenuDto menuDto) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException(id));
        Menu updatedMenu = appMapper.menuDtoToMenu(menuDto);
        updatedMenu.setId(menu.getId());
        return appMapper.menuToMenuDto(menuRepository.save(updatedMenu));
    }
    
    public void deleteMenu(UUID id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException(id));
        menuRepository.delete(menu);
    }
}
