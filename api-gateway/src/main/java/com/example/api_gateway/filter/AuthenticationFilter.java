package com.example.api_gateway.filter;

import com.example.api_gateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

	@Autowired
	private RouteValidator validator;

	@Autowired
	private RestTemplate template;

	@Autowired
	private JwtUtil jwtUtil;

	public AuthenticationFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) -> {
			// exchange contains HttpRequest object.
			if (validator.isSecured.test(exchange.getRequest())) {
				// checking header contains token or not
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("Missing authorization header");
				}

				// Get token from header
				String authToken = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if (authToken != null && authToken.startsWith("Bearer ")) {
					authToken = authToken.substring(7);
				}
				try {
					/* REST call to AUTH service and validate token.
					 * Only when token is validated, the request will be transfered to actual microservice. 
					 */
					//template.getForObject("http://IDENTITY-SERVICE/auth/validate?token=" + authHeader, String.class);

					// Validating token in api gateway itself to avoid rest call to auth service.
					// jwtUtil.validateToken(authHeader);

				} catch (Exception e) {
					System.out.println("Failed: "+e.getStackTrace());
					throw new RuntimeException("Un authorized access to application" + e.getMessage());
				}
			}
			return chain.filter(exchange);
		});
	}

	public static class Config {

	}
}
