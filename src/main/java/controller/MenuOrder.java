package controller;

import java.util.Scanner;

public class MenuOrder {
    private static MenuOrder instance;

    public static MenuOrder getInstance() {
        if (instance == null) {
            instance = new MenuOrder();
        }
        return instance;
    }

    public int MainMenuOrder() {
        System.out.println("---------Order menu----------");
        System.out.println(
                "1. Create new Order:\n" +
                "2. Search order by Name customer.\n" +
                "3. List order by Date.\n" +
                "4. List order Today by Total Money.\n" +
                "0. Back to Main Menu Shop....");
        int chooseSubMenuOrder;
        chooseSubMenuOrder = Integer.parseInt(new Scanner(System.in).nextLine());
        return chooseSubMenuOrder;
    }

    /**
     * In menu Order, when choose = 2 - search order
     * After search, handle data
     * show Detail, edit detail or del,...
     */
    public int MenuSearch() {
        System.out.println("Are you do something:\n" +
                "1. View Order detail.\n" +
                "2. Edit Order detail\n" +
                "3. Delete Order\n" +
                "0. Back to Menu Order.");
        int chooseMenuSearch;
        chooseMenuSearch = Integer.parseInt(new Scanner(System.in).nextLine());
        return chooseMenuSearch;
    }

    public int MenuEditOrder(){
        System.out.println("Menu Edit Order:\n" +
                "1. Edit ID Address.\n" +
                "0. Back and Save>>>>>>");
        int choose = Integer.parseInt(new Scanner(System.in).nextLine());
        return choose;
    }
}
