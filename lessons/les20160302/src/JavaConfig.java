import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.itis.softilnyr.BioInstitute;
import ru.kpfu.itis.softilnyr.ITInstitute;
import ru.kpfu.itis.softilnyr.Institute;

/**
 * Created by softi on 02.03.2016.
 */
@Configuration
@ComponentScan(basePackages = "ru.kpfu.itis.softilnyr")
public class JavaConfig {
    @Bean
    @Qualifier("it")
    //@Scope("prototype")
    public Institute itinstitute() {
        return new ITInstitute("ITIS");
    }

    @Bean
    @Qualifier("bio")
    public Institute bioinstitute() {
        return new BioInstitute();
    }
}
