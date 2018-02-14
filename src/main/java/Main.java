public class Main {
    public static void main(String[] args) {
        VendingMachineView view = new VendingMachineView();
        VendingMachineModel model = new VendingMachineModel(0.0);
        VendingMachineController vmc = new VendingMachineController(model, view);

        vmc.start();
    }
}
