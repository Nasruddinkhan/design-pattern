package com.mypractice.java8.lamda;

import java.util.Objects;

public class MyEqualsImpl {
    private String name;
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyEqualsImpl myEquals = (MyEqualsImpl) o;
        return Objects.equals(name, myEquals.name) &&
                Objects.equals(id, myEquals.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
