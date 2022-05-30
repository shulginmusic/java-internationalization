package formatting.messages.compound;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * https://docs.oracle.com/javase/tutorial/i18n/format/messageFormat.html
 */
public class I18NCompoundMessage {
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

        //3. Set the message arguments
        Object[] messageArguments = {
                compoundMessages.getString("planet"), //the planet {0}
                new Integer(7), //we detected {1,number,integer} spaceships on
                new Date() //template = At {2,time,short} on {2,date,long},
        };

        //4. Create the Formatter
        MessageFormat formatter = new MessageFormat("");
        //set the locale because the message contains Date and Number objects, which should be formatted
        //in a locale-sensitive manner
        formatter.setLocale(currentLocale);

        /**
         * 5. Format the Message Using the Pattern and the Arguments
         * This step shows how the pattern, message arguments, and formatter all work together.
         * First, fetch the pattern String from the ResourceBundle with the getString method.
         * The key to the pattern is template. Pass the pattern String to the formatter with the applyPattern method.
         * Then format the message using the array of message arguments, by invoking the format method.
         * The String returned by the format method is ready to be displayed.
         * All of this is accomplished with just two lines of code:
         */

        formatter.applyPattern(compoundMessages.getString("template"));
        String output = formatter.format(messageArguments);

        System.out.println(output);
    }
}


























