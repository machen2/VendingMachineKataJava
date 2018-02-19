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
    @Mock
    Dispenser dispenser;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        vendingMachineController = new VendingMachineController(model, view, dispenser);
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
    public void whenThereAreNoCoinsInsertedTheMachineReturnsTheStartingMessage(){
        vendingMachineController.start();

        verify(view).displayStartingMessage();
    }

    @Test
    public void givenEnoughMoneyWhenTheColaIsSelectedThenColaIsDispensed(){
        when(model.getTotal()).thenReturn(1.0);
        vendingMachineController.productSelected("cola");

        verify(dispenser).dispenseProduct("cola");
    }

    @Test
    public void givenEnoughMoneyWhenTheColaIsSelectedThenAThankYouMessageIsDisplayed(){
        when(model.getTotal()).thenReturn(1.0);
        vendingMachineController.productSelected("cola");

        verify(view).displayThankYouMessage();
    }

    @Test
    public void givenNotEnoughMoneyWhenColaIsSelectedThenVendingMachineDisplaysInvalidPriceMessage(){
        vendingMachineController.productSelected("cola");

        verify(view).displayInvalidPriceMessage();
    }

    @Test
    public void givenEnoughMoneyWhenChipsAreSelectedThenVendingMachineDisplaysThankYouMessage(){
        when(model.getTotal()).thenReturn(.50);
        vendingMachineController.productSelected("chips");

        verify(view).displayThankYouMessage();
    }

    @Test
    public void givenNotEnoughMoneyWhenChipsAreSelectedThenVendingMachineDisplaysInvalidPriceMessage(){
        when(model.getTotal()).thenReturn(.49);
        vendingMachineController.productSelected("chips");

        verify(view).displayInvalidPriceMessage();
    }

    @Test
    public void givenEnoughMoneyWhenCandyIsSelectedThenVendingMachineDisplaysThankYouMessage(){
        when(model.getTotal()).thenReturn(.65);
        vendingMachineController.productSelected("candy");

        verify(view).displayThankYouMessage();
    }

    @Test
    public void givenNotEnoughMoneyWhenCandyIsSelectedThenVendingMachineDisplaysInvalidPriceMessage(){
        when(model.getTotal()).thenReturn(.64);
        vendingMachineController.productSelected("candy");

        verify(view).displayInvalidPriceMessage();
    }
}
