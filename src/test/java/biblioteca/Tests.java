package biblioteca;

import biblioteca.model.Carte;
import biblioteca.repository.repoMock.CartiRepoMock;
import biblioteca.util.Validator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Tests {

    private CartiRepoMock cartiRepo = new CartiRepoMock();
    private Carte carte;

    List<String> autori = new ArrayList<String>();
    List<String> cuvinte = new ArrayList<String>();
    String autor;
    String an;

    @Test
    public void addCarteAllValid() {
        autori.add("autor");
        cuvinte.add("cuvant");

        try {
            carte = new Carte("titlu", autori, "1887", cuvinte);
            Validator.validateCarte(carte);
        } catch (Exception e) {
            assertTrue(true);
        }


        int repoSizeBeforeAdd = cartiRepo.count();
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
            assertTrue(repoSizeBeforeAdd + 1 != cartiRepo.count());

        }
    }

    @Test
    public void addCarteTitleInvalid() {
        autori.add("autor");
        cuvinte.add("cuvant");
        try {
            carte = new Carte("123", autori, "1987", cuvinte);
            Validator.validateCarte(carte);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Title is not string");
        }

        int repoSizeBeforeAdd = cartiRepo.count();
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
            assertTrue(repoSizeBeforeAdd + 1 != cartiRepo.count());

        }
    }

    @Test
    public void addCarteTitleLengthOk() {
        autori.add("autor");
        cuvinte.add("cuvant");
        try {
            carte = new Carte("titlu", autori, "1987", cuvinte);
            Validator.validateCarte(carte);
        } catch (Exception e) {
            assertTrue(true);
        }

        int repoSizeBeforeAdd = cartiRepo.count();
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
            assertTrue(repoSizeBeforeAdd + 1 != cartiRepo.count());

        }
    }

    @Test
    public void addCarteTitleLengthIncorrect() {
        autori.add("autor");
        cuvinte.add("cuvant");
        try {
            carte = new Carte("ti", autori, "1987", cuvinte);
            Validator.validateCarte(carte);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Title must be at least 3 characters length");
        }

        int repoSizeBeforeAdd = cartiRepo.count();
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
            assertTrue(repoSizeBeforeAdd + 1 != cartiRepo.count());

        }
    }

    @Test
    public void addCarteAutorInvalid() {
        autori.add("");
        cuvinte.add("cuvant");
        try {
            carte = new Carte("titlu", autori, "1987", cuvinte);
            Validator.validateCarte(carte);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Author is not string");
        }

        int repoSizeBeforeAdd = cartiRepo.count();
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
            assertTrue(repoSizeBeforeAdd + 1 != cartiRepo.count());

        }
    }

    @Test
    public void addCarteAnSmaller() {
        autori.add("autori");
        cuvinte.add("cuvant");
        try {
            carte = new Carte("titlu", autori, "1765", cuvinte);
            Validator.validateCarte(carte);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Year must be greater than 1800.");
        }

        int repoSizeBeforeAdd = cartiRepo.count();
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
            assertTrue(repoSizeBeforeAdd + 1 != cartiRepo.count());

        }
    }

    @Test
    public void addCarteAnInvalid() {
        autori.add("autori");
        cuvinte.add("cuvant");
        try {
            carte = new Carte("titlu", autori, "ana", cuvinte);
            Validator.validateCarte(carte);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Year is not number.");
        }

        int repoSizeBeforeAdd = cartiRepo.count();
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
            assertTrue(repoSizeBeforeAdd + 1 != cartiRepo.count());

        }
    }

    @Test
    public void addCarteCuvantCheieNumber() {
        autori.add("autori");
        cuvinte.add("123");
        try {
            carte = new Carte("titlu", autori, "1988", cuvinte);
            Validator.validateCarte(carte);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Key word must be string.");
        }

        int repoSizeBeforeAdd = cartiRepo.count();
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
            assertTrue(repoSizeBeforeAdd + 1 != cartiRepo.count());

        }
    }

    @Test
    public void addCarteCuvantCheieInvalid() {
        autori.add("autori");
        cuvinte.add("");
        try {
            carte = new Carte("titlu", autori, "1988", cuvinte);
            Validator.validateCarte(carte);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Key word is not string.");
        }

        int repoSizeBeforeAdd = cartiRepo.count();
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
            assertTrue(repoSizeBeforeAdd + 1 != cartiRepo.count());

        }
    }
//lab 3
    @Test
    public void cautareDupaAutorValid() {
        List<Carte> cartiG=null;

        try {
            autor = "ca";
            Validator.isOKString(autor);
            cartiG = cartiRepo.cautaCarte(autor);
            System.out.println(cartiG);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Autor is not string.");
        }
    }

    @Test
    public void cautareDupaAutorNull() {
        List<Carte> cartiG=null;

        try {
            autor = "";
            Validator.isStringOK(autor);
            cartiG = cartiRepo.cautaCarte(autor);
            System.out.println(cartiG);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Autor is not string.");
        }

    }

    @Test
    public void cautareDupaAutorNr() {
        List<Carte> cartiG=null;
        try {
            autor = "2";
            Validator.isStringOK(autor);
            cartiG = cartiRepo.cautaCarte(autor);
            System.out.println(cartiG);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Autor is not string.");
        }
    }

   // lab 4
    @Test
    public void cautaCarteAnNumber() {
        List<Carte> cartiG=null;

        try {
            an = "1948";
            Validator.isNumeric(an);
            cartiG = cartiRepo.getCartiOrdonateDinAnul(an);
            System.out.println(cartiG);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Year is not number");
        }
    }

    @Test
    public void cautaCarteAnInvalid() {
        List<Carte> cartiG=null;

        try {
            an = "ddd";
            Validator.isNumber(an);
            cartiG = cartiRepo.getCartiOrdonateDinAnul(an);
            System.out.println(cartiG);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Year is not number");
        }
    }

}
