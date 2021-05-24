package pl.test.testbackend.grafana.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.test.testbackend.grafana.dto.UserDto;
import pl.test.testbackend.grafana.model.User;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {
    User mapToUser(UserDto userDto);
}
