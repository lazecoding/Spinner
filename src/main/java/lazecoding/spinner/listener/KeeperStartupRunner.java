package lazecoding.spinner.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 系统启动后执行
 *
 * @author lazecoding
 */
@Component
public class KeeperStartupRunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(KeeperStartupRunner.class);


    @Override
    public void run(ApplicationArguments args) {
        try {

        } catch (Exception e) {
            logger.error("ApplicationRunner Exception", e);
        }
    }
}
