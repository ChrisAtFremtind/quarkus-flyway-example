package no.chris;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ApplicationStartupListener {

    void onStart(@Observes StartupEvent ev) {
        System.out.println("started!!!");
    }
}
