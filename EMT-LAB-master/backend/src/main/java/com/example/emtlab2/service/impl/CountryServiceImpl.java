package com.example.emtlab2.service.impl;

import com.example.emtlab2.model.Country;
import com.example.emtlab2.repository.CountryRepository;
import com.example.emtlab2.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void create(String name, String continent) {
        Country country = new Country(name,continent);
        this.countryRepository.save(country);
    }
}
