package io.sudheer.springboot.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@RequestMapping("/allTopics")
	public List<Topic> getAllTopics() { //gets all topics from static array list within the controller class
		return Arrays.asList(
				new Topic("spring", "Springframework", "Springframework Description"),
				new Topic("java", "Core Java", "Core Java description"),
				new Topic("javascript", "Javascript", "Javascript Description")
				);
	}
	
	@Autowired 
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getTopics() { //gets all topics from static arraylist within the controller class
		return topicService.getAllTopics();
	}
}
