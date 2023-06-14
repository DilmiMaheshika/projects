/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citymart;

/**
 *
 * @author user
 */
public class CityMart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         login();
    }
    
        public static void login(){
         Managerlogin frame = new Managerlogin ();
            frame.setVisible(true);
    
            WelcomePage frame1 = new WelcomePage();
            frame1.dispose();
            
            frame.setDefaultCloseOperation(Managerlogin.DISPOSE_ON_CLOSE); //close the only Login frame
    }
    
}
