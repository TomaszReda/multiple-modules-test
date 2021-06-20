package pl.test.testbackend.elasticsearch;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class DtoBlogRequest {
    private String title;
    private String[] tag;
    private String author;

}
