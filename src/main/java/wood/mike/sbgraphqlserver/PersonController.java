package wood.mike.sbgraphqlserver;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {

    @QueryMapping
    public Person personById(@Argument String id) {
        return new Person(1L, "Always", "Bob");
    }
}
