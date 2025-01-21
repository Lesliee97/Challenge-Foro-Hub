package com.leslierodriguez.foroalura.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

public class TopicResponseDTO implements Serializable {
    private Long id;
    private String title;
    private String message;
    private Instant dateEntry;
    private Boolean status;
    private String course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(Instant dateEntry) {
        this.dateEntry = dateEntry;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
