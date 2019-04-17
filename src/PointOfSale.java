/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hosiang, Jared, Marissa
 */

import java.io.*;
import javax.swing.*;

public class PointOfSale {
    
    private int choices;
    private String selection;
    
    private int _orderNum;
    private String invoice;
    private double _totalPrice;
    
    boolean _set_ordered;
    boolean _alacarte_ordered;

    private int[] _set1_quantity = new int[99];
    private int[] _set2_quantity = new int[99];
    private int[] _set3_quantity = new int[99];

    private int[] _starter_quantity = new int[2];
    private int[] _desserts_quantity = new int[3];
    private int[] _softDrinks_quantity = new int[4];
    private int[] _mainCourse_quantity = new int[4];
    private int[] _warmBeverages_quantity = new int[2];
    
    private String[] _starter = new String[2];
    private String[] _desserts = new String[3];
    private String[] _mainCourse = new String[4];
    private String[] _softDrinks = new String[4];
    private String[] _warmBeverages = new String[2];

    private String[] _set1_starter = new String[99];
    private String[] _set1_softDrinks = new String[99];
    private String[] _set1_mainCourse = new String[99];

    private String[] _set2_desserts = new String[99];
    private String[] _set2_mainCourse = new String[99];
    private String[] _set2_warmBeverages = new String[99];

    private String[] _set3_starter = new String[99];
    private String[] _set3_desserts = new String[99];
    private String[] _set3_softDrinks = new String[99];
    private String[] _set3_mainCourse = new String[99];
    private String[] _set3_warmBeverages = new String[99];
    
    PointOfSale() {
        
        invoice = "";
        _orderNum = 0;
        _totalPrice = 0.0;
        
        _set_ordered = false;
        _alacarte_ordered = false;
        
        for(int i = 0; i < 99; i++) {

            _set1_quantity[i] = 0;
            _set2_quantity[i] = 0;
            _set3_quantity[i] = 0;
        
        }
        
        for(int i = 0; i < 99; i++) {
            
            _set1_quantity[i] = 0;
            _set2_quantity[i] = 0;
            _set3_quantity[i] = 0;
            _set1_starter[i] = "";
            _set3_starter[i] = "";
            _set2_desserts[i] = "";
            _set3_desserts[i] = "";
            _set1_softDrinks[i] = "";
            _set1_mainCourse[i] = "";
            _set2_mainCourse[i] = "";
            _set3_softDrinks[i] = "";
            _set3_mainCourse[i]  = "";
            _set2_warmBeverages[i] = "";
            _set3_warmBeverages[i] = "";
        
        }

        for(int i = 0; i < 4; i++) {

            _mainCourse[i] = "";
            _softDrinks[i] = "";
            _softDrinks_quantity[i] = 0;
            _mainCourse_quantity[i] = 0;
        
        }
        
        for(int i =0; i < 3; i++) {

            _desserts[i] = "";
            _desserts_quantity[i] = 0;
        
        }

        for(int i = 0; i < 2; i++) {
    
            _starter[i] = "";
            _warmBeverages[i] = "";
            _starter_quantity[i] = 0;
            _warmBeverages_quantity[i] = 0;
        
        }
                
    }

    
    public String alacarte(String condition) {
        
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        
        String alacarteType = setAlacarte();        
        
        if( alacarteType == "Warm Beverages") {
            
            String proceed = setWarmBeverages(condition);
            
            if(proceed == "proceed") {
                
                _alacarte_ordered = true;
                return "proceed";
                
            }
            
            else {
                
                return "";
                
            }
            
        }
        
        else if (alacarteType == "Soft Drinks") {
            
            String proceed = setSoftDrink(condition);
            
            if(proceed == "proceed") {
                
                _alacarte_ordered = true;
                return "proceed";
                
            }
            
            else {
                
                return "";
                
            }
            
        }
        
        else if (alacarteType == "Starter") {
            
            String proceed = setStarter(condition);
            
            if(proceed == "proceed") {
                
                _alacarte_ordered = true;
                return "proceed";
                
            }
            
            else {
                
                return "";
                
            }
            
        }
        
        else if (alacarteType == "Main Course") {
            
            String proceed = setMainCourse(condition);
            
            if(proceed == "proceed") {
                
                _alacarte_ordered = true;
                return "proceed";
                
            }
            
            else {
                
                return "";
                
            }
            
        }
        
        else if (alacarteType == "Dessert") {
            
            String proceed = setDesserts(condition);
            
            if(proceed == "proceed") {
                
                _alacarte_ordered = true;
                return "proceed";
                
            }
            
            else {
                
                return "";
                
            }
            
        }

        return "";
        
    }
    
    private String setAlacarte(){
        
        String[] alacarteType = { "Soft Drinks", "Warm Beverages", "Starter", "Main Course", "Dessert" };

        String ipA = (String) JOptionPane.showInputDialog(null, Menu.alacarteList() + "Which section would you like to order from", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, alacarteType, alacarteType[0]);
        
        return ipA;
    }
    
    private String setSoftDrink(String condition){
        
        String quantityInputS;
        String order;
        int testValue;

        String softDrinksList[] = {"Coca cola", "Sprite", "Ice lemon tea", "Fanta"};
        
        order = (String) JOptionPane.showInputDialog(null, Menu.softDrinksList() + "Please select your prefered soft drink", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, softDrinksList, softDrinksList[0]);
        
        if(order == null) {
            
            return "";
            
        }
        
        for(int i = 0; i < 4; i++) {
            
            if(_softDrinks[i] == order) {
                
                if (condition == "add") {
                    
                    while(true) {
                
                        try {

                            quantityInputS = JOptionPane.showInputDialog(null, Menu.softDrinksList() + "How many would you like to add?");

                            if(quantityInputS == null) {

                                return "";

                            }
                        
                            else if ((Integer.parseInt(quantityInputS) + _softDrinks_quantity[i]) >= 100) {
                                
                                quantityInputS = "Oi ! No one will try to buy more then 100.";
                                
                            }

                            _softDrinks_quantity[i] += Integer.parseInt(quantityInputS);

                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number less than 99.");

                        }

                    }
                    
                    _totalPrice += ((Integer.parseInt(quantityInputS)) * 2.0);
                    
                    return "";
                    
                }
                
                UIManager.put("OptionPane.yesButtonText","Add");
                UIManager.put("OptionPane.noButtonText", "Reduce");
                UIManager.put("OptionPane.cancelButtonText", "Cancel");
                
                choices = JOptionPane.showConfirmDialog(null, Menu.softDrinksList() + "Add or reduce?", "Point of sale system", JOptionPane.YES_NO_CANCEL_OPTION);

                if (choices == 0){
                    
                    while(true) {
                
                        try {
                            
                            _totalPrice = (_softDrinks_quantity[i] * 2.00);
                            quantityInputS = JOptionPane.showInputDialog(null, Menu.name() + "\n                                                                                                                   > " + _softDrinks_quantity[i] + " <    X    " + _softDrinks[i] + "        RM" + _totalPrice + "\n\n" + "How many would you like to add?");

                            if(quantityInputS == null) {

                                return "";

                            }
                            
                            else if ((Integer.parseInt(quantityInputS) + _softDrinks_quantity[i]) >= 100) {
                                
                                quantityInputS = "Oi ! No one will try to buy more then 100.";
                                
                            }

                            _softDrinks_quantity[i] += Integer.parseInt(quantityInputS);
                            
                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number less than 100.");

                        }

                    }
                    
                    _totalPrice += ((Integer.parseInt(quantityInputS)) * 2.0);
                    
                    return "";

                }

                else if (choices == 1) {
                   
                    while(true) {
                
                        try {

                            _totalPrice = (_softDrinks_quantity[i] * 2.00);
                            quantityInputS = JOptionPane.showInputDialog(null, Menu.name() + "\n                                                                                                                   > " + _softDrinks_quantity[i] + " <    X    " + _softDrinks[i] + "        RM" + _totalPrice + "\n\n" + "How many would you like to reduce?");

                            if(quantityInputS == null) {

                                return "";

                            }

                            testValue = Integer.parseInt(quantityInputS);
                            
                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a valid value.");

                        }

                    }
                    
                    if(Integer.parseInt(quantityInputS) >= _softDrinks_quantity[i]) {
                        
                        _totalPrice -= (_softDrinks_quantity[i] * 2.0);
                        _softDrinks_quantity[i] = 0;
                        _alacarte_ordered = false;
                        
                        return "";
                        
                    }
                    
                    else {
                        
                        _totalPrice -= ((Integer.parseInt(quantityInputS)) * 2.0);
                        _softDrinks_quantity[i] -= Integer.parseInt(quantityInputS);

                        return "";
                        
                    }

                }
                
                else if (choices == JOptionPane.CLOSED_OPTION) {
            
                    System.exit(0);

                }
                
                else {
                    
                    return "";
                    
                }
                
            }
            
        }
        
        UIManager.put("OptionPane.yesButtonText","Yes");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        
        for(int i = 0; i < 4; i++) {
            
            if(_softDrinks[i] == "") {
                
                _softDrinks[i] = order;
                
                while(true) {
                
                    try {

                        quantityInputS = JOptionPane.showInputDialog(null, Menu.softDrinksList() + "How many would you like to order?");
                        
                        if(quantityInputS == null) {
                            
                            return "";
                            
                        }
                        
                        else if(Integer.parseInt(quantityInputS) <= 0 || Integer.parseInt(quantityInputS) > 99) {

                            quantityInputS = " Oi ! No one will try to buy more then 100 or less then 1.";
                            
                        }
                        
                        _softDrinks_quantity[i] = Integer.parseInt(quantityInputS);

                        break;

                    } catch (Exception errorLog) {

                        JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number more than 0 or less than 100.");

                    }
                
                }
                
                _totalPrice += 2.0;
                
                return  "proceed";
                
            }
            
        }
        
        return "";

    }
    
    private String setWarmBeverages(String condition){
        
        int testValue;
        String quantityInputS;
        String order;
        
        String warmBeveragesList[] = {"Coffee", "Tea"};
        
        order = (String) JOptionPane.showInputDialog(null, Menu.warmBeverageList() + "Please select your prefered warm beverage", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, warmBeveragesList, warmBeveragesList[0]);
        
        if (order == null) {
            
            return "";
            
        }
        
        for(int i = 0; i < 2; i++) {
            
            if(_warmBeverages[i] == order) {
                
                if (condition == "add") {
                    
                     while(true) {
                
                        try {

                            quantityInputS = JOptionPane.showInputDialog(null, Menu.warmBeverageList() + "How many would you like to add?");

                            if(quantityInputS == null) {

                                return "";

                            }
                        
                            else if ((Integer.parseInt(quantityInputS) + _warmBeverages_quantity[i]) >= 100) {
                                
                                quantityInputS = "Oi ! No one will try to buy more then 100.";
                                
                            }

                            _warmBeverages_quantity[i] += Integer.parseInt(quantityInputS);

                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number more than 0 or less than 100.");

                        }

                    }
                    
                    _totalPrice += ((Integer.parseInt(quantityInputS)) * 2.0);
                    
                    return "";
                    
                }
                
                UIManager.put("OptionPane.yesButtonText","Add");
                UIManager.put("OptionPane.noButtonText", "Reduce");
                UIManager.put("OptionPane.cancelButtonText", "Cancel");
                
                choices = JOptionPane.showConfirmDialog(null, Menu.warmBeverageList() + "Add or reduce?", "Point of sale system", JOptionPane.YES_NO_CANCEL_OPTION);

                if (choices == 0){

                    while(true) {
                
                        try {
                            
                            _totalPrice = (_warmBeverages_quantity[i] * 1.80);
                            quantityInputS = JOptionPane.showInputDialog(null, Menu.name() + "\n                                                                                                                   > " + _warmBeverages_quantity[i] + " <    X    " + _warmBeverages[i] + "        RM" + _totalPrice + "\n\n" + "How many would you like to add?");

                            if(quantityInputS == null) {

                                return "";

                            }
                            
                            else if ((Integer.parseInt(quantityInputS) + _warmBeverages_quantity[i]) >= 100) {
                                
                                quantityInputS = "Oi ! No one will try to buy more then 100.";
                                
                            }

                            _warmBeverages_quantity[i] += Integer.parseInt(quantityInputS);
                            
                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number less than 100.");

                        }

                    }
                    
                    _totalPrice += ((Integer.parseInt(quantityInputS)) * 1.80);
                    
                    return "";

                }

                else if (choices == 1) {

                    while(true) {
                
                        try {
                            
                            _totalPrice = (_warmBeverages_quantity[i] * 1.80);
                            quantityInputS = JOptionPane.showInputDialog(null, Menu.name() + "\n                                                                                                                   > " + _warmBeverages_quantity[i] + " <    X    " + _warmBeverages[i] + "        RM" + _totalPrice + "\n\n" + "How many would you like to reduce?");

                            if(quantityInputS == null) {

                                return "";

                            }

                            testValue = Integer.parseInt(quantityInputS);
                            
                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a valid value.");

                        }

                    }
                    
                    if(Integer.parseInt(quantityInputS) >= _warmBeverages_quantity[i]) {
                        
                        _totalPrice -= (_warmBeverages_quantity[i] * 1.80);
                        _warmBeverages_quantity[i] = 0;
                        _alacarte_ordered = false;

                        return "";
                        
                    }
                    
                    else {
                        
                        _totalPrice -= ((Integer.parseInt(quantityInputS)) * 1.80);
                        _warmBeverages_quantity[i] -= Integer.parseInt(quantityInputS);

                        return "";
                        
                    }

                }
                
                else if (choices == JOptionPane.CLOSED_OPTION) {
            
                    System.exit(0);

                }
                
                else {
                    
                    return "";
                    
                }
                
            }
            
        }
        
        UIManager.put("OptionPane.yesButtonText","Yes");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        
        for(int i = 0; i < 2; i++) {
            
            if(_warmBeverages[i] == "") {
                
                _warmBeverages[i] = order;
        
                while(true) {
                
                    try {

                        quantityInputS = JOptionPane.showInputDialog(null, Menu.warmBeverageList() + "How many would you like to order?");
                                                
                        if(quantityInputS == null) {
                            
                            return "";
                            
                        }
                        
                        else if(Integer.parseInt(quantityInputS) <= 0 || Integer.parseInt(quantityInputS) > 99) {

                            quantityInputS = " Oi ! No one will try to buy more then 100 or less then 1.";
                            
                        }
                        
                        _warmBeverages_quantity[i] = Integer.parseInt(quantityInputS);
                        
                        break;

                    } catch (Exception errorLog) {

                        JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number more than 0 or less than 100.");

                    }
                
                }
                
                _totalPrice += ((Integer.parseInt(quantityInputS)) * 1.80);
                
                return "proceed";
                
            }
            
        }
        
        return "";
        
    }
    
    private String setStarter(String condition){
        
        int testValue;
        String quantityInputS;
        String order;

        String starterList[] = {"Salad", "Soup"};
        
        order = (String) JOptionPane.showInputDialog(null, Menu.starterList() + "Please select your prefered starter dish", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, starterList, starterList[0]);
        
        if (order == null) {
            
            return "";
            
        }
        
        for(int i = 0; i < 2; i++) {
            
            if(_starter[i] == order) {
                
                if (condition == "add") {
                    
                    while(true) {
                
                        try {

                            quantityInputS = JOptionPane.showInputDialog(null, Menu.starterList() + "How many would you like to add?");

                            if(quantityInputS == null) {

                                return "";

                            }
                        
                            else if ((Integer.parseInt(quantityInputS) + _starter_quantity[i]) >= 100) {
                                
                                quantityInputS = "Oi ! No one will try to buy more then 100.";
                                
                            }

                            _starter_quantity[i] += Integer.parseInt(quantityInputS);

                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number more than 0 or less than 100.");

                        }

                    }
                    
                    _totalPrice += ((Integer.parseInt(quantityInputS)) * 2.0);
                    
                    return "";
                    
                }
                
                UIManager.put("OptionPane.yesButtonText","Add");
                UIManager.put("OptionPane.noButtonText", "Reduce");
                UIManager.put("OptionPane.cancelButtonText", "Cancel");
                
                choices = JOptionPane.showConfirmDialog(null, Menu.starterList() + "Add or reduce?", "Point of sale system", JOptionPane.YES_NO_CANCEL_OPTION);

                if (choices == 0){

                    while(true) {
                
                        try {

                            _totalPrice = (_starter_quantity[i] * 4.00);
                            quantityInputS = JOptionPane.showInputDialog(null, Menu.name() + "\n                                                                                                                   > " + _starter_quantity[i] + " <    X    " + _starter[i] + "        RM" + _totalPrice + "\n\n" + "How many would you like to add?");

                            if(quantityInputS == null) {

                                return "";

                            }
                            
                            else if ((Integer.parseInt(quantityInputS) + _starter_quantity[i]) >= 100) {
                                
                                quantityInputS = "Oi ! No one will try to buy more then 100.";
                                
                            }

                            _starter_quantity[i] += Integer.parseInt(quantityInputS);
                            
                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number less than 100.");

                        }

                    }
                    
                    _totalPrice += ((Integer.parseInt(quantityInputS)) * 4.0);
                    
                    return "";

                }

                else if (choices == 1) {

                    while(true) {
                
                        try {

                            _totalPrice = (_starter_quantity[i] * 4.00);
                            quantityInputS = JOptionPane.showInputDialog(null, Menu.name() + "\n                                                                                                                   > " + _starter_quantity[i] + " <    X    " + _starter[i] + "        RM" + _totalPrice + "\n\n" + "How many would you like to reduce?");

                            if(quantityInputS == null) {

                                return "";

                            }

                            testValue = Integer.parseInt(quantityInputS);
                            
                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a valid value.");

                        }

                    }
                    
                    if(Integer.parseInt(quantityInputS) >= _starter_quantity[i]) {
                        
                        _totalPrice -= (_starter_quantity[i] * 4.0);
                        _starter_quantity[i] = 0;
                        _alacarte_ordered = false;

                        return "";
                        
                    }
                    
                    else {
                        
                        _totalPrice -= ((Integer.parseInt(quantityInputS)) * 4.0);
                        _starter_quantity[i] -= Integer.parseInt(quantityInputS);

                        return "";
                        
                    }

                }
                
                else if (choices == JOptionPane.CLOSED_OPTION) {
            
                    System.exit(0);

                }
                
                else {
                    
                    return "";
                    
                }
                
            }
            
        }
        
        UIManager.put("OptionPane.yesButtonText","Yes");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        
        for(int i = 0; i < 2; i++) {
            
            if(_starter[i] == "") {
                
                _starter[i] = order;
        
                while(true) {
                
                    try {

                        quantityInputS = JOptionPane.showInputDialog(null, Menu.starterList() + "How many would you like to order?");
                                                
                        if(quantityInputS == null) {
                            
                            return "";
                            
                        }
                        
                        else if(Integer.parseInt(quantityInputS) <= 0 || Integer.parseInt(quantityInputS) > 99) {

                            quantityInputS = " Oi ! No one will try to buy more then 100 or less then 1.";
                            
                        }
                        
                        _starter_quantity[i] = Integer.parseInt(quantityInputS);
                        
                        break;

                    } catch (Exception errorLog) {

                        JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number more than 0 or less than 100.");

                    }
                
                }
                
                _totalPrice += ((Integer.parseInt(quantityInputS)) * 4.0);
                
                return  "proceed";
                
            }
            
        }
        
        return "";
        
    }
    private String setMainCourse(String condition){
        
        int testValue;
        String quantityInputS;
        String order;

        String mainCourseList[] = {"Chicken rice", "Curry noodle", "Nasi lemak", "Asam laksa"};
        
        order = (String) JOptionPane.showInputDialog(null, Menu.mainCourseList() + "Please select your prefered main course dish", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, mainCourseList, mainCourseList[0]);
        
        if (order == null) {
            
             return "";
            
        }
        
        for(int i = 0; i < 4; i++) {
            
            if(_mainCourse[i] == order) {
                
                if (condition == "add") {
                    
                    while(true) {
                
                        try {

                            quantityInputS = JOptionPane.showInputDialog(null, Menu.mainCourseList() + "How many would you like to add?");

                            if(quantityInputS == null) {

                                return "";

                            }
                        
                            else if ((Integer.parseInt(quantityInputS) + _mainCourse_quantity[i]) >= 100) {
                                
                                quantityInputS = "Oi ! No one will try to buy more then 100.";
                                
                            }

                            _mainCourse_quantity[i] += Integer.parseInt(quantityInputS);

                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number more than 0 or less than 100.");

                        }

                    }
                    
                    _totalPrice += ((Integer.parseInt(quantityInputS)) * 2.0);
                    
                    return "";
                    
                }
                
                UIManager.put("OptionPane.yesButtonText","Add");
                UIManager.put("OptionPane.noButtonText", "Reduce");
                UIManager.put("OptionPane.cancelButtonText", "Cancel");
                
                choices = JOptionPane.showConfirmDialog(null, Menu.mainCourseList() + "Add or reduce?", "Point of sale system", JOptionPane.YES_NO_CANCEL_OPTION);

                if (choices == 0){

                    while(true) {
                
                        try {

                            _totalPrice = (_mainCourse_quantity[i] * 8.00);
                            quantityInputS = JOptionPane.showInputDialog(null, Menu.name() + "\n                                                                                                                   > " + _mainCourse_quantity[i] + " <    X    " + _mainCourse[i] + "        RM" + _totalPrice + "\n\n" + "How many would you like to add?");

                            if(quantityInputS == null) {

                                return "";

                            }
                            
                            else if ((Integer.parseInt(quantityInputS) + _mainCourse_quantity[i]) >= 100) {
                                
                                quantityInputS = "Oi ! No one will try to buy more then 100.";
                                
                            }

                            _mainCourse_quantity[i] += Integer.parseInt(quantityInputS);
                            
                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number less than 100.");

                        }

                    }
                    
                    _totalPrice += ((Integer.parseInt(quantityInputS)) * 8.0);
                    
                    return "";

                }

                else if (choices == 1) {

                    while(true) {
                
                        try {

                            _totalPrice = (_mainCourse_quantity[i] * 8.00);
                            quantityInputS = JOptionPane.showInputDialog(null, Menu.name() + "\n                                                                                                                   > " + _mainCourse_quantity[i] + " <    X    " + _mainCourse[i] + "        RM" + _totalPrice + "\n\n" + "How many would you like to reduce?");

                            if(quantityInputS == null) {

                                return "";

                            }

                            testValue = Integer.parseInt(quantityInputS);
                            
                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a valid value.");

                        }

                    }
                    
                    if(Integer.parseInt(quantityInputS) >= _mainCourse_quantity[i]) {
                        
                        _totalPrice -= (_mainCourse_quantity[i] * 8.0);
                        _mainCourse_quantity[i] = 0;
                        _alacarte_ordered = false;

                        return "";
                        
                    }
                    
                    else {
                        
                        _totalPrice -= ((Integer.parseInt(quantityInputS)) * 8.0);
                        _mainCourse_quantity[i] -= Integer.parseInt(quantityInputS);

                        return "";
                        
                    }

                }
                
                else if (choices == JOptionPane.CLOSED_OPTION) {
            
                    System.exit(0);

                }
                
                else {
                    
                    return "";
                    
                }
                
            }
            
        }
        
        UIManager.put("OptionPane.yesButtonText","Yes");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        
        for(int i = 0; i < 4; i++) {
            
            if(_mainCourse[i] == "") {
                
                _mainCourse[i] = order;
       
                while(true) {
                
                    try {

                        quantityInputS = JOptionPane.showInputDialog(null, Menu.mainCourseList() + "How many would you like to order?");
                                                
                        if(quantityInputS == null) {
                            
                            return "";
                            
                        }
                        
                        else if(Integer.parseInt(quantityInputS) <= 0 || Integer.parseInt(quantityInputS) > 99) {

                            quantityInputS = " Oi ! No one will try to buy more then 100 or less then 1.";
                            
                        }
                        
                        _mainCourse_quantity[i] = Integer.parseInt(quantityInputS);

                        break;

                    } catch (Exception errorLog) {

                        JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number more than 0 or less than 100.");

                    }
                
                }
                
                _totalPrice += ((Integer.parseInt(quantityInputS)) * 8.0);
                
                return  "proceed";
                
            }
            
        }
        
        return "";
        
    }
    private String setDesserts(String condition){
        
        int testValue;
        String quantityInputS;
        String order;

        String dessertsList[] = {"Ice Cream", "Cendol", "Pudding"};
        
        order = (String) JOptionPane.showInputDialog(null, Menu.dessertList() + "Please select your prefered dessert", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, dessertsList, dessertsList[0]);

        if (order == null) {
            
            return "";
            
        }
        
        for(int i = 0; i < 3; i++) {
            
            if(_desserts[i] == order) {
                
                if (condition == "add") {
                    
                    while(true) {
                
                        try {

                            quantityInputS = JOptionPane.showInputDialog(null, Menu.dessertList() + "How many would you like to add?");

                            if(quantityInputS == null) {

                                return "";

                            }
                        
                            else if ((Integer.parseInt(quantityInputS) + _desserts_quantity[i]) >= 100) {
                                
                                quantityInputS = "Oi ! No one will try to buy more then 100.";
                                
                            }

                            _desserts_quantity[i] += Integer.parseInt(quantityInputS);

                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number more than 0 or less than 100.");

                        }

                    }
                    
                    _totalPrice += ((Integer.parseInt(quantityInputS)) * 2.0);
                    
                    return "";
                    
                }
                
                UIManager.put("OptionPane.yesButtonText","Add");
                UIManager.put("OptionPane.noButtonText", "Reduce");
                UIManager.put("OptionPane.cancelButtonText", "Cancel");
                
                choices = JOptionPane.showConfirmDialog(null, Menu.dessertList() + "Add or reduce?", "Point of sale system", JOptionPane.YES_NO_CANCEL_OPTION);

                if (choices == 0){

                    while(true) {
                
                        try {

                            _totalPrice = (_desserts_quantity[i] * 3.50);
                            quantityInputS = JOptionPane.showInputDialog(null, Menu.name() + "\n                                                                                                                   > " + _desserts_quantity[i] + " <    X    " + _desserts[i] + "        RM" + _totalPrice + "\n\n" + "How many would you like to add?");

                            if(quantityInputS == null) {

                                return "";

                            }
                            
                            else if ((Integer.parseInt(quantityInputS) + _desserts_quantity[i]) >= 100) {
                                
                                quantityInputS = "Oi ! No one will try to buy more then 100.";
                                
                            }

                            _desserts_quantity[i] += Integer.parseInt(quantityInputS);
                            
                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number less than 100.");

                        }

                    }
                    
                    _totalPrice += ((Integer.parseInt(quantityInputS)) * 3.5);
                    
                    return "";

                }

                else if (choices == 1) {

                    while(true) {
                
                        try {

                            _totalPrice = (_desserts_quantity[i] * 8.00);
                            quantityInputS = JOptionPane.showInputDialog(null, Menu.name() + "\n                                                                                                                   > " + _desserts_quantity[i] + " <    X    " + _desserts[i] + "        RM" + _totalPrice + "\n\n" + "How many would you like to reduce?");

                            if(quantityInputS == null) {

                                return "";

                            }

                            testValue = Integer.parseInt(quantityInputS);
                            
                            break;

                        } catch (Exception errorLog) {

                            JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a valid value.");

                        }

                    }
                    
                    if(Integer.parseInt(quantityInputS) >= _desserts_quantity[i]) {
                        
                        _totalPrice -= (_desserts_quantity[i] * 3.5);
                        _desserts_quantity[i] = 0;
                        _alacarte_ordered = false;

                        return "";
                        
                    }
                    
                    else {
                        
                        _totalPrice -= ((Integer.parseInt(quantityInputS)) * 3.5);

                        return "";
                        
                    }

                }
                
                else if (choices == JOptionPane.CLOSED_OPTION) {
            
                    System.exit(0);

                }
                
                else {
                    
                    return "";
                    
                }
                
            }
            
        }
        
        UIManager.put("OptionPane.yesButtonText","Yes");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        
        for(int i = 0; i < 3; i++) {
            
            if(_desserts[i] == "") {
                
                _desserts[i] = order;
      
                while(true) {
                
                    try {

                        quantityInputS = JOptionPane.showInputDialog(null, Menu.dessertList() + "How many would you like to order?");
                                                
                        if(quantityInputS == null) {
                            
                            return "";
                            
                        }
                        
                        else if(Integer.parseInt(quantityInputS) <= 0 || Integer.parseInt(quantityInputS) > 99) {

                            quantityInputS = " Oi ! No one will try to buy more then 100 or less then 1.";
                            
                        }
                        
                        _desserts_quantity[i] = Integer.parseInt(quantityInputS);
                        
                        break;

                    } catch (Exception errorLog) {

                        JOptionPane.showMessageDialog(null, "                          Invalid input !!!\nPlease input a number more than 0 or less than 100.");

                    }
                
                }
                
                _totalPrice += ((Integer.parseInt(quantityInputS)) * 3.50);
                
                return "proceed";
                
            }
            
        }
        
        return "";
        
    }
    
    public String setNav(String condition, int order) {
        
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        
        String check = "";
        
        String[] setMenu = { "Set 1", "Set 2", "Set 3"};
        
        selection = (String) JOptionPane.showInputDialog(null, Menu.setMenuList() + "Which set would you like to order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, setMenu, setMenu[0]);
        
        if (selection == "Set 1") {
            
            if (condition == "add") {
                
                check = set1("add");
                
            }
            
            else if (_set1_quantity[order] != 0) {
                
                check = set1("reorder");
                
            }

            else {
                
                check = set1("new");
                
            }
            
            if (check == "proceed") {
                
                _set_ordered = true;
                return "proceed";
                
            }
            
            else {
                
                return "";
                
            }
            
        }
        
        else if (selection == "Set 2") {
            
            if (condition == "add") {
                
                check = set2("add");
                
            }
            
            else if (_set2_quantity[order] != 0) {
                
                check = set2("reorder");
                
            }

            else {
                
                check = set2("new");
                
            }
            
            if (check == "proceed") {
                
                _set_ordered = true;
                return "proceed";
                
            }
            
            else {
                
                return "";
                
            }
            
        }
        
        else if (selection == "Set 3") {
            
            if (condition == "add") {
                
                check = set3("add");
                
            }
            
            else if (_set3_quantity[order] != 0) {
                
                check = set3("reorder");
                
            }

            else {
                
                check = set3("new");
                
            }
            
            if (check == "proceed") {
                
                _set_ordered = true;
                return "proceed";
                
            }
            
            else {
                
                return "";
                
            }
            
        }
    
        return "cancel";
        
    }
    
    private String set1(String condition) {
        
        if (condition == "add") {
            
            set1_order();
            
        }
        
        else if(condition == "new") {
        
            return set1_order();
            
        }
        
        else if (condition == "reorder") {
            
            set1_reOrder();
            
        }
        
        return "";
        
    }
    
    private String set2(String condition) {
        
        if (condition == "add") {
            
            set2_order();
            
            return "";
            
        }
        
        else if (condition == "new") {
        
            return set2_order();
            
        }
        
        else if (condition == "reorder") {
            
            set2_reOrder();
            
        }
        
        return "";
        
    }
    
    private String set3(String condition) {
        
        if (condition == "add") {
            
            set3_order();
            
            return "";
            
        }
        
        else if (condition == "new") {
            
            return set3_order();
            
        }
        
        else if (condition == "reorder") {
            
            set3_reOrder();
            
        }
        
        return "";
        
    }
    
    private String set1_order() {
        
        int counter = 0, checker = 0;
        
        String[] softDrinks = {"Pepsi", "Sprite", "Ice lemon tea", "Fanta"};
        String[] starter = {"Salad", "Soup"};
        String[] mainCourse = {"Chicken rice", "Curry noodle", "Nasi lemak", "Asam laksa"};
        
        for( ; counter < 99; counter++) {
            
            if (_set1_quantity[counter] == 0) {
                
                break;
                
            }
            
            checker++;
            
        }
        
        if (checker == 99) {
            
            JOptionPane.showMessageDialog(null, Menu.set1List() + "You have reached your max quantity of orders for the current set");
            
        }
        
        selection = (String) JOptionPane.showInputDialog(null, Menu.set1List() + "Choose your soft drink of choice.", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, softDrinks, softDrinks[0]);
        
        if (selection == "Pepsi") {
        
            _set1_softDrinks[counter] = "Pepsi";

        }
        
        else if (selection == "Sprite") {
        
            _set1_softDrinks[counter] = "Sprite";

        }
        
        else if (selection == "Ice lemon tea") {
        
            _set1_softDrinks[counter] = "Ice lemon tea";

        }
        
        else if (selection == "Fanta") {
        
            _set1_softDrinks[counter] = "Fanta";

        }
        
        else if(selection == null) {
            
            return "";
            
        }
        
        selection = (String) JOptionPane.showInputDialog(null, Menu.set1List() + "Choose your starter of choice.", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, starter, starter[0]);
        
        if (selection == "Salad") {
        
            _set1_starter[counter] = "Salad";

        }
        
        else if (selection == "Soup") {
        
            _set1_starter[counter] = "Soup";

        }
        
        else if(selection == null) {
            
            return "";
            
        }
        
        selection = (String) JOptionPane.showInputDialog(null, Menu.set1List() + "Choose your main course of choice.", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, mainCourse, mainCourse[0]);
        
        if (selection == "Chicken rice") {
        
            _set1_mainCourse[counter] = "Chicken rice";

        }
        
        else if (selection == "Curry noodle") {
        
            _set1_mainCourse[counter] = "Curry noodle";

        }
        
        else if (selection == "Nasi lemak") {
        
            _set1_mainCourse[counter] = "Nasi lemak";

        }
        
        else if (selection == "Asam laksa") {
        
            _set1_mainCourse[counter] = "Asam laksa";

        }
        
        else if(selection == null) {
            
            return "";
            
        }
        
        _set1_quantity[counter] += 1;
        _totalPrice += 11.00;
 
        return "proceed";
        
    }
    
    private String set2_order() {
        
        String[] warmBeverages = {"Coffee", "Tea"};
        String[] mainCourse = {"Chicken rice", "Curry noodle", "Nasi lemak", "Asam laksa"};
        String[] dessert = {"Ice cream", "Cendol", "Pudding"};
        
        int counter = 0; int checker = 0;
        
        for( ; counter < 99; counter++) {
            
            if (_set2_quantity[counter] == 0) {
                
                break;
                
            }
            
            checker++;
            
        }
        
        if (checker == 99) {
            
            JOptionPane.showMessageDialog(null, Menu.set2List() + "You have reached your max quantity of orders for the current set");
            
        }
        
        selection = (String) JOptionPane.showInputDialog(null, Menu.set2List() + "Choose your warm beverage of choice.", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, warmBeverages, warmBeverages[0]);
        
        if (selection == "Coffee") {
        
            _set2_warmBeverages[counter] = "Coffee";

        }
        
        else if (selection == "Tea") {
        
            _set2_warmBeverages[counter] = "Tea";

        }
        
        else if(selection == null) {
            
            return "";
            
        }
        
        selection = (String) JOptionPane.showInputDialog(null, Menu.set2List() + "Choose your main course of choice.", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, mainCourse, mainCourse[0]);
        
        if (selection == "Chicken rice") {
        
            _set2_mainCourse[counter] = "Chicken rice";

        }
        
        else if (selection == "Curry noodle") {
        
            _set2_mainCourse[counter] = "Curry noodle";

        }
        
        else if (selection == "Nasi lemak") {
        
            _set2_mainCourse[counter] = "Nasi lemak";

        }
        
        else if (selection == "Asam laksa") {
        
            _set2_mainCourse[counter] = "Asam laksa";

        }
        
        else if(selection == null) {
            
            return "";
            
        }
        
        selection = (String) JOptionPane.showInputDialog(null, Menu.set2List() + "Choose your dessert of choice.", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, dessert, dessert[0]);
        
        if (selection == "Ice cream") {
        
            _set2_desserts[counter] = "Ice cream";

        }
        
        else if (selection == "Cendol") {
        
            _set2_desserts[counter] = "Cendol";

        }
        
        else if (selection == "Pudding") {
        
            _set2_desserts[counter] = "Pudding";

        }
        
        else if(selection == null) {
            
            return "";
            
        }
        
        _set2_quantity[counter] += 1;
        _totalPrice += 11.50;
        
        return "proceed";
        
    }
    
    private String set3_order() {
        
        String[] softDrinks = {"Pepsi", "Sprite", "Ice lemon tea", "Fanta"};
        String[] starter = {"Salad", "Soup"};
        String[] warmBeverages = {"Coffee", "Tea"};
        String[] mainCourse = {"Chicken rice", "Curry noodle", "Nasi lemak", "Asam laksa"};
        String[] dessert = {"Ice cream", "Cendol", "Pudding"};
        
        int counter = 0, checker = 0;
        
        for( ; counter < 99; counter++) {
            
            if (_set3_quantity[counter] == 0) {
                
                break;
                
            }
            
            checker++;
            
        }
        
        if (checker == 100) {
            
            JOptionPane.showMessageDialog(null, Menu.set3List() + "You have reached your max quantity of orders for the current set");
            
            return "";
            
        }
        
        selection = (String) JOptionPane.showInputDialog(null, Menu.set3List() + "Choose your soft drink of choice.", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, softDrinks, softDrinks[0]);
        
        if (selection == "Pepsi") {
        
            _set3_softDrinks[counter] = "Pepsi";

        }
        
        else if (selection == "Sprite") {
        
            _set3_softDrinks[counter] = "Sprite";

        }
        
        else if (selection == "Ice lemon tea") {
        
            _set3_softDrinks[counter] = "Ice lemon tea";

        }
        
        else if (selection == "Fanta") {
        
            _set3_softDrinks[counter] = "Fanta";

        }
        
        else if(selection == null) {
            
            return "";
            
        }
        
        selection = (String) JOptionPane.showInputDialog(null, Menu.set3List() + "Choose your warm beverage of choice.", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, warmBeverages, warmBeverages[0]);
        
        if (selection == "Coffee") {
        
            _set3_warmBeverages[counter] = "Coffee";

        }
        
        else if (selection == "Tea") {
        
            _set3_warmBeverages[counter] = "Tea";

        }
        
        else if(selection == null) {
            
            return "";
            
        }
        
        selection = (String) JOptionPane.showInputDialog(null, Menu.set3List() + "Choose your starter of choice.", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, starter, starter[0]);
        
        if (selection == "Salad") {
        
            _set3_starter[counter] = "Salad";

        }
        
        else if (selection == "Soup") {
        
            _set3_starter[counter] = "Soup";

        }
        
        else if(selection == null) {
            
            return "";
            
        }
        
        selection = (String) JOptionPane.showInputDialog(null, Menu.set3List() + "Choose your main course of choice.", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, mainCourse, mainCourse[0]);
        
        if (selection == "Chicken rice") {
        
            _set3_mainCourse[counter] = "Chicken rice";

        }
        
        else if (selection == "Curry noodle") {
        
            _set3_mainCourse[counter] = "Curry noodle";

        }
        
        else if (selection == "Nasi lemak") {
        
            _set3_mainCourse[counter] = "Nasi lemak";

        }
        
        else if (selection == "Asam laksa") {
        
            _set3_mainCourse[counter] = "Asam laksa";

        }
        
        else if(selection == null) {
            
            return "";
            
        }
        
        selection = (String) JOptionPane.showInputDialog(null, Menu.set3List() + "Choose your dessert of choice.", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, dessert, dessert[0]);
        
        if (selection == "Ice cream") {
        
            _set3_desserts[counter] = "Ice cream";

        }
        
        else if (selection == "Cendol") {
        
            _set3_desserts[counter] = "Cendol";

        }
        
        else if (selection == "Pudding") {
        
            _set3_desserts[counter] = "Pudding";

        }
        
        else if(selection == null) {
            
            return "";
            
        }
        
        _set3_quantity[counter] += 1;
        _totalPrice += 15.00;
        
        return "proceed";
        
    }
    
    private void set1_reOrder() {
        
        int orderCount = 1;
        
        String[] plusMinus0 = {"Add", "Remove", "Modify"};
        String[] plusMinus1 = {"Add", "Remove", "Modify", "Next"};
        String[] plusMinus2 = {"Add", "Remove", "Modify", "Back"};
        String[] plusMinus3 = {"Add", "Remove", "Modify", "Next" ,"Back"};
        
        String[] modify = {"Soft drinks", "Starter", "Main course"};
        
        String[] softDrinks = {"Pepsi", "Sprite", "Ice lemon tea", "Fanta"};
        String[] starter = {"Salad", "Soup"};
        String[] mainCourse = {"Chicken rice", "Curry noodle", "Nasi lemak", "Asam laksa"};
        
        for(int i = 0 ; i < 99; /**/) {
            
            selection = "";
            
            if (_set1_quantity[i] == 100) {
                
                i++;
                
            }
            
            if (i == 0) {
                
                int count  = i + 1;
                
                while(true) {
                
                    if(count == 98) {
                        
                        selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set1", i, orderCount) + "Would you like to add current set order, remove current set, or modify the current set?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus0, plusMinus0[0]);
                        break;
                        
                    }
                    
                    else if (_set1_quantity[count] != 0 && _set1_quantity[count] != 100) {

                        selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set1", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, or view next set order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus1, plusMinus1[0]);
                        break;

                    }

                    count++;

                }
                
            }
            
            else if (i == 98) {
                
                int count  = 1;
                
                while(true) {
                
                    if(count == (98 - i)) {
                        
                        selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set1", i, orderCount) + "Would you like to add current set order, remove current set, or modify the current set?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus0, plusMinus0[0]);
                        break;
                        
                    }
                    
                    else if (_set1_quantity[i - count] != 0 && _set1_quantity[i - count] != 100) {

                        selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set1", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, or view previous set order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus2, plusMinus2[0]);
                        break;

                    }

                    count++;

                }
                
            }
            
            else if (i != 0 && i != 98) {
                
                boolean readyUp = false, readyDown = false;
                int fixedUp = 0, fixedDown = 0, countUp = (i + 1), countDown = 1;
                
                while(true) {
                
                    if(readyUp == false && countUp == (98 - i)) {
                        
                        fixedUp = 0;
                        readyUp = true;
                        
                    }
                    
                    else if (readyUp == false && _set1_quantity[countUp] != 0 && _set1_quantity[countUp] != 100) {

                       fixedUp = countUp;
                       readyUp = true;

                   }
                    
                    if(readyDown == false && countDown == (98 - i)) {
                        
                        fixedDown = 0;
                        readyDown = true;
                        
                    }
                    
                    else if (readyDown == false && _set1_quantity[i - countDown] != 0 && _set1_quantity[i - countDown] != 100) {

                        fixedDown = countDown;
                        readyDown = true;

                    }
                    
                    if (readyUp == true && readyDown == true && fixedUp == 0 && fixedDown == 0) {

                        if(fixedUp == 0 && fixedDown == 0) {
                        
                            selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set1", i, orderCount) + "Would you like to add current set order, remove current set, or modify the current set?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus0, plusMinus0[0]);
                            break;

                        }
                        
                        else if (fixedUp != 0 && fixedDown == 0) {
                            
                            selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set1", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, or view next set order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus1, plusMinus1[0]);
                            break;
                            
                        }
                        
                        else if (fixedUp == 0 && fixedDown != 0) {
                            
                            selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set1", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, or view previous ser order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus2, plusMinus2[0]);
                            break;
                            
                        }
                        
                        else if (fixedUp != 0 && fixedDown != 0) {
                            
                            selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set1", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, view next set order, or view previous set order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus3, plusMinus3[0]);
                            break;
                            
                        }

                    }

                    countUp++;
                    countDown++;

                }
                
            }
            
            if (selection == "Add") {

                set1_order();
                break;

            }
            
            else if (selection == "Next") {
                
                orderCount++;
                i++;
                
            }
            
            else if (selection == "Back") {
                
                while(true) {

                    if(i == 0) {
                        
                        orderCount--;
                        i--;
                        break;
                        
                    }
                    
                    else if((i - 1) != 0 && (i - 1) != 100) {
                        
                        orderCount--;
                        i -= 2;
                        break;
                        
                    }
                    
                    i --;
                    
                }

            }

            else if (selection == "Remove") {

                set_reset("set 1", i);

                return;

            }

            else if (selection == "Modify") {

                selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set1", i, orderCount) + "Which item category would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, modify, modify[0]);
                    
                if (selection == "Soft drinks") {

                    selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set1", i, orderCount) + "Which item would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, softDrinks, softDrinks[0]);

                    if (selection == "Pepsi") {

                        _set1_softDrinks[i] = "Pepsi";

                    }

                    else if (selection == "Sprite") {

                        _set1_softDrinks[i] = "Sprite";

                    }

                    else if (selection == "Ice lemon tea") {

                        _set1_softDrinks[i] = "Ice lemon tea";

                    }

                    else if (selection == "Fanta") {

                        _set1_softDrinks[i] = "Fanta";

                    }
                    
                    else if (selection == null) {
                        
                        return;
                        
                    }

                }

                else if (selection == "starter") {

                    selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set1", i, orderCount) + "Which item would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, starter, starter[0]);

                    if (selection == "Salad") {

                        _set1_starter[i] = "Salad";

                    }

                    else if (selection == "Soup") {

                        _set1_starter[i] = "Soup";

                    }
                    
                    else if (selection == null) {
                        
                        return;
                        
                    }

                }

                else if (selection == "Main course") {

                    selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set1", i, orderCount) + "Which item  would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, mainCourse, mainCourse[0]);

                    if (selection == "Chicken rice") {

                        _set1_mainCourse[i] = "Chicken rice";

                    }

                    else if (selection == "Curry noodle") {

                        _set1_mainCourse[i] = "Curry noodle";

                    }

                    else if (selection == "Nasi lemak") {

                        _set1_mainCourse[i] = "Nasi lemak";

                    }

                    else if (selection == "Asam laksa") {

                        _set1_mainCourse[i] = "Asam laksa";

                    }
                    
                    else if (selection == null) {
                        
                        return;
                        
                    }

                }
                
                else if (selection == null) {
                    
                    return;
                    
                }

                return;

            }
            
            else if (selection == null) {
                    
                return;

            }

        }
        
    }
    
    private void set2_reOrder() {
        
        int orderCount = 1;
        
        String[] plusMinus0 = {"Add", "Remove", "Modify"};
        String[] plusMinus1 = {"Add", "Remove", "Modify", "Next"};
        String[] plusMinus2 = {"Add", "Remove", "Modify", "Back"};
        String[] plusMinus3 = {"Add", "Remove", "Modify", "Next" ,"Back"};
        
        String[] modify = {"Warm beverages" , "Main course", "Dessert"};
        
        String[] warmBeverages = {"Coffee", "Tea"};
        String[] mainCourse = {"Chicken rice", "Curry noodle", "Nasi lemak", "Asam laksa"};
        String[] dessert = {"Ice cream", "Cendol", "Pudding"};;
        
        for( int i = 0 ; i < 99; /**/) {
            
            selection = "";
            
            if (_set2_quantity[i] == 100) {
                
                i++;
                
            }
            
            if (i == 98) {
                
                int count  = 1;
                
                while(true) {
                
                    if(count == (98 - i)) {
                        
                        selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set2", i, orderCount) + "Would you like to add current set order, remove current set, or modify the current set?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus0, plusMinus0[0]);
                        break;
                        
                    }
                    
                    else if (_set2_quantity[i - count] != 0 && _set2_quantity[i - count] != 100) {

                        selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set2", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, or view previous set order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus2, plusMinus2[0]);
                        break;

                    }

                    count++;

                }
                
            }
            
            else if (i != 0 && i != 98) {
                
                boolean readyUp = false, readyDown = false;
                int fixedUp = 0, fixedDown = 0, countUp = (i + 1), countDown = 1;
                
                while(true) {
                
                    if(countUp == (98 - i)) {
                        
                        fixedUp = 0;
                        readyUp = true;
                        break;
                        
                    }
                    
                    if(countDown == (98 - i)) {
                        
                        fixedDown = 0;
                        readyDown = true;
                        break;
                        
                    }
                    
                    if (readyDown == false && _set2_quantity[i - countDown] != 0 && _set2_quantity[i - countDown] != 100) {

                        fixedDown = countDown;
                        readyDown = true;
                        break;

                    }
                    
                    if (readyUp == false && _set2_quantity[countUp] != 0 && _set2_quantity[countUp] != 100) {

                        fixedUp = countUp;
                        readyUp = true;
                        break;

                    }
                    
                    if (readyUp == true && readyDown == true) {

                        if(fixedUp == 0 && fixedDown == 0) {
                        
                            selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set2", i, orderCount) + "Would you like to add current set order, remove current set, or modify the current set?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus0, plusMinus0[0]);
                            break;

                        }
                        
                        else if (fixedUp != 0 && fixedDown == 0) {
                            
                            selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set2", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, or view next set order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus1, plusMinus1[0]);
                            break;
                            
                        }
                        
                        else if (fixedUp == 0 && fixedDown != 0) {
                            
                            selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set2", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, or view previous ser order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus2, plusMinus2[0]);
                            break;
                            
                        }
                        
                        else if (fixedUp != 0 && fixedDown != 0) {
                            
                            selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set2", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, view next set order, or view previous set order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus3, plusMinus3[0]);
                            break;
                            
                        }
                        
                        break;

                    }

                    countUp++;
                    countDown++;

                }
                
            }
            
            else if (i == 0) {
                
                int count  = i + 1;
                
                while(true) {
                
                    if(count == 98) {
                        
                        selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set2", i, orderCount) + "Would you like to add current set order, remove current set, or modify the current set?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus0, plusMinus0[0]);
                        break;
                        
                    }
                    
                    else if (_set2_quantity[count] != 0 && _set2_quantity[count] != 100) {

                        selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set2", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, or view next set order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus1, plusMinus1[0]);
                        break;

                    }

                    count++;

                }
                
            }
            
            if (selection == "Add") {

                set2_order();
                break;

            }
            
            else if (selection == "Next") {
                
                orderCount++;
                i++;
                
            }
            
            else if (selection == "Back") {
                
                while(true) {

                    if(i == 0) {
                        
                        orderCount--;
                        i--;
                        break;
                        
                    }
                    
                    else if((i - 1) != 0 && (i - 1) != 100) {
                        
                        orderCount--;
                        i -= 2;
                        break;
                        
                    }
                    
                    i --;
                    
                }

            }

            else if (selection == "Remove") {

                set_reset("set 2", i);

                return;

            }

            else if (selection == "Modify") {
                
                selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set2", i, orderCount) + "Which item category would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, modify, modify[0]);

                if (selection == "Warm beverages") {

                    selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set2", i, orderCount) + "Which item would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, warmBeverages, warmBeverages[0]);

                    if (selection == "Coffee") {

                        _set2_warmBeverages[i] = "Coffee";

                    }

                    else if (selection == "Tea") {

                        _set2_warmBeverages[i] = "Tea";

                    }
                    
                    else if (selection == null) {
                        
                        return;
                        
                    }

                }

                else if (selection == "Main course") {

                    selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set2", i, orderCount) + "Which item  would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, mainCourse, mainCourse[0]);

                    if (selection == "Chicken rice") {

                        _set2_mainCourse[i] = "Chicken rice";

                    }

                    else if (selection == "Curry noodle") {

                        _set2_mainCourse[i] = "Curry noodle";

                    }

                    else if (selection == "Nasi lemak") {

                        _set2_mainCourse[i] = "Nasi lemak";

                    }

                    else if (selection == "Asam laksa") {

                        _set2_mainCourse[i] = "Asam laksa";

                    }
                    
                    else if (selection == null) {
                        
                        return;
                        
                    }

                }
                
                else if (selection == "Dessert") {

                    selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set2", i, orderCount) + "Which item would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, dessert, dessert[0]);

                    if (selection == "Ice cream") {

                        _set2_desserts[i] = "Ice cream";

                    }

                    else if (selection == "Cendol") {

                        _set2_desserts[i] = "Cendol";

                    }
                    
                    else if (selection == "Pudding") {

                        _set2_desserts[i] = "Pudding";

                    }
                    
                    else if (selection == null) {
                        
                        return;
                        
                    }
                    
                }
                
                return;

            }
            
            else if (selection == null) {
                    
                    return;
                    
                }
        
        }
        
    }
    
    private void set3_reOrder() {
        
        int orderCount = 1;
        
        String[] plusMinus0 = {"Add", "Remove", "Modify"};
        String[] plusMinus1 = {"Add", "Remove", "Modify", "Next"};
        String[] plusMinus2 = {"Add", "Remove", "Modify", "Back"};
        String[] plusMinus3 = {"Add", "Remove", "Modify", "Next" ,"Back"};
        
        String[] modify = {"Soft drinks", "Warm beverages", "Starter", "Main course", "Dessert"};
        
        String[] softDrinks = {"Pepsi", "Sprite", "Ice lemon tea", "Fanta"};
        String[] starter = {"Salad", "Soup"};
        String[] warmBeverages = {"Coffee", "Tea"};
        String[] mainCourse = {"Chicken rice", "Curry noodle", "Nasi lemak", "Asam laksa"};
        String[] dessert = {"Ice cream", "Cendol", "Pudding"};
        
        for( int i = 0 ; i < 99; /**/) {
            
            selection = "";
            
            if (_set3_quantity[i] == 100) {
                
                i++;
                
            }
            
            if (i == 98) {
                
                int count  = 1;
                
                while(true) {
                
                    if(count == (98 - i)) {
                        
                        selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Would you like to add current set order, remove current set, or modify the current set?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus0, plusMinus0[0]);
                        break;
                        
                    }
                    
                    else if (_set3_quantity[i - count] != 0 && _set3_quantity[i - count] != 100) {

                        selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, or view previous set order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus2, plusMinus2[0]);
                        break;

                    }

                    count++;

                }
                
            }
            
            else if (i != 0 && i != 98) {
                
                boolean readyUp = false, readyDown = false;
                int fixedUp = 0, fixedDown = 0, countUp = (i + 1), countDown = 1;
                
                while(true) {
                
                    if(countUp == (98 - i)) {
                        
                        fixedUp = 0;
                        readyUp = true;
                        break;
                        
                    }
                    
                    if(countDown == (98 - i)) {
                        
                        fixedDown = 0;
                        readyDown = true;
                        break;
                        
                    }
                    
                    if (readyDown == false && _set3_quantity[i - countDown] != 0 && _set3_quantity[i - countDown] != 100) {

                        fixedDown = countDown;
                        readyDown = true;
                        break;

                    }
                    
                    if (readyUp == false && _set3_quantity[countUp] != 0 && _set3_quantity[countUp] != 100) {

                        fixedUp = countUp;
                        readyUp = true;
                        break;

                    }
                    
                    if (readyUp == true && readyDown == true) {

                        if(fixedUp == 0 && fixedDown == 0) {
                        
                            selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Would you like to add current set order, remove current set, or modify the current set?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus0, plusMinus0[0]);
                            break;

                        }
                        
                        else if (fixedUp != 0 && fixedDown == 0) {
                            
                            selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, or view next set order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus1, plusMinus1[0]);
                            break;
                            
                        }
                        
                        else if (fixedUp == 0 && fixedDown != 0) {
                            
                            selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, or view previous ser order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus2, plusMinus2[0]);
                            break;
                            
                        }
                        
                        else if (fixedUp != 0 && fixedDown != 0) {
                            
                            selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, view next set order, or view previous set order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus3, plusMinus3[0]);
                            break;
                            
                        }
                        
                        break;

                    }

                    countUp++;
                    countDown++;

                }
                
            }
            
            else if (i == 0) {
                
                int count  = i + 1;
                
                while(true) {
                
                    if(count == 98) {
                        
                        selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Would you like to add current set order, remove current set, or modify the current set?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus0, plusMinus0[0]);
                        break;
                        
                    }
                    
                    else if (_set3_quantity[count] != 0 && _set3_quantity[count] != 100) {

                        selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Would you like to add current set order, remove current set, modify the current set, or view next set order?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, plusMinus1, plusMinus1[0]);
                        break;

                    }

                    count++;

                }
                
            }
            
            if (selection == "Add") {

                set3_order();
                break;

            }
            
            else if (selection == "Next") {
                
                orderCount++;
                i++;
                
            }
            
            else if (selection == "Back") {
                
                while(true) {

                    if(i == 0) {
                        
                        orderCount--;
                        i--;
                        break;
                        
                    }
                    
                    else if((i - 1) != 0 && (i - 1) != 100) {
                        
                        orderCount--;
                        i -= 2;
                        break;
                        
                    }
                    
                    i --;
                    
                }

            }

            else if (selection == "Remove") {

                set_reset("set 3", i);

                return;

            }

            else if (selection == "Modify") {
                
                selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Which item category would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, modify, modify[0]);

                if (selection == "Soft drinks") {

                    selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Which item would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, softDrinks, softDrinks[0]);

                    if (selection == "Pepsi") {

                        _set3_softDrinks[i] = "Pepsi";

                    }

                    else if (selection == "Sprite") {

                        _set3_softDrinks[i] = "Sprite";

                    }

                    else if (selection == "Ice lemon tea") {

                        _set3_softDrinks[i] = "Ice lemon tea";

                    }

                    else if (selection == "Fanta") {

                        _set3_softDrinks[i] = "Fanta";

                    }
                    
                    else if (selection == null) {
                        
                        return;
                        
                    }

                }
                
                else if (selection == "Warm beverages") {

                    selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Which item would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, warmBeverages, warmBeverages[0]);

                    if (selection == "Coffee") {

                        _set3_warmBeverages[i] = "Coffee";

                    }

                    else if (selection == "Tea") {

                        _set3_warmBeverages[i] = "Tea";

                    }
                    
                    else if (selection == null) {
                        
                        return;
                        
                    }

                }

                else if (selection == "Starter") {

                    selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Which item would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, starter, starter[0]);

                    if (selection == "Salad") {

                        _set3_starter[i] = "Salad";

                    }

                    else if (selection == "Soup") {

                        _set3_starter[i] = "Soup";

                    }
                    
                    else if (selection == null) {
                        
                        return;
                        
                    }

                }

                else if (selection == "Main course") {

                    selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Which item  would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, mainCourse, mainCourse[0]);

                    if (selection == "Chicken rice") {

                        _set3_mainCourse[i] = "Chicken rice";

                    }

                    else if (selection == "Curry noodle") {

                        _set3_mainCourse[i] = "Curry noodle";

                    }

                    else if (selection == "Nasi lemak") {

                        _set3_mainCourse[i] = "Nasi lemak";

                    }

                    else if (selection == "Asam laksa") {

                        _set3_mainCourse[i] = "Asam laksa";

                    }
                    
                    else if (selection == null) {
                        
                        return;
                        
                    }

                }
                
                else if (selection == "Dessert") {

                    selection = (String) JOptionPane.showInputDialog(null, getCurrentSetOrder("set3", i, orderCount) + "Which item would you like to modify?", "Point of sale system", JOptionPane.QUESTION_MESSAGE, null, dessert, dessert[0]);

                    if (selection == "Ice cream") {

                        _set3_desserts[i] = "Ice cream";

                    }

                    else if (selection == "Cendol") {

                        _set3_desserts[i] = "Cendol";

                    }
                    
                    else if (selection == "Pudding") {

                        _set3_desserts[i] = "Pudding";

                    }
                    
                    else if (selection == null) {
                        
                        return;
                        
                    }

                }
                
                else if (selection == null) {
                    
                    return;
                    
                }
                
                return;

            }
            
            else if (selection == null) {
                    
                return;

            }

        }
        
    }
    
    public String orderAgain() {
        
        UIManager.put("OptionPane.yesButtonText","Yes, a la carte");
        UIManager.put("OptionPane.noButtonText", "Yes, set");
        UIManager.put("OptionPane.cancelButtonText", "No");
        
        if (_set_ordered == false && _alacarte_ordered == false) {
            
            choices = JOptionPane.showConfirmDialog(null, "No orders placed.\nWould you like to order again?", "Point of sale system", JOptionPane.YES_NO_CANCEL_OPTION);

            
        }
        
        else {

            choices = JOptionPane.showConfirmDialog(null, getCurrentOrder() + "Would you like to order again?", "Point of sale system", JOptionPane.YES_NO_CANCEL_OPTION);

        }
                
        if (choices == 0) {

            return "alacarte";

        }

        else if (choices == 1) {

            return "set";

        }

        else if (choices == 2) {

            return "no";
            
        }
        
        else if (choices == JOptionPane.CLOSED_OPTION) {
            
            System.exit(0);
            
        }
        
        JOptionPane.showMessageDialog(null, "An error has occured.");
        
        return "";
    }
    
    public boolean getSetOrdered() {

        return _set_ordered;

    }
    
    public int getOrderNum() {

        return _orderNum;

    }
    
    public double getTotalPrice() {

        return _totalPrice;

    }
    
    public void setOrderNum(int orderNum) {
        
        _orderNum = orderNum;
        
    }
    
    public void setInvoice() {
        
        invoice = "       <  ^ Invoice " + _orderNum + " ^  > \n---------------------------------------\n";
        
        for(int i = 0; i < 4; i++) {
            
            if(_softDrinks_quantity[i] != 0) {
            
                invoice += "\n" + _softDrinks_quantity[i] + " x ";
                
                if(_softDrinks[i] == "Coca cola") {
                
                    invoice += _softDrinks[i] + "   RM" + (_softDrinks_quantity[i] * 2.0) + "0" + "\n";
                
                }
                
                else if(_softDrinks[i] == "Sprite") {
                
                    invoice += _softDrinks[i] + "   RM" + (_softDrinks_quantity[i] * 2.0) + "0" + "\n";
                
                }
                
                else if(_softDrinks[i] == "Ice lemon tea") {
                
                    invoice += _softDrinks[i] + "   RM" + (_softDrinks_quantity[i] * 2.0) + "0" + "\n";
                
                }
                
                else if(_softDrinks[i] == "Fanta") {
                
                    invoice += _softDrinks[i] + "   RM" + (_softDrinks_quantity[i] * 2.0) + "0" + "\n";
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 2; i++) {
            
            if(_warmBeverages_quantity[i] != 0) {
            
                invoice += "\n" +  _warmBeverages_quantity[i] + "x ";
                
                if(_warmBeverages[i] == "Coffee") {
                
                    invoice += _warmBeverages[i] + "   RM" + (_warmBeverages_quantity[i] * 1.8) + "0" + "\n";
                
                }
                
                else if(_warmBeverages[i] == "Tea") {
                
                    invoice += _warmBeverages[i] + "   RM" + (_warmBeverages_quantity[i] * 1.8) + "0" + "\n";
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 2; i++) {
            
            if(_starter_quantity[i] != 0) {
            
                invoice += "\n" + _starter_quantity[i] + "x ";
                
                if(_starter[i] == "Salad") {
                
                    invoice += _starter[i] + "   RM" + (_starter_quantity[i] * 4.0) + "0" + "\n";
                
                }
                
                else if(_starter[i] == "Soup") {
                
                    invoice += _starter[i] + "   RM" + (_starter_quantity[i] * 4.0) + "0" + "\n";
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 4; i++) {
            
            if(_mainCourse_quantity[i] != 0) {
            
                invoice += "\n" + _mainCourse_quantity[i] + "x ";
                
                if(_mainCourse[i] == "Chicken rice") {
                
                    invoice += _mainCourse[i] + "   RM" + (_mainCourse_quantity[i] * 8.0) + "0" + "\n";
                
                }
                
                else if(_mainCourse[i] == "Curry noodle") {
                
                    invoice += _mainCourse[i] + "   RM" + (_mainCourse_quantity[i] * 8.0) + "0" + "\n";
                
                }
                
                else if(_mainCourse[i] == "Nasi lemak") {
                
                    invoice += _mainCourse[i] + "   RM" + (_mainCourse_quantity[i] * 8.0) + "0" + "\n";
                
                }
                
                else if(_mainCourse[i] == "Asam laksa") {
                
                    invoice += _mainCourse[i] + "   RM" + (_mainCourse_quantity[i] * 8.0) + "0" + "\n";
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 3; i++) {
            
            if(_desserts_quantity[i] != 0) {
            
                invoice += "\n" + _desserts_quantity[i] + "x ";
                
                if(_desserts[i] == "Ice Cream") {
                
                    invoice += _desserts[i] + "   RM " + (_desserts_quantity[i] * 3.5) + "0" +  "\n";
                
                }
                
                else if(_desserts[i] == "Cendol") {
                
                    invoice += _desserts[i] + "   RM " + (_desserts_quantity[i] * 3.5) + "0" + "\n";
                
                }
                
                else if(_desserts[i] == "Pudding") {
                
                    invoice += _desserts[i] + "   RM " + (_desserts_quantity[i] * 3.5) + "0" + "\n";
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 99; i++) {
            
            if(_set1_quantity[i] != 0 && _set1_quantity[i] != 100) {
                
                invoice += "\n" + _set1_quantity[i] + "x Set 1" + "                         RM" + (_set1_quantity[i] * 11.0) + "0" + "\n      *" + _set1_softDrinks[i] + "\n      *" + _set1_starter[i] + "\n      *" + _set1_mainCourse[i]  + "\n";
                
            }
            
        }
        
        for(int i = 0; i < 99; i++) {
            
            if(_set2_quantity[i] != 0 && _set2_quantity[i] != 100) {
                
                invoice += "\n" + _set2_quantity[i] + "x Set 2" + "                         RM" + (_set2_quantity[i] * 11.5) + "0" + "\n      *" + _set2_warmBeverages[i] + "\n      *" + _set2_mainCourse[i] + "\n      *" + _set2_desserts[i]  + "\n";
                
            }
            
        }
        
        for(int i = 0; i < 99; i++) {
            
            if(_set3_quantity[i] != 0 && _set3_quantity[i] != 100) {
                
                invoice += "\n" + _set3_quantity[i] + "x Set 3" + "                         RM" + (_set3_quantity[i] * 15.0) + "0" + "\n      *" + _set3_softDrinks[i] + _set3_warmBeverages[i] + "\n      *" + _set3_starter[i] + "\n      *" + _set3_mainCourse[i] + "\n      *" + _set3_desserts[i] + "\n";
                
            }
            
        }

        invoice += "\n---------------------------------------\n                Grand total: RM" + _totalPrice + "0";
        
        /*
        try {

            writeData();
            
            System.out.println("Data written to file");
            
        } catch (Exception errorLog) {

                System.out.println("File can't be created!\n" + errorLog);
            
        }
        */
    }
    
    private String getCurrentOrder() {
        
        String orderList = "Current order:\n---------------------------------------\n";
        
        for(int i = 0; i < 4; i++) {
            
            if(_softDrinks_quantity[i] != 0) {
            
                orderList += "\n" + _softDrinks_quantity[i] + " x ";
                
                if(_softDrinks[i] == "Coca cola") {
                
                    orderList += _softDrinks[i] + "\n";
                
                }
                
                else if(_softDrinks[i] == "Sprite") {
                
                    orderList += _softDrinks[i] + "\n";
                
                }
                
                else if(_softDrinks[i] == "Ice lemon tea") {
                
                    orderList += _softDrinks[i] + "\n";
                
                }
                
                else if(_softDrinks[i] == "Fanta") {
                
                    orderList += _softDrinks[i] + "\n";
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 2; i++) {
            
            if(_warmBeverages_quantity[i] != 0) {
            
                orderList += "\n" +  _warmBeverages_quantity[i] + "x ";
                
                if(_warmBeverages[i] == "Coffee") {
                
                    orderList += _warmBeverages[i] + "\n";
                
                }
                
                else if(_warmBeverages[i] == "Tea") {
                
                    orderList += _warmBeverages[i] + "\n";
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 2; i++) {
            
            if(_starter_quantity[i] != 0) {
            
                orderList += "\n" + _starter_quantity[i] + "x ";
                
                if(_starter[i] == "Salad") {
                
                    orderList += _starter[i] + "\n";
                
                }
                
                else if(_starter[i] == "Soup") {
                
                    orderList += _starter[i] + "\n";
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 4; i++) {
            
            if(_mainCourse_quantity[i] != 0) {
            
                orderList += "\n" + _mainCourse_quantity[i] + "x ";
                
                if(_mainCourse[i] == "Chicken rice") {
                
                    orderList += _mainCourse[i] + "\n";
                
                }
                
                else if(_mainCourse[i] == "Curry noodle") {
                
                    orderList += _mainCourse[i] + "\n";
                
                }
                
                else if(_mainCourse[i] == "Nasi lemak") {
                
                    orderList += _mainCourse[i] + "\n";
                
                }
                
                else if(_mainCourse[i] == "Asam laksa") {
                
                    orderList += _mainCourse[i] + "\n";
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 3; i++) {
            
            if(_desserts_quantity[i] != 0) {
            
                orderList += "\n" + _desserts_quantity[i] + "x ";
                
                if(_desserts[i] == "Ice Cream") {
                
                    orderList += _desserts[i] + "\n";
                
                }
                
                else if(_desserts[i] == "Cendol") {
                
                    orderList += _desserts[i] + "\n";
                
                }
                
                else if(_desserts[i] == "Pudding") {
                
                    orderList += _desserts[i] + "\n";
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 99; i++) {
            
            if(_set1_quantity[i] != 0 && _set1_quantity[i] != 100) {
                
                orderList += "\n" + _set1_quantity[i] + " x Set 1\n      *" + _set1_softDrinks[i] + "\n      *" + _set1_starter[i] + "\n      *" + _set1_mainCourse[i]  + "\n";
                
            }
            
        }
        
        for(int i = 0; i < 99; i++) {
            
            if(_set2_quantity[i] != 0 && _set2_quantity[i] != 100) {
                
                orderList += "\n" + _set2_quantity[i] + " x Set 2\n      *" + _set2_warmBeverages[i] + "\n      *" + _set2_mainCourse[i] + "\n      *" + _set2_desserts[i]  + "\n";
                
            }
            
        }
        
        for(int i = 0; i < 99; i++) {
            
            if(_set3_quantity[i] != 0 && _set3_quantity[i] != 100) {
                
                orderList += "\n" + _set3_quantity[i] + " x Set 3\n      *" + _set3_softDrinks[i] + _set3_warmBeverages[i] + "\n      *" + _set3_starter[i] + "\n      *" + _set3_mainCourse[i] + "\n      *" + _set3_desserts[i] + "\n";
                
            }
            
        }
        
        orderList += "\n---------------------------------------\n\n";
        
        return orderList;
        
    }
    
    private String getCurrentSetOrder(String setSelect, int order, int orderCount) {
        
        String orderList = "";
        
        if (setSelect == "set1") {
            
            orderList += "Set 1 order " + orderCount + " :\n" + _set1_quantity[order] + " x Set 1\n      *" + _set1_softDrinks[order] + "\n      *" + _set1_starter[order] + "\n      *" + _set1_mainCourse[order]  + "\n";
            
        }
        
        else if (setSelect == "set2") {
            
            orderList += "Set 2 order " + orderCount + " :\n" + _set2_quantity[order] + " x Set 2\n      *" + _set2_warmBeverages[order] + "\n      *" + _set2_mainCourse[order] + "\n      *" + _set2_desserts[order]  + "\n";
            
        }
        
        else if (setSelect == "set3") {
            
            orderList += "Set 3 order " + orderCount + " :\n" + _set3_quantity[order] + " x Set 3\n      *" + _set3_softDrinks[order] + _set3_warmBeverages[order] + "\n      *" + _set3_starter[order] + "\n      *" + _set3_mainCourse[order] + "\n      *" + _set3_desserts[order] + "\n";
            
        }
        
        return orderList;
        
    }
    
    public String displayInvoice() {
        
        return invoice;
        
    }
    
    public String viewInvoice() {
        
        UIManager.put("OptionPane.yesButtonText","Add order(s)");
        UIManager.put("OptionPane.noButtonText", "Issue receipt");
        UIManager.put("OptionPane.cancelButtonText", "Return to main menu");
        
        choices = JOptionPane.showConfirmDialog(null, invoice, "Point of sale system", JOptionPane.YES_NO_CANCEL_OPTION);
        
        if(choices == 0){
            
            UIManager.put("OptionPane.yesButtonText","A la carte");
            UIManager.put("OptionPane.noButtonText", "Set");
            UIManager.put("OptionPane.cancelButtonText", "Cancel");
            
            choices = JOptionPane.showConfirmDialog(null, getCurrentOrder() + "What type of order(s) would you like to add?", "Point of sale system", JOptionPane.YES_NO_CANCEL_OPTION);
            
            if (choices == 0){
    
                alacarte("add");
                setInvoice();
                return "yes";
    
            }

            else if (choices == 1) {

                setNav("add", 0);
                setInvoice();
                return "yes";

            }
            
            else if (choices == JOptionPane.CLOSED_OPTION) {

                System.exit(0);

            }
            
            else {
                
                return "yes";
                
            }
            
        }
        
        else if (choices == 1) {
            
            try {

                writeReceiptV2();
                resetAll();
                
                JOptionPane.showMessageDialog(null, "Receipt issued.");

            } catch (Exception errorLog) {

                JOptionPane.showMessageDialog(null, "Error! File can't be created!\nReceipt not issued" + errorLog);

            }
            
            //deleteData();
            
            return "no";
            
        }
        
        else if (choices == JOptionPane.CLOSED_OPTION) {
            
            System.exit(0);
            
        }
        
        return "no";

    }
    
    private void writeReceiptV2() throws Exception {
        
        FileWriter fw = new FileWriter("src/receipt/" + _orderNum + ".txt");
        PrintWriter pw = new PrintWriter(fw);
        
        pw.println("Invoice " + _orderNum + ":");
        pw.println(System.lineSeparator());
        pw.println("---------------------------------------");
        pw.println(System.lineSeparator());
        
        for(int i = 0; i < 4; i++) {
            
            if(_softDrinks_quantity[i] != 0) {
                
                if(_softDrinks[i] == "Coca cola") {
                
                    pw.println(_softDrinks_quantity[i] + " x " + _softDrinks[i] + "                RM " + (_softDrinks_quantity[i] * 2.0) + "0");
                    pw.println(System.lineSeparator());
                
                }
                
                else if(_softDrinks[i] == "Sprite") {
                
                    pw.println(_softDrinks_quantity[i] + " x " + _softDrinks[i] + "                   RM " + (_softDrinks_quantity[i] * 2.0) + "0");
                    pw.println(System.lineSeparator());
                
                }
                
                else if(_softDrinks[i] == "Ice lemon tea") {
                
                    pw.println(_softDrinks_quantity[i] + " x " + _softDrinks[i] + "            RM " + (_softDrinks_quantity[i] * 2.0) + "0");
                    pw.println(System.lineSeparator());
                
                }
                
                else if(_softDrinks[i] == "Fanta") {
                
                    pw.println(_softDrinks_quantity[i] + " x " + _softDrinks[i] + "                    RM " + (_softDrinks_quantity[i] * 2.0) + "0");
                    pw.println(System.lineSeparator());
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 2; i++) {
            
            if(_warmBeverages_quantity[i] != 0) {
                
                if(_warmBeverages[i] == "Coffee") {
                
                    pw.println(_warmBeverages_quantity[i] + " x " + _warmBeverages[i] + "                   RM " + (_warmBeverages_quantity[i] * 1.8) + "0");
                    pw.println(System.lineSeparator());
                
                }
                
                else if(_warmBeverages[i] == "Tea") {
                
                    pw.println(_warmBeverages_quantity[i] + " x " + _warmBeverages[i] + "                      RM " + (_warmBeverages_quantity[i] * 1.8) + "0");
                    pw.println(System.lineSeparator());
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 2; i++) {
            
            if(_starter_quantity[i] != 0) {
                
                if(_starter[i] == "Salad") {
                
                    pw.println(_starter_quantity[i] + " x " + _starter[i] + "                    RM " + (_starter_quantity[i] * 4.0) + "0");
                    pw.println(System.lineSeparator());
                
                }
                
                else if(_starter[i] == "Soup") {
                
                    pw.println(_starter_quantity[i] + " x " + _starter[i] + "                     RM " + (_starter_quantity[i] * 4.0) + "0");
                    pw.println(System.lineSeparator());
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 4; i++) {
            
            if(_mainCourse_quantity[i] != 0) {
                
                if(_mainCourse[i] == "Chicken rice") {
                
                    pw.println(_mainCourse_quantity[i] + " x " + _mainCourse[i] + "             RM " + (_mainCourse_quantity[i] * 8.0) + "0");
                    pw.println(System.lineSeparator());
                
                }
                
                else if(_mainCourse[i] == "Curry noodle") {
                
                    pw.println(_mainCourse_quantity[i] + " x " + _mainCourse[i] + "             RM " + (_mainCourse_quantity[i] * 8.0) + "0");
                    pw.println(System.lineSeparator());
                
                }
                
                else if(_mainCourse[i] == "Nasi lemak") {
                
                    pw.println(_mainCourse_quantity[i] + " x " + _mainCourse[i] + "               RM " + (_mainCourse_quantity[i] * 8.0) + "0");
                    pw.println(System.lineSeparator());
                
                }
                
                else if(_mainCourse[i] == "Asam laksa") {
                
                    pw.println(_mainCourse_quantity[i] + " x " + _mainCourse[i] + "               RM " + (_mainCourse_quantity[i] * 8.0) + "0");
                    pw.println(System.lineSeparator());
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 3; i++) {
            
            if(_desserts_quantity[i] != 0) {
                
                if(_desserts[i] == "Ice cream") {
                
                    pw.println(_desserts_quantity[i] + " x " + _desserts[i] + "                RM " + (_desserts_quantity[i] * 3.5) + "0");
                    pw.println(System.lineSeparator());
                
                }
                
                else if(_desserts[i] == "Cendol") {
                
                    pw.println(_desserts_quantity[i] + " x " + _desserts[i] + "                   RM " + (_desserts_quantity[i] * 3.5) + "0");
                    pw.println(System.lineSeparator());
                
                }
                
                else if(_desserts[i] == "Pudding") {
                
                    pw.println(_desserts_quantity[i] + " x " + _desserts[i] + "                  RM " + (_desserts_quantity[i] * 3.5) + "0");
                    pw.println(System.lineSeparator());
                
                }
            
            }
            
        }
        
        for(int i = 0; i < 99; i++) {
            
            if(_set1_quantity[i] != 0 && _set1_quantity[i] != 100) {
                
                pw.println(System.lineSeparator());
                pw.println(_set1_quantity[i] + " x Set 1" + "                    RM " + (_set1_quantity[i] * 11.0) + "0");
                pw.println(System.lineSeparator());
                pw.println("      *(free) " + _set1_softDrinks[i]);
                pw.println(System.lineSeparator());
                pw.println("      * " + _set1_starter[i]);
                pw.println(System.lineSeparator());
                pw.println("      * " + _set1_mainCourse[i]);
                pw.println(System.lineSeparator());
                
            }
            
        }
        
        for(int i = 0; i < 99; i++) {
            
            if(_set2_quantity[i] != 0 && _set2_quantity[i] != 100) {
                
                pw.println(System.lineSeparator());
                pw.println(_set2_quantity[i] + " x Set 2" + "                    RM " + (_set2_quantity[i] * 11.5) + "0");
                pw.println(System.lineSeparator());
                pw.println("      *(free) " + _set2_warmBeverages[i]);
                pw.println(System.lineSeparator());
                pw.println("      * " + _set2_mainCourse[i]);
                pw.println(System.lineSeparator());
                pw.println("      * " + _set2_desserts[i]);
                pw.println(System.lineSeparator());
                
            }
            
        }
        
        for(int i = 0; i < 99; i++) {
            
            if(_set3_quantity[i] != 0 && _set3_quantity[i] != 100) {
                
                pw.println(System.lineSeparator());
                pw.println(_set3_quantity[i] + " x Set 3" + "                    RM " + (_set3_quantity[i] * 15.0) + "0");
                pw.println(System.lineSeparator());
                pw.println("      *(free) " + _set3_softDrinks[i] + ", " + _set3_warmBeverages[i]);
                pw.println(System.lineSeparator());
                pw.println("      * " + _set3_starter[i]);
                pw.println(System.lineSeparator());
                pw.println("      * " + _set3_mainCourse[i]);
                pw.println(System.lineSeparator());
                pw.println("      * " + _set3_desserts[i]);
                pw.println(System.lineSeparator());
                
            }
            
        }

        pw.println(System.lineSeparator());
        pw.println("---------------------------------------");
        pw.println(System.lineSeparator());
        pw.println("       Grand total:          RM " + _totalPrice + "0");
        
        pw.close();
        fw.close();
        
    }
    
    private void set_reset(String direction, int number) {
        
        if (direction == "set 1") {
            
            _set1_softDrinks[number] = "";
            _set1_starter[number] = "";
            _set1_mainCourse[number] = ""; 
            
            _set1_quantity[number] = 100;
            
            _totalPrice -= 11.00;
            
        }
        
        else if (direction == "set 2") {
            
            _set2_warmBeverages[number] = "";
            _set2_mainCourse[number] = "";
            _set2_desserts[number] = "";
            
            _set2_quantity[number] = 100;
            
            _totalPrice -= 11.50;
            
        }
        
        else if (direction == "set 3") {
            
            _set3_softDrinks[number] = "";
            _set3_warmBeverages[number] = "";
            _set3_starter[number] = "";
            _set3_mainCourse[number] = "";
            _set3_desserts[number] = "";
            
            _set3_quantity[number] = 100;
            
            _totalPrice -= 15.00;
            
        }
        
        if((_set1_quantity[number] == 0 && _set1_quantity[number] == 100) && (_set2_quantity[number] == 0 && _set2_quantity[number] == 100) && (_set3_quantity[number] == 0 && _set3_quantity[number] == 100)) {
            
            _set_ordered = false;
            
        }
        
    }
    
    private void resetAll() {
            
        invoice = "";
        _orderNum = 0;
        _totalPrice = 0.0;
        
        _set_ordered = false;
        _alacarte_ordered = false;
        
        for(int i = 0; i < 99; i++) {

            _set1_quantity[i] = 0;
            _set2_quantity[i] = 0;
            _set3_quantity[i] = 0;
        
        }
        
        for(int i = 0; i < 99; i++) {

            _set1_starter[i] = "";
            _set3_starter[i] = "";
            _set3_desserts[i] = "";
            _set2_desserts[i] = "";
            _set1_softDrinks[i] = "";
            _set1_mainCourse[i] = "";
            _set2_mainCourse[i] = "";
            _set3_softDrinks[i] = "";
            _set3_mainCourse[i]  = "";
            _set2_warmBeverages[i] = "";
            _set3_warmBeverages[i] = "";
        
        }

        for(int i = 0; i < 4; i++) {

            _mainCourse[i] = "";
            _softDrinks[i] = "";
            _softDrinks_quantity[i] = 0;
            _mainCourse_quantity[i] = 0;
        
        }
        
        for(int i =0; i < 3; i++) {

            _desserts[i] = "";
            _desserts_quantity[i] = 0;
        
        }

        for(int i = 0; i < 2; i++) {
    
            _starter[i] = "";
            _warmBeverages[i] = "";
            _starter_quantity[i] = 0;
            _warmBeverages_quantity[i] = 0;
        
        }
        
    }
    /*    
    private void writeData() throws Exception{
        
        try {

            FileWriter fw = new FileWriter("src/data/" + _orderNum + ".hjm");
            PrintWriter pw = new PrintWriter(fw);

            pw.println(_orderNum);
            pw.println(_totalPrice);


            for(int i = 0; i < 99; i++) {

                pw.println(_set1_quantity[i]);
                pw.println(_set2_quantity[i]);
                pw.println(_set3_quantity[i]);

            }

            for(int i = 0; i < 4; i++) {

                pw.println(_mainCourse[i]);
                pw.println(_softDrinks[i]);
                pw.println(_set1_softDrinks[i]);
                pw.println(_set1_mainCourse[i]);
                pw.println(_set2_mainCourse[i]);
                pw.println(_set3_softDrinks[i]);
                pw.println(_set3_mainCourse[i]);
                pw.println(_softDrinks_quantity[i]);
                pw.println(_mainCourse_quantity[i]);

            }

            for(int i =0; i < 3; i++) {

                pw.println(_desserts[i]);
                pw.println(_set2_desserts[i]);
                pw.println(_set3_desserts[i]);
                pw.println(_desserts_quantity[i]);

            }

            for(int i = 0; i < 2; i++) {

                pw.println(_starter[i]);
                pw.println(_set1_starter[i]);
                pw.println(_set3_starter[i]);
                pw.println(_warmBeverages[i]);
                pw.println(_starter_quantity[i]);
                pw.println(_set2_warmBeverages[i]);
                pw.println(_set3_warmBeverages[i]);
                pw.print(_warmBeverages_quantity[i]);

            }

            pw.close();
            fw.close();
            
        } catch (Exception errorLog) {
            
            System.out.println("File cannot be created.\n\nError:\n" + errorLog);
            
        }
        
    }
*/    
    
/*
    private void deleteData() {
        
        File invoice = new File("src/data/" + _orderNum + ".hjm");
        
        if (invoice.exists()){
            
            invoice.delete();
            
            System.out.println("Data file succesfully deleted");
            
        }
        
        else {
            
            System.out.println("Data file not found. Unable to delete!");
            
        }
        
    }
*/  
    /*
    private void writeReceipt() throws Exception {
        
        FileWriter fw = new FileWriter("src/receipt/" + _orderNum + ".txt");
        PrintWriter pw = new PrintWriter(fw);
        
        pw.print(invoice);
        
        pw.close();
        fw.close();
        
    }
    */
}
