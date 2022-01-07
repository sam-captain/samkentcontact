package com.samkent.samkentapp.Model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Contact {
    String imageUrl,safCom,gmail, phone, aiTel,name,email;
    int number;
    @Id
    long id;

    public Contact() {
    }

    public Contact(String imageUrl, String name, int number) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.number = number;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSafCom() {
        return safCom;
    }

    public void setSafCom(String safCom) {
        this.safCom = safCom;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAiTel() {
        return aiTel;
    }

    public void setAiTel(String aiTel) {
        this.aiTel = aiTel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}


