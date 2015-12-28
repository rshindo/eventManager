/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shindo
 */
@Entity
@Table(name = "user_attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAttendance.findAll", query = "SELECT u FROM UserAttendance u"),
    @NamedQuery(name = "UserAttendance.findByUserId", query = "SELECT u FROM UserAttendance u WHERE u.userAttendancePK.userId = :userId"),
    @NamedQuery(name = "UserAttendance.findByEventId", query = "SELECT u FROM UserAttendance u WHERE u.userAttendancePK.eventId = :eventId"),
    @NamedQuery(name = "UserAttendance.findByName", query = "SELECT u FROM UserAttendance u WHERE u.name = :name"),
    @NamedQuery(name = "UserAttendance.findByComment", query = "SELECT u FROM UserAttendance u WHERE u.comment = :comment")})
public class UserAttendance implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserAttendancePK userAttendancePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "name")
    private String name;
    @Size(max = 300)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Events events;

    public UserAttendance() {
    }

    public UserAttendance(UserAttendancePK userAttendancePK) {
        this.userAttendancePK = userAttendancePK;
    }

    public UserAttendance(UserAttendancePK userAttendancePK, String name) {
        this.userAttendancePK = userAttendancePK;
        this.name = name;
    }

    public UserAttendance(String userId, long eventId) {
        this.userAttendancePK = new UserAttendancePK(userId, eventId);
    }

    public UserAttendancePK getUserAttendancePK() {
        return userAttendancePK;
    }

    public void setUserAttendancePK(UserAttendancePK userAttendancePK) {
        this.userAttendancePK = userAttendancePK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userAttendancePK != null ? userAttendancePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAttendance)) {
            return false;
        }
        UserAttendance other = (UserAttendance) object;
        if ((this.userAttendancePK == null && other.userAttendancePK != null) || (this.userAttendancePK != null && !this.userAttendancePK.equals(other.userAttendancePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserAttendance[ userAttendancePK=" + userAttendancePK + " ]";
    }
    
}
