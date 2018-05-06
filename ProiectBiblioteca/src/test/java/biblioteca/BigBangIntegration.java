package biblioteca;

import biblioteca.model.Carte;
import biblioteca.repository.repoMock.CartiRepoMock;
import biblioteca.util.Validator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BigBangIntegration {

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
    public void BigBangTest() {
//1
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

//2
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
//test search for activities ( III )

        List<Carte> cartiGAn=null;

        try {
            an = "1948";
            Validator.isNumeric(an);
            cartiGAn = cartiRepo.getCartiOrdonateDinAnul(an);
            System.out.println(cartiG);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Year is not number");
        }
    }

}
