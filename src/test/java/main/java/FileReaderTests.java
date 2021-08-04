package main.java;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileReaderTests {

    @Test
    public void readContentTest() throws Exception {
        String expected = "kxgst1+@pitt.edu (Kenneth Gilbert) writes>Unfortunately it was rather poorly researched, and would not be availabl>today if it were just invented.  Keep in mind however that those wer>the days when a bottle of Coca Cola really did contain coca extract an>a certain amount of active cocaine.  Times have changed, and our attitude>need to change with them Well, yes.  That was a part of my point.  Aspirin has its problems, buin some situations it is useful.  Ditto stuff like licorice root.  Takinanything as a drug for theraputic purposes implicitly carries the ideof taking a dose where the benefits are not exceeded by any unwantedadditional effects.  Taking any drug when the potential ill-effects arnot known is a risk assumed by the parties involved, and it may be thain a given situation the risk is worthwhile   Like Prozac, for instance; Prozac has been shown to be theraputic isome cases where the tri-cyclics fail.  But Prozac hasn't been in usthat long, and it really isn't clear what if any effects it may havwhen taken over long periods of time, even though it has been testeby present day standards.  Should Prozac be taken off the market becauslong-term effects, if any, are not known?  IMHO, i'd say noeucli>=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=->=  Kenneth Gilbert                |          University of Pittsburgh   >=  General Internal Medicine    --*--        Pittsburgh, PA             >=  kxgst1+@pitt.edu               |      \"...dammit, not a programmer!  >=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=->-->=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=->=  Kenneth Gilbert                |          University of Pittsburgh   >=  General Internal Medicine    --*--        Pittsburgh, PA             >=  kxgst1+@pitt.edu               |      \"...dammit, not a programmer!  -Euclid K.       standard disclaimers appl\"It is a bit ironic that we need the wave model [of light] to understand thpropagation of light only through that part of the system where it leaves ntrace.\"  --Hudson & Nelson (_University_Physics_ " ;
        FileReader fileReader = new FileReader();
        assertEquals(expected.toLowerCase(), fileReader.getDocumentsContent().get("58060"));
    }
}
