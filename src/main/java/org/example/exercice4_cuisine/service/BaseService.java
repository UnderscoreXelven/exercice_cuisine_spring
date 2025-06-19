package org.example.exercice4_cuisine.service;

import java.util.List;

public interface BaseService <T>{
    public void delete(int id);
    public T get(int id);
    public void add(T t);
    public List<T> getAll();
}
