package io.sudheer.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Springframework", "Springframework Description"),
			new Topic("java", "Core Java", "Core Java description"),
			new Topic("javascript", "Javascript", "Javascript Description")
			));

	public List<Topic> getTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().get();
	}

	public String addTopic(Topic topic) {
		String message;
		if (topics.stream().anyMatch(t -> t.getId().equalsIgnoreCase(topic.getId()))) {
			message = "Already Exists";
		} else {
			topics.add(topic);
			message = "Added Topic";
		}
		
		return message;
	}

	public String updateTopic(String id, Topic topic) {
		Topic t = null;
		String message = "Not found and Not Updated";
		for(int i=0; i < topics.size(); i++) {
			t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				message = "Topic Updated";
				return message;
			}
		}
		return message;
	}
	
	public String removeTopic(String id) {
		//Using Lambda predicate
		topics.removeIf(t -> t.getId().equals(id));
		return "Topic Deleted";
		
		//General for loop
		/*Topic t = null;
		for(int i=0; i < topics.size(); i++) {
			t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.remove(i);
				System.out.println("Topic Deleted");
				return;
			}
		}*/
	}
}
