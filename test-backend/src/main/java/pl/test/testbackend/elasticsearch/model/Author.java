package pl.test.testbackend.elasticsearch.model;
import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@AllArgsConstructor
public class Author {
    @Field(type = Text)
    private String name;
}
