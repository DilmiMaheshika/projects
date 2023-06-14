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
class Requests {
     private int id, price, quantity;
    private String name,category,companyname,approvalST;
    
     public Requests(int id, int price , int quantity, String name,  String category, String companyname, String approvalST)
    {
       this.id =id;
       this.price=price;
       this.quantity=quantity;
       this.name=name;
       this.category=category;
       this.approvalST=approvalST;
       this.companyname=companyname;
               
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
     
     public String getname(){
         return name;
     }
     
     public String getcategory(){
         return category;
     }
     
     public String getcompanyname(){
         return companyname;
     }
     
     public String getapprovalST(){
         return approvalST;
     }
}
