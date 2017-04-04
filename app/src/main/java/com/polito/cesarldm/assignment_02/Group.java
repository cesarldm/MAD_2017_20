package com.polito.cesarldm.assignment_02;

import java.io.Serializable;

/**
 * Created by CesarLdM on 23/3/17.
 */

@SuppressWarnings("serial")
public class Group implements Serializable {
    public String name;
    public double budget;
    public Member membersArray[]= new Member[30];
    public int id;


    public Group(String name, double budget, int id) {
        this.name = name;
        this.budget = budget;
        this.id = id;
    }

    public Group(double budget, String name, Member[] membersArray) {
        super();
        this.name=name;
        this.budget = budget;
        this.membersArray = membersArray;
    }

public Group (String name){
    this.name= name;
    this.budget=0;
}
    public double getBudget() {
        return budget;
    }

    public String getName() {
        return name;
    }


    public void setBudget(double budget) {
        this.budget = budget;
    }


    public Member[] getMembersArray() {
        return membersArray;
    }


    public void setMembersArray(Member[] membersArray) {
        this.membersArray = membersArray;
    }

    public void setName(String name) {
        this.name = name;
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
        Group other = (Group) obj;
        if (id != other.id)
            return false;
        return true;
    }


}
