package com.examen.service;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import com.examen.entities.Cv;
import com.examen.repository.ForumRepository;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
//import org.apache.activemq.ActiveMQConnection;
//import org.apache.activemq.ActiveMQConnectionFactory;

@Stateless
public class ForumService  extends Service<Cv> implements ForumRepository {
	
	
	@Override
	public List<String> receive() {
        try {
        	 /*String url = ActiveMQConnection.DEFAULT_BROKER_URL; 
        	 ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
             Connection connection = connectionFactory.createConnection();
             connection.start();
             Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
             Topic topic = session.createTopic("myTopic");
             MessageConsumer consumer = session.createConsumer(topic);*/
             List<String> messages = new ArrayList();
             /*while (true) {
                 TextMessage message = (TextMessage) consumer.receive();
                 messages.add(message.getText());
             }*/
             return messages;
        } catch(Exception e) {
        	
        }
		return null;
	}

	@Override
	public void send(String msg) {
		/*try {
			String url = ActiveMQConnection.DEFAULT_BROKER_URL; 
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
	        Connection connection = connectionFactory.createConnection();
	        connection.start();
	        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        Topic topic = session.createTopic("myTopic");
	        MessageProducer producer = session.createProducer(topic);
	        TextMessage textMessage = session.createTextMessage(msg);
	        producer.send(textMessage);
	        session.close();
	        connection.close();
		} catch(Exception e) {
			
		}*/
	}
	
	
}
