package org.derbanz.cluborga.logic.organization.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Specializes;
import org.derbanz.cluborga.logic.organization.PersonLogic;

@Specializes
@ApplicationScoped
public class PersonLogicImpl extends BasePersonLogicImpl implements PersonLogic {
}
