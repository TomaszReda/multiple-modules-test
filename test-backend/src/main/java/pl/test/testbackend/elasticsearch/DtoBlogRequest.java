package pl.test.testbackend.elasticsearch;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class DtoBlogRequest {
    private String title;
    private String[] tags;
    private String author;
}
