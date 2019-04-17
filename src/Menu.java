/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HoSiang
 */

public class Menu {
    
    public static String name(){
        
        String name = "";
        
        name += "\n";
        name += "                                                                               = = = = = =      #  #       *   *   *   *   *   *   *   *   *   *       #  #      = = = = = =    \n";
        name += "                                                                       +++++++++          #     #          Lite Lunch Lounge          #     #          +++++++++                \n";
        name += "                                                                               = = = = = =      #  #       *   *   *   *   *   *   *   *   *   *       #  #      = = = = = =    \n";
        name += "________________________________________________________________________________________________________________________\n\n";
        
        return name;
        
    }
    
    public static String greet(){
        
        String greet = name();
        
        greet += "";
        greet += "                                        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
        greet += "      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
        greet += "                             W                     W                     W       EEEEEEEEE       L                    CCCCCC            OOOOOO          M                 M       EEEEEEEEE            \n";
        greet += "                                W               W   W               W         E                          L                 CC                      OO            OO       M M          M M      E      \n";
        greet += "                                   W         W         W         W            EEEEEEE            L                 C                       O                      O     M   M      M   M     EEEEEEE   \n";
        greet += "                                      W   W               W   W               E                          L                 CC                      OO            OO       M      M M      M     E      \n";
        greet += "                                         W                       W                  EEEEEEEEE       LLLLLLL      CCCCCC            OOOOOO          M        M        M     EEEEEEEEE                       \n\n\n";
        greet += "      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        greet += "                                        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
        greet += "                                                                           _______________________________________________________";
        greet += "\n\n\n";
                
        return greet;
    }
    
    public static String menuList(){
        
        String menuListPrint = name();
        
        menuListPrint += "Menu\n\n";
        menuListPrint += "                  Alacarte:\n\n";
        menuListPrint += "                                     Warm Beverages:                  Soft Drinks:                  Starter:                  Dessert:                  Main Course:                                        \n";
        menuListPrint += "                                   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
        menuListPrint += "                                            Coffee                                   Coca cola                     Salad                      Ice Cream               Chicken rice                                        \n";
        menuListPrint += "                                            Tea                                        Sprite                             Soup                      Cendol                      Curry noodle                              \n";
        menuListPrint += "                                                                                            Ice lemon tea                                              Pudding                   Nasi lemak                               \n";
        menuListPrint += "                                                                                            Fanta                                                                                                Asam laksa           \n\n\n";
        menuListPrint += "                  Set:\n\n";
        menuListPrint += "                                     < Set 1 >                                                                  < Set 2 >                                                                  < Set 3 >                      \n";
        menuListPrint += "                             - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
        menuListPrint += "                                     1 Starter  +                                                           1 Dessert  +                                                              1 Starter  +                        \n";
        menuListPrint += "                                  1 Main course  +                                               1 Main Course  +                                                         1 Dessert  +                                    \n";
        menuListPrint += "                                1 Soft Drink (>free<)                                     1 Warm Beverage (>free<)                                            1 Main Course  +                                            \n";
        menuListPrint += "                                                                                                                                                                                            1 Warm Beverage (>free<)  +   \n";
        menuListPrint += "                                                                                                                                                                                                  1 Soft Drink (>free<)   \n";
        menuListPrint += "\n";
        
        return menuListPrint;
        
    }
    
    public static String alacarteList(){
        
        String alacarteListPrint = name();
        
        alacarteListPrint += "Alacarte Menu:\n\n";
        alacarteListPrint += "                        Warm Beverages - RM 1.80            Soft Drinks - RM 2.00            Starter - RM 4.00            Dessert - RM 3.50            Main Course - RM 8.00                                        \n";
        alacarteListPrint += "                      - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
        alacarteListPrint += "                                   Coffee                                                 Coca cola                                 Salad                               Ice Cream                             Chicken rice                          \n";
        alacarteListPrint += "                                   Tea                                                      Sprite                                         Soup                               Cendol                                    Curry noodle                \n";
        alacarteListPrint += "                                                                                                 Ice lemon tea                                                                   Pudding                                 Nasi lemak                 \n";
        alacarteListPrint += "                                                                                                 Fanta                                                                                                                                   Asam laksa  \n";
        alacarteListPrint += "\n";
        
        return alacarteListPrint;
        
    }
    
    public static String setMenuList(){
        
        String setListPrint = name();

        setListPrint += "    Set Menu:\n\n";
        setListPrint += "            < Set 1 >\n";
        setListPrint += "                                                                                                                                                                                                                                                      RM 11.00\n";
        setListPrint += "                          1 Starter       +       1 Main course       +       1 Soft Drink (free)                  \n";
        setListPrint += "                                 Salad                        Chicken rice                   Coca cola             \n";
        setListPrint += "                                 Soup                         Curry noodle                  Sprite                 \n";
        setListPrint += "                                                                    Nasi lemak                     Ice lemon tea   \n";
        setListPrint += "                                                                    Asam laksa                    Fanta       \n\n\n";
        setListPrint += "            < Set 2 >\n";
        setListPrint +=  "                                                                                                                                                                                                                                                     RM 11.50\n";
        setListPrint += "                          1 Dessert       +       1 Main Course       +       1 Warm Beverage (free)   \n";
        setListPrint += "                                  Ice Cream                Chicken rice                    Coffee      \n";
        setListPrint += "                                  Cendol                      Curry noodle                    Tea      \n";
        setListPrint += "                                  Pudding                    Nasi lemak                                \n";
        setListPrint += "                                                                     Asam laksa                    \n\n\n";
        setListPrint += "            < Set 3 >\n";
        setListPrint += "                                                                                                                                                                                                                                                      RM 15.00\n";
        setListPrint += "                          1 Starter       +       1 Dessert       +       1 Main Course       +       1 Warm Beverage (free)       +       1 Soft Drink (free)                                                  \n";
        setListPrint += "                                 Salad                        Ice Cream               Chicken rice                     Coffee                                                Coca cola                          \n";
        setListPrint += "                                 Soup                         Cendol                     Curry noodle                     Tea                                                     Sprite                        \n";
        setListPrint += "                                                                    Pudding                   Nasi lemak                                                                                    Ice lemon tea       \n";
        setListPrint += "                                                                                                      Asam laksa                                                                                   Fanta    \n";
        setListPrint += "\n";
        
        return setListPrint;
        
    }
    
    public static String set1List(){
        
        String setListPrint = name();

        setListPrint += "    Set Menu:\n\n";
        setListPrint += "            < Set 1 >\n";
        setListPrint += "                                                                                                                                                                                                                                                      RM 11.00\n";
        setListPrint += "                          1 Starter       +       1 Main course       +       1 Soft Drink (free)                  \n";
        setListPrint += "                                 Salad                        Chicken rice                   Coca cola             \n";
        setListPrint += "                                 Soup                         Curry noodle                  Sprite                 \n";
        setListPrint += "                                                                    Nasi lemak                     Ice lemon tea   \n";
        setListPrint += "                                                                    Asam laksa                    Fanta       \n";
        setListPrint += "\n";
        
        return setListPrint;
        
    }
    
    public static String set2List(){
        
        String setListPrint = name();

        setListPrint += "    Set Menu:\n\n";
        setListPrint += "            < Set 2 >\n";
        setListPrint +=  "                                                                                                                                                                                                                                                     RM 11.50\n";
        setListPrint += "                          1 Dessert       +       1 Main Course       +       1 Warm Beverage (free)   \n";
        setListPrint += "                                  Ice Cream                Chicken rice                    Coffee      \n";
        setListPrint += "                                  Cendol                      Curry noodle                    Tea      \n";
        setListPrint += "                                  Pudding                    Nasi lemak                                \n";
        setListPrint += "                                                                     Asam laksa                    \n";
        setListPrint += "\n";
        
        return setListPrint;
        
    }
    
    public static String set3List(){
        
        String setListPrint = name();

        setListPrint += "            < Set 3 >\n";
        setListPrint += "                                                                                                                                                                                                                                                      RM 15.00\n";
        setListPrint += "                          1 Starter       +       1 Dessert       +       1 Main Course       +       1 Warm Beverage (free)       +       1 Soft Drink (free)                                                  \n";
        setListPrint += "                                 Salad                        Ice Cream               Chicken rice                     Coffee                                                Coca cola                          \n";
        setListPrint += "                                 Soup                         Cendol                     Curry noodle                     Tea                                                     Sprite                        \n";
        setListPrint += "                                                                    Pudding                   Nasi lemak                                                                                    Ice lemon tea       \n";
        setListPrint += "                                                                                                      Asam laksa                                                                                   Fanta    \n";
        setListPrint += "\n";
        
        return setListPrint;
        
    }
    
    public static String softDrinksList(){
        
        String softDrinksListPrint = name();

        softDrinksListPrint += "                                                                                            Alacarte:\n\n";
        softDrinksListPrint += "                                                                                                  _|        (< Soft Drinks  RM 2.00 >)          |_          \n";
        softDrinksListPrint += "                                                                                                  _|    - - - - - - - - - - - - - - - - - - - - - - - - -    |_   \n";
        softDrinksListPrint += "                                                                                                  _|                        Coca cola                      |_       \n";
        softDrinksListPrint += "                                                                                                  _|                        Sprite                              |_   \n";
        softDrinksListPrint += "                                                                                                  _|                        Ice lemon tea                |_          \n";
        softDrinksListPrint += "                                                                                                  _|                        Fanta                               |_   \n";
        softDrinksListPrint += "\n";
        
        return softDrinksListPrint;
        
    }
    
    public static String warmBeverageList(){
        
        String warmBeverageListPrint = "";
        
        warmBeverageListPrint += name();
        warmBeverageListPrint += "                                                                                            Alacarte:\n\n";
        warmBeverageListPrint += "                                                                                                  _|    (< Warm Beverages  RM 1.80 >)  |_              \n";
        warmBeverageListPrint += "                                                                                                  _|    - - - - - - - - - - - - - - - - - - - - - - - - -    |_       \n";
        warmBeverageListPrint += "                                                                                                  _|                            Coffee                         |_     \n";
        warmBeverageListPrint += "                                                                                                  _|                            Tea                              |_   \n";
        warmBeverageListPrint += "\n";
        
        return warmBeverageListPrint;
        
    }
    
    public static String starterList(){
        
        String starterListPrint = name();

        starterListPrint += "                                                                                            Alacarte:\n\n";
        starterListPrint += "                                                                                                _|             (< Starter  RM 4.00 >)             |_        \n";
        starterListPrint += "                                                                                                _|    - - - - - - - - - - - - - - - - - - - - - - - - -    |_      \n";
        starterListPrint += "                                                                                                _|                           Salad                            |_    \n";
        starterListPrint += "                                                                                                _|                           Soup                             |_    \n";
        starterListPrint += "\n";
        
        return starterListPrint;
        
    }
    
    public static String mainCourseList(){
        
        String mainCourseListPrint = name();

        mainCourseListPrint += "                                                                                         Alacarte:\n\n";
        mainCourseListPrint += "                                                                                              _|         (< Main Course  RM 8.00 >)      |_           \n";
        mainCourseListPrint += "                                                                                              _|    - - - - - - - - - - - - - - - - - - - - - - - - -    |_    \n";
        mainCourseListPrint += "                                                                                              _|                       Chicken rice                   |_       \n";
        mainCourseListPrint += "                                                                                              _|                       Curry noodle                   |_       \n";
        mainCourseListPrint += "                                                                                              _|                       Nasi lemak                      |_      \n";
        mainCourseListPrint += "                                                                                              _|                       Asam laksa                     |_       \n";
        mainCourseListPrint += "\n";
        
        return mainCourseListPrint;
        
    }
    
    public static String dessertList(){
        
        String dessertListPrint = name();

        dessertListPrint += "                                                                                            Alacarte:\n\n";
        dessertListPrint += "                                                                                                 _|            (< Dessert  RM 3.50 >)            |_         \n";
        dessertListPrint += "                                                                                                 _|    - - - - - - - - - - - - - - - - - - - - - - - - -    |_      \n";
        dessertListPrint += "                                                                                                 _|                       Ice Cream                       |_        \n";
        dessertListPrint += "                                                                                                 _|                       Cendol                             |_     \n";
        dessertListPrint += "                                                                                                 _|                       Pudding                           |_      \n";
        dessertListPrint += "\n";
                
        return dessertListPrint;
        
    }
    
}
