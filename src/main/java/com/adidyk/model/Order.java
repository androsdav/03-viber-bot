package com.adidyk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany()
    @JoinTable(name = "order_smart_phones",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = { @JoinColumn(name = "smart_phone_id")}
    )
    @JsonIgnore
    private List<SmartPhone> smartPhones = new ArrayList<>();

    public Order() {
    }

    public Order(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SmartPhone> getSmartPhones() {
        return smartPhones;
    }

    public void setSmartPhones(List<SmartPhone> smartPhones) {
        this.smartPhones = smartPhones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id == order.id &&
                Objects.equals(name, order.name) &&
                Objects.equals(smartPhones, order.smartPhones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, smartPhones);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
