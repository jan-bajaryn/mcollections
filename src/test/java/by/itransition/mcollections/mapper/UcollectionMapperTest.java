package by.itransition.mcollections.mapper;

import by.itransition.mcollections.dto.ShowCollectionDto;
import by.itransition.mcollections.entity.UCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UcollectionMapperTest {

    @Autowired
    UcollectionMapper ucollectionMapper;

    @Test
    void toShowCollection() {
        UCollection uCollection = UCollection.builder()
                .bool1Name("1")
                .name("aa")
                .description("bb")
                .build();

        ShowCollectionDto showCollectionDto = ucollectionMapper.toShowCollection(uCollection);
        System.out.println("showCollectionDto = " + showCollectionDto);
    }
}