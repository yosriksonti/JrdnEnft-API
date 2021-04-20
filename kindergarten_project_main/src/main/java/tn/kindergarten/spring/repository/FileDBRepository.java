package tn.kindergarten.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.spring.entities.FileDB;

public interface FileDBRepository extends JpaRepository<FileDB,String > {


}
