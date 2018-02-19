public class Main {
    public static void main(String[] args) {
        VendingMachineView view = new VendingMachineView();
        VendingMachineModel model = new VendingMachineModel(0.0);
        Dispenser dispenser = new Dispenser();
        VendingMachineController vmc = new VendingMachineController(model, view, dispenser);

        vmc.start();
    }
}
