package by.itransition.mcollections.service;

import by.itransition.mcollections.dto.UcollectionDto;
import by.itransition.mcollections.entity.UCollection;
import by.itransition.mcollections.mapper.UcollectionMapper;
import by.itransition.mcollections.repos.UCollectionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UcollectionService {

    private final UCollectionRepo uCollectionRepo;
    private final UcollectionMapper ucollectionMapper;

    public List<UcollectionDto> findAll(){
        return ucollectionMapper.toUcollectionDtoList(uCollectionRepo.findAll());
    }
}
