package biblioteca;

import biblioteca.model.Carte;
import biblioteca.repository.repoMock.CartiRepoMock;
import biblioteca.util.Validator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TopDownIntegration {

    private CartiRepoMock cartiRepo = new CartiRepoMock();
    private Carte carte;
    private List<Carte> carti = cartiRepo.getCarti();

    List<String> autori = new ArrayList<String>();
    List<String> cuvinte = new ArrayList<String>();
    String autor;
    String an;

    @Test
    public void addCarteAllValid() {
        autori.add("autorunu");
        cuvinte.add("cuvantunu");

        try {
            carte = new Carte("titluunu", autori, "1887", cuvinte);
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
    public void integrationSearchBooksA() {

        autori.add("autoridoi");
        cuvinte.add("cuvantdoi");

        try {
            carte = new Carte("titludoi", autori, "1887", cuvinte);
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

        List<Carte> cartiG=null;

        try {
            autor = "caragiale";
            Validator.isOKString(autor);
            cartiG = cartiRepo.cautaCarte(autor);
            System.out.println(cartiG);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Autor is not string.");
        }
    }

    @Test
    public void integrationSearchBooksY() {

        autori.add("autordoi");
        cuvinte.add("cuvanttrei");

        try {
            carte = new Carte("titlutrei", autori, "1887", cuvinte);
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


        List<Carte> cartiG=null;

        try {
            autor = "autordoi";
            Validator.isOKString(autor);
            cartiG = cartiRepo.cautaCarte(autor);
            System.out.println(cartiG);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Autor is not string.");
        }

        List<Carte> cartiGAn=null;

        try {
            an = "1948";
            Validator.isNumeric(an);
            cartiGAn = cartiRepo.getCartiOrdonateDinAnul(an);
            System.out.println(cartiGAn);
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Year is not number");
        }
    }
}