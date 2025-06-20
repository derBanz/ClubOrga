package org.derbanz.cluborga.domain.base.transfer;

import java.sql.Timestamp;

public class BaseBto {

  private String id;
  private String creationUser;
  private Timestamp creation;
  private String lastUpdateUser;
  private Timestamp lastUpdate;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCreationUser() {
    return creationUser;
  }

  public void setCreationUser(String creationUser) {
    this.creationUser = creationUser;
  }

  public Timestamp getCreation() {
    return creation;
  }

  public void setCreation(Timestamp creation) {
    this.creation = creation;
  }

  public String getLastUpdateUser() {
    return lastUpdateUser;
  }

  public void setLastUpdateUser(String lastUpdateUser) {
    this.lastUpdateUser = lastUpdateUser;
  }

  public Timestamp getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Timestamp lastUpdate) {
    this.lastUpdate = lastUpdate;
  }
}
