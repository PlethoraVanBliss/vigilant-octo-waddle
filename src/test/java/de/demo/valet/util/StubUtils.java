package de.demo.valet.util;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

import java.time.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.springframework.http.HttpStatus.OK;

@UtilityClass
public class StubUtils {

    public static Clock getClock(LocalDateTime dateTime){
            OffsetDateTime offsetDateTime = OffsetDateTime.now();
            return Clock.fixed(dateTime.toInstant(offsetDateTime.getOffset()), offsetDateTime.getOffset());
    }

    public static void getScheduleForOkValet(String baseUrl, int valetId, int pickUpId){

        //@formatter:off
        given()
                .get(baseUrl, valetId)
        .then().log().all()
                .statusCode(OK.value())
                .body("pickup.id", is(pickUpId))
                .body("valet.id", is(valetId))
                .body("id", notNullValue())
        ;
        //@formatter:on
    }

    public static void getScheduleForValetStatus(String baseUrl, int valetId, HttpStatus httpStatus){

        //@formatter:off
        given()
                .get(baseUrl, valetId)
        .then().log().all()
                .statusCode(httpStatus.value())
        ;
        //@formatter:on
    }
}
