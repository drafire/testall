package com.drafire.testall.model;

public class User {
    private Integer id;

    private Long amount;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public User() {
    }

    public User(Integer id, Long amount, String name) {


        this.id = id;
        this.amount = amount;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                '}';
    }
}