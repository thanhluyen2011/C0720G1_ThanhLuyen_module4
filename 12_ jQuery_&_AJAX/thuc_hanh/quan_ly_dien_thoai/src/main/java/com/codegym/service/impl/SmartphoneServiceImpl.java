package com.codegym.service.impl;

import com.codegym.model.Smartphone;
import com.codegym.repository.SmartphoneRepository;
import com.codegym.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {
    @Autowired
    private SmartphoneRepository repository;
    @Override
    public Iterable<Smartphone> findAll() {
        return repository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone phone) {
        return repository.save(phone);
    }

    @Override
    public Smartphone remove(Integer id) {
        Smartphone smartphone = findById(id);
        repository.delete(smartphone);
        return smartphone;
    }
}
