package formatting.messages;

import java.util.Locale;
import java.util.ResourceBundle;

public class NotI18nCompoundMessage {
    public static void main(String[] args) {

        String language;
        String country;

        if (args.length == 2) {
            language = new String(args[0]);
            country = new String(args[1]);
        } else {
            //Default
            language = "en";
            country = "US";
        }

        Locale currentLocale;
        ResourceBundle compoundMessages;

        //Declare current locale
        currentLocale = new Locale(language, country);
        //Get bundle based on locale
        compoundMessages = ResourceBundle.getBundle("CompoundMessageBundle", currentLocale);

        double numDays = 6;

        /**
         * Because the word order of this message is hardcoded,
         * your localizers won't be able to create grammatically correct translations for all languages.
         */
        String message = compoundMessages.getString("deleteolder")
                + Integer.toString((int) numDays) + " " + compoundMessages.getString("days");

        System.out.println(message);

    }
}
