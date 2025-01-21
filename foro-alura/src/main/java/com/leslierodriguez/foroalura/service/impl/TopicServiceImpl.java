package com.leslierodriguez.foroalura.service.impl;

import com.leslierodriguez.foroalura.model.Topic;
import com.leslierodriguez.foroalura.model.User;
import com.leslierodriguez.foroalura.model.repository.TopicRepository;
import com.leslierodriguez.foroalura.service.ITopicService;
import com.leslierodriguez.foroalura.service.dto.TopicRequestDTO;
import com.leslierodriguez.foroalura.service.dto.TopicResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements ITopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<TopicResponseDTO> findAll() {
        List<Topic> topics = topicRepository.findAll();
        List<TopicResponseDTO> topicsDTO = new ArrayList<>();
        TopicResponseDTO topicDTO;
        if (!topics.isEmpty()) {
            for (Topic topic : topics) {
                topicDTO = this.topicToDTO(topic);
                topicsDTO.add(topicDTO);
            }
        }
        return topicsDTO;
    }

    @Override
    public TopicResponseDTO findById(Long id) {
        Topic topic = topicRepository.findById(id).orElse(null);
        if (topic == null) {
            return null;
        }else {
            return this.topicToDTO(topic);
        }
    }

    @Override
    public TopicResponseDTO save(TopicRequestDTO topic) {
        Topic topicModel = this.topicDtoToModel(topic);
        topicModel.setDateEntry(Instant.now());

        topicModel = topicRepository.save(topicModel);

        return this.topicToDTO(topicModel);
    }

    @Override
    public TopicResponseDTO update(TopicRequestDTO topic, Long id) {
        Topic topicModel = this.topicDtoToModel(topic);
        topicModel.setId(id);

        topicModel = topicRepository.save(topicModel);

        return this.topicToDTO(topicModel);
    }

    @Override
    public void delete(Long id) {
        this.topicRepository.deleteById(id);
    }

    public TopicResponseDTO topicToDTO(Topic topic){
        TopicResponseDTO topicDTO = new TopicResponseDTO();

        topicDTO.setId(topic.getId());
        topicDTO.setTitle(topic.getTitle());
        topicDTO.setMessage(topic.getMessage());
        topicDTO.setStatus(topic.getStatus());
        topicDTO.setDateEntry(topic.getDateEntry());
        topicDTO.setCourse(topic.getCourse());

        return topicDTO;
    }

    public Topic topicDtoToModel(TopicRequestDTO topicDto){
        Topic topic = new Topic();

        topic.setTitle(topicDto.getTitle());
        topic.setMessage(topicDto.getMessage());
        topic.setCourse(topicDto.getCourse());

        User user = new User();
        user.setId(topicDto.getIdUser());

        topic.setIdUser(user);

        return topic;
    }
}
