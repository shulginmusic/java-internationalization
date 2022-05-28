import java.util.Locale;
import java.util.ResourceBundle;

public class I18nSample {
    public static void main(String[] args) {

        String language;
        String country;

        if (args.length != 2) {
            //Default settings
            language = new String("en");
            country = new String("US");
        } else {
            //Set lang and country
            language = new String(args[0]);
            country = new String(args[1]);
        }

        Locale currentLocale;
        ResourceBundle messages;

        //Set current locale
        currentLocale = new Locale(language, country);
        //Get bundle based on locale and give it a base name
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

        //Print messages from resource bundle
        System.out.println(messages.getString("greetings"));
        System.out.println(messages.getString("inquiry"));
        System.out.println(messages.getString("farewell"));

    }
}
