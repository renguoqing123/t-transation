package conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring配置类, 相当于bean.xml
 */
@Configuration
@ComponentScan("com.hr")
@Import({JdbcConfig.class,TransactionManager.class})
@EnableTransactionManagement   //开启Spring对注解的支持
public class SpringConfiguration {
}
