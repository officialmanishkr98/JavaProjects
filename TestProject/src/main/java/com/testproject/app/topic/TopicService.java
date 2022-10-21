package com.testproject.app.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private ArrayList<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring" , "Spring Framework" , "Spring Framework Description"),
			new Topic("Java" , "Java Framework" , "Java Framework Description"),
			new Topic("JavaScript" , "Node.js Framework" , "Node.js Framework Description"),
			new Topic("JavaScript" , "Node.js Framework" , "Node.js Framework Description")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter( t -> t.getId().equals(id)).findFirst().get();
	}
	
	public Topic addTopic( Topic topic ) {
		topics.add(topic);
		return topic;
	}
	
	@SuppressWarnings("unlikely-arg-type")
//	public String deleteTopic(String id) {
//		
//		boolean result = false;
//
//		for(int i=0; i<topics.size(); i++) {
//			if( id.equals( topics.get(i).getId() ) ) {
//				result = topics.remove(i) != null;
//				break;
//			}
//		}
//
//		if(result) return "Topic with the id " + id + " is Deleted ";
//		
//		return "not done";
//	}
	//------------ For all the elements ---------------------------------------------
	public String deleteTopic(String id) {
		
		boolean result = false;

		result = topics.removeIf(t -> t.getId().equals(id) ); 

		if(result) return "Topic with the id " + id + " is Deleted ";
		
		return "not done";
	}
	
	public String updateTopic(Topic topic , String id) {
		
		boolean result = false;
		
		for(int i=0; i<topics.size(); i++) {
			if(topics.get(i).getId().equals(id)) {
				
				result = true;
				
				topics.get(i).setId(          topic.getId()          );
				topics.get(i).setName(        topic.getName()        );
				topics.get(i).setDescription( topic.getDescription() );
			}
		}

		if(result) return "Topic with the id: " + id + " is Update";
		
		return "-------- Topic is NOT Update --------";
	}

}
