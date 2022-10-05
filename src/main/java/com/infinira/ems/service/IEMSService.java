package com.infinira.ems.service;

import java.util.List;
import java.util.Optional;

public interface IEMSService<T> {
    public long create(T obj);
	
	public Optional<T>  get(long id);
	
	public List<T> getAll();

    public long update(T obj);

    public long delete(long id);

}