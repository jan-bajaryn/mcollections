package by.itransition.mcollections.mapper;

import by.itransition.mcollections.dto.ShowCollectionDto;
import by.itransition.mcollections.entity.ucollection.UCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UcollectionMapperTest {

    @Autowired
    UcollectionMapper ucollectionMapper;

    @Test
    void toShowCollection() {
        UCollection uCollection = UCollection.builder()
                .name("aa")
                .description("bb")
                .build();

        ShowCollectionDto showCollectionDto = ucollectionMapper.toShowCollection(uCollection);
        System.out.println("showCollectionDto = " + showCollectionDto);
    }
}