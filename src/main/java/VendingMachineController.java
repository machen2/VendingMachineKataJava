import java.util.HashMap;
import java.util.Map;

public class VendingMachineController {
    private VendingMachineModel model;
    private VendingMachineView view;
    private Dispenser dispenser;

    Map<String, Double> productPrices = new HashMap<>();

    public VendingMachineController(VendingMachineModel model, VendingMachineView view, Dispenser dispenser) {
        this.model = model;
        this.view = view;
        this.dispenser = dispenser;

        productPrices.put("chips", .50);
        productPrices.put("cola", 1.00);
        productPrices.put("candy", .65);
    }

    public void start() {
        view.displayStartingMessage();
    }

    public void insertCoin(String coin) {
        switch (coin) {
            case "nickel":
                changeTotal(.05);
                displayTotal();
                break;

            case "dime":
                changeTotal(.10);
                displayTotal();
                break;

            case "quarter":
                changeTotal(.25);
                displayTotal();
                break;

            default:
                view.displayErrorMessage();
        }
    }

    public void productSelected(String product) {
        if (getTotal() < productPrices.get(product)) {
            view.displayInvalidPriceMessage();
        } else {
            dispenser.dispenseProduct(product);
            view.displayThankYouMessage();
        }
    }

    private Double getTotal(){
        return model.getTotal();
    }

    private void displayTotal() {
        view.displayTotal(getTotal());
    }

    private void changeTotal(double value) {
        model.changeTotal(value);
    }
}
