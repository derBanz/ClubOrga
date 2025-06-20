//generated
package org.derbanz.cluborga.domain.i18n;

import jakarta.enterprise.inject.spi.CDI;
import org.derbanz.cluborga.domain.base.I18N;

public final class Constants {

    public static final String BO_ADDRESS = "bo.address";

    public static final String BO_ADDRESS_CITY = "bo.address.city";

    public static final String BO_ADDRESS_COUNTRY = "bo.address.country";

    public static final String BO_ADDRESS_NUMBER = "bo.address.number";

    public static final String BO_ADDRESS_NUMBERSUFFIX = "bo.address.numberSuffix";

    public static final String BO_ADDRESS_POSTBOX = "bo.address.postbox";

    public static final String BO_ADDRESS_STREET = "bo.address.street";

    public static final String BO_ADDRESS_ZIP = "bo.address.zip";

    public static String getBoAddress() {
        I18N i18N = CDI.current().select(I18N.class).get();
        return i18N.getLocalizedValue(BO_ADDRESS);
    }

    public static String getBoAddressCity() {
        I18N i18N = CDI.current().select(I18N.class).get();
        return i18N.getLocalizedValue(BO_ADDRESS_CITY);
    }

    public static String getBoAddressCountry() {
        I18N i18N = CDI.current().select(I18N.class).get();
        return i18N.getLocalizedValue(BO_ADDRESS_COUNTRY);
    }

    public static String getBoAddressNumber() {
        I18N i18N = CDI.current().select(I18N.class).get();
        return i18N.getLocalizedValue(BO_ADDRESS_NUMBER);
    }

    public static String getBoAddressNumbersuffix() {
        I18N i18N = CDI.current().select(I18N.class).get();
        return i18N.getLocalizedValue(BO_ADDRESS_NUMBERSUFFIX);
    }

    public static String getBoAddressPostbox() {
        I18N i18N = CDI.current().select(I18N.class).get();
        return i18N.getLocalizedValue(BO_ADDRESS_POSTBOX);
    }

    public static String getBoAddressStreet() {
        I18N i18N = CDI.current().select(I18N.class).get();
        return i18N.getLocalizedValue(BO_ADDRESS_STREET);
    }

    public static String getBoAddressZip() {
        I18N i18N = CDI.current().select(I18N.class).get();
        return i18N.getLocalizedValue(BO_ADDRESS_ZIP);
    }

}