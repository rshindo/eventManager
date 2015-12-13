/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Shindo
 */
@Embeddable
public class UserAttendanceDatePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "user_id")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "event_id")
    private long eventId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "event_schedule_id")
    private long eventScheduleId;

    public UserAttendanceDatePK() {
    }

    public UserAttendanceDatePK(String userId, long eventId, long eventScheduleId) {
        this.userId = userId;
        this.eventId = eventId;
        this.eventScheduleId = eventScheduleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getEventScheduleId() {
        return eventScheduleId;
    }

    public void setEventScheduleId(long eventScheduleId) {
        this.eventScheduleId = eventScheduleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        hash += (int) eventId;
        hash += (int) eventScheduleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAttendanceDatePK)) {
            return false;
        }
        UserAttendanceDatePK other = (UserAttendanceDatePK) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        if (this.eventId != other.eventId) {
            return false;
        }
        if (this.eventScheduleId != other.eventScheduleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserAttendanceDatePK[ userId=" + userId + ", eventId=" + eventId + ", eventScheduleId=" + eventScheduleId + " ]";
    }
    
}
