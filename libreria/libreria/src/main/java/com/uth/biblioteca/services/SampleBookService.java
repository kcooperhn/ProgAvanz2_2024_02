package com.uth.biblioteca.services;

import com.uth.biblioteca.data.Libro;
import com.uth.biblioteca.data.SampleBookRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class SampleBookService {

    private final SampleBookRepository repository;

    public SampleBookService(SampleBookRepository repository) {
        this.repository = repository;
    }

    public Optional<Libro> get(Long id) {
        return repository.findById(id);
    }

    public Libro update(Libro entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<Libro> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Libro> list(Pageable pageable, Specification<Libro> filter) {
        return repository.findAll(filter, pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
