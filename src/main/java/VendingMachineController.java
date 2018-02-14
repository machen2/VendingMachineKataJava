public class VendingMachineController {
    VendingMachineModel model;
    VendingMachineView view;

    public VendingMachineController(VendingMachineModel model, VendingMachineView view) {
        this.model = model;
        this.view = view;
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
