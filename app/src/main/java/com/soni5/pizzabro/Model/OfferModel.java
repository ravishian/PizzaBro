package com.soni5.pizzabro.Model;

public class OfferModel

{

    String Name , old , New , id;


    public OfferModel(String name, String old, String aNew, String id) {
        Name = name;
        this.old = old;
        New = aNew;
        this.id = id;
    }

    public OfferModel() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public String getNew() {
        return New;
    }

    public void setNew(String aNew) {
        New = aNew;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
