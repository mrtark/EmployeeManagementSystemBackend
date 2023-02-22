package com.example.employee.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdDate,updatedDate"},allowGetters = true)
@MappedSuperclass

abstract public class BaseEntity implements Serializable {
    public static final Long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,insertable = true, nullable = false,unique = true)
    private Long id;
    @Column(name="system_created_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemCreatedDate;
    @CreatedBy
    @Column(name = "createdBy",updatable = false)
    private String createdBy;
    @CreatedDate
    @Column(name = "createdDate", updatable = false)
    private String createdDate;
    @LastModifiedBy
    @Column(name = "updatedBy", updatable = false)
    private String updatedBy;
    @LastModifiedDate
    @Column(name = "updatedDate",updatable = false)
    private String updatedDate;

}
