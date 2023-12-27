package com.SayItApp.SayItOrganization.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity
public class Pjesmarresit {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
@Column(name="emri")
    private String emri;
    @Column(name="mosha")
    private String mosha;
    @Column(name="arsimi")
    private String arsimi;
    @Column(name="institucioni")
    private String institucioni;
    @Column(name="numri")
    private String numri;
    @Column(name="email")
    private String email;
    @Column(name="vendbanim")
    private String vendbanim;
    @Column(name = "doethemi")
    private String doethemi;
  
@ManyToOne
@JoinColumn(name="njoftimid")
private Njoftimet njoftimet;

public Pjesmarresit() {
    // Initialization logic if needed
}



public Pjesmarresit(Long id, String emri, String mosha, String arsimi, String institucioni, String numri,
        String email, String vendbanim, String doethemi, Njoftimet njoftimet) {
    this.id = id;
    this.emri = emri;
    this.mosha = mosha;
    this.arsimi = arsimi;
    this.institucioni = institucioni;
    this.numri = numri;
    this.email = email;
    this.vendbanim = vendbanim;
    this.doethemi = doethemi;
 
    this.njoftimet = njoftimet;
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getEmri() {
    return emri;
}
public void setEmri(String emri) {
    this.emri = emri;
}
public String getMosha() {
    return mosha;
}
public void setMosha(String mosha) {
    this.mosha = mosha;
}
public String getArsimi() {
    return arsimi;
}
public void setArsimi(String arsimi) {
    this.arsimi = arsimi;
}
public String getInstitucioni() {
    return institucioni;
}
public void setInstitucioni(String institucioni) {
    this.institucioni = institucioni;
}
public String getNumri() {
    return numri;
}
public void setNumri(String numri) {
    this.numri = numri;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getVendbanim() {
    return vendbanim;
}
public void setVendbanim(String vendbanim) {
    this.vendbanim = vendbanim;
}
public String getDoethemi() {
    return doethemi;
}
public void setDoethemi(String doethemi) {
    this.doethemi = doethemi;
}

public Njoftimet getNjoftimet() {
    return njoftimet;
}
public void setNjoftimet(Njoftimet njoftimet) {
    this.njoftimet = njoftimet;
}






}
