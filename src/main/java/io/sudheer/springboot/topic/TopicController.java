package io.sudheer.springboot.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@RequestMapping("/allTopics")
	//gets all topics from static array list within the controller class
	public List<Topic> getAllTopics() { 
		return Arrays.asList(
				new Topic("spring", "Springframework", "Springframework Description"),
				new Topic("java", "Core Java", "Core Java description"),
				new Topic("javascript", "Javascript", "Javascript Description")
				);
	}
	
	@Autowired 
	private TopicService topicService;
	
	@RequestMapping("/topics")
	//gets all topics using service
	public List<Topic> getTopics() { 
		return topicService.getTopics();
	}
	
	@RequestMapping("/topics/{id}")
	//gets the topic using service
	public Topic getTopic(@PathVariable("id") String id) { 
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	//adds the topic using service
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	//updates the topic using service
	public void updateTopic(@RequestBody Topic topic, @PathVariable("id") String id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	//Deletes the topic using service
	public void removeTopic(@PathVariable("id") String id) {
		topicService.removeTopic(id);
	}
}
