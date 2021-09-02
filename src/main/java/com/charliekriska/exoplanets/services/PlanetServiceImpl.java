package com.charliekriska.exoplanets.services;

import com.charliekriska.exoplanets.models.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PlanetServiceImpl implements PlanetService {

    private RestTemplate restTemplate;
    private SortingService sortingService;
    private String url;
    private List<Planet> planets;

    @Autowired
    public PlanetServiceImpl(RestTemplate restTemplate, @Value("${rest.url.all}") String url, SortingService sortingService) {
        this.restTemplate = restTemplate;
        this.url = url;
        this.sortingService = sortingService;
    }

    @PostConstruct
    public void postConstruct() {
        ResponseEntity<List<Planet>> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Planet>>() {});
        planets = responseEntity.getBody();
    }

    @Override
    public List<Planet> getPlanets(String sortBy) {
        if(!sortBy.equals("")) {
            sortingService.planetSort(sortBy, planets);
        }
        return planets;

    }
}
