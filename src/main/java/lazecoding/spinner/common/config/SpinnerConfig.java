package lazecoding.spinner.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * WebSocket 服务器配置
 *
 * @author lazecoding
 */
@Configuration("serverInfo")
@ConfigurationProperties(prefix = "project.spinner-config")
public class SpinnerConfig {

}

