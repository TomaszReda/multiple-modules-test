package pl.test.testbackend.grafana.repository;

import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.test.testbackend.grafana.model.QUser;
import pl.test.testbackend.grafana.model.User;


@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {

    @Override
    default void customize(QuerydslBindings bindings, QUser root) {
        bindings.bind(String.class).first(
                (StringPath path, String value) -> path.containsIgnoreCase(value));
    }
}
