package com.hyj.demo.interfaces;

public interface Human {
    void walk();

    public static void main(String[] args) {
        Human h=new Student() {
            @Override
            public void walk() {

            }

            @Override
            public void work() {

            }
        };
    }
}
