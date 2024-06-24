package br.com.avaliacao.assembleia.votacao.infrastructure.integration.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("br.com.avaliacao.assembleia.votacao.infrastructure.integration")
public class FeignClientConfiguration {

}
