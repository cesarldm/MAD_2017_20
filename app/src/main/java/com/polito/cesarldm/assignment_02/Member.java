package com.polito.cesarldm.assignment_02;

import java.io.Serializable;

/**
 * Created by CesarLdM on 23/3/17.
 */

@SuppressWarnings("serial")
public class Member implements Serializable {
    public String name;
    public double spent;
    public int id;

    public Member (String name){
        super();
        this.name=name;
    }
    public Member(String name, int id) {
        super();
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpent() {
        return spent;
    }

    public void setSpent(double spent) {
        this.spent = spent;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Member other = (Member) obj;
        if (id != other.id)
            return false;
        return true;
    }


}
