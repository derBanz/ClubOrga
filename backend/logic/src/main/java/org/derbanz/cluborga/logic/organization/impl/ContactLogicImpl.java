package org.derbanz.cluborga.logic.organization.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Specializes;
import org.derbanz.cluborga.logic.organization.ContactLogic;

@Specializes
@ApplicationScoped
public class ContactLogicImpl extends BaseContactLogicImpl implements ContactLogic {
}
