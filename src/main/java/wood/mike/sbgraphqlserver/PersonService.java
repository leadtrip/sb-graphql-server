package wood.mike.sbgraphqlserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class PersonService {

    private final RestClient restClient;

    public PersonService(RestClient.Builder restClientBuilder,
                         @Value("${personservice.host}") String host,
                         @Value("${personservice.port}") String port) {
        this.restClient = restClientBuilder.baseUrl("http://"+host+":"+port).build();
    }

    public Person getPerson(String id) {
        return restClient.get().uri("/people/", id).retrieve().body(Person.class);
    }
}
