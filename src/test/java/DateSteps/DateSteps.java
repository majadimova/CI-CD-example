package DateSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Date;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSteps {
    private String poruka;
    private long brojDana;

    @Given("^korisnik unese datum rodjenja \"([^\"]*)\"$")
    public void korisnik_unese_datum_rodjenja(String datumRodjenja) throws ParseException {
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date datum = sdf.parse(datumRodjenja);
            Sate danas = new Date();
            if (datum.after(danas)) {
                poruka = "Greska:Datum je u buducnosti";
                brojDana = 0;
            }else {
                poruka = "Uspesan unos";
                brojDana = izracunajBrojDana(datum, danas);
            }
        } catch (ParseException e) {
            poruka = "Greska: Neispravan datum";
            brojDana = 0;
        }
    }
    @When("^sistem proverava da li je datum ispravan i u proslosti$^")
    public void sistem_proverava_datum(){

    }
    @Then("^prikazuje poruku \"([^\"]*)\"$")
    public void prikazuje_poruku(String ocekivanaPoruka) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(ocekivanaPoruka, poruka);
    }
    @Then("^izracunava broj dana proteklih od rodjenja \"([^\"]*)\"$")
    public void izracunava_broj_dana(String ocekivaniBrojDana){
        assertEquals(Long.parseLong(ocekivaniBrojDana), brojDana);
        }
    private  long izracunajBrojDana(Date datunRodjenja,Date danas){
        long razlikaVremena =danas.getTime() - datumRodjenja.getTime();
        return TimeUnit.DAYS.convert(razlikaVremena, TimeUnit.MILLISECONDS);
      }

}
