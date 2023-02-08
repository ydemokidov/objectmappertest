package org.example;

import java.io.Serializable;

public class Parent implements Serializable {

    public int id;

    public int name;

    public Parent() {
    }

    public Parent(int id, int name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
