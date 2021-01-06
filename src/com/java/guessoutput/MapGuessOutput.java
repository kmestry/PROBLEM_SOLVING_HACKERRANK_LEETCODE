package com.java.guessoutput;


public class MapGuessOutput {
    String name;
    int age;

    public MapGuessOutput(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MapGuessOutput other = (MapGuessOutput) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


