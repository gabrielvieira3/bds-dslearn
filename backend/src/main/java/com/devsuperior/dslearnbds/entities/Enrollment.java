package com.devsuperior.dslearnbds.entities;

import com.devsuperior.dslearnbds.entities.pk.EnrollmentPK;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment {
  //Chave composta
  @EmbeddedId
  private EnrollmentPK id = new EnrollmentPK(); //Instancia porque foi vc q criou!!
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant enrollMoment;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant refunddMoment;
  private boolean available;
  private boolean onlyUpdate;

  public Enrollment(){
  }

  //Atenção Constructor
  public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refunddMoment, boolean available, boolean onlyUpdate) {
    //Atenção q seta nos construtores
    id.setUser(user);
    id.setOffer(offer);
    this.enrollMoment = enrollMoment;
    this.refunddMoment = refunddMoment;
    this.available = available;
    this.onlyUpdate = onlyUpdate;
  }

  public User getStudent() {
    return id.getUser();
  }

  public void setStudent(User user) {
    id.setUser(user);
  }

  public Offer getOffer() {
    return id.getOffer();
  }

  public void setOffer(Offer offer) {
    id.setOffer(offer);
  }

  public Instant getEnrollMoment() {
    return enrollMoment;
  }

  public void setEnrollMoment(Instant enrollMoment) {
    this.enrollMoment = enrollMoment;
  }

  public Instant getRefunddMoment() {
    return refunddMoment;
  }

  public void setRefunddMoment(Instant refunddMoment) {
    this.refunddMoment = refunddMoment;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public boolean isOnlyUpdate() {
    return onlyUpdate;
  }

  public void setOnlyUpdate(boolean onlyUpdate) {
    this.onlyUpdate = onlyUpdate;
  }


}
