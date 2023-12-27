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

import org.aspectj.weaver.Position;
import org.springframework.web.multipart.MultipartFile;

@Table
@Entity
public class Postimet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
      private Long id;
@Column(name="titulli")
private String titulli;

@Column(name="tipi")
private String tipi;

@Column(name="data")
private String data;

@OneToOne
@JoinColumn(name="photo1_id")
private PostimetMedia  photo1;

@OneToOne
@JoinColumn(name="photo2_id")
private PostimetMedia  photo2;

@OneToOne
@JoinColumn(name="photo3_id")
private PostimetMedia  photo3;

@OneToOne
@JoinColumn(name="photo4")
private PostimetMedia  photo4;

@OneToOne
@JoinColumn(name="photo5_id")
private PostimetMedia  photo5;

@OneToOne
@JoinColumn(name="photo6_id")
private PostimetMedia  photo6;

@OneToOne
@JoinColumn(name="photo7_id")
private PostimetMedia  photo7;

@OneToOne
@JoinColumn(name="photo8_id")
private PostimetMedia  photo8;

@OneToOne(optional = true)
@JoinColumn(name="video_id", nullable = true)
private Video  video;

@Column(name="pershkrim")
private String pershkrim;











public Postimet() {
}

public Postimet(Long id, String titulli, String tipi, String data, PostimetMedia photo1, PostimetMedia photo2,
        PostimetMedia photo3, PostimetMedia photo4, PostimetMedia photo5, PostimetMedia photo6, PostimetMedia photo7,
        PostimetMedia photo8, Video video, String pershkrim) {
    this.id = id;
    this.titulli = titulli;
    this.tipi = tipi;
    this.data = data;
    this.photo1 = photo1;
    this.photo2 = photo2;
    this.photo3 = photo3;
    this.photo4 = photo4;
    this.photo5 = photo5;
    this.photo6 = photo6;
    this.photo7 = photo7;
    this.photo8 = photo8;
    this.video = video;
    this.pershkrim = pershkrim;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getTitulli() {
    return titulli;
}

public void setTitulli(String titulli) {
    this.titulli = titulli;
}

public String getTipi() {
    return tipi;
}

public void setTipi(String tipi) {
    this.tipi = tipi;
}

public String getData() {
    return data;
}

public void setData(String data) {
    this.data = data;
}

public PostimetMedia getPhoto1() {
    return photo1;
}

public void setPhoto1(PostimetMedia photo1) {
    this.photo1 = photo1;
}

public PostimetMedia getPhoto2() {
    return photo2;
}

public void setPhoto2(PostimetMedia photo2) {
    this.photo2 = photo2;
}

public PostimetMedia getPhoto3() {
    return photo3;
}

public void setPhoto3(PostimetMedia photo3) {
    this.photo3 = photo3;
}

public PostimetMedia getPhoto4() {
    return photo4;
}

public void setPhoto4(PostimetMedia photo4) {
    this.photo4 = photo4;
}

public PostimetMedia getPhoto5() {
    return photo5;
}

public void setPhoto5(PostimetMedia photo5) {
    this.photo5 = photo5;
}

public PostimetMedia getPhoto6() {
    return photo6;
}

public void setPhoto6(PostimetMedia photo6) {
    this.photo6 = photo6;
}

public PostimetMedia getPhoto7() {
    return photo7;
}

public void setPhoto7(PostimetMedia photo7) {
    this.photo7 = photo7;
}

public PostimetMedia getPhoto8() {
    return photo8;
}

public void setPhoto8(PostimetMedia photo8) {
    this.photo8 = photo8;
}

public Video getVideo() {
    return video;
}

public void setVideo(Video video) {
    this.video = video;
}

public String getPershkrim() {
    return pershkrim;
}

public void setPershkrim(String pershkrim) {
    this.pershkrim = pershkrim;
}









    
}
