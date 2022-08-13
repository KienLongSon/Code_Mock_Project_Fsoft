package controller;

public class MenuOrder {
    private static MenuOrder instance;
    public static MenuOrder getInstance(){
        if(instance==null){
            instance = new MenuOrder();
        }
        return instance;
    }

    public void MainMenuOrder(){
        System.out.println("Menu Order:\n" +
                "1. Create new Order:\n" +
                "2. Search order by Name customer.\n" +
                "3. List order by Date.\n" +
                "4. List order by Total Money.\n" +
                "0. Back to Main Menu Shop....");
    }

    /** In menu Order, when choose = 2 - search order
     * After search, handle data
     * show Detail, edit detail or del,...
     */
    public void MenuSearch(){
        System.out.println("Are you do something:\n" +
                "1. View Order detail.\n" +
                "2. Edit Order detail\n" +
                "3. Delete Order\n" +
                "0. Back to Menu Order.");
    }
}
