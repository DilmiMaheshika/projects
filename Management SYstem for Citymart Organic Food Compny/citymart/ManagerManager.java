/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citymart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ManagerManager extends javax.swing.JFrame {

    
    Connection conn;
    PreparedStatement ps;
    String Gender;
    String Approval_Status;
    
    public ManagerManager() {
        initComponents();
        
        this.setLocationRelativeTo(null); // center form in the screen
        
         try {
            String url = "jdbc:mysql://localhost/citymart";
            String user = "root";
            String pass = "";
            
            conn = DriverManager.getConnection(url, user, pass);
            
    }catch(Exception ex){
             System.err.println("Error : "+ex.getMessage());
    }
      
         
         sales_items(); // call sales details methode
         show_users(); // call user details methode
         store_items(); //call store details methode
         suppliers(); //call supplier details methode
         Req_Details(); //call Request details methode
         Approve_Requests();//call approval reqs methode
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    // users viewtable
    public ArrayList<User> userList(){
        ArrayList<User> objUserList =new ArrayList<>();
        try{
            String sql = "SELECT * FROM user_accounts";
            ps=conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            User clsUser;
            while(rs.next()){
                clsUser=new User(rs.getInt("Phone_No"), rs.getString("User_ID"), rs.getString("Full_Name"), rs.getString("NIC_No"), rs.getString("Address"), rs.getString("DOB"),  rs.getString("Gender"), rs.getString("Position"));
                objUserList.add(clsUser);
            }
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return objUserList;
    }
    
    
     public void show_users(){
        ArrayList<User> list = userList();
        DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
        Object[] row =new Object[8];
        for(int i=0; i<list.size(); i++){
        row[0]=list.get(i).getid();    
        row[1]=list.get(i).getname();
        row[2]=list.get(i).getnic();
        row[3]=list.get(i).getaddress();
        row[4]=list.get(i).getdob();
        row[5]=list.get(i).getphone();
        row[6]=list.get(i).getgender();
        row[7]=list.get(i).getposition();
        model.addRow(row);
        
    } }
    
    ////////////////////////////////////////////////////////////////////////////////////////
  //Stores viewtable
    public ArrayList<Store> storeList(){
        ArrayList<Store> objStoreList =new ArrayList<>();
        try{
            String sql = "SELECT * FROM store_items";
            ps=conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            Store clsStore;
            while(rs.next()){
                clsStore=new Store(rs.getInt("Item_Id"), rs.getInt("Quantity"), rs.getString("Item_Name"), rs.getString("Category"));
                objStoreList.add(clsStore);
            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return objStoreList;
    }
    
   
    public void store_items(){
       ArrayList<Store> list =storeList();
        DefaultTableModel model= (DefaultTableModel)jTable2.getModel();
        Object[] row =new Object[4];
        for(int i=0; i<list.size(); i++){
        row[0]=list.get(i).getid();
        row[1]=list.get(i).getname();
        row[2]=list.get(i).getcategory();
        row[3]=list.get(i).getquantity();
        model.addRow(row);
        
    } 
    }
     
    
   ////////////////////////////////////////////////////////////////////////////////////////
    //Supplier viewtable
    public ArrayList<Supplier> supplierList(){
        ArrayList<Supplier> objSupplierList =new ArrayList<>();
        try{
            String sql = "SELECT * FROM suppliers";
            ps=conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            Supplier clsSupplier;
            while(rs.next()){
                clsSupplier=new Supplier(rs.getInt("Supplier_ID"),rs.getInt("Phone_No"), rs.getString("Supplier_Name"), rs.getString("Address"), rs.getString("Gender"), rs.getString("NIC_No"));
                objSupplierList.add(clsSupplier);
            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return objSupplierList;
    }
    
   
    public void suppliers(){
       ArrayList<Supplier> list =supplierList();
        DefaultTableModel model= (DefaultTableModel)jTable4.getModel();
        Object[] row =new Object[6];
        for(int i=0; i<list.size(); i++){
        row[0]=list.get(i).getid();
        row[1]=list.get(i).getname();
        row[2]=list.get(i).getaddress();
        row[3]=list.get(i).getgender();
        row[4]=list.get(i).getnic();
        row[5]=list.get(i).getphone();
        model.addRow(row);
        
    } } 
    
     //////////////////////////////////////////////////////////////////////
    ////View RequestDetails Tables
    
      public ArrayList<Requests> RequestIncome(){
        ArrayList<Requests> objRequestIncome =new ArrayList<>();
        try{
            String sql = "SELECT * FROM incoming_requests";
            ps=conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            Requests clsRequests;
            while(rs.next()){
                clsRequests=new Requests(rs.getInt("Requests_No"), rs.getInt("Unit_Price_Rs"), rs.getInt("Quantity"), rs.getString("Item_Name"), rs.getString("Category"),rs.getString("Company_Name"), rs.getString("Approval_Status"));
                objRequestIncome.add(clsRequests);
            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return objRequestIncome;
    }
    
   
    public void Req_Details(){
       ArrayList<Requests> list =RequestIncome();
        DefaultTableModel model= (DefaultTableModel)jTable5.getModel();
        Object[] row =new Object[7];
        for(int i=0; i<list.size(); i++){
        row[0]=list.get(i).getid();
        row[1]=list.get(i).getname();
        row[2]=list.get(i).getcategory();
        row[3]=list.get(i).getprice();
        row[4]=list.get(i).getquantity();
        row[5]=list.get(i).getcompanyname();
        row[6]=list.get(i).getapprovalST();
        model.addRow(row);
        
    } 
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////
    
      //////////////////////////////////////////////////////////////////////
    ////View RequestDetails Tables
    
      public ArrayList<ApproveReqs> ApproveRequests(){
        ArrayList<ApproveReqs> objApproveRequests =new ArrayList<>();
        try{
            String sql = "SELECT * FROM approve_requests";
            ps=conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            ApproveReqs clsApproveReqs;
            while(rs.next()){
                clsApproveReqs=new ApproveReqs(rs.getInt("Requests_No"), rs.getInt("Unit_Price_Rs"), rs.getInt("Quantity"), rs.getString("Item_Name"), rs.getString("Category"),rs.getString("Company_Name"), rs.getString("Approval_Status"));
                objApproveRequests.add(clsApproveReqs);
            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return objApproveRequests;
    }
    
   
    public void Approve_Requests(){
       ArrayList<ApproveReqs> list =ApproveRequests();
        DefaultTableModel model= (DefaultTableModel)jTable6.getModel();
        Object[] row =new Object[7];
        for(int i=0; i<list.size(); i++){
        row[0]=list.get(i).getid();
        row[1]=list.get(i).getname();
        row[2]=list.get(i).getcategory();
        row[3]=list.get(i).getprice();
        row[4]=list.get(i).getquantity();
        row[5]=list.get(i).getcompanyname();
        row[6]=list.get(i).getapprovalST();
        model.addRow(row);
        
    } 
    }
    

     
     public ArrayList<Sales> saleList(){
        ArrayList<Sales> saleslist =new ArrayList<>();
        try{
            String sql = "SELECT * FROM sales_items";
            ps=conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            Sales sales;
            while(rs.next()){
                sales=new Sales(rs.getInt("Item_Id"), rs.getInt("Quantity"), rs.getString("Item_Name"), rs.getString("Category"));
                saleslist.add(sales);
            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return saleslist;
    }
    
   
    public void sales_items(){
       ArrayList<Sales> list =saleList();
        DefaultTableModel model= (DefaultTableModel)jTableSales.getModel();
        Object[] row =new Object[4];
        for(int i=0; i<list.size(); i++){
        row[0]=list.get(i).getsid();
        row[1]=list.get(i).getsname();
        row[2]=list.get(i).getscategory();
        row[3]=list.get(i).getsquantity();
        model.addRow(row);
        
    } 
    }
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        HomePanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        stckshowbtn = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ManageUserAccounts = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        CreatejPanel10 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelRegister1 = new javax.swing.JPanel();
        lblName1 = new javax.swing.JLabel();
        lblNIC1 = new javax.swing.JLabel();
        lblAddress1 = new javax.swing.JLabel();
        lblDOB1 = new javax.swing.JLabel();
        lblPhone1 = new javax.swing.JLabel();
        lblPhone2 = new javax.swing.JLabel();
        lblPhone3 = new javax.swing.JLabel();
        userAddBtn = new javax.swing.JButton();
        AddtxtName = new javax.swing.JTextField();
        AddtxtNIC = new javax.swing.JTextField();
        AddtxtAddress = new javax.swing.JTextField();
        AddtxtDOB = new javax.swing.JTextField();
        AddtxtPhone = new javax.swing.JTextField();
        AddComboBx = new javax.swing.JComboBox<>();
        Addradio1 = new javax.swing.JRadioButton();
        Addradio2 = new javax.swing.JRadioButton();
        lblName5 = new javax.swing.JLabel();
        SupplierID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        UpdatejPanel11 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        PanelRegister2 = new javax.swing.JPanel();
        lblName2 = new javax.swing.JLabel();
        lblNIC2 = new javax.swing.JLabel();
        lblAddress2 = new javax.swing.JLabel();
        lblDOB2 = new javax.swing.JLabel();
        lblPhone4 = new javax.swing.JLabel();
        lblPhone5 = new javax.swing.JLabel();
        lblPhone6 = new javax.swing.JLabel();
        userUpdateBtn = new javax.swing.JButton();
        Nametxtbx = new javax.swing.JTextField();
        NICtxtbx = new javax.swing.JTextField();
        Addresstxtbx = new javax.swing.JTextField();
        DOBtxtbx = new javax.swing.JTextField();
        PhoneNOtxtbx = new javax.swing.JTextField();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        SupplierID1 = new javax.swing.JTextField();
        lblName6 = new javax.swing.JLabel();
        UpdateserachBtn = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        DeletejPanel12 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        PanelRegister3 = new javax.swing.JPanel();
        lblName3 = new javax.swing.JLabel();
        lblNIC3 = new javax.swing.JLabel();
        lblAddress3 = new javax.swing.JLabel();
        lblDOB3 = new javax.swing.JLabel();
        lblPhone7 = new javax.swing.JLabel();
        lblPhone8 = new javax.swing.JLabel();
        txtName2 = new javax.swing.JTextField();
        txtNIC2 = new javax.swing.JTextField();
        txtDOB2 = new javax.swing.JTextField();
        txtAddress2 = new javax.swing.JTextField();
        txtPhone2 = new javax.swing.JTextField();
        lblPhone9 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        Deletebtn = new javax.swing.JButton();
        lblName7 = new javax.swing.JLabel();
        SupID = new javax.swing.JTextField();
        DeleteSearchbtn = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        SearchjPanel13 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        PanelRegister4 = new javax.swing.JPanel();
        lblName4 = new javax.swing.JLabel();
        lblNIC4 = new javax.swing.JLabel();
        lblAddress4 = new javax.swing.JLabel();
        lblDOB4 = new javax.swing.JLabel();
        lblPhone10 = new javax.swing.JLabel();
        lblPhone11 = new javax.swing.JLabel();
        txtName3 = new javax.swing.JTextField();
        txtNIC3 = new javax.swing.JTextField();
        txtDOB3 = new javax.swing.JTextField();
        txtAddress3 = new javax.swing.JTextField();
        txtPhone3 = new javax.swing.JTextField();
        lblPhone12 = new javax.swing.JLabel();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        SupplierID3 = new javax.swing.JTextField();
        lblName8 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        ViewAlljPanel18 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        ViewStockDetails = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField12 = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        jTextField21 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton26 = new javax.swing.JButton();
        ViewSalesDetails = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableSales = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        searchStock = new javax.swing.JButton();
        jTextField22 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jButton27 = new javax.swing.JButton();
        ViewSuppliers = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel37 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton22 = new javax.swing.JButton();
        jTextField23 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        Requests = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        ViewRequestjPanel39 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel43 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txrequestsNo = new javax.swing.JTextField();
        txname = new javax.swing.JTextField();
        txprice = new javax.swing.JTextField();
        txquantity = new javax.swing.JTextField();
        txcompanyname = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jcombobox = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();
        ReqUpdate = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        ViewApprovedReqjPanel40 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel44 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jButton24 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jComboBox8 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jcombobox1 = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 255));

        HomePanel.setForeground(new java.awt.Color(0, 0, 255));

        jPanel7.setBackground(new java.awt.Color(0, 0, 51));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Welcome to");

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Manager");

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Portal...");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 51, 102));

        jButton6.setFont(new java.awt.Font("Forte", 0, 36)); // NOI18N
        jButton6.setText("User Account Manage");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        stckshowbtn.setFont(new java.awt.Font("Forte", 0, 36)); // NOI18N
        stckshowbtn.setText("View All stock Details");
        stckshowbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        stckshowbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stckshowbtnActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Forte", 0, 36)); // NOI18N
        jButton16.setText("View All Sales Details");
        jButton16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton30.setFont(new java.awt.Font("Forte", 0, 36)); // NOI18N
        jButton30.setText("View All Supplier Details");
        jButton30.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setFont(new java.awt.Font("Forte", 0, 36)); // NOI18N
        jButton31.setText("Manage Incoming Requests Details");
        jButton31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                    .addComponent(stckshowbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stckshowbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/citymartjpg.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Manager Portal");

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 451, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout HomePanelLayout = new javax.swing.GroupLayout(HomePanel);
        HomePanel.setLayout(HomePanelLayout);
        HomePanelLayout.setHorizontalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePanelLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        HomePanelLayout.setVerticalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        jTabbedPane1.addTab("Home Page", HomePanel);

        ManageUserAccounts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CreatejPanel10.setPreferredSize(new java.awt.Dimension(1167, 650));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel5.setText("Create User Accounts");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblName1.setBackground(new java.awt.Color(255, 153, 102));
        lblName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblName1.setText("Ente User Full Name  :-");

        lblNIC1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNIC1.setText("Enter User NIC No  :-");

        lblAddress1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAddress1.setText("Enter User Address  :-");

        lblDOB1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDOB1.setText("Enter User DOB :-");

        lblPhone1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone1.setText("Enter Supplier Phone No  :-");

        lblPhone2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone2.setText("Select Position :-");

        lblPhone3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone3.setText("Gender :-");

        userAddBtn.setText("Add");
        userAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAddBtnActionPerformed(evt);
            }
        });

        AddComboBx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Store Keeper", "Cashier/Accountant" }));

        buttonGroup2.add(Addradio1);
        Addradio1.setText("Male");
        Addradio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Addradio1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(Addradio2);
        Addradio2.setText("Female");
        Addradio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Addradio2ActionPerformed(evt);
            }
        });

        lblName5.setBackground(new java.awt.Color(255, 153, 102));
        lblName5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblName5.setText("Enter User ID  :-");

        javax.swing.GroupLayout PanelRegister1Layout = new javax.swing.GroupLayout(PanelRegister1);
        PanelRegister1.setLayout(PanelRegister1Layout);
        PanelRegister1Layout.setHorizontalGroup(
            PanelRegister1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegister1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(PanelRegister1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegister1Layout.createSequentialGroup()
                        .addComponent(lblName5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelRegister1Layout.createSequentialGroup()
                        .addGroup(PanelRegister1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNIC1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDOB1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddtxtName)
                            .addComponent(AddtxtNIC)
                            .addComponent(AddtxtAddress)
                            .addComponent(AddtxtDOB)
                            .addComponent(AddtxtPhone)
                            .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SupplierID, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelRegister1Layout.createSequentialGroup()
                        .addGroup(PanelRegister1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddComboBx, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelRegister1Layout.createSequentialGroup()
                                .addGroup(PanelRegister1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelRegister1Layout.createSequentialGroup()
                                        .addComponent(lblPhone3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Addradio1)))
                                .addGap(18, 18, 18)
                                .addComponent(Addradio2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        PanelRegister1Layout.setVerticalGroup(
            PanelRegister1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegister1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNIC1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddtxtNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAddress1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddtxtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDOB1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddtxtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPhone1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddtxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRegister1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone3)
                    .addComponent(Addradio1)
                    .addComponent(Addradio2))
                .addGap(6, 6, 6)
                .addComponent(lblPhone2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegister1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddComboBx, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/citymartjpg.png"))); // NOI18N

        javax.swing.GroupLayout CreatejPanel10Layout = new javax.swing.GroupLayout(CreatejPanel10);
        CreatejPanel10.setLayout(CreatejPanel10Layout);
        CreatejPanel10Layout.setHorizontalGroup(
            CreatejPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreatejPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelRegister1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(CreatejPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(21, 21, 21))
        );
        CreatejPanel10Layout.setVerticalGroup(
            CreatejPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreatejPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CreatejPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelRegister1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("create", CreatejPanel10);

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel12.setText("Update User Accounts");
        jLabel12.setToolTipText("");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(5, 5, 5))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblName2.setBackground(new java.awt.Color(255, 153, 102));
        lblName2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblName2.setText("Enter User Full Name  :-");

        lblNIC2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNIC2.setText("Enter User NIC No  :-");

        lblAddress2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAddress2.setText("Enter User Address  :-");

        lblDOB2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDOB2.setText("Enter User DOB  :-");

        lblPhone4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone4.setText("Enter Supplier Phone No  :-");

        lblPhone5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone5.setText("Select Position :-");

        lblPhone6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone6.setText("Gender :-");

        userUpdateBtn.setText("Update");
        userUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userUpdateBtnActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton13);
        jRadioButton13.setText("Male");

        buttonGroup2.add(jRadioButton14);
        jRadioButton14.setText("Female");
        jRadioButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton14ActionPerformed(evt);
            }
        });

        lblName6.setBackground(new java.awt.Color(255, 153, 102));
        lblName6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblName6.setText("Enter User ID  :-");

        UpdateserachBtn.setText("Search");
        UpdateserachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateserachBtnActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Store Keeper", "Cashier/Accountant" }));

        javax.swing.GroupLayout PanelRegister2Layout = new javax.swing.GroupLayout(PanelRegister2);
        PanelRegister2.setLayout(PanelRegister2Layout);
        PanelRegister2Layout.setHorizontalGroup(
            PanelRegister2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegister2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(PanelRegister2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegister2Layout.createSequentialGroup()
                        .addGroup(PanelRegister2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegister2Layout.createSequentialGroup()
                                .addComponent(lblPhone6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton13)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton14))
                            .addComponent(lblName6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelRegister2Layout.createSequentialGroup()
                        .addGroup(PanelRegister2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegister2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblNIC2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDOB2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPhone4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Nametxtbx, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                                .addComponent(NICtxtbx)
                                .addComponent(DOBtxtbx)
                                .addComponent(PhoneNOtxtbx)
                                .addComponent(Addresstxtbx)
                                .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SupplierID1)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblPhone5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelRegister2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegister2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(UpdateserachBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(201, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegister2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                                .addComponent(userUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))))))
        );
        PanelRegister2Layout.setVerticalGroup(
            PanelRegister2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegister2Layout.createSequentialGroup()
                .addComponent(lblName6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelRegister2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SupplierID1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateserachBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(lblName2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nametxtbx, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNIC2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NICtxtbx, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAddress2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Addresstxtbx, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDOB2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DOBtxtbx, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhone4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PhoneNOtxtbx, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRegister2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone6)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton14))
                .addGroup(PanelRegister2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegister2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPhone5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelRegister2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(userUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/citymartjpg.png"))); // NOI18N

        javax.swing.GroupLayout UpdatejPanel11Layout = new javax.swing.GroupLayout(UpdatejPanel11);
        UpdatejPanel11.setLayout(UpdatejPanel11Layout);
        UpdatejPanel11Layout.setHorizontalGroup(
            UpdatejPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatejPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UpdatejPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdatejPanel11Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(PanelRegister2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(UpdatejPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 424, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addContainerGap())))
        );
        UpdatejPanel11Layout.setVerticalGroup(
            UpdatejPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatejPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UpdatejPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(PanelRegister2, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Update", UpdatejPanel11);

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel16.setText("Delete User Accounts");
        jLabel16.setToolTipText("");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(5, 5, 5))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblName3.setBackground(new java.awt.Color(255, 153, 102));
        lblName3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblName3.setText("Full Name  :-");

        lblNIC3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNIC3.setText("NIC No  :-");

        lblAddress3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAddress3.setText("Address  :-");

        lblDOB3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDOB3.setText("DOB  :-");

        lblPhone7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone7.setText("User Phone No  :-");

        lblPhone8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone8.setText("Select Position :-");

        lblPhone9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone9.setText("Gender :-");

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setText("Male");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton8);
        jRadioButton8.setText("Female");
        jRadioButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        Deletebtn.setText("Delete");
        Deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebtnActionPerformed(evt);
            }
        });

        lblName7.setBackground(new java.awt.Color(255, 153, 102));
        lblName7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblName7.setText(" User ID  :-");

        DeleteSearchbtn.setText("Search");
        DeleteSearchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteSearchbtnActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Store Keeper", "Cashier/Accountant" }));

        javax.swing.GroupLayout PanelRegister3Layout = new javax.swing.GroupLayout(PanelRegister3);
        PanelRegister3.setLayout(PanelRegister3Layout);
        PanelRegister3Layout.setHorizontalGroup(
            PanelRegister3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegister3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelRegister3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegister3Layout.createSequentialGroup()
                        .addComponent(lblPhone8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(PanelRegister3Layout.createSequentialGroup()
                        .addGroup(PanelRegister3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelRegister3Layout.createSequentialGroup()
                                .addGroup(PanelRegister3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtName2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                    .addComponent(lblNIC3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNIC2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAddress3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDOB3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDOB2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPhone7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SupID, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelRegister3Layout.createSequentialGroup()
                                        .addComponent(lblPhone9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jRadioButton7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton8))
                                    .addComponent(txtPhone2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(DeleteSearchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(256, Short.MAX_VALUE))))
        );
        PanelRegister3Layout.setVerticalGroup(
            PanelRegister3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegister3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegister3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DeleteSearchbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SupID, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGroup(PanelRegister3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegister3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblName3)
                        .addGap(2, 2, 2)
                        .addComponent(txtName2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNIC3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNIC2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAddress3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDOB3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDOB2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(lblPhone7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelRegister3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhone9)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPhone8))
                    .addGroup(PanelRegister3Layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(Deletebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/citymartjpg.png"))); // NOI18N

        javax.swing.GroupLayout DeletejPanel12Layout = new javax.swing.GroupLayout(DeletejPanel12);
        DeletejPanel12.setLayout(DeletejPanel12Layout);
        DeletejPanel12Layout.setHorizontalGroup(
            DeletejPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeletejPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeletejPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DeletejPanel12Layout.createSequentialGroup()
                        .addComponent(PanelRegister3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(71, Short.MAX_VALUE))
                    .addGroup(DeletejPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(439, 439, 439)
                        .addComponent(jLabel11)
                        .addContainerGap())))
        );
        DeletejPanel12Layout.setVerticalGroup(
            DeletejPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeletejPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeletejPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(PanelRegister3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Delete", DeletejPanel12);

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel20.setText("Search User Accounts");
        jLabel20.setToolTipText("");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblName4.setBackground(new java.awt.Color(255, 153, 102));
        lblName4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblName4.setText("User Full Name  :-");

        lblNIC4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNIC4.setText("User NIC No  :-");

        lblAddress4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAddress4.setText("User Address  :-");

        lblDOB4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDOB4.setText("User DOB  :-");

        lblPhone10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone10.setText("Enter Your Phone No  :-");

        lblPhone11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone11.setText("Select Position :-");

        lblPhone12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone12.setText("Gender :-");

        buttonGroup2.add(jRadioButton9);
        jRadioButton9.setText("Male");
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton10);
        jRadioButton10.setText("Female");
        jRadioButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton10ActionPerformed(evt);
            }
        });

        lblName8.setBackground(new java.awt.Color(255, 153, 102));
        lblName8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblName8.setText("User ID  :-");

        jButton17.setText("Search");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Store Keeper", "Cashier/Accountant" }));

        javax.swing.GroupLayout PanelRegister4Layout = new javax.swing.GroupLayout(PanelRegister4);
        PanelRegister4.setLayout(PanelRegister4Layout);
        PanelRegister4Layout.setHorizontalGroup(
            PanelRegister4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegister4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(PanelRegister4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhone11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelRegister4Layout.createSequentialGroup()
                        .addGroup(PanelRegister4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(lblNIC4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNIC3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDOB4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDOB3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhone10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SupplierID3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhone3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelRegister4Layout.createSequentialGroup()
                                .addComponent(lblPhone12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jRadioButton9)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton10)))
                        .addGap(36, 36, 36)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(236, Short.MAX_VALUE))
        );
        PanelRegister4Layout.setVerticalGroup(
            PanelRegister4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegister4Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(lblName8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegister4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SupplierID3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNIC4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNIC3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAddress4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDOB4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDOB3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhone10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhone3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(PanelRegister4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPhone12)
                    .addGroup(PanelRegister4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton9)
                        .addComponent(jRadioButton10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPhone11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/citymartjpg.png"))); // NOI18N

        javax.swing.GroupLayout SearchjPanel13Layout = new javax.swing.GroupLayout(SearchjPanel13);
        SearchjPanel13.setLayout(SearchjPanel13Layout);
        SearchjPanel13Layout.setHorizontalGroup(
            SearchjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchjPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchjPanel13Layout.createSequentialGroup()
                        .addComponent(PanelRegister4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 71, Short.MAX_VALUE))
                    .addGroup(SearchjPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)))
                .addContainerGap())
        );
        SearchjPanel13Layout.setVerticalGroup(
            SearchjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchjPanel13Layout.createSequentialGroup()
                .addGroup(SearchjPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchjPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchjPanel13Layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(PanelRegister4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Search", SearchjPanel13);

        jLabel24.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel24.setText("View All User Accounts");
        jLabel24.setToolTipText("");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(5, 5, 5))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Full Name", "NIC No", "Address", "DOB", "Phone No", "Gender", "Position"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/citymartjpg.png"))); // NOI18N

        javax.swing.GroupLayout ViewAlljPanel18Layout = new javax.swing.GroupLayout(ViewAlljPanel18);
        ViewAlljPanel18.setLayout(ViewAlljPanel18Layout);
        ViewAlljPanel18Layout.setHorizontalGroup(
            ViewAlljPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewAlljPanel18Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(ViewAlljPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ViewAlljPanel18Layout.createSequentialGroup()
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addContainerGap())
        );
        ViewAlljPanel18Layout.setVerticalGroup(
            ViewAlljPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewAlljPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewAlljPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("View All", ViewAlljPanel18);

        ManageUserAccounts.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, -31, 990, 700));

        jPanel14.setBackground(new java.awt.Color(0, 102, 153));

        jButton7.setText("Create Accounts");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Update User Accounts");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Delete User Accounts");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Search ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("View All User Accounts");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        ManageUserAccounts.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 79, 260, 590));

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/left arrow.png"))); // NOI18N
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        ManageUserAccounts.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 66, 60));

        jTabbedPane1.addTab("User Accounts", ManageUserAccounts);

        jPanel28.setBackground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel25.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel25.setText("View Stock Details");
        jLabel25.setToolTipText("");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Category", "Quantity"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel26.setText("Item ID");

        jLabel27.setText("Item Name");

        jLabel29.setText("Category");

        jLabel30.setText("Quantity");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Vegetables", "Fruits", "Leaf Varieties" }));

        jButton18.setText("Search Stock Details");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel27)
                            .addComponent(jLabel30)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, 665, Short.MAX_VALUE)))
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField21)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/citymartjpg.png"))); // NOI18N

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(307, 307, 307)
                                .addComponent(jLabel8)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/left arrow.png"))); // NOI18N
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewStockDetailsLayout = new javax.swing.GroupLayout(ViewStockDetails);
        ViewStockDetails.setLayout(ViewStockDetailsLayout);
        ViewStockDetailsLayout.setHorizontalGroup(
            ViewStockDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewStockDetailsLayout.createSequentialGroup()
                .addGroup(ViewStockDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ViewStockDetailsLayout.setVerticalGroup(
            ViewStockDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewStockDetailsLayout.createSequentialGroup()
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(ViewStockDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Stock details", ViewStockDetails);

        jLabel31.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel31.setText("View Sales Details");
        jLabel31.setToolTipText("");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Category", "Quantity"
            }
        ));
        jScrollPane3.setViewportView(jTableSales);

        jLabel32.setText("Item ID");

        jLabel33.setText("Item Name");

        jLabel35.setText("Category");

        jLabel36.setText("Quantity");

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Vegetables", "Fruits", "Leaf Varieties" }));

        searchStock.setText("Search Stock Details");
        searchStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStockActionPerformed(evt);
            }
        });

        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchStock, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel32)))
                            .addComponent(jLabel36)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.TRAILING, 0, 520, Short.MAX_VALUE)
                            .addComponent(jTextField7)
                            .addComponent(jTextField10)
                            .addComponent(jTextField19))))
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(searchStock, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addComponent(jLabel32)
                                .addGap(26, 26, 26)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel33)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35)))
                .addGap(16, 16, 16)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(81, 81, 81))
        );

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/citymartjpg.png"))); // NOI18N

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(136, Short.MAX_VALUE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel65)
                        .addGap(25, 25, 25))))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel33.setBackground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/left arrow.png"))); // NOI18N
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewSalesDetailsLayout = new javax.swing.GroupLayout(ViewSalesDetails);
        ViewSalesDetails.setLayout(ViewSalesDetailsLayout);
        ViewSalesDetailsLayout.setHorizontalGroup(
            ViewSalesDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewSalesDetailsLayout.createSequentialGroup()
                .addGroup(ViewSalesDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ViewSalesDetailsLayout.setVerticalGroup(
            ViewSalesDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewSalesDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sales Details", ViewSalesDetails);

        jPanel34.setBackground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );

        jLabel37.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel37.setText("View Supplier Details");
        jLabel37.setToolTipText("");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Supplier Name", "Address", "Gender", "NIC No", "Phone No"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jLabel38.setText("Supplier ID");

        jLabel39.setText("Supplier Name");

        jLabel40.setText("Address");

        jLabel41.setText("NIC No");

        jLabel42.setText("Phone No");

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jLabel43.setText("Gender");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Gender", "Male", "Female" }));

        jButton22.setText("Search");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(jLabel42)
                            .addComponent(jLabel41)
                            .addComponent(jLabel40)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39))
                        .addGap(105, 105, 105)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addGap(18, 18, 18)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/citymartjpg.png"))); // NOI18N

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                        .addComponent(jLabel66)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/left arrow.png"))); // NOI18N
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewSuppliersLayout = new javax.swing.GroupLayout(ViewSuppliers);
        ViewSuppliers.setLayout(ViewSuppliersLayout);
        ViewSuppliersLayout.setHorizontalGroup(
            ViewSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewSuppliersLayout.createSequentialGroup()
                .addGroup(ViewSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ViewSuppliersLayout.setVerticalGroup(
            ViewSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewSuppliersLayout.createSequentialGroup()
                .addGroup(ViewSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewSuppliersLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ViewSuppliersLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Suppliers", ViewSuppliers);

        Requests.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel38.setBackground(new java.awt.Color(0, 102, 153));

        jButton20.setText("View & Manage All Requests");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("View All Approved Requests");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        Requests.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 250, 560));

        jLabel44.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel44.setText("View All Requests");
        jLabel44.setToolTipText("");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Category", "Price Rs.", "Quantity", "Company Name", "Approval Status"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jLabel46.setText("Request No");

        jLabel47.setText("Item Name");

        jLabel48.setText("Category");

        jLabel49.setText("Unit Price Rs");

        jLabel50.setText("Quantity");

        jLabel51.setText("Company Name");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Update Approval Status");

        jButton23.setText("Search");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jcombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Vegetables", "Fruits", "Leaf Varieties" }));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Approved", "Not Approved" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        ReqUpdate.setText("Update");
        ReqUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReqUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txcompanyname)
                            .addComponent(txquantity)
                            .addComponent(txprice)
                            .addComponent(txname)
                            .addComponent(txrequestsNo)
                            .addComponent(jcombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGap(0, 574, Short.MAX_VALUE)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ReqUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton23)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txrequestsNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(txprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(txquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(txcompanyname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ReqUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/citymartjpg.png"))); // NOI18N

        javax.swing.GroupLayout ViewRequestjPanel39Layout = new javax.swing.GroupLayout(ViewRequestjPanel39);
        ViewRequestjPanel39.setLayout(ViewRequestjPanel39Layout);
        ViewRequestjPanel39Layout.setHorizontalGroup(
            ViewRequestjPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewRequestjPanel39Layout.createSequentialGroup()
                .addGroup(ViewRequestjPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ViewRequestjPanel39Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel67)
                .addGap(29, 29, 29))
            .addGroup(ViewRequestjPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ViewRequestjPanel39Layout.setVerticalGroup(
            ViewRequestjPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewRequestjPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewRequestjPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewRequestjPanel39Layout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addComponent(jLabel67)
                        .addGap(117, 117, 117))
                    .addGroup(ViewRequestjPanel39Layout.createSequentialGroup()
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jTabbedPane3.addTab("view all", ViewRequestjPanel39);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel45.setText("View All Approved Requests");
        jLabel45.setToolTipText("");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Category", "Price Rs.", "Quantity", "Company Name", "Approval Status"
            }
        ));
        jScrollPane6.setViewportView(jTable6);

        jLabel53.setText("Item ID");

        jLabel54.setText("Item Name");

        jLabel55.setText("Category");

        jLabel56.setText("Price Rs");

        jLabel57.setText("Quantity");

        jLabel58.setText("Company Name");

        jLabel59.setText("Approval Status");

        jButton24.setText("Search");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Approved", "Not Approved" }));

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jcombobox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Vegetables", "Fruits", "Leaf Varieties" }));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56)
                            .addComponent(jLabel57)
                            .addComponent(jLabel58))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField35)
                            .addComponent(jTextField34)
                            .addComponent(jTextField33)
                            .addComponent(jTextField31)
                            .addComponent(jTextField30)
                            .addComponent(jComboBox8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcombobox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(0, 577, Short.MAX_VALUE)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel44Layout.createSequentialGroup()
                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jcombobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/citymartjpg.png"))); // NOI18N

        javax.swing.GroupLayout ViewApprovedReqjPanel40Layout = new javax.swing.GroupLayout(ViewApprovedReqjPanel40);
        ViewApprovedReqjPanel40.setLayout(ViewApprovedReqjPanel40Layout);
        ViewApprovedReqjPanel40Layout.setHorizontalGroup(
            ViewApprovedReqjPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewApprovedReqjPanel40Layout.createSequentialGroup()
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(ViewApprovedReqjPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewApprovedReqjPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        ViewApprovedReqjPanel40Layout.setVerticalGroup(
            ViewApprovedReqjPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewApprovedReqjPanel40Layout.createSequentialGroup()
                .addGroup(ViewApprovedReqjPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewApprovedReqjPanel40Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewApprovedReqjPanel40Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("view Approved", ViewApprovedReqjPanel40);

        Requests.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, -38, -1, 700));

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/citymart/left arrow.png"))); // NOI18N
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        Requests.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 60, -1));

        jTabbedPane1.addTab("Requests", Requests);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -29, -1, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton10ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void searchStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchStockActionPerformed
        //view all sales SEARCH Button
        try{
            
            String sql = "SELECT * From sales_items WHERE Item_Id=?";
            ps = conn.prepareStatement(sql);
            
            String search = jTextField22.getText();
            ps.setString(1, search);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String id=rs.getString("Item_Id");
               jTextField7.setText(id);
               
               String name=rs.getString("Item_Name");
               jTextField10.setText(name);
               
               String category=rs.getString("Category");
               switch(category){
                    case "Select Category":
                       jComboBox4.setSelectedIndex(0);
                       break;
                   case "Vegetables":
                       jComboBox4.setSelectedIndex(1);
                       break;
                   case "Fruits":
                       jComboBox4.setSelectedIndex(2);
                       break;
                   case "Leaf Varieties":
                       jComboBox4.setSelectedIndex(3);
                       break;
               }
               
               String quantity = rs.getString("Quantity");
               jTextField19.setText(quantity);
           } else {
                JOptionPane.showMessageDialog(this, "Item Details Not Found");
              SalesSearch();
           }
            
            }catch(Exception ex){
                System.err.println("Error : " +ex.getMessage());
            }
       
            
        
        
        
    }//GEN-LAST:event_searchStockActionPerformed

    private void SalesSearch(){
        jTextField22.setText(null);
        jTextField7.setText(null);
        jTextField10.setText(null);
        jTextField19.setText(null);
        jComboBox4.setSelectedIndex(0);
        jTextField22.requestFocus();
    }
    
    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //ManagerLogout
       WelcomePage wp= new WelcomePage();
       wp.setVisible(true);
       this.dispose(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(3);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(4);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        jTabbedPane3.setSelectedIndex(1);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        jTabbedPane3.setSelectedIndex(0);
    }//GEN-LAST:event_jButton20ActionPerformed

   
    
    private void userAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAddBtnActionPerformed
        // Add Button
      
       if(SupplierID.getText().trim().isEmpty() || AddtxtName.getText().trim().isEmpty() || AddtxtNIC.getText().trim().isEmpty() || 
               AddtxtAddress.getText().trim().isEmpty() || 
               AddtxtDOB.getText().trim().isEmpty() || AddtxtPhone.getText().trim().isEmpty())
      
       {
           
           JOptionPane.showMessageDialog(this,"Please Fill All Fields!!! ");
       }else{
           

            try {
                String id = SupplierID.getText();
                String name = AddtxtName.getText();
                String nic = AddtxtNIC.getText();
                String address = AddtxtAddress.getText();
                String dob = AddtxtDOB.getText();
                String phone = AddtxtPhone.getText();
               // String rd = Gender;
                //String svalue = AddComboBx.getSelectedItem().toString();
              
                
                    JOptionPane.showMessageDialog(this, " User Successful Registered!!!!!!!!!!!!!");

                    String sql = "INSERT INTO user_accounts VALUES (?,?,?,?,?,?,?,?)";
                    ps = conn.prepareStatement(sql);

                    ps.setString(1, id);
                    ps.setString(2, name);
                    ps.setString(3, nic);
                    ps.setString(4, address);
                    ps.setString(5, dob);
                    ps.setString(6, phone);
                   
                    
                    
                    if (Addradio1.isSelected()){
                        Gender = "M";
                    }
                    if(Addradio2.isSelected()){
                        Gender="F";
                    }
                    
                    ps.setString(7,Gender);
                   // ps.setString(8, svalue);
                    //svalue =AddComboBx.getSelectedItem().toString();
                    
                    String position;
                    position=AddComboBx.getSelectedItem().toString();
                    ps.setString(8,position);
                   
                    
                    ps.executeUpdate();
                    
                    LoginAuthentication LoginAu = new LoginAuthentication();
                    LoginAu.setVisible(true);
                    this.dispose();
                    
                    
                    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    model.setRowCount(0);
                    show_users();

                    Clear();
                 
                
            } catch (Exception ex) {
                System.err.println("Error :" + ex.getMessage());
            }
       }
       
    }//GEN-LAST:event_userAddBtnActionPerformed

      private void Clear(){
        SupplierID.setText(null);
        AddtxtName.setText(null);
        AddtxtNIC.setText(null);
        AddtxtAddress.setText(null);
        AddtxtDOB.setText(null);
        AddtxtPhone.setText(null);
        AddComboBx.setSelectedItem(null);
        buttonGroup2.clearSelection();
        SupplierID.requestFocus();
       }
    
      
    
    private void userUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userUpdateBtnActionPerformed
        // User Update button
        
        try{
       // int row = jTable1.getSelectedRow();
      //  String unique = (jTable1.getModel().getValueAt(row,0).toString());
      
                String id = SupplierID1.getText();
                String name = Nametxtbx.getText();
                String nic = NICtxtbx.getText();
                String address = Addresstxtbx.getText();
                String dob = DOBtxtbx.getText();
                String phone = PhoneNOtxtbx.getText();
               // String rd = Gender;
                String svalue = jComboBox1.getSelectedItem().toString();
                
                
      
                String sql = "UPDATE user_accounts SET Full_Name=?, NIC_No=?, Address=?, DOB=?, Phone_No=?, Gender=?, Position=? WHERE User_ID=?";
                ps = conn.prepareStatement(sql);
        
               
                    ps.setString(1, name);
                    ps.setString(2, nic);
                    ps.setString(3, address);
                    ps.setString(4, dob);
                    ps.setString(5, phone);
                    
                    
                    if(jRadioButton13.isSelected()){
                        Gender="M";
                    }
                    if(jRadioButton14.isSelected()){
                        Gender="F";
                    }
                    
                    ps.setString(6, Gender);
                    ps.setString(7, svalue);
                    ps.setString(8, id);
                  
        
                  //  show_users();
                    
                   // DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                   // model.setRowCount(0);
                    
                     ps.executeUpdate();
                        JOptionPane.showMessageDialog(this,"Supplier Updated Successfully!!!");
                        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                        model.setRowCount(0);
                        show_users();
                        UpClear();
                    
        
        }catch(Exception ex){
             System.err.println("Error :" + ex.getMessage());
        }
        
        
    }//GEN-LAST:event_userUpdateBtnActionPerformed

      private void UpClear(){
        SupplierID1.setText(null);
        Nametxtbx.setText(null);
        NICtxtbx.setText(null);
        Addresstxtbx.setText(null);
        DOBtxtbx.setText(null);
        PhoneNOtxtbx.setText(null);
        jComboBox1.setSelectedItem(null);
        buttonGroup2.clearSelection();
        SupplierID1.requestFocus();
       }
    
    private void Addradio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Addradio1ActionPerformed
        //Gender Male
       // Gender = "M";
        
    }//GEN-LAST:event_Addradio1ActionPerformed

    private void Addradio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Addradio2ActionPerformed
        // Gender Female
       // Gender = "F"; 
    }//GEN-LAST:event_Addradio2ActionPerformed

    private void DeleteSearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteSearchbtnActionPerformed
        // Delete Search
        
        try{
            String id = SupID.getText();
            String  sql = "Select * from user_accounts where User_ID=?";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            
            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst())
            {
            rs.next();
            txtName2.setText(rs.getString(2));
            txtNIC2.setText(rs.getString(3));
            txtAddress2.setText(rs.getString(4));
            txtDOB2.setText(rs.getString(5));
            txtPhone2.setText(rs.getString(6));
            String sex =rs.getString(7);
            if( sex.equals("M")){
            jRadioButton7.setSelected(true);
            }
            else{
                jRadioButton8.setSelected(true);
            }
            
            String pose=rs.getString("Position");
            switch(pose) {
                case "Manager":
                    jComboBox2.setSelectedIndex(0);
                    break;
                case "Store Keeper":
                    jComboBox2.setSelectedIndex(1);
                    break;
                case "Cashier/Accountant":
                    jComboBox2.setSelectedIndex(2);
                    break;
                
            }
           
        } else {
                JOptionPane.showMessageDialog(this,"Student Record Not Found");
                DeleteUser();
            }
            
        }catch(Exception ex){
            System.err.println("Error :"+ex.getMessage());
            
        }
    }                                         

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // Delete Button
        try{int row = jTable2.getSelectedRow();
        String value = (jTable2.getModel().getValueAt(row,0).toString());
        String sql= "DELETE FROM user_accounts WHERE Supplier_ID="+value;
        ps = conn.prepareStatement(sql);
        ps.executeUpdate();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        show_users();
        JOptionPane.showMessageDialog(null,"Deleted ");
        
            
        }catch(Exception ex){
            System.err.println("Error :"+ ex.getMessage());
        }
        
    }//GEN-LAST:event_DeleteSearchbtnActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // Search
       try{
            
            String  sql = "Select * from user_accounts where User_ID=?";
            ps = conn.prepareStatement(sql);
            String id = SupplierID3.getText();
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.isBeforeFirst())
            {
            rs.next();
          
            String userId =rs.getString("User_ID");
            SupplierID3.setText(userId);
            
            String name =rs.getString("Full_Name");
            txtName3.setText(name);
            
            String nic =rs.getString("NIC_No");
            txtNIC3.setText(nic);
            
            String address =rs.getString("Address");
            txtAddress3.setText(address);
            
            String dob =rs.getString("DOB");
            txtDOB3.setText(dob);
            
            String phone =rs.getString("Phone_No");
            txtPhone3.setText(phone);
            
            String sex =rs.getString("Gender");
            if( sex.equals("M")){
            jRadioButton9.setSelected(true);
            }
            else{
                jRadioButton10.setSelected(true);
            }
            
            String position=rs.getString("Position");
            switch(position) {
                case "Manager":
                    jComboBox6.setSelectedIndex(0);
                    break;
                case "Store Keeper":
                    jComboBox6.setSelectedIndex(1);
                    break;
                case "Cashier/Accountant":
                    jComboBox6.setSelectedIndex(2);
                    break;  }
           
           
        } else {
                JOptionPane.showMessageDialog(this,"Student Record Not Found");
                SearchUser();
            }
            
        }catch(Exception ex){
            System.err.println("Error :"+ex.getMessage());
            
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void SearchUser(){
        SupplierID3.setText(null);
        txtName3.setText(null);
        txtNIC3.setText(null);
        txtAddress3.setText(null);
        txtDOB3.setText(null);
        txtPhone3.setText(null);
        buttonGroup2.clearSelection();
        jComboBox6.setSelectedIndex(0);
        SupplierID3.requestFocus();
    }
    
    
    private void DeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebtnActionPerformed
        // Delete Button
        try{
            String id = SupID.getText();
        
            String sql= "DELETE FROM user_accounts WHERE User_ID=?";
            ps = conn.prepareStatement(sql);
        
            ps.setString(1,id);
        
        if (ps.executeUpdate()>0) {
            JOptionPane.showMessageDialog(null,"Record Deleted successfully!!! ");
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            show_users();
            
            DeleteUser();
            
            }
            
            }catch(Exception ex){
                System.err.println("Error :"+ ex.getMessage());
            }
        
    }//GEN-LAST:event_DeletebtnActionPerformed

    private void UpdateserachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateserachBtnActionPerformed
        // Update Search
          try{
            String id = SupplierID1.getText();
            String  sql = "Select * from user_accounts where User_ID=?";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            
            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst())
            {
            rs.next();
            Nametxtbx.setText(rs.getString(2));
            NICtxtbx.setText(rs.getString(3));
            Addresstxtbx.setText(rs.getString(4));
            DOBtxtbx.setText(rs.getString(5));
            PhoneNOtxtbx.setText(rs.getString(6));
            
            
            String sex =rs.getString(7);
            if( sex.equals("M")){
            jRadioButton13.setSelected(true);
            }
            else{
                jRadioButton14.setSelected(true);
            }
            
            String pose=rs.getString("Position");
            switch(pose) {
                case "Manager":
                    jComboBox1.setSelectedIndex(0);
                    break;
                case "Store Keeper":
                    jComboBox1.setSelectedIndex(1);
                    break;
                case "Cashier/Accountant":
                    jComboBox1.setSelectedIndex(2);
                    break; 
            }
           
        } else {
                JOptionPane.showMessageDialog(this,"Student Record Not Found");
                UpClear();
            }
            
        }catch(Exception ex){
            System.err.println("Error :"+ex.getMessage());
            
        }
    }//GEN-LAST:event_UpdateserachBtnActionPerformed

    private void DeleteUser(){
        SupID.setText(null);
        txtName2.setText(null);
        txtNIC2.setText(null);
        txtAddress2.setText(null);
        txtDOB2.setText(null);
        txtPhone2.setText(null);
        buttonGroup2.clearSelection();
        jComboBox2.setSelectedIndex(0);
        SupID.requestFocus();
    }
    
    private void jRadioButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton14ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // Supplier SERACH Button
        try{
            String sql = "SELECT * From suppliers WHERE Supplier_ID=?";
            ps = conn.prepareStatement(sql);
            String search=jTextField23.getText();
            ps.setString(1,search);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                String id=rs.getString("Supplier_ID");
                jTextField14.setText(id);

                String name=rs.getString("Supplier_Name");
                jTextField15.setText(name);

                String address = rs.getString("Address");
                jTextField16.setText(address);

                String gender=rs.getString("Gender");
                switch(gender){
                    case "Select Gender":
                    jComboBox5.setSelectedIndex(0);
                    break;
                    case "Male":
                    jComboBox5.setSelectedIndex(1);
                    break;
                    case "Female":
                    jComboBox5
                            .setSelectedIndex(2);
                    break;
                }

                String nic = rs.getString("NIC_No");
                jTextField18.setText(nic);

                String phone = rs.getString("Phone_No");
                jTextField17.setText(phone);

            } else {
                JOptionPane.showMessageDialog(this, "Supplier Details Not Found");
                SupplierViewSearch();
            }
            
            
        }catch(Exception ex){
        System.err.println("Error :" + ex.getMessage());
      
    }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void SupplierViewSearch(){
        jTextField23.setText(null);
        jTextField14.setText(null);
        jTextField15.setText(null);
        jTextField16.setText(null);
        jTextField17.setText(null);
        jTextField18.setText(null);
        jComboBox5.setSelectedIndex(0);
        jTextField23.requestFocus();
         
    }
    
    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // View All Req SEARCH Button
         try{
           String sql = "SELECT * FROM incoming_requests WHERE Requests_No=?";
           ps = conn.prepareStatement(sql);
           String search=jTextField4.getText();
           ps.setString(1,search);
           ResultSet rs= ps.executeQuery();
           
           if(rs.next()){
               String id=rs.getString("Requests_No");
               txrequestsNo.setText(id);
               
               String name=rs.getString("Item_Name");
               txname.setText(name);
               
               String category=rs.getString("Category");
               switch(category){
                    case "Select Category":
                       jcombobox.setSelectedIndex(0);
                       break;
                   case "Vegetables":
                       jcombobox.setSelectedIndex(1);
                       break;
                   case "Fruits":
                       jcombobox.setSelectedIndex(2);
                       break;
                   case "Leaf Varieties":
                       jcombobox.setSelectedIndex(3);
                       break;
               }
               
               String price = rs.getString("Unit_Price_Rs");
               txprice.setText(price);
               
               String quantity = rs.getString("Quantity");
               txquantity.setText(quantity);
               
               String companyname = rs.getString("Company_Name");
               txcompanyname.setText(companyname);
            
               String approval=rs.getString("Approval_Status");
               switch(approval){
                   case "None":
                       jComboBox7.setSelectedIndex(0);
                       break;
                   case "Approved":
                       jComboBox7.setSelectedIndex(1);
                       break;
                   case "Not Approved":
                           jComboBox7.setSelectedIndex(2);
                           break;
               }
              
            
           } else {
                JOptionPane.showMessageDialog(this, "Item Details Not Found");
               ViewAllReqSearch();
           }
            
        }catch(Exception ex){
           System.err.println("Error :" + ex.getMessage()); 
        }
      
    }//GEN-LAST:event_jButton23ActionPerformed

    private void ViewAllReqSearch(){
        jTextField4.setText(null);
        txrequestsNo.setText(null);
        txname.setText(null);
        txprice.setText(null);
        txquantity.setText(null);
        txcompanyname.setText(null);
        jcombobox.setSelectedIndex(0);
        jComboBox7.setSelectedIndex(0);
        jTextField4.requestFocus();
    }
    
    
      private void method(){
        
        DefaultTableModel model = (DefaultTableModel)jTable6.getModel();
        model.setRowCount(0);
        Req_Details();
        JOptionPane.showMessageDialog(null, " Succesfully ");
        
    }
    
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void stckshowbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stckshowbtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_stckshowbtnActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // Approval update
      /*
        String approval = jComboBox7.getSelectedItem().toString();
        
        switch(approval){
            case "Approved":
                methode1();
                //methode2();
                break;
           /*     
            case "Not Approved":
                //methode2();
                break;
                
            case "None":
               // methode2();
                break;
*/       // }
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void ReqUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReqUpdateActionPerformed
        // Update requests
     try{
             String sql = "UPDATE incoming_requests SET Item_Name=?, Category=?, Unit_Price_Rs=? , Quantity=?, Company_Name=?, Approval_Status=? WHERE Requests_No=?";
            
                    ps = conn.prepareStatement(sql);

                    String id = txrequestsNo.getText();
                    String name = txname.getText();
                    String category = jcombobox.getSelectedItem().toString();
                    int price = Integer.parseInt(txprice.getText());
                    int quantity = Integer.parseInt(txquantity.getText());
                    String companyname = txcompanyname.getText();
                    String approval = jComboBox7.getSelectedItem().toString();
                
                    ps.setString(1, name);
                    ps.setString(2, category);
                    ps.setInt(3, price);
                    ps.setInt(4, quantity);
                    ps.setString(5,companyname);
                    ps.setString(6,approval);
                    ps.setString(7, id);
               
                   
                    if(ps.executeUpdate()>0){
                        DefaultTableModel model= (DefaultTableModel)jTable5.getModel();
                        model.setRowCount(0);
                        Req_Details();
                        JOptionPane.showMessageDialog(this,"Items Updated Successfully!!!"); 
                      
                        
                         String approval1 = jComboBox7.getSelectedItem().toString();
        
                        switch(approval1){
                            case "Approved":
                                methode1();
                                //methode2();
                                break;
                                
                            case "Not Approved":
                                DeleteBtn();
                                break;
                                
                            case "None":
                                DeleteBtn();
                                break;        
                                }
                        
                        ViewAllReqSearch();
                        }
                  
        } catch(Exception ex){
            System.err.println("Error :" + ex.getMessage());
        }
    }//GEN-LAST:event_ReqUpdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Approve Req DELETE Button
        ///*****************************************
         try{
            String id = jTextField30.getText();
        
        String sql= "DELETE FROM approve_requests WHERE Requests_No=?";
        ps = conn.prepareStatement(sql);
        
        ps.setString(1,id);
        
        if (ps.executeUpdate()>0) {
            JOptionPane.showMessageDialog(null,"Record Deleted successfully!!! ");
            DefaultTableModel model=(DefaultTableModel)jTable6.getModel();
            model.setRowCount(0);
            Approve_Requests();
            
            ApproveReqClear();
         }
            
        }catch(Exception ex){
            System.err.println("Error :"+ ex.getMessage());
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ApproveReqClear(){
        jTextField5.setText(null);
        jTextField30.setText(null);
        jTextField31.setText(null);
        jTextField33.setText(null);
        jTextField34.setText(null);
        jcombobox1.setSelectedIndex(0);
        jComboBox8.setSelectedIndex(0);
        jTextField5.requestFocus();
    }
    
    private void DeleteBtn(){
          try{
            String id = txrequestsNo.getText();
        
        String sql= "DELETE FROM approve_requests WHERE Requests_No=?";
        ps = conn.prepareStatement(sql);
        
        ps.setString(1,id);
        
        if (ps.executeUpdate()>0) {
            JOptionPane.showMessageDialog(null,"Record Remove From Approval List Successfully!!! ");
            DefaultTableModel model=(DefaultTableModel)jTable6.getModel();
            model.setRowCount(0);
            Approve_Requests();
            
            ApproveReqClear();
         }
            
        }catch(Exception ex){
            System.err.println("Error :"+ ex.getMessage());
        }
    }
    
    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // View All Approved SEARCH BUTTON
        
        try{
           String sql = "SELECT * FROM approve_requests WHERE Requests_No=?";
           ps = conn.prepareStatement(sql);
           String search=jTextField5.getText();
           ps.setString(1,search);
           ResultSet rs= ps.executeQuery();
           
           if(rs.next()){
               String reqNo=rs.getString("Requests_No");
               jTextField30.setText(reqNo);
               
               String name=rs.getString("Item_Name");
               jTextField31.setText(name);
               
               String category=rs.getString("Category");
               switch(category){
                    case "Select Category":
                       jcombobox1.setSelectedIndex(0);
                       break;
                   case "Vegetables":
                       jcombobox1.setSelectedIndex(1);
                       break;
                   case "Fruits":
                       jcombobox1.setSelectedIndex(2);
                       break;
                   case "Leaf Varieties":
                       jcombobox1.setSelectedIndex(3);
                       break;
               }
               
               String price = rs.getString("Unit_Price_Rs");
               jTextField33.setText(price);
               
               String quantity = rs.getString("Quantity");
               jTextField34.setText(quantity);
               
               String companyname = rs.getString("Company_Name");
               jTextField35.setText(companyname);
            
               String approval=rs.getString("Approval_Status");
               switch(approval){
                   case "None":
                       jComboBox8.setSelectedIndex(0);
                       break;
                   case "Approved":
                       jComboBox8.setSelectedIndex(1);
                       break;
                   case "Not Approved":
                           jComboBox8.setSelectedIndex(2);
                           break;
               }
              
            
           } else {
                JOptionPane.showMessageDialog(this, "Item Details Not Found");
               // ClearDelete();
           }
            
        }catch(Exception ex){
           System.err.println("Error :" + ex.getMessage()); 
        }
        
        
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // View Stock Details SEARCH Button
        try{
            String sql = "SELECT * FROM store_items WHERE Item_Id=?";
            ps = conn.prepareStatement(sql);

            String search = jTextField21.getText();
            ps.setString(1, search);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                String id=rs.getString("Item_Id");
                jTextField6.setText(id);

                String name= rs.getString("Item_Name");
                jTextField8.setText(name);

                String category=rs.getString("Category");
                switch(category){
                    case "Select Category":
                    jComboBox3.setSelectedIndex(0);
                    break;
                    case "Vegetables":
                    jComboBox3.setSelectedIndex(1);
                    break;
                    case "Fruits":
                    jComboBox3.setSelectedIndex(2);
                    break;
                    case "Leaf Varieties":
                    jComboBox3.setSelectedIndex(3);
                    break;
                }

                String quantity = rs.getString("Quantity");
                jTextField12.setText(quantity);
            } else {
                JOptionPane.showMessageDialog(this, "Item Details Not Found");
                StockSearchClear();
            }

        }catch(Exception ex){
            System.err.println("Error :" +ex.getMessage());
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void StockSearchClear(){
        jTextField21.setText(null);
        jTextField6.setText(null);
        jTextField8.setText(null);
        jComboBox3.setSelectedIndex(0);
        jTextField12.setText(null);
        jTextField21.requestFocus();
    }
    
    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

  
    private void methode1(){
        try {
                
                    String sql = "INSERT INTO approve_requests VALUES (?,?,?,?,?,?,?)";
                    ps = conn.prepareStatement(sql);

                    String id = txrequestsNo.getText();
                    String name = txname.getText();
                    String category = jcombobox.getSelectedItem().toString();
                    int price = Integer.parseInt(txprice.getText());
                    int quantity = Integer.parseInt(txquantity.getText());
                    String companyname = txcompanyname.getText();
                    String approvalST = jComboBox7.getSelectedItem().toString();
                
                    
                    ps.setString(1, id);
                    ps.setString(2, name);
                    ps.setString(3, category);
                    ps.setInt(4, price);
                    ps.setInt(5, quantity);
                    ps.setString(6, companyname);
                    ps.setString(7,approvalST);
               
                    if(ps.executeUpdate()>0){
                       DefaultTableModel model= (DefaultTableModel)jTable6.getModel();
                       model.setRowCount(0);
                       Approve_Requests();
                       JOptionPane.showMessageDialog(this,"Request Details Added Successfully!!!");
                    }

            
            } catch (Exception ex) {
                System.err.println("Error :" + ex.getMessage());
            }
    }
    
    
    private void methode2(){
       
        try{
      
            
                String sql = "UPDATE incoming_requests SET Item_Name=?, Category=?, Unit_Price_Rs=?, Quantity=?, Company_Name=?, Approval_Status=? WHERE Requests_No=?";
                ps = conn.prepareStatement(sql);
               
                   
      
  ////////////////////////////////////////////////////////////////      
               
                    ps.setString(1,txname.getText());
                    
                    String category;
                    category=jcombobox.getSelectedItem().toString();
                    ps.setString(2,category);
                    
                    ps.setInt(3,Integer.parseInt(txprice.getText()));
                    ps.setInt(4, Integer.parseInt(txquantity.getText()));
                    ps.setString(5,txcompanyname.getText());
                    
                    String approvalST;
                    approvalST= jComboBox7.getSelectedItem().toString();
                    ps.setString(6,approvalST);
                    
                    ps.setString(7,txrequestsNo.getText());
                    
                    
                    
                    
                    
                    ///////////////////////////////////////////////////////
                   
        
                  //  show_users();
                    
                   // DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                   // model.setRowCount(0);
                    
                     if(ps.executeUpdate()>0){
                        
                       DefaultTableModel model=(DefaultTableModel)jTable5.getModel();
                       model.setRowCount(0);
                       Req_Details();
                       JOptionPane.showMessageDialog(this,"Requests Details Updated Successfully!!!");
                       
                       
                       
                        //Clear();
                    }
        
        }catch(Exception ex){
             System.err.println("Error :" + ex.getMessage());
        }
        
    }
            
    
    
     
       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerManager().setVisible(true);
            }
        });
    }

     
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AddComboBx;
    private javax.swing.JRadioButton Addradio1;
    private javax.swing.JRadioButton Addradio2;
    private javax.swing.JTextField Addresstxtbx;
    private javax.swing.JTextField AddtxtAddress;
    private javax.swing.JTextField AddtxtDOB;
    private javax.swing.JTextField AddtxtNIC;
    private javax.swing.JTextField AddtxtName;
    private javax.swing.JTextField AddtxtPhone;
    private javax.swing.JPanel CreatejPanel10;
    private javax.swing.JTextField DOBtxtbx;
    private javax.swing.JButton DeleteSearchbtn;
    private javax.swing.JButton Deletebtn;
    private javax.swing.JPanel DeletejPanel12;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JPanel ManageUserAccounts;
    private javax.swing.JTextField NICtxtbx;
    private javax.swing.JTextField Nametxtbx;
    private javax.swing.JPanel PanelRegister1;
    private javax.swing.JPanel PanelRegister2;
    private javax.swing.JPanel PanelRegister3;
    private javax.swing.JPanel PanelRegister4;
    private javax.swing.JTextField PhoneNOtxtbx;
    private javax.swing.JButton ReqUpdate;
    private javax.swing.JPanel Requests;
    private javax.swing.JPanel SearchjPanel13;
    private javax.swing.JTextField SupID;
    private javax.swing.JTextField SupplierID;
    private javax.swing.JTextField SupplierID1;
    private javax.swing.JTextField SupplierID3;
    private javax.swing.JPanel UpdatejPanel11;
    private javax.swing.JButton UpdateserachBtn;
    private javax.swing.JPanel ViewAlljPanel18;
    private javax.swing.JPanel ViewApprovedReqjPanel40;
    private javax.swing.JPanel ViewRequestjPanel39;
    private javax.swing.JPanel ViewSalesDetails;
    private javax.swing.JPanel ViewStockDetails;
    private javax.swing.JPanel ViewSuppliers;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTableSales;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JComboBox<String> jcombobox;
    private javax.swing.JComboBox<String> jcombobox1;
    private javax.swing.JLabel lblAddress1;
    private javax.swing.JLabel lblAddress2;
    private javax.swing.JLabel lblAddress3;
    private javax.swing.JLabel lblAddress4;
    private javax.swing.JLabel lblDOB1;
    private javax.swing.JLabel lblDOB2;
    private javax.swing.JLabel lblDOB3;
    private javax.swing.JLabel lblDOB4;
    private javax.swing.JLabel lblNIC1;
    private javax.swing.JLabel lblNIC2;
    private javax.swing.JLabel lblNIC3;
    private javax.swing.JLabel lblNIC4;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblName3;
    private javax.swing.JLabel lblName4;
    private javax.swing.JLabel lblName5;
    private javax.swing.JLabel lblName6;
    private javax.swing.JLabel lblName7;
    private javax.swing.JLabel lblName8;
    private javax.swing.JLabel lblPhone1;
    private javax.swing.JLabel lblPhone10;
    private javax.swing.JLabel lblPhone11;
    private javax.swing.JLabel lblPhone12;
    private javax.swing.JLabel lblPhone2;
    private javax.swing.JLabel lblPhone3;
    private javax.swing.JLabel lblPhone4;
    private javax.swing.JLabel lblPhone5;
    private javax.swing.JLabel lblPhone6;
    private javax.swing.JLabel lblPhone7;
    private javax.swing.JLabel lblPhone8;
    private javax.swing.JLabel lblPhone9;
    private javax.swing.JButton searchStock;
    private javax.swing.JButton stckshowbtn;
    private javax.swing.JTextField txcompanyname;
    private javax.swing.JTextField txname;
    private javax.swing.JTextField txprice;
    private javax.swing.JTextField txquantity;
    private javax.swing.JTextField txrequestsNo;
    private javax.swing.JTextField txtAddress2;
    private javax.swing.JTextField txtAddress3;
    private javax.swing.JTextField txtDOB2;
    private javax.swing.JTextField txtDOB3;
    private javax.swing.JTextField txtNIC2;
    private javax.swing.JTextField txtNIC3;
    private javax.swing.JTextField txtName2;
    private javax.swing.JTextField txtName3;
    private javax.swing.JTextField txtPhone2;
    private javax.swing.JTextField txtPhone3;
    private javax.swing.JButton userAddBtn;
    private javax.swing.JButton userUpdateBtn;
    // End of variables declaration//GEN-END:variables

}
