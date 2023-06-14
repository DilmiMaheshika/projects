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
class Store {
    private int id, quantity;
    private String name,category;
    
     public Store(int id,  int quantity, String name,  String category)
    {
       this.id =id;
       this.quantity=quantity;
       this.name=name;
       this.category=category;         
    }
    
     public int getid(){
         return id;
     }
   
     
     public int getquantity(){
         return quantity;
     }
     
     public String getname(){
         return name;
     }
     
     public String getcategory(){
         return category;
     }
    
}
