package com.spiashko.rfetchexample.crudbase.mapperconfig;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(componentModel = "spring", uses = ToEntityMapperSupport.class,
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreationMapperMappingConfig {
}