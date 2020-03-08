package core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
public class BaseEntity implements Serializable {

    @JsonProperty
    @Column(name = "ACTIVE")
    protected boolean active;

    @JsonProperty
    @Column(name = "CREATEDBY")
    protected String createdBy;

    @JsonProperty
    @Column(name = "CRETATED")
    @Temporal(TemporalType.TIMESTAMP)
    protected LocalDateTime created;

    @JsonProperty
    @Column(name = "UPDATEBY")
    protected String updatedBy;

    @JsonProperty
    @Column(name = "UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    protected LocalDateTime updated;

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @PrePersist
    public void onPrePersist() {
        setCreated(LocalDateTime.now());
    }

    @PreUpdate
    public void onPreUpdate() {
        setUpdated(LocalDateTime.now());
    }
}
