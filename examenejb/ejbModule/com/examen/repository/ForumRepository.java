package com.examen.repository;

import java.util.List;

import javax.ejb.Local;
//import javax.jms.Message;
//import javax.jms.TextMessage;

import com.examen.entities.Cv;

@Local
public interface ForumRepository extends Repository<Cv> {
	public void send(String msg);
	public List<String> receive();
}
