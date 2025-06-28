//generated
package org.derbanz.cluborga.domain.i18n;

import jakarta.enterprise.inject.spi.CDI;
import org.derbanz.cluborga.domain.base.I18N;

public final class ValidationMessages {

  public static final String BO_ADDRESS_REQUIRED_CITY = "bo.address.required.city";

  public static final String BO_ADDRESS_REQUIRED_COUNTRY = "bo.address.required.country";

  public static final String BO_ADDRESS_REQUIRED_ZIP = "bo.address.required.zip";

  public static String getBoAddressRequiredCity() {
    I18N i18N = CDI.current().select(I18N.class).get();
    return i18N.getLocalizedValue(BO_ADDRESS_REQUIRED_CITY);
  }

  public static String getBoAddressRequiredCountry() {
    I18N i18N = CDI.current().select(I18N.class).get();
    return i18N.getLocalizedValue(BO_ADDRESS_REQUIRED_COUNTRY);
  }

  public static String getBoAddressRequiredZip() {
    I18N i18N = CDI.current().select(I18N.class).get();
    return i18N.getLocalizedValue(BO_ADDRESS_REQUIRED_ZIP);
  }

}