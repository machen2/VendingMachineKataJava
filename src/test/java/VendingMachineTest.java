import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VendingMachineTest {

    VendingMachine vendingMachine;
    @Mock
    VendingMachineModel model;


    @Before
    public void setup(){
        vendingMachine = new VendingMachine(model);
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
        vendingMachine.insertCoin("nickel");

        verify(model).changeTotal(.05);
    }
}
