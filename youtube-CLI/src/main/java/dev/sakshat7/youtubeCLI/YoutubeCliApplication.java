package dev.sakshat7.youtubeCLI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import dev.sakshat7.youtubeCLI.config.YouTubeConfigProps;

@SpringBootApplication
@EnableConfigurationProperties(YouTubeConfigProps.class)
public class YoutubeCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoutubeCliApplication.class, args);
	}

}
