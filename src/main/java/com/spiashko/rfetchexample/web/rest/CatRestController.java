package com.spiashko.rfetchexample.web.rest;

import com.spiashko.rfetchexample.cat.Cat;
import com.spiashko.rfetchexample.cat.CatCreationModel;
import com.spiashko.rfetchexample.cat.CatCreationService;
import com.spiashko.rfetchexample.cat.CatSearchService;
import com.spiashko.rfetchexample.rfetch.RfetchSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CatRestController {

    private final CatCreationService creationService;
    private final CatSearchService searchService;

    @PostMapping("/cats")
    public Cat create(@RequestBody CatCreationModel createRequest) {
        Cat result = creationService.create(createRequest);
        return result;
    }

    @GetMapping("/cats")
    public List<Cat> findAll(
            @RfetchSpec Specification<Cat> spec
    ) {
        List<Cat> result = searchService.findAll(spec);
        return result;
    }

}
