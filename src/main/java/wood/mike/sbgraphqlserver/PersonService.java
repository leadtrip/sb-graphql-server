package wood.mike.sbgraphqlserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);
    private final RestClient restClient;

    public PersonService(RestClient.Builder restClientBuilder,
                         @Value("http://${personservice.host}:${personservice.port}") String baseUrl) {
        log.warn("Connecting to {}", baseUrl);
        this.restClient = restClientBuilder.baseUrl(baseUrl).build();
    }

    public Person getPerson(String id) {
        log.warn("Getting person with id {}", id);
        return restClient.get().uri("/people/{id}", id).retrieve().body(Person.class);
    }
}
