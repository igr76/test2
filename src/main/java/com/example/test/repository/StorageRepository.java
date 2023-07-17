package com.example.test.repository;

import com.example.test.DataNumber;
import com.example.test.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/** Репозиторий  чата */
@Repository
public interface StorageRepository extends JpaRepository<DataNumber,Integer> {
}
