package com.SayItApp.SayItOrganization.Models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;

public class NjoftimetDataTransfer {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private MultipartFile  photo;
private String tipi;
private String titulli;
private String data;
private String ora;
private String vendi;
private String pershkrimi;
private String aktiv;


public NjoftimetDataTransfer(){
    
}



public NjoftimetDataTransfer(Long id, MultipartFile  photo, String tipi, String titulli, String data, String ora, String vendi,
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
public MultipartFile getPhoto() {
    return photo;
}
public void setPhoto(MultipartFile  photo) {
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
