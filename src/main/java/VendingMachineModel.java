public class VendingMachineModel {

    public VendingMachineModel(double startingAmount) {
        this.total = startingAmount;
    }

    private double total;

    public void changeTotal(double coin) {
        total += coin;
    }

    public double getTotal() {
        return total;
    }
}
