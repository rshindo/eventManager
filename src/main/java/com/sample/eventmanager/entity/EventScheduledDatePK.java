/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Shindo
 */
@Embeddable
public class EventScheduledDatePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "event_id")
    private long eventId;
    @Basic(optional = false)
    @Column(name = "schedule_id")
    private long scheduleId;

    public EventScheduledDatePK() {
    }

    public EventScheduledDatePK(long eventId, long scheduleId) {
        this.eventId = eventId;
        this.scheduleId = scheduleId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) eventId;
        hash += (int) scheduleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventScheduledDatePK)) {
            return false;
        }
        EventScheduledDatePK other = (EventScheduledDatePK) object;
        if (this.eventId != other.eventId) {
            return false;
        }
        if (this.scheduleId != other.scheduleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EventScheduledDatePK[ eventId=" + eventId + ", scheduleId=" + scheduleId + " ]";
    }
    
}
