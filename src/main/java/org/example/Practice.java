package org.example;

import java.util.HashMap;
import java.util.Objects;

public class Practice {
    public static void main(String[] args) {
        HE one = new HE(1, "J");
        HashMap<HE, Integer> map = new HashMap<>();
        map.put(one, 1);
        HE two = new HE(1, "p");
        map.put(two, 2);
        System.out.println(map);

    }
}

class HE {
    int id;
    String name;

    public HE() {

    }

    public HE(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int hashCode() {
        //System.out.println("came inside");
        return Objects.hash(id);
    }

    public boolean equals(Object ob) {
        System.out.println(this);
        if (this == ob) return true;
        if (ob == null || !(ob instanceof HE)) return false;
        HE two = (HE) ob;
        
        return two.id == this.id;
    }

    public String toString() {
        return this.name;
    }
}