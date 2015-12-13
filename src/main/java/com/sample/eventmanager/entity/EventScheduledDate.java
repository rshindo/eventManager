/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Shindo
 */
@Entity
@Table(name = "event_scheduled_date")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventScheduledDate.findAll", query = "SELECT e FROM EventScheduledDate e"),
    @NamedQuery(name = "EventScheduledDate.findByEventId", query = "SELECT e FROM EventScheduledDate e WHERE e.eventScheduledDatePK.eventId = :eventId"),
    @NamedQuery(name = "EventScheduledDate.findByScheduleId", query = "SELECT e FROM EventScheduledDate e WHERE e.eventScheduledDatePK.scheduleId = :scheduleId"),
    @NamedQuery(name = "EventScheduledDate.findByScheduledStartDate", query = "SELECT e FROM EventScheduledDate e WHERE e.scheduledStartDate = :scheduledStartDate"),
    @NamedQuery(name = "EventScheduledDate.findByScheduledEndDate", query = "SELECT e FROM EventScheduledDate e WHERE e.scheduledEndDate = :scheduledEndDate"),
    @NamedQuery(name = "EventScheduledDate.findByNotDispTime", query = "SELECT e FROM EventScheduledDate e WHERE e.notDispTime = :notDispTime")})
public class EventScheduledDate implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventScheduledDatePK eventScheduledDatePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scheduled_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledStartDate;
    @Column(name = "scheduled_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledEndDate;
    @Column(name = "not_disp_time")
    private Boolean notDispTime;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Events events;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventScheduledDate")
    private List<UserAttendanceDate> userAttendanceDateList;

    public EventScheduledDate() {
    }

    public EventScheduledDate(EventScheduledDatePK eventScheduledDatePK) {
        this.eventScheduledDatePK = eventScheduledDatePK;
    }

    public EventScheduledDate(EventScheduledDatePK eventScheduledDatePK, Date scheduledStartDate) {
        this.eventScheduledDatePK = eventScheduledDatePK;
        this.scheduledStartDate = scheduledStartDate;
    }

    public EventScheduledDate(long eventId, long scheduleId) {
        this.eventScheduledDatePK = new EventScheduledDatePK(eventId, scheduleId);
    }

    public EventScheduledDatePK getEventScheduledDatePK() {
        return eventScheduledDatePK;
    }

    public void setEventScheduledDatePK(EventScheduledDatePK eventScheduledDatePK) {
        this.eventScheduledDatePK = eventScheduledDatePK;
    }

    public Date getScheduledStartDate() {
        return scheduledStartDate;
    }

    public void setScheduledStartDate(Date scheduledStartDate) {
        this.scheduledStartDate = scheduledStartDate;
    }

    public Date getScheduledEndDate() {
        return scheduledEndDate;
    }

    public void setScheduledEndDate(Date scheduledEndDate) {
        this.scheduledEndDate = scheduledEndDate;
    }

    public Boolean getNotDispTime() {
        return notDispTime;
    }

    public void setNotDispTime(Boolean notDispTime) {
        this.notDispTime = notDispTime;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
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
        hash += (eventScheduledDatePK != null ? eventScheduledDatePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventScheduledDate)) {
            return false;
        }
        EventScheduledDate other = (EventScheduledDate) object;
        if ((this.eventScheduledDatePK == null && other.eventScheduledDatePK != null) || (this.eventScheduledDatePK != null && !this.eventScheduledDatePK.equals(other.eventScheduledDatePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EventScheduledDate[ eventScheduledDatePK=" + eventScheduledDatePK + " ]";
    }
    
}
