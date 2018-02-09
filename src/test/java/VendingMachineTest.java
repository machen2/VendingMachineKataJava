import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    VendingMachine vendingMachine;

    @Before
    public void setup(){
        vendingMachine = new VendingMachine(0.0);
    }

    @Test
    public void givenANickelTheVendingMachineAcceptsIt(){
        String actual = vendingMachine.insertCoin("nickel");

        assertEquals("Total: $.05", actual);
    }

    @Test
    public void givenADimeTheVendingMachineAcceptsIt() {
        String actual = vendingMachine.insertCoin("dime");

        assertEquals("Total: $.10", actual);
    }

    @Test
    public void givenAQuarterTheVendingMachineAcceptsIt() {
        String actual = vendingMachine.insertCoin("quarter");

        assertEquals("Total: $.25", actual);
    }

    @Test
    public void givenAnInvalidCoinTheVendingMachineDeniesIt() {
        String actual = vendingMachine.insertCoin("peso");

        assertEquals("Invalid Coin", actual);
    }

    @Test
    public void afterInsertingANickleTheVendingMachineShouldAddedToTheTotal(){
        vendingMachine.insertCoin("nickel");

        Double actual = vendingMachine.getTotal();

        assertEquals(.05, actual, .001);
    }

    @Test
    public void givenAVendingMachineWith30CentsWhenAddingANickelItShouldBe35(){
        vendingMachine = new VendingMachine(.30);

        vendingMachine.insertCoin("nickel");
        Double actual = vendingMachine.getTotal();

        assertEquals(.35, actual, .001);
    }
}
