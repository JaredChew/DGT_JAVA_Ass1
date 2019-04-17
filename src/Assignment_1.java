/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hosiang, Jared, Marissa
 */

import javax.swing.*;
import java.util.Random;

public class Assignment_1 {
    
    static PointOfSale[] Pos = new PointOfSale[100];
    static String selection;
    static int choices;
    
    public static void main(String args[]) {
        
        int mainMenu_loop = 1;
        
        for(int i = 0; i < 100; i++) {
            
            Pos[i] = new PointOfSale();
            
        }

        //loadData();
        
        do {
            
            mainMenu_loop = mainMenu();
            
        } while (mainMenu_loop != 0);
        
        System.exit(0);

    }
    
    private static int mainMenu() {

        String orderNum_list = "";
        
        UIManager.put("OptionPane.yesButtonText","Place a new order");
        UIManager.put("OptionPane.noButtonText", "View outstanding invoice");
        UIManager.put("OptionPane.cancelButtonText", "Close the program");
        
        choices = JOptionPane.showConfirmDialog(null, Menu.greet() + "Would you like to place a new order, view outstanding invoice, or close the program?", "Point of sale system", JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (choices == 0) {

            for(int i = 0; i < 100; i++) {

                if (Pos[i].getOrderNum() == 0) {
                    
                    UIManager.put("OptionPane.yesButtonText","Place a la carte order");
                    UIManager.put("OptionPane.noButtonText", "Place a set order");
                    UIManager.put("OptionPane.cancelButtonText", "Return to main menu");

                    choices = JOptionPane.showConfirmDialog(null, Menu.menuList() + "Would you like to place an a la carte order or a set order?", "Point of sale system", JOptionPane.YES_NO_CANCEL_OPTION);
                    
                    if(choices == 0) {

                        selection = Pos[i].alacarte("new");
                        
                        if (selection == "proceed") {
                            
                            reorderLoop(i);
                            
                        }
                        
                        else {

                            return 1;
                        
                        }
                        
                        return 1;
                        
                    }

                    else if (choices == 1) {

                        selection = Pos[i].setNav("new", i);

                        if (selection == "proceed") {
                            
                            reorderLoop(i);

                        }
                        
                        else {

                            return 1;
                        
                        }
                        
                        return 1;

                    }
                    
                    else if (choices == 2) {

                        return 1;

                    }
                    
                    else if (choices == JOptionPane.CLOSED_OPTION) {
            
                        System.exit(0);

                    }

                }

            }
            
            JOptionPane.showMessageDialog(null, "No capacity for new orders.\nComplete previous orders!");
            
            return 1;

        }

        else if (choices == 1) {
            
            UIManager.put("OptionPane.cancelButtonText", "Cancel");
            
            String loop;
            int order, counter = 0, checker = 0;
            
            for(int i = 0 ; i < 100; i++) {
                
                if (Pos[i].getOrderNum() == 0) {
                    
                    counter++;
                    
                }

                else if (Pos[i].getOrderNum() != 0) {
                    
                    if(checker == 0){
                        
                        orderNum_list += (Pos[i].getOrderNum());
                        
                    }
                    
                    else if(checker == 4){
                        
                        orderNum_list += (", " + Pos[i].getOrderNum() + ",\n");
                        
                    }
                    
                    else if (checker == 5){
                        
                        orderNum_list += (Pos[i].getOrderNum());
                        
                        checker = 0;
                        
                    }
                    
                    else{
                        
                        orderNum_list += (", " + Pos[i].getOrderNum());
                        
                    }
                    
                    checker++;
                    
               }

            }
            
            if (counter != 100) {
                
                while(true) {
                    
                    try {
                    
                        counter = 0;

                        selection = JOptionPane.showInputDialog(null, orderNum_list + "\nPlease key-in the order number you wish to view:");

                        if(selection == null) {

                            return 1;

                        }

                        order = Integer.parseInt(selection);

                        for(int i = 0; i < 99; i++) {

                            if(order == Pos[i].getOrderNum()) {

                                order = i;
                                break;

                            }
                            
                            counter++;

                        }
                        
                        if (counter == 98) {
                            
                            JOptionPane.showMessageDialog(null, "Order does not exist!");
                            
                        }
                        
                        else {

                            break;
                        
                        }

                    } catch (Exception errorLog) {

                        JOptionPane.showMessageDialog(null, "Please input a valid order number!");

                    }

                }
                
                while(true) {

                    loop = Pos[order].viewInvoice();
                    
                    if(loop == "no") {
                        
                        break;
                        
                    }
                
                }
                
            }
            
            else if (counter == 100) {
                
                JOptionPane.showMessageDialog(null, "No orders were placed.");
                
            }
            
            return 1;

        }

        else if (choices == 2) {

            return 0;

        }
        
        else if (choices == JOptionPane.CLOSED_OPTION) {
            
            System.exit(0);
            
        }
        
        return 1;

    }
    
    private static void reorderLoop(int order) {
        
        int orderNum;
        
        selection = Pos[order].orderAgain();
        
        while(true) {
        
            if (selection == "set") {
                
                Pos[order].setNav("reorder", order);
                selection = Pos[order].orderAgain();

            }

            else if (selection == "alacarte") {

                Pos[order].alacarte("reorder");
                selection = Pos[order].orderAgain();

            }

            else if (selection == "no") {
                
                if(Pos[order].getTotalPrice() <= 0.00) {
                    
                    JOptionPane.showMessageDialog(null, "Order canceled.");
                    
                    break;
                    
                }

                orderNum = orderNumberGenerator();
                
                Pos[order].setOrderNum(orderNum);
                Pos[order].setInvoice();
                
                JOptionPane.showMessageDialog(null, Pos[order].displayInvoice());
                
                break;

            }
            
            else if (choices == JOptionPane.CLOSED_OPTION) {
            
                System.exit(0);
            
            }
        
        }
        
    }
    
    private static int randomNumberGenerator() {
        
        Random rng = new Random();
        
        int number = rng.nextInt() % 10000;
        
        return number;
        
    }
    
    private static int orderNumberGenerator() {
        
        int orderNum;
        int counter = 0;
        
        while(true) {
                
            orderNum = randomNumberGenerator();

            if(orderNum > 0) {

                for(int i = 0; i < 100; i++) {
                    
                    if(orderNum == Pos[i].getOrderNum()) {
                        
                        break;
                        
                    }
                    
                    counter++;
                    
                }
                
                if (counter == 100) {
                    
                    break;
                    
                }
                
                counter = 0;

            }

        }
        
        return orderNum;
        
    }
/*    
    private static void loadData() {

        int orderNum = 0;

        try {
            
            for(int i = 0; i < 100; i++) {
                
                FileReader fr = new FileReader("src/data/" + orderNum + ".hjm");
                Scanner input = new Scanner(fr);
                //BufferedReader br = new BufferedReader(fr);

                while(input.hasNext()) {
                    
                    //read data algorithm
                    
                }
                
                input.close();
                
            }

        } catch (Exception errorLog) {

            System.out.println("File not found.\n\nError:\n" + errorLog);

        }
    }
*/
}
