package com.spiashko.rfetchexample.cat.impl;

import com.spiashko.rfetchexample.cat.Cat;
import com.spiashko.rfetchexample.cat.CatCreationModel;
import com.spiashko.rfetchexample.crudbase.mapperconfig.CreationMapperMappingConfig;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import javax.persistence.EntityManager;

@Mapper(config = CreationMapperMappingConfig.class)
interface CatCreationMapper {

    Cat map(CatCreationModel creationModel, @Context EntityManager entityManager);

}
