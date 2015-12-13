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
public class UserAttendancePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "user_id")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "event_id")
    private long eventId;

    public UserAttendancePK() {
    }

    public UserAttendancePK(String userId, long eventId) {
        this.userId = userId;
        this.eventId = eventId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        hash += (int) eventId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAttendancePK)) {
            return false;
        }
        UserAttendancePK other = (UserAttendancePK) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        if (this.eventId != other.eventId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserAttendancePK[ userId=" + userId + ", eventId=" + eventId + " ]";
    }
    
}
