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

	public void addTopic(Topic topic) {
		topics.add(topic);
		System.out.println("Topic Added");
	}

	public void updateTopic(String id, Topic topic) {
		Topic t = null;
		for(int i=0; i < topics.size(); i++) {
			t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				System.out.println("Topic Updated");
				return;
			}
		}
	}
	
	public void removeTopic(String id) {
		//Using Lambda predicate
		topics.removeIf(t -> t.getId().equals(id));
		
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
