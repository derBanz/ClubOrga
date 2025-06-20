package org.derbanz.cluborga.domain.model.organization.transfer;

public class ApplicationBto extends ApplicationCoreBto {

  @Override
  public boolean equals(Object object) {
    if (object == null) {
      return false;
    }
    if (object.getClass() != this.getClass()) {
      return false;
    }
    final ApplicationBto bto = (ApplicationBto) object;
    if (bto.getId() == null) {
      return object == this;
    } else {
      return this.getId().equals(bto.getId());
    }
  }
}
