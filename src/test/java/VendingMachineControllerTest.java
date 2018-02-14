import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VendingMachineControllerTest {

    VendingMachineController vendingMachineController;
    @Mock
    VendingMachineModel model;
    @Mock
    VendingMachineView view;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        vendingMachineController = new VendingMachineController(model, view);
    }

    @Test
    public void givenANickelTheVendingMachineShouldDisplayTheTotal(){
        when(model.getTotal()).thenReturn(.05);
        vendingMachineController.insertCoin("nickel");

        verify(view).displayTotal(.05);
    }

    @Test
    public void givenADimeTheVendingMachineAcceptsIt() {
        when(model.getTotal()).thenReturn(.10);
        vendingMachineController.insertCoin("dime");

        verify(view).displayTotal(.10);
    }

    @Test
    public void givenAQuarterTheVendingMachineAcceptsIt() {
        when(model.getTotal()).thenReturn(.25);
        vendingMachineController.insertCoin("quarter");

        verify(view).displayTotal(.25);
    }

    @Test
    public void givenAnInvalidCoinTheVendingMachineDeniesIt() {
        vendingMachineController.insertCoin("peso");

        verify(view).displayErrorMessage();
    }

    @Test
    public void afterInsertingANickleTheVendingMachineShouldAddTheValueToTheTotal(){
        vendingMachineController.insertCoin("nickel");

        verify(model).changeTotal(.05);
    }

    @Test
    public void afterInsertingADimeTheVendingMachineShouldAddTheValueToTheTotal(){
        vendingMachineController.insertCoin("dime");

        verify(model).changeTotal(.10);
    }

    @Test
    public void afterInsertingAQuarterTheVendingMachineShouldAddTheValueToTheTotal(){
        vendingMachineController.insertCoin("quarter");

        verify(model).changeTotal(.25);
    }

    @Test
    public void whenThereAreNoCoinsInsertedTheMachineReturnsInsertCoin(){
        vendingMachineController.start();

        verify(view).displayStartingMessage();
    }
}
