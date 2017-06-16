package com.test.trgt.utils;

public class BuildString {

    private String internalString = "";

    private BuildString() {
    }

    public static BuildString init(Object o) {

        BuildString s = new BuildString();
        s.internalString += s.removeNull(o);
        return s;
    }

    public BuildString append(Object o) {

        internalString += removeNull(o);
        return this;
    }

    @Override
    public String toString() {
        return internalString;
    }

    public String get() {
        return internalString;
    }

    String removeNull(Object obj) {
        if (obj == null) {
            return "Null";
        } else {
            return obj.toString();
        }
    }
}
