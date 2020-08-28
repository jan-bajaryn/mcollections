package by.itransition.mcollections.mapper;

import by.itransition.mcollections.dto.UserDto;
import by.itransition.mcollections.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper instance = Mappers.getMapper(UserMapper.class);

    UserDto toUserDto(User user);
}
