package com.leslierodriguez.foroalura.service;

import com.leslierodriguez.foroalura.model.Topic;
import com.leslierodriguez.foroalura.service.dto.TopicRequestDTO;
import com.leslierodriguez.foroalura.service.dto.TopicResponseDTO;

import java.util.List;

public interface ITopicService {

    List<TopicResponseDTO> findAll();
    TopicResponseDTO findById(Long id);
    TopicResponseDTO save(TopicRequestDTO topic);
    TopicResponseDTO update(TopicRequestDTO topic, Long id);
    void delete(Long id);
}
