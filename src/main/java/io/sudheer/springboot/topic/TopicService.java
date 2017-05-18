package io.sudheer.springboot.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	List<Topic> topics = Arrays.asList(
			new Topic("spring", "Springframework", "Springframework Description"),
			new Topic("java", "Core Java", "Core Java description"),
			new Topic("javascript", "Javascript", "Javascript Description")
			);

	public List<Topic> getAllTopics() {
		return topics;
	}
}
