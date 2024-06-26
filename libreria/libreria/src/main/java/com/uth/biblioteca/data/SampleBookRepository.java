package com.uth.biblioteca.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SampleBookRepository extends JpaRepository<Libro, Long>, JpaSpecificationExecutor<Libro> {

}
