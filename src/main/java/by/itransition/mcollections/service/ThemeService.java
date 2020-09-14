package by.itransition.mcollections.service;


import by.itransition.mcollections.dto.ThemeDto;
import by.itransition.mcollections.mapper.ThemeMapper;
import by.itransition.mcollections.repos.ThemeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemeService {
    private final ThemeRepo themeRepo;
    private final ThemeMapper themeMapper;

    public List<ThemeDto> findAll() {
        return themeMapper.toThemeDto(themeRepo.findAll());
    }
}
