package com.adidyk.service;

import com.adidyk.model.SmartPhone;
import com.adidyk.repository.SmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SmartPhoneService {

    /**
     *
     */
    private final SmartPhoneRepository repository;


    /**
     *
     * @param repository - repository.
     */
    @Autowired
    public SmartPhoneService(SmartPhoneRepository repository) {
        this.repository = repository;
    }

    /**
     * create - create.
     * @param smartPhone - smart phone.
     */
    public void add(SmartPhone smartPhone) {
        this.repository.save(smartPhone);
    }

    /**
     *
     * @param id - id.
     * @return - SmartPhone.
     */

    public SmartPhone get(Integer id) {
        return  this.repository.findById(id).get();
    }

    /*
    public void update(SmartPhone smartPhone) {
        this.repository

    }
    */

}