package com.example.test;

import com.example.test.repository.StorageRepository;
import com.example.test.service.StorageServise;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StorageServiseImplTest {
    DataNumber dataNumber;
    @Mock
    StorageServise servise;
    @Mock
    StorageRepository repository;
    @Test
    void addStorageTest() {
        dataNumber.setNumber(2);
        dataNumber.setId(1);
        when(repository.save(dataNumber)).thenReturn(dataNumber);
    }
}
