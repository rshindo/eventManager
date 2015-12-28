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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shindo
 */
@Entity
@Table(name = "user_attendance_date")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAttendanceDate.findAll", query = "SELECT u FROM UserAttendanceDate u"),
    @NamedQuery(name = "UserAttendanceDate.findByUserId", query = "SELECT u FROM UserAttendanceDate u WHERE u.userAttendanceDatePK.userId = :userId"),
    @NamedQuery(name = "UserAttendanceDate.findByEventId", query = "SELECT u FROM UserAttendanceDate u WHERE u.userAttendanceDatePK.eventId = :eventId"),
    @NamedQuery(name = "UserAttendanceDate.findByEventScheduleId", query = "SELECT u FROM UserAttendanceDate u WHERE u.userAttendanceDatePK.eventScheduleId = :eventScheduleId"),
    @NamedQuery(name = "UserAttendanceDate.findByAttendance", query = "SELECT u FROM UserAttendanceDate u WHERE u.attendance = :attendance")})
public class UserAttendanceDate implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserAttendanceDatePK userAttendanceDatePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "attendance")
    private boolean attendance;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Events events;
    @JoinColumn(name = "event_schedule_id", referencedColumnName = "schedule_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EventScheduledDate eventScheduledDate;

    public UserAttendanceDate() {
    }

    public UserAttendanceDate(UserAttendanceDatePK userAttendanceDatePK) {
        this.userAttendanceDatePK = userAttendanceDatePK;
    }

    public UserAttendanceDate(UserAttendanceDatePK userAttendanceDatePK, boolean attendance) {
        this.userAttendanceDatePK = userAttendanceDatePK;
        this.attendance = attendance;
    }

    public UserAttendanceDate(String userId, long eventId, long eventScheduleId) {
        this.userAttendanceDatePK = new UserAttendanceDatePK(userId, eventId, eventScheduleId);
    }

    public UserAttendanceDatePK getUserAttendanceDatePK() {
        return userAttendanceDatePK;
    }

    public void setUserAttendanceDatePK(UserAttendanceDatePK userAttendanceDatePK) {
        this.userAttendanceDatePK = userAttendanceDatePK;
    }

    public boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public EventScheduledDate getEventScheduledDate() {
        return eventScheduledDate;
    }

    public void setEventScheduledDate(EventScheduledDate eventScheduledDate) {
        this.eventScheduledDate = eventScheduledDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userAttendanceDatePK != null ? userAttendanceDatePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAttendanceDate)) {
            return false;
        }
        UserAttendanceDate other = (UserAttendanceDate) object;
        if ((this.userAttendanceDatePK == null && other.userAttendanceDatePK != null) || (this.userAttendanceDatePK != null && !this.userAttendanceDatePK.equals(other.userAttendanceDatePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserAttendanceDate[ userAttendanceDatePK=" + userAttendanceDatePK + " ]";
    }
    
}
