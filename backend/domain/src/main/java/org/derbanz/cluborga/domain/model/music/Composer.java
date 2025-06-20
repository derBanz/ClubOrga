package org.derbanz.cluborga.domain.model.music;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.derbanz.cluborga.domain.base.AbstractBusinessObject;
import org.derbanz.cluborga.domain.base.Caption;

@Entity(
  name = "org.derbanz.cluborga.domain.model.music.composer"
)
@Table(
  name = "co_composer"
)
@Caption("") //todo
public class Composer extends AbstractBusinessObject {
  public static final String PERSON = "person";
}
