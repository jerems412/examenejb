package com.examen.repository;

import javax.ejb.Local;
import com.examen.entities.Cv;

@Local
public interface CvRepository extends Repository<Cv> {
	public Cv logon(String email, String password);
	public Boolean Register(Cv cv);
	public Boolean print(Cv cv);
	public String htmlcontent(Cv cv);
}
