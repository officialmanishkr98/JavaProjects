package com.SpringCRUD.app.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable Integer id) {
		return topicService.getTopic(id);
	}
	
	@PostMapping("/topics")
	public Topic addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}
	
	@PutMapping("/topics/{id}")
	public String updateTopic(@RequestBody Topic topic , @PathVariable Integer id) {
		topicService.updateTopic(topic , id);
		
		return "Updation Successful";
		
	}
	
	@DeleteMapping("/topics/{id}")
	public String deleteTopic(@PathVariable Integer id) {
		topicService.deleteTopic(id);
		return "Deleted Successfully";
	}
}
