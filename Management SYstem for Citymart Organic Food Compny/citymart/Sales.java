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
class Sales {
    private int sid, squantity;
    private String sname, scategory;
    
    public Sales(int sid, int squantity, String sname, String scategory)
    {
       this.sid= sid;
       this.squantity=squantity;
       this.sname=sname;
       this.scategory=scategory;         
    }
    
     public int getsid(){
         return sid;
     }
    
     public int getsquantity(){
         return squantity;
     }
     
     public String getsname(){
         return sname;
     }
     
     public String getscategory(){
         return scategory;
     }
    
}

  

