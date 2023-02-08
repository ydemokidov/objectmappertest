package org.example;

public class Child extends Parent implements IChildFieldKeeper{

    public String childField1;

    public int childField2;

    public Child() {
    }

    public Child(int id, int name, String childField1, int childField2) {
        super(id, name);
        this.childField1 = childField1;
        this.childField2 = childField2;
    }

    @Override
    public void setChildField1(String childField1) {
        this.childField1 = childField1;
    }

    @Override
    public void setChildField2(int childField2) {
        this.childField2 = childField2;
    }
}
