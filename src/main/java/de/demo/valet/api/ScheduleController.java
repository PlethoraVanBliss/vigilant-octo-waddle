package de.demo.valet.api;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import de.demo.valet.service.*;
import de.demo.valet.domain.*;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/v1/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @RequestMapping(value = "/{valet-id}", method = GET, produces = APPLICATION_JSON_VALUE)
    @ApiOperation("Get current or next available pick up")
    public ScheduledPickup getAvailablePickup(@PathVariable("valet-id") int valetId) {
        log.info("Get scheduled PickupHour [{}]", valetId);
        return scheduleService.getCurrentOrNextAvailablePickup(valetId);
    }
}
