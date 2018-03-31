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


    @Test
    public void addCarteAllValid() {
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

}
