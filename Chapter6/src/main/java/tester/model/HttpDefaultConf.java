package tester.model;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zjy on 17/5/26.
 */

@Data
@Component
@ConfigurationProperties(prefix = "http")
public class HttpDefaultConf {


    @NotNull
    private String encoding;

}
