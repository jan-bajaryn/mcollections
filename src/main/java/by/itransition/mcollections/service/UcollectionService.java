package by.itransition.mcollections.service;

import by.itransition.mcollections.dto.ShowCollectionDto;
import by.itransition.mcollections.dto.UcollectionDto;
import by.itransition.mcollections.dto.reqbody.UcollectionForCreate;
import by.itransition.mcollections.entity.ucollection.UCollection;
import by.itransition.mcollections.entity.User;
import by.itransition.mcollections.mapper.UcollectionMapper;
import by.itransition.mcollections.repos.UCollectionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UcollectionService {

    private final UCollectionRepo uCollectionRepo;
    private final UcollectionMapper ucollectionMapper;

    public List<UcollectionDto> findAll() {
        return ucollectionMapper.toUcollectionDtoList(uCollectionRepo.findAll());
    }

    public boolean save(UcollectionForCreate ucollection, User user) {
        UCollection uCollection = ucollectionMapper.toUcollection(ucollection);
        uCollection.setAuthor(user);
        UCollection save = uCollectionRepo.save(uCollection);
        return save.getId() != null;
    }

    public ShowCollectionDto showCollectionById(Integer id) {
        Optional<UCollection> byId = uCollectionRepo.findById(id);
        return byId.map(ucollectionMapper::toShowCollection).orElse(null);
    }
}
