package com.daenamu.drama.feign;

import feign.RequestInterceptor;
import io.micrometer.tracing.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignTracingConfig {

    @Bean
    public RequestInterceptor tracingInterceptor(Tracer tracer){
        return requestTemplate -> {
            if(tracer.currentSpan() != null){
                String traceId = tracer.currentSpan().context().traceId();
                String spanId = tracer.currentSpan().context().spanId();
                String sampled = "1";
                requestTemplate.header("b3", traceId + "-" + spanId + "-" + sampled);
            }
        };
    }
}
