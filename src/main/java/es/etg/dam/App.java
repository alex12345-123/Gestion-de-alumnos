package es.etg.dam;

import javax.mvc.security.Csrf;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;

@ApplicationPath("app")
public class App extends Application {
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put(Csrf.CSRF_PROTECTION, Csrf.CsrfOptions.EXPLICIT);
        return props;
    }
}
