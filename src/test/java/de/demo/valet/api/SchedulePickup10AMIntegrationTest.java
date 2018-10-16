package de.demo.valet.api;

import de.demo.valet.config.ValetTestConfiguration;
import de.demo.valet.ValetApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static de.demo.valet.util.StubUtils.getScheduleForOkValet;
import static de.demo.valet.util.StubUtils.getScheduleForValetStatus;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RunWith(SpringRunner.class)
@ActiveProfiles("pickup")
@SpringBootTest(classes = {ValetApplication.class, ValetTestConfiguration.class}, webEnvironment = RANDOM_PORT)
@TestPropertySource(properties = "de.demo.vallet.test.pickUpHour=10")
public class SchedulePickup10AMIntegrationTest {

    @Value("http://localhost:${local.server.port}/bryc/v1/schedule/{valet-id}")
    private String baseUrl;

    @Test
    public void testGetSchedule() {

        getScheduleForOkValet(baseUrl, 100, 900);
        getScheduleForOkValet(baseUrl,100, 900);
        getScheduleForOkValet(baseUrl, 101, 901);
        getScheduleForValetStatus(baseUrl, 102, NOT_FOUND);
    }
}
