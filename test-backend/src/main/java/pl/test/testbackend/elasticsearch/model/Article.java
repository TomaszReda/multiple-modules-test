package pl.test.testbackend.elasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.*;

@Data
@Document(indexName = "blog")
public class Article {

    @Id
    private String id;

    @MultiField(mainField = @Field(type = Text, fielddata = true), otherFields = {@InnerField(suffix = "verbatim", type = Keyword)})
    private String title;


    @Field(type = Keyword)
    private String[] tags;


    @Field(type = Nested, includeInParent = true)
    private List<Author> authors;
}
