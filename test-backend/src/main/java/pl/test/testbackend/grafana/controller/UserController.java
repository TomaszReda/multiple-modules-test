package pl.test.testbackend.grafana.controller;

import com.querydsl.core.types.Predicate;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.test.testbackend.grafana.dto.UserDto;
import pl.test.testbackend.grafana.model.User;
import pl.test.testbackend.grafana.serivce.UserServices;


@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
@Timed
public class UserController {
    private final UserServices userServices;

    @GetMapping("/find")
    public ResponseEntity<Page<User>> getUsers(Pageable pageable, Predicate predicate) {
        return userServices.find(pageable, predicate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return userServices.delete(id);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody UserDto userDto) {
        return userServices.add(userDto);
    }


    @GetMapping("/timer")
    public ResponseEntity timer() {
        userServices.timer();
        return ResponseEntity.ok().build();
    }

}
