package org.gslearn.gatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(1)
@Component
public class RequestTraceFilter implements GlobalFilter {

  private static final Logger logger = LoggerFactory.getLogger(RequestTraceFilter.class);

  @Autowired
  FilterUtility filterUtility;

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    HttpHeaders headers = exchange.getRequest().getHeaders();
    if(isCorrelationIdPresent(headers)){
      logger.debug("Correlation ID present in request Filter : {}", filterUtility.getCorrelationId(headers));
    } else{
      String correlationId = generateCorrelationId();
      exchange = filterUtility.setCorrelationId(exchange, correlationId);
      logger.debug("Correlation ID present in generated in Request Filter : {}", correlationId);
    }
    return chain.filter(exchange);
  }

  private String generateCorrelationId() {
    return java.util.UUID.randomUUID().toString();
  }

  private boolean isCorrelationIdPresent(HttpHeaders headers) {
    return filterUtility.getCorrelationId(headers) != null;
  }
}
