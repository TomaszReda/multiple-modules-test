package pl.test.testbackend.grafana.serivce;

import com.codahale.metrics.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import pl.test.testbackend.grafana.dto.UserDto;
import pl.test.testbackend.grafana.mapper.UserMapper;
import pl.test.testbackend.grafana.model.User;
import pl.test.testbackend.grafana.repository.UserRepository;

import java.util.Optional;

import com.querydsl.core.types.Predicate;

@Component
@Service
@AllArgsConstructor
public class UserServices {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final Counter counter;
    private final Timer timer;
    private final RestTemplate restTemplate;

    @Timed(name = "test_timer_add")
    public ResponseEntity add(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @io.micrometer.core.annotation.Timed
    public ResponseEntity delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Page<User>> find(Pageable pageable, Predicate predicate) {

        if (predicate == null) {
            return ResponseEntity.ok(userRepository.findAll(pageable));
        } else
            return ResponseEntity.ok(userRepository.findAll(predicate, pageable));
    }

    public void timer() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        timer.record(() -> this.restTemplate.getForObject(url, String.class));
        counter.increment();
    }
}
