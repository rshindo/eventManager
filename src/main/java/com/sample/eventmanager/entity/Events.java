/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Shindo
 */
@Entity
@Table(name = "events")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Events.findAll", query = "SELECT e FROM Events e"),
    @NamedQuery(name = "Events.findByEventId", query = "SELECT e FROM Events e WHERE e.eventId = :eventId"),
    @NamedQuery(name = "Events.findByEventTitle", query = "SELECT e FROM Events e WHERE e.eventTitle = :eventTitle"),
    @NamedQuery(name = "Events.findByInsertUserId", query = "SELECT e FROM Events e WHERE e.insertUserId = :insertUserId"),
    @NamedQuery(name = "Events.findByInsertTime", query = "SELECT e FROM Events e WHERE e.insertTime = :insertTime"),
    @NamedQuery(name = "Events.findByUpdateUserId", query = "SELECT e FROM Events e WHERE e.updateUserId = :updateUserId"),
    @NamedQuery(name = "Events.findByUpdateTime", query = "SELECT e FROM Events e WHERE e.updateTime = :updateTime")})
public class Events implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "event_id")
    private Long eventId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "event_title")
    private String eventTitle;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "insert_user_id")
    private String insertUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "update_user_id")
    private String updateUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "events")
    private List<UserAttendance> userAttendanceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "events")
    private List<EventScheduledDate> eventScheduledDateList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "events")
    private List<UserAttendanceDate> userAttendanceDateList;

    public Events() {
    }

    public Events(Long eventId) {
        this.eventId = eventId;
    }

    public Events(Long eventId, String eventTitle, String description, String insertUserId, Date insertTime, String updateUserId, Date updateTime) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.description = description;
        this.insertUserId = insertUserId;
        this.insertTime = insertTime;
        this.updateUserId = updateUserId;
        this.updateTime = updateTime;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @XmlTransient
    public List<UserAttendance> getUserAttendanceList() {
        return userAttendanceList;
    }

    public void setUserAttendanceList(List<UserAttendance> userAttendanceList) {
        this.userAttendanceList = userAttendanceList;
    }

    @XmlTransient
    public List<EventScheduledDate> getEventScheduledDateList() {
        return eventScheduledDateList;
    }

    public void setEventScheduledDateList(List<EventScheduledDate> eventScheduledDateList) {
        this.eventScheduledDateList = eventScheduledDateList;
    }

    @XmlTransient
    public List<UserAttendanceDate> getUserAttendanceDateList() {
        return userAttendanceDateList;
    }

    public void setUserAttendanceDateList(List<UserAttendanceDate> userAttendanceDateList) {
        this.userAttendanceDateList = userAttendanceDateList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Events)) {
            return false;
        }
        Events other = (Events) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Events[ eventId=" + eventId + " ]";
    }
    
}
