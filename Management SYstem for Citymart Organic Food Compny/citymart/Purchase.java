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
class Purchase {
     private int id, price, quantity,totalP;
    private String name,category,date;
    
     public Purchase(int id, int price , int quantity, int totalP, String name,  String category, String date)
    {
       this.id =id;
       this.price=price;
       this.quantity=quantity;
       this.name=name;
       this.category=category;
       this.totalP=totalP;
       this.date=date;
    }
    
     public int getid(){
         return id;
     }
     
     public int getprice(){
         return price;
     }
     
     public int getquantity(){
         return quantity;
     }
     
     
     public int gettotalP(){
         return totalP;
     }
     
     public String getname(){
         return name;
     }
     
     public String getcategory(){
         return category;
     }
     
     
     public String getdate(){
         return date;
     }
}
