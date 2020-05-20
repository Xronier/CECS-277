public class lab4Main {
    public static void main(String[] args) {
        vendingMachine machine = new vendingMachine();
        vendingMachineMenu menu = new vendingMachineMenu();
        menu.Run(machine);
    }
}
