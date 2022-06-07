package com.fst.sir.bean;


import com.fst.sir.security.bean.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;

    // important,not,alert,....
    private String status;

    private Boolean seen=false;
    @Lob
    private String message;

    private Date addedAt;

    private Date seenAt;

    @ManyToOne
    private User user;

    public Notification() {
    }

    public Notification(String status, Boolean seen, String message, Date addedAt, User user) {
        this.status = status;
        this.seen = seen;
        this.message = message;
        this.addedAt = addedAt;
        this.user = user;
    }

    public Notification(Long id, String reference, String status, Boolean seen, String message, Date addedAt, Date seenAt, User user) {
        this.id = id;
        this.reference = reference;
        this.status = status;
        this.seen = seen;
        this.message = message;
        this.addedAt = addedAt;
        this.seenAt = seenAt;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    public Date getSeenAt() {
        return seenAt;
    }

    public void setSeenAt(Date seenAt) {
        this.seenAt = seenAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
