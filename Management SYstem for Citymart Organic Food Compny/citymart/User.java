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
class User {
    
    private int phone;
    private String id, name, nic, dob, address, gender, position;
    
    public User(int phone,String id,  String name,  String nic, String address, String dob, String gender, String position)
    {
       this.phone=phone;
       this.id=id;
       this.name=name;
       this.nic=nic;
       this.dob=dob;
       this.address=address;
       this.gender=gender;
       this.position=position;
       
               
    }
    
    public int getphone(){
        return phone;
    }
    
    public String getid(){
        return id;
    }
    
    public String getname(){
        return name;
    }
    
     public String getnic(){
        return nic;
    }
     
      public String getdob(){
        return dob;
    }
      
       public String getaddress(){
        return address;
    }
       
        public String getgender(){
        return gender;
    }
         public String getposition(){
        return position;
    }
         
   
}
