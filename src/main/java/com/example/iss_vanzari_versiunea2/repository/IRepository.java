package com.example.iss_vanzari_versiunea2.repository;

import java.util.List;

public interface IRepository<E> {
    E save(E agent);

    E findById(long id);

    List<E> findAll();

    void delete(E agent);
}
