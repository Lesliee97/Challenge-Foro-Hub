package com.leslierodriguez.foroalura.service.dto;

import java.util.List;

public class UserDTO {
    private Long id;
    private String userName;
    private String email;
    private String password;
    private List<TopicResponseDTO> topics;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TopicResponseDTO> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicResponseDTO> topics) {
        this.topics = topics;
    }
}
