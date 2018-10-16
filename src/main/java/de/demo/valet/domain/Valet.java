package de.demo.valet.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Valet {

    private int id;
    private String name;
}
