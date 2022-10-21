package com.SpringCRUD.app.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	public List<Topic> getAllTopics(){
		return topicRepository.findAll();
	}
	
	public Optional<Topic> getTopic(Integer id) {
		return topicRepository.findById(id);
	}
	
	public Topic addTopic( Topic topic ) {
		
		return topicRepository.save(topic);
	}

	public void deleteTopic(Integer id) {
		
		topicRepository.deleteById(id);
	}
	
	public void updateTopic(Topic topic , Integer id) {
		
		Optional<Topic> existingTopic = topicRepository.findById(id);
		
		existingTopic.get().setName(        topic.getName()        );
		existingTopic.get().setDescription( topic.getDescription() );
		
		topicRepository.save(existingTopic.get());
		
	}

}
