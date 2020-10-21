package com.spiashko.rfetchexample.person.impl;

import com.spiashko.rfetchexample.crudbase.mapperconfig.CreationMapperMappingConfig;
import com.spiashko.rfetchexample.person.Person;
import com.spiashko.rfetchexample.person.PersonCreationModel;
import org.mapstruct.Mapper;

@Mapper(config = CreationMapperMappingConfig.class)
interface PersonCreationMapper {

    Person map(PersonCreationModel creationModel);

}
