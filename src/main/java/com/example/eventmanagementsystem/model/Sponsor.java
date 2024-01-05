/*
 * You can use the following import statements
 *
 * import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 * 
 * import javax.persistence.*;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.eventmanagementsystem.model;

import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sponsor")
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "industry")
    private String industry;
    @ManyToMany
    @JoinTable(name = "event_sponsor", joinColumns = @JoinColumn(name = "eventId"), inverseJoinColumns = @JoinColumn(name = "sponsorId"))
    @JsonIgnoreProperties("sponsors")
    private List<Event> events = new ArrayList<>();

    public Sponsor() {

    }

    public Sponsor(int id, String name, String industry) {
        this.id = id;
        this.name = name;
        this.industry = industry;

    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname() {
        this.name = name;
    }

    public String getindustry() {
        return industry;
    }

    public void setindustry() {
        this.industry = industry;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}