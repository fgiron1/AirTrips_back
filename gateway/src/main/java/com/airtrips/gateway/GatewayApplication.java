package com.airtrips.gateway;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.*;
import org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerResilience4JFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@SpringBootApplication
@RestController
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				// Circuit breakers specified for each microservice in any version of the API.
				.route(p -> p
						.path("/api/**")
						.filters(f -> f.circuitBreaker(config -> config
										.setName("global_flights")
										.setFallbackUri("forward:/fallback")))
						.uri("http://localhost:8081"))
				.route(p -> p
						.path("/api/**")
						.filters(f -> f.circuitBreaker(config -> config
								.setName("global_prices")
								.setFallbackUri("forward:/fallback")))
						.uri("http://localhost:8082"))
				.route(p -> p
						.path("/api/**")
						.filters(f -> f.circuitBreaker(config -> config
								.setName("global_metrics")
								.setFallbackUri("forward:/fallback")))
						.uri("http://localhost:8083"))
				// FLIGHT MICROSERVICE
				.route(p -> p
						.path("api/v1/**")
						.uri("http://localhost:8081"))
				.build();

	}

	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
				.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build()).build());
	}

	@RequestMapping("/fallback")
	public Mono<String> fallback(){
		return Mono.just("Too many requests!");
	}
}
