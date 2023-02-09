package org.example;

public class GrandChild extends Child{

    public GrandChild() {
    }

    public GrandChild(int id, int name, String childField1, int childField2, boolean grandChildField) {
        super(id, name, childField1, childField2);
        this.grandChildField = grandChildField;
    }

    public boolean grandChildField;

}
