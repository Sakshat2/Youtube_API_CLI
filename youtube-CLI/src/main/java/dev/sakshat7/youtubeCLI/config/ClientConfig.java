package dev.sakshat7.youtubeCLI.config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import dev.sakshat7.youtubeCLI.client.YouTubeDataClient;

@Configuration(proxyBeanMethods = false)
public class ClientConfig {

    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory() {
        WebClient client = WebClient.builder()
                .baseUrl("https://youtube.googleapis.com/youtube/v3")
                .build();
        return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
    }

    @Bean
    public YouTubeDataClient youTubeDataClient(HttpServiceProxyFactory factory) {
       return factory.createClient(YouTubeDataClient.class);
    }

}