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
class Supplier {
    
    private int id,phone;
    private String name, address, gender, nic;
    
    public Supplier(int id, int phone, String name, String address , String gender, String nic)
    {
        this.id=id;
        this. phone=phone;
        this.name=name;
        this.gender=gender;
        this.address=address;
        this.nic=nic;     
    }
    
    public int getid(){
        return id;
    }
    
    public int getphone()
    {
        return phone;
    }
    
    public String getname(){
        return name;
    }
    
    
    public String getgender(){
        return gender;
    }
    
    
    public String getaddress(){
        return address;
    }
    
    
    public String getnic(){
        return nic;
    }
}
