package com.spiashko.rfetchexample.cat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.UUID;

@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
public class CatCreationModel {

    private String name;
    private LocalDate dob;
    private UUID owner;
    private UUID parent;

}
