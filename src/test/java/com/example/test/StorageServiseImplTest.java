package com.example.test;

import com.example.test.repository.StorageRepository;
import com.example.test.service.StorageServise;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StorageServiseImplTest {
    DataNumber dataNumber;
    @Mock
    StorageServise servise;
    @Mock
    StorageRepository repository;
    @Test
    void addStorageTest() {
        dataNumber = new DataNumber();
        dataNumber.setNumber(2);
        dataNumber.setId(1);
        when(repository.save(dataNumber)).thenReturn(dataNumber);
        servise.addStorage("2",true);
        verify(repository, times(1)).save(any());
    }
}
