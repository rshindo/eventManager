/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "attendance_code")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttendanceCode.findAll", query = "SELECT a FROM AttendanceCode a"),
    @NamedQuery(name = "AttendanceCode.findByAttendanceCode", query = "SELECT a FROM AttendanceCode a WHERE a.attendanceCode = :attendanceCode"),
    @NamedQuery(name = "AttendanceCode.findByAttendanceStatus", query = "SELECT a FROM AttendanceCode a WHERE a.attendanceStatus = :attendanceStatus")})
public class AttendanceCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "attendance_code")
    private Integer attendanceCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "attendance_status")
    private String attendanceStatus;

    public AttendanceCode() {
    }

    public AttendanceCode(Integer attendanceCode) {
        this.attendanceCode = attendanceCode;
    }

    public AttendanceCode(Integer attendanceCode, String attendanceStatus) {
        this.attendanceCode = attendanceCode;
        this.attendanceStatus = attendanceStatus;
    }

    public Integer getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(Integer attendanceCode) {
        this.attendanceCode = attendanceCode;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendanceCode != null ? attendanceCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttendanceCode)) {
            return false;
        }
        AttendanceCode other = (AttendanceCode) object;
        if ((this.attendanceCode == null && other.attendanceCode != null) || (this.attendanceCode != null && !this.attendanceCode.equals(other.attendanceCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AttendanceCode[ attendanceCode=" + attendanceCode + " ]";
    }
    
}
