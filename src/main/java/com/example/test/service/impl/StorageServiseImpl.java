package com.example.test.service.impl;

import com.example.test.DataNumber;
import com.example.test.Storage;
import com.example.test.repository.StorageRepository;
import com.example.test.service.StorageServise;
import org.springframework.stereotype.Service;

@Service
public class StorageServiseImpl implements StorageServise {
    private StorageRepository repository;
     private  DataNumber dataNumber;
    @Override
    public void addStorage(String number,boolean b) {
        try {            Integer.parseInt(number);
        } catch (NumberFormatException e){}
        if (b) {
            dataNumber.setNumber(Integer.parseInt(number)+1);
        } else dataNumber.setNumber(Integer.parseInt(number));
        repository.save(dataNumber);
    }
}
