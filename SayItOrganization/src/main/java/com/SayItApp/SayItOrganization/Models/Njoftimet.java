package com.SayItApp.SayItOrganization.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Njoftimet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
private Long id;

@OneToOne
@JoinColumn(name="photo_id")
private ImageData  photo;
@Column(name="tipi")
private String tipi;
@Column(name="titulli")
private String titulli;
@Column(name="data")
private String data;
@Column(name="ora")
private String ora;
@Column(name="vendi")
private String vendi;
@Column(name="pershkrimi")
private String pershkrimi;
@Column(name="aktiv")
private String aktiv;


public Njoftimet(){
    
}



public Njoftimet(Long id, ImageData  photo, String tipi, String titulli, String data, String ora, String vendi,
        String pershkrimi, String aktiv) {
    this.id = id;
    this.photo = photo;
    this.tipi = tipi;
    this.titulli = titulli;
    this.data = data;
    this.ora = ora;
    this.vendi = vendi;
    this.pershkrimi = pershkrimi;
    this.aktiv = aktiv;
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public ImageData  getPhoto() {
    return photo;
}
public void setPhoto(ImageData  photo) {
    this.photo = photo;
}
public String getTipi() {
    return tipi;
}
public void setTipi(String tipi) {
    this.tipi = tipi;
}
public String getTitulli() {
    return titulli;
}
public void setTitulli(String titulli) {
    this.titulli = titulli;
}
public String getData() {
    return data;
}
public void setData(String data) {
    this.data = data;
}
public String getOra() {
    return ora;
}
public void setOra(String ora) {
    this.ora = ora;
}
public String getVendi() {
    return vendi;
}
public void setVendi(String vendi) {
    this.vendi = vendi;
}
public String getPershkrimi() {
    return pershkrimi;
}
public void setPershkrimi(String pershkrimi) {
    this.pershkrimi = pershkrimi;
}
public String getAktiv() {
    return aktiv;
}
public void setAktiv(String aktiv) {
    this.aktiv = aktiv;
}















    
}
