package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepo;
import pl.coderslab.charity.validator.DonationValidator;

import java.time.LocalDate;


@Slf4j
@Service
@AllArgsConstructor
public class DonationService {
    private final DonationRepo donationRepo;
    private final DonationValidator donationValidator;

    public long getAllDonations() {
        return donationRepo.count();
    }

    public long getCountOfDonationsQuantity() {
        return donationRepo.countAllByQuantity();
    }

    public void registerDonation(Donation donation) {
//        //walidacja worków - nie może być mniej niż 1
//        if (donation.getQuantity() <= 1) {
//            throw new IllegalStateException("Minimalna ilość worków to 1");
//        }
//
//        //walidacja daty -- nie moze byc z przeszlosci
//        if(donation.getPickUpDate().isBefore(LocalDate.now())){
//            throw new IllegalStateException("Data nie może być z przeszłości");
//        }
//
//        //walidacja stringow(city,street) -- brak znakow specjalnych procz "-" regex
//        boolean isCityValid = donationValidator.checkCity(donation.getCity());
//
//        if(!isCityValid){
//            throw new IllegalStateException("Nazwa miasta powinna składać się z liter i '-'");
//        }
//
//        boolean isStreetValid = donationValidator.checkStreet(donation.getStreet());
//
//        if(!isStreetValid){
//            throw new IllegalStateException("Nazwa ulicy powinna składać się z liter cyfr oraz '-'");
//        }
//        //walidacja numeru tel - tylko 9 cyfr litery niedozwolone regex
//        boolean isPhoneNumberValid = donationValidator.checkPhoneNumber(donation.getPhoneNumber());
//        if(!isPhoneNumberValid){
//            throw new IllegalStateException("Numer telefonu powinien składać się z 9 cyfr");
//        }
//        //walidacja kodu pocztowego 2 cyfry "-" 3 cyfry regex
//        boolean isZipCodeValid = donationValidator.checkPostcode(donation.getZipCode());
//        if(!isZipCodeValid){
//            throw new IllegalStateException("Kod pocztowy powinien się składać z 2 cyfr + '-' + 3 cyfr");
//        }

        donationRepo.save(donation);

        log.info("Dar dodany pomyslnie: " + donation);
    }


}
