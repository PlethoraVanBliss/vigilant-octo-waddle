package de.demo.valet.config;

import de.demo.valet.domain.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.LinkedList;

@Data
@Component
@Validated
@ConfigurationProperties(prefix = "de.demo.valet.dummy-pickup-hours")
public class DummyPickupProperties {

    @NotEmpty
    private  LinkedList<PickupHour> pickups = new LinkedList<>();

}
