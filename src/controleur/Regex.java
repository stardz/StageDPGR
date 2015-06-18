package controleur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static String nominal_regex = "^([A-Za-z]+ *)+$";
    public static String int_format = "^[0-9]{1,}[0-9]*$";
    public static String inte_format = "^[0-9]*$";

    public static boolean verifNominal(String nom_prenom) {
        Pattern p = Pattern.compile(nominal_regex);
        Matcher m = p.matcher(nom_prenom);

        return m.matches();

    }

    public static boolean isInteger(String text) {
        return Pattern.matches("^[0-9]+$", text);

    }

    public static boolean isAdresse(String text) {
        return Pattern.matches("^[0-9A-Za-z °]+$", text);

    }

    public static boolean dateValid(String date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        Date dateValidator = null;

        try {
            dateValidator = dateFormat.parse(date);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }
}
