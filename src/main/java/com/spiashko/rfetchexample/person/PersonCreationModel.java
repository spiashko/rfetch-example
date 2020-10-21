package com.spiashko.rfetchexample.person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
public class PersonCreationModel {

    private String name;

}
