package pl.coderslab.charity.validator;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DonationValidator {

    /* CASE_INSENSITIVE klasy Pattern dopasowuje znaki bez względu na wielkość liter */
    public static final Pattern VALID_CITIES =
            Pattern.compile("[A-Za-z-]{2,20}", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_STREETS =
            Pattern.compile("[A-Za-z0-9]{2,30}");

    public static final Pattern VALID_ZIPCODE =
            Pattern.compile("[0-9][0-9]-[0-9][0-9][0-9]", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_PHONENUMBER =
            Pattern.compile("[0-9]{9}", Pattern.CASE_INSENSITIVE);



    public boolean checkCity(String city){
        Matcher matcher = VALID_CITIES.matcher(city);
        return matcher.find();
    }
    public boolean checkStreet(String street){
        Matcher matcher = VALID_STREETS.matcher(street);
        return matcher.find();
    }
    public boolean checkPostcode(String zipCode){
        Matcher matcher = VALID_ZIPCODE.matcher(zipCode);
        return matcher.find();
    }
    public boolean checkPhoneNumber(String phoneNumber){
        Matcher matcher = VALID_PHONENUMBER.matcher(phoneNumber);
        return matcher.find();
    }

}
