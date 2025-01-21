package com.leslierodriguez.foroalura.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "TOPICS")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TOPIC", nullable = false)
    private Long id;

    @Column(name = "TITLE", nullable = false, length = 120)
    private String title;

    @Column(name = "MESSAGE", length = 1000)
    private String message;

    @Column(name = "DATE_ENTRY")
    private Instant dateEntry;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USER", nullable = false)
    private User idUser;

    @ColumnDefault("1")
    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "COURSE", length = 50)
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

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
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