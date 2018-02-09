public class VendingMachine {
    VendingMachineModel model;

    public VendingMachine(VendingMachineModel model) {
        this.model = model;
    }

    public String insertCoin(String coin) {
        switch (coin) {
            case "nickel":
                model.changeTotal(.05);
                return "Total: $.05";

            case "dime":
                return "Total: $.10";

            case "quarter":
                return "Total: $.25";

            default:
                return "Invalid Coin";
        }
    }

    public Double getTotal(){
        return model.getTotal();
    }
}
