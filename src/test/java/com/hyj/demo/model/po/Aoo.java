package com.hyj.demo.model.po;

import lombok.Data;

import java.util.Objects;

@Data
public class Aoo {
    private Long id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aoo aoo = (Aoo) o;
        return name.equals(aoo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
