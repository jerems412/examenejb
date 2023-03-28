package com.examen.repository;

import java.util.List;
import javax.ejb.Local;

@Local
public interface Repository<T> {
	public int save(T t);
	public int deleteById(int id,T t);
	public int update(T t);
	public List<T> findAll(T t);
	public T findById(int id,T t);
	public Boolean sendMail(String emailreceive);
}
