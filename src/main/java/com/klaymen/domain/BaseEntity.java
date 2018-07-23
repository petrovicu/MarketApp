package com.klaymen.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by petrovicu on 19/07/2018.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    public static final int STARTING_VERSION = -1;
    public static final String $version = "version";
    public static final String $id = "id";

    @Version
    private Integer version = STARTING_VERSION;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @Column(name = "created_by")
    private String createdBy;

    //  @Column(columnDefinition = "int default 0")
    @Column(columnDefinition = "NUMBER(1,0) default 0", nullable = false)
    private Boolean deleted = false;

    @Column(name = "deleted_date")
    private Date deletedDate;

    @Column(name = "deleted_comment")
    private String deletedComment;


    @PrePersist
    protected void onCreate() {
        updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    public boolean isNew() {
        return (getVersion() == STARTING_VERSION);
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedComment() {
        return deletedComment;
    }

    public void setDeletedComment(String deletedComment) {
        this.deletedComment = deletedComment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == 0) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BaseEntity other = (BaseEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + (id != null ? id.toString() : "");
    }

}