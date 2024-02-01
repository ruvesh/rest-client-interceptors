package io.github.ruvesh.restclientinterceptors.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class JsonPlaceHolderRestClient {

    private static final Logger log = LoggerFactory.getLogger(JsonPlaceHolderRestClient.class);

    private final RestClient restClient;

    public JsonPlaceHolderRestClient(RestClient.Builder restClientBuilder, ClientHttpRequestInterceptor restInterceptor) {
        this.restClient = restClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .requestFactory(new JdkClientHttpRequestFactory())
                .requestInterceptor(restInterceptor)
                /*
                    * above can be replaced by following lambda if the requirement is as simple as
                    * just appending header to the request
                    *
                    * In real usage, it would be more complicated, thus creating a separate class for the interceptor
                    * should be preferred
                    *
                    * Usage of RestInterceptor only for the purpose of adding/modifying headers is not advisable.
                    * That can be easily achieved with the RestClient itself.
                 */
//                .requestInterceptor(((request, body, execution) -> {
//                    log.info("Intercepting request: {}", request.getURI());
//                    request.getHeaders().add("x-request-id", "1234");
//                    return execution.execute(request, body);
//                }))
                .build();
    }

    @Bean
    public RestClient getRestClient(){
        return restClient;
    }

}
