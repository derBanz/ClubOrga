package org.derbanz.cluborga.domain.base;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@MappedSuperclass
public class AbstractBusinessObject implements Serializable {

  public static final String ID = "id";
  public static final String VERSION = "version";
  public static final String CREATION = "creation";
  public static final String CREATION_USER = "creationUser";
  public static final String LAST_UPDATE = "lastUpdate";
  public static final String LAST_UPDATE_USER = "lastUpdateUser";

  @Id
  @Column(
    length = 40,
    name = "id"
  )
  private String id;

  @Version
  private int version;

  @Basic
  private Timestamp creation;

  @Basic
  private String creationUser;

  @Basic
  private Timestamp lastUpdate;

  @Basic
  private String lastUpdateUser;

  public AbstractBusinessObject() {
    this.id = "";
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getVersion() {
    return this.version;
  }

  protected void setVersion(int version) {
    this.version = version;
  }

  public Timestamp getCreation() {
    return this.creation;
  }

  public Timestamp getLastUpdate() {
    return this.lastUpdate;
  }

  public String getCreationUser() {
    return this.creationUser;
  }

  public String getLastUpdateUser() {
    return this.lastUpdateUser;
  }

  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || !Hibernate.getClass(this).equals(Hibernate.getClass(object))) {
      return false;
    }
    AbstractBusinessObject other = (AbstractBusinessObject) object;
    return Objects.equals(this.getId(), other.getId());
  }
}
