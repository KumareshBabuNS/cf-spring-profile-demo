package io.pivotal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bboe on 2/2/16.
 */
@RestController
public class ConfigController {

    @Value("${configstring}")
    private String configString;

    @Value("${somekey}")
    private String someKey;

    @Value("${anotherkey}")
    private String anotherKey;

    @Value("${dburi}")
    private String uri;

    @Value("${dbkey}")
    private String dbKey;

    @RequestMapping("/")
    public String getConfig() {
        return String.format("Config: %s\nSome key: %s\nAnother key: %s\nDB URI Zone: %s\nDB key: %s", configString, someKey, anotherKey, uri, dbKey);
    }
}
