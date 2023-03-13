package gov.iti.jets.ecommiti.mappers;

import gov.iti.jets.ecommiti.dtos.UserDTO;
import gov.iti.jets.ecommiti.dtos.response.CategoryResponseDto;
import gov.iti.jets.ecommiti.models.Category;
import gov.iti.jets.ecommiti.models.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserDTO> map(List<User> user);

    @InheritInverseConfiguration
    UserDTO map(User user);
}
