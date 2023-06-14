using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using BusinessLayer;


namespace ThirdLayerArchitecture
{
    public partial class CategoryMange : Form
    {
        public CategoryMange()
        {
            InitializeComponent();
        }


        private void CategoryMange_Load(object sender, EventArgs e)
        {
            textBox49.Hide();
            textBox50.Hide();

            textBox30.Hide();
            textBox31.Hide();
        }

        private void tabPage1_Click(object sender, EventArgs e)
        {
            Category cate = new Category();
            dataGridView1.DataSource = cate.searchAllcate().Tables[0];
        }

        private void editAvailableStock()
        {
            try
            {
                Flowers flow = new Flowers();
                flow.fcode = (Convert.ToInt32(textBox19.Text));
                flow.fstock = (Convert.ToInt32(textBox17.Text));
                if (flow.editAvailable() > 0)
                {
                    MessageBox.Show("Record Updated!", "UPDATE");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error :" + ex.Message);
            }
            finally
            {
                //  clear();
            }
        }


        private void EditOrderBtn_Click(object sender, EventArgs e)
        {
            try
            { 
                if ((textBox12.Text != "") && (textBox13.Text != "") && (textBox14.Text != "") && (textBox18.Text != ""))
                {


                    Order ord = new Order();
                    ord.custName = textBox7.Text;
                    ord.custTP = textBox29.Text;
                    ord.fcode = (Convert.ToInt32(textBox19.Text));
                    ord.fname = textBox13.Text;
                    ord.fcategory = textBox14.Text;
                    ord.orderQuantity = (Convert.ToInt32(textBox18.Text));
                    ord.orderNo = (Convert.ToInt32(textBox12.Text));
                    if (ord.updateOrder() > 0)
                    {
                        MessageBox.Show("Record Updated!", "UPDATE");

                    }
                    editAvailableStock();
                }
                else
                {
                    MessageBox.Show("You can't click Button without fill all fields!!!","TRY AGAIN!");
                }
            }

            catch (Exception ex)
            {
                MessageBox.Show("Error :" + ex.Message);
            }
            finally
            {
                clearOrder();
            }
        }
        private void clearOrder()
        {
            textBox12.Clear();
            textBox13.Clear();
            textBox14.Clear();
            textBox15.Clear();
            textBox16.Clear();
            textBox17.Clear();
            textBox18.Clear();
            textBox19.Clear();
            textBox12.Focus();
            
        }

        private void AddUserBtn_Click(object sender, EventArgs e)
        {
            
            if ((textBox8.Text != "") && (textBox9.Text != "") && (textBox10.Text != "") && (textBox11.Text != ""))
            {
                User us = new User();
                us.nic = textBox9.Text;
                if (us.userNameSearch())
                {
                   
                    MessageBox.Show("This User's details are already included here.", "WARNING!");
                    clear();
                }
                else
                {
                    try
                    {
                        us.uname = textBox8.Text;
                        us.nic = textBox9.Text;
                        us.luser = textBox10.Text;
                        us.lpass = textBox11.Text;
                        if (us.addUser() > 0)
                        {
                            MessageBox.Show("User Details Inserted!", "Add");
                            dataGridView4.DataSource = us.searchAllUser().Tables[0];
                        }
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show("Error : " + ex.Message);
                    }
                    finally
                    {
                        clear();
                    }
                }
            }
            else
            {
                MessageBox.Show("You can't click Button without fill all fields!!!","WARNING!");
            }
        }

        private void clear()
        {
            textBox8.Clear();
            textBox9.Clear();
            textBox10.Clear();
            textBox11.Clear();
            textBox8.Focus();
        }

        private void DeleteUserBtn_Click(object sender, EventArgs e)
        {
            try
            {
                if ((textBox24.Text != "") && (textBox25.Text != "") && (textBox26.Text != "") && (textBox27.Text != "") && (textBox28.Text != ""))
                {
                    User us = new User();
                    us.uid = (Convert.ToInt32(textBox28.Text));
                    if (us.deleteUser() > 0)
                    {
                        MessageBox.Show("Record Deleted!", "DELETE");
                        dataGridView4.DataSource = us.searchAllUser().Tables[0];
                    }
                }
                else
                {
                    MessageBox.Show("You can't click Button without fill all fields!!!","WARNING!");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error : " + ex.Message);
            }
            finally
            {
                textBox24.Clear();
                textBox25.Clear();
                textBox26.Clear();
                textBox27.Clear();
                textBox28.Clear();
                textBox28.Focus();
            }
        }


        private void addCategoryBtn_Click(object sender, EventArgs e)
        {
            if (textBox2.Text != "")
            {

                Category cate = new Category();
                cate.catename = textBox2.Text;
                if (cate.categoryNameSearch())
                {
                    MessageBox.Show("This Category Name is Already there","TRY AGAIN!");
                    textBox2.Clear();
                }
                else
                {
                    try
                    {
                        cate.catename = textBox2.Text;
                        if (cate.addCate() > 0)
                        {
                            MessageBox.Show("Category Details Inserted!", "Add");
                            dataGridView1.DataSource = cate.searchAllcate().Tables[0];
                        }
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show("Error : " + ex.Message);
                    }
                    finally
                    {
                        textBox2.Clear();
                        textBox2.Focus();
                    }
                }
            }
            else

            {
                MessageBox.Show("You can't click ADD without fill the field!!!","WARNING!");
            }
        }


        private void UpdateFlowerBtn_Click(object sender, EventArgs e)
        {
            try
            {
                if ((textBox20.Text != "") && (textBox21.Text != "") && (textBox3.Text != "") )
                {
                    Flowers flow = new Flowers();
                    flow.fcode = (Convert.ToInt32(textBox21.Text));
                    flow.fname = textBox20.Text;
                    flow.fstock = (Convert.ToInt32(textBox3.Text));
                    if (flow.updateFlow() > 0)
                    {
                        MessageBox.Show("Record Updated!", "UPDATE");
                        dataGridView2.DataSource = flow.searchAllFlow().Tables[0];
                    }
                }
                else
                {
                    MessageBox.Show("You Can't click Button without Fill All Fields!!!","WARNING!");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error :" + ex.Message);
            }
            finally
            {
                textBox21.Clear();
                textBox20.Clear();
                textBox3.Clear();

            }
        }

        private void DeleteFlowerBtn_Click(object sender, EventArgs e)
        {
            try
            {
                if ((textBox20.Text != "") && (textBox21.Text != "") && (textBox3.Text != ""))
                {


                    Flowers flow = new Flowers();
                    flow.fcode = (Convert.ToInt32(textBox21.Text));
                    if (flow.deleteFlow() > 0)
                    {
                        MessageBox.Show("Flower Record Deleted!", "DELETE");
                        dataGridView2.DataSource = flow.searchAllFlow().Tables[0];
                    }
                }
                else
                {
                    MessageBox.Show("You Can't click Button without Fill All Fields!!!","WARNING!");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error : " + ex.Message);
            }
            finally
            {
                textBox21.Clear();
                textBox3.Clear();
                textBox20.Clear();
            }
        }
        private void clearFlow()
        {
            textBox3.Clear();
            textBox4.Clear();
            textBox5.Clear();
            textBox6.Clear();
            textBox3.Focus();

        }

        private void textBox12_TextChanged(object sender, EventArgs e)
        {
        if (textBox12.Text != "")
            {
                try
                {
                    Order ord = new Order();
                    ord.orderNo = (Convert.ToInt32(textBox12.Text));
                    if (ord.orderTextChangedDelete())
                    {
                        textBox7.Text = ord.custName;
                        textBox29.Text = ord.custTP;
                        textBox19.Text = ord.fcode.ToString();
                        textBox15.Text = ord.orderQuantity.ToString();
                        textBox13.Text = ord.fname;
                        textBox14.Text = ord.fcategory;
                        textBox32.Text = ord.catecode.ToString();
                    }
                    else
                    {
                        textBox7.Clear();
                        textBox29.Clear();
                        textBox13.Clear();
                        textBox14.Clear();
                        textBox19.Clear();
                        textBox15.Clear();
                        textBox16.Clear();
                        textBox32.Clear();
                    }
                }
                catch (Exception)
                {
                    
                }
            }
            else
            {
                textBox7.Clear();
                textBox29.Clear();
                textBox12.Clear();
                textBox13.Clear();
                textBox14.Clear();
                textBox19.Clear();
                textBox15.Clear();
                textBox16.Clear();
                textBox32.Clear();

            }

        }

        private void textBox19_TextChanged(object sender, EventArgs e)
        {
            try
            {if (textBox19.Text != "")
                {
                    textBox16.Show();
                    textBox17.Hide();
                    Flowers flow = new Flowers();
                    flow.fcode = (Convert.ToInt32(textBox19.Text));
                    if (flow.orderStoreValueFlowerCode())
                    {
                        textBox16.Text = flow.fstock.ToString();
                    }

                    else
                    {
                        textBox16.Clear();
                    }
                }
                else
                {
                    textBox16.Clear();
                }
            }
            catch (Exception)
            {
                
            }
        }

        private void textBox18_TextChanged(object sender, EventArgs e)
        {
            try
            {
               
                if (textBox18.Text != "")
                {
                    
                    textBox17.Text = (float.Parse(textBox16.Text) + (float.Parse(textBox15.Text) - float.Parse(textBox18.Text))).ToString();
                    textBox16.Hide();
                    textBox17.Show();

                }
                else
                {

                    textBox17.Hide();
                    textBox16.Show();
                }
            }
            catch (Exception)
            {
               // MessageBox.Show("Error : " + ex.Message);
            }
        }

        private void tabPage5_Click(object sender, EventArgs e)
        {
            Flowers flow = new Flowers();
            dataGridView2.DataSource = flow.searchAllFlow().Tables[0];
        }

        private void button1_Click(object sender, EventArgs e)
        {
            tabPage1.Show();
            tabPage2.Hide();
            tabPage4.Hide();
            tabPage5.Hide();
            tabPage3.Hide();
            tabPage6.Hide();
            tabPage7.Hide();

            Category cate = new Category();
            dataGridView1.DataSource = cate.searchAllcate().Tables[0];

            panel5.Height = button1.Height;
            panel5.Top = button1.Top;
            panel5.Left = button1.Left;
            button1.BackColor = Color.FromArgb(64,64,64);

        }

        private void button2_Click(object sender, EventArgs e)
        {
            tabPage2.Show();
            tabPage1.Hide();
            tabPage4.Hide();
            tabPage5.Hide();
            tabPage3.Hide();
            tabPage6.Hide();
            tabPage7.Hide();

            Category cate = new Category();
            dataGridView5.DataSource = cate.searchAllcate().Tables[0];

            panel5.Height = button2.Height;
            panel5.Top = button2.Top;
            panel5.Left = button2.Left;
            button2.BackColor = Color.FromArgb(64, 64, 64);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            tabPage3.Show();
            tabPage2.Hide();
            tabPage1.Hide();
            tabPage5.Hide();
            tabPage4.Hide();
            tabPage6.Hide();
            tabPage7.Hide();

            Flowers flow = new Flowers();
            dataGridView2.DataSource = flow.searchAllFlow().Tables[0];

            panel5.Height = button3.Height;
            panel5.Top = button3.Top;
            panel5.Left = button3.Left;
            button3.BackColor = Color.FromArgb(64, 64, 64);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            tabPage7.Show();
            tabPage2.Hide();
            tabPage5.Hide();
            tabPage1.Hide();
            tabPage3.Hide();
            tabPage6.Hide();
            tabPage4.Hide();

            Order ord = new Order();
            dataGridView6.DataSource = ord.searchAllOrder().Tables[0];

            //Flowers flow = new Flowers();

            panel5.Height = button4.Height;
            panel5.Top = button4.Top;
            panel5.Left = button4.Left;
            button4.BackColor = Color.FromArgb(64, 64, 64);
        }

        private void button5_Click(object sender, EventArgs e)
        {
            tabPage4.Show();
            tabPage2.Hide();
            tabPage7.Hide();
            tabPage3.Hide();
            tabPage1.Hide();
            tabPage6.Hide();
            tabPage5.Hide();

            Order ord = new Order();
            dataGridView6.DataSource = ord.searchAllOrder().Tables[0];

            panel5.Height = button5.Height;
            panel5.Top = button5.Top;
            panel5.Left = button5.Left;
            button5.BackColor = Color.FromArgb(64, 64, 64);
        }

        private void textBox1_TextChanged_1(object sender, EventArgs e)
        {
            if (textBox1.Text != "")
            {

                try
                {
                    Category cate = new Category();
                    cate.catecode = (Convert.ToInt32(textBox1.Text));
                    if (cate.searchCategory())
                    {
                        textBox5.Text = cate.catename;
                        
                    }
                    else
                    {
                        textBox5.Clear();
                    }
                }
                catch (Exception)
                {
                   
                }
            }
            else
            {
                textBox1.Clear();
                textBox5.Clear();
            }
        }

        private void AddFlowerBtn_Click(object sender, EventArgs e)
        {
            if ((textBox1.Text != "") && (textBox4.Text != "") && (textBox6.Text != "") && (textBox5.Text != ""))
            {
                if (textBox30.Text !="") //Hidden Textbox (Store Quantity)
                {

                    Flowers flow = new Flowers();
                    flow.fstock = (Convert.ToInt32(textBox31.Text));
                    flow.fname = textBox4.Text;
                    if (flow.updateFlowName() > 0)
                    {
                       MessageBox.Show("Updated!");
                    }
                }
                else
                {
                    try
                    {
                        Flowers flow = new Flowers();
                        flow.fname = textBox4.Text;
                        flow.fcategory = textBox5.Text;
                        flow.fstock = (Convert.ToInt32(textBox6.Text));
                        flow.catecode = (Convert.ToInt32(textBox1.Text));
                        if (flow.addFlow() > 0)
                        {
                            MessageBox.Show("Flower Details Inserted!", "Add");
                        }

                    }
                    catch (Exception)
                    {
                        
                    }
                    finally
                    {
                        textBox1.Clear();
                        textBox3.Clear();
                        textBox4.Clear();
                        textBox5.Clear();
                        textBox6.Clear();
                        textBox1.Focus();
                    }
                }
            }
            else
            {
                MessageBox.Show("You can't click ADD without fill all fields!!!","WARNING!");
            }
        }

        private void textBox21_TextChanged(object sender, EventArgs e)
        {
            if (textBox21.Text != "")
            {
                try
                {
                    Flowers flow = new Flowers();
                    flow.fcode = (Convert.ToInt32(textBox21.Text));
                    if (flow.searchFlow())
                    {
                        textBox20.Text = flow.fname;
                        textBox3.Text = flow.fstock.ToString();
                    }
                  
                }
                catch (Exception)
                {
                    
                }
            }
            else
            {
                textBox21.Clear();
                textBox20.Clear();
                textBox3.Clear();
            }
        }

        private void textBox23_TextChanged(object sender, EventArgs e)
        {
            if (textBox23.Text != "")
            {
                try
                {
                    Category cate = new Category();
                    cate.catecode = (Convert.ToInt32(textBox23.Text));
                    if (cate.searchCategory())
                    {
                        textBox22.Text = cate.catename;
                    }
                }
                catch (Exception)
                {
                   
                }
            }
            else
            {
                textBox23.Clear();
                textBox22.Clear();
            }
        }

        private void updateCategoryBtn_Click_1(object sender, EventArgs e)
        {
            try
            {
                if ((textBox22.Text != "") && (textBox23.Text != "")) 
                
                {
                    Category cate = new Category();
                    cate.catecode = (Convert.ToInt32(textBox23.Text));
                    cate.catename = textBox22.Text;
                    if (cate.updateCate() > 0)
                    {
                        MessageBox.Show("Record Updated!", "UPDATE");

                        UpdateSelectedValue();
                        dataGridView5.DataSource = cate.searchAllcate().Tables[0];
                    }
                }
                else
                {
                     MessageBox.Show("You Can't click Button without Fill All Fields!!!","WARNING!");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error :" + ex.Message);
            }
            finally
            {
                textBox23.Clear();
                textBox22.Clear();
            }
        }

        private void UpdateSelectedValue()
        {
            try
            {
                Flowers flow = new Flowers();
                flow.catecode = (Convert.ToInt32(textBox23.Text));
                flow.catename = textBox22.Text;

                if (flow.updateSelectedValue() > 0)
                {
                    MessageBox.Show("Record Updated!", "UPDATE");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error :" + ex.Message);
            }
            finally
            {
               
            }
        }

        private void deleteCategoryBtn_Click(object sender, EventArgs e)
        {
            
            try
                
            {
                if ((textBox22.Text != "") && (textBox23.Text != ""))

                {
                    Category cate = new Category();
                    cate.catecode = (Convert.ToInt32(textBox23.Text));
                    if (cate.deleteCate() > 0)
                    {
                        MessageBox.Show("Category Record Deleted!", "DELETE");
                        deleteSelectedCategory();
                        dataGridView5.DataSource = cate.searchAllcate().Tables[0];
                    }
                }
                else
                {
                    MessageBox.Show("You Can't click Button without Fill All Fields!!!","WARNING!");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error : " + ex.Message);
            }
            finally
            {
                textBox23.Clear();
                textBox22.Clear();
                textBox22.Focus();
            }
        }

        private void deleteSelectedCategory()
        {

            try
            {
                Flowers flow = new Flowers();
                flow.catecode = (Convert.ToInt32(textBox23.Text));
                if (flow.deleteSelectedCate() > 0)
                {
                    MessageBox.Show("Category Record Deleted!", "DELETE");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error : " + ex.Message);
            }
            finally
            {

            }
        }

        private void textBox28_TextChanged(object sender, EventArgs e)
        {
            if (textBox28.Text != "")
            {

                try
                {
                    User us = new User();
                    us.uid = (Convert.ToInt32(textBox28.Text));
                    if (us.userDetails())
                    {
                        textBox27.Text = us.uname;
                        textBox26.Text = us.nic;
                        textBox25.Text = us.luser;
                        textBox24.Text = us.lpass;
                    }
                    else
                    {
                        textBox27.Clear();
                        textBox26.Clear();
                        textBox25.Clear();
                        textBox24.Clear();
                    }
                }
                catch (Exception)
                {
                   
                }
            }
            else
            {
                textBox28.Clear();
                textBox27.Clear();
                textBox26.Clear();
                textBox25.Clear();
                textBox24.Clear();
            }
        }

        private void UpdateUserBtn_Click(object sender, EventArgs e)
        {
            try
            {
                if ((textBox24.Text != "") && (textBox25.Text != "") && (textBox26.Text != "") && (textBox27.Text != "") && (textBox28.Text != ""))
                {
                    User us = new User();
                    us.uid = (Convert.ToInt32(textBox28.Text));
                    us.uname = textBox27.Text;
                    us.nic = textBox26.Text;
                    us.luser = textBox25.Text;
                    us.lpass = textBox24.Text;

                    if (us.updateUser() > 0)
                    {
                        MessageBox.Show("Record Updated!", "UPDATE");
                        dataGridView4.DataSource = us.searchAllUser().Tables[0];
                    }
                }
                else
                {
                    MessageBox.Show("You Can't click Button without Fill All Fields!!!","WARNING!");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error :" + ex.Message);
            }
            finally
            {
                textBox28.Clear();
                textBox27.Clear();
                textBox26.Clear();
                textBox25.Clear();
                textBox24.Clear();
                textBox28.Focus();
            }
        }

        private void DELETEELete()
        {
            try
            {
                if (textBox50.Text == "")
                {
                    try
                    {
                        Flowers flow = new Flowers();
                        flow.fname = textBox44.Text;
                        flow.fcategory = textBox46.Text;
                        flow.fstock = (Convert.ToInt32(textBox45.Text));
                        flow.catecode = (Convert.ToInt32(textBox48.Text));
                        if (flow.addFlow() > 0)
                        {
                            MessageBox.Show("Deleted Flower Details Inserted Again!", "Add");
                        }
                       
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show("Error : " + ex.Message);
                    }
                    finally
                    {
                    
                    }
                }
                else
                {
                    try
                    {
                        textBox49.Text = (float.Parse(textBox50.Text) + (float.Parse(textBox45.Text))).ToString();

                        Flowers flow = new Flowers();
                        flow.fcode = (Convert.ToInt32(textBox47.Text));
                        flow.fstock = (Convert.ToInt32(textBox49.Text));
                        if (flow.editAvailable() > 0)
                        {
                            MessageBox.Show("Record Updated!", "UPDATE");
                        }
                        
                    }
                    catch (Exception)
                    {

                    }
                   
                }
            }
            catch (Exception)
            {

            }
        }

        private void textBox41_TextChanged(object sender, EventArgs e)
        {
            try
            {
                Flowers flow = new Flowers();
                flow.fcategory = textBox41.Text;
                dataGridView2.DataSource = flow.LetterSearchCate();
                
            }
            catch(Exception)
            {

            }
        }

        private void button1_Leave(object sender, EventArgs e)
        {
            button1.BackColor = Color.FromArgb(24,30,54);
        }

        private void button2_Leave(object sender, EventArgs e)
        {
            button2.BackColor = Color.FromArgb(24,30,54);
        }

        private void button3_Leave(object sender, EventArgs e)
        {
            button3.BackColor = Color.FromArgb(24, 30, 54);
        }

        private void button4_Leave(object sender, EventArgs e)
        {
            button4.BackColor = Color.FromArgb(24, 30, 54);
        }

        private void button5_Leave(object sender, EventArgs e)
        {
            button5.BackColor = Color.FromArgb(24, 30, 54);
        }

        private void button6_Leave(object sender, EventArgs e)
        {
            button6.BackColor = Color.FromArgb(24, 30, 54);
        }

        private void button6_Click(object sender, EventArgs e)
        {

            tabPage8.Show();
            tabPage2.Hide();
            tabPage4.Hide();
            tabPage1.Hide();
            tabPage3.Hide();
            tabPage6.Hide();
            tabPage7.Hide();
            tabPage5.Hide();

            AcceptedOrders accOrd = new AcceptedOrders();
            dataGridView7.DataSource = accOrd.searchAllAccept().Tables[0];

            panel5.Height = button6.Height;
            panel5.Top = button6.Top;
            panel5.Left = button6.Left;
            button6.BackColor = Color.FromArgb(64, 64, 64);
        }

        private void textBox27_MouseClick(object sender, MouseEventArgs e)
        {
            try
            {
                User us = new User();
                us.uid = (Convert.ToInt32(textBox28.Text));
                if (us.userDetails())
                {
                    textBox27.Text = us.uname;
                    textBox26.Text = us.nic;
                    textBox25.Text = us.luser;
                    textBox24.Text = us.lpass;
                }

                else
                {
                    MessageBox.Show("Invalid User ID. Please Check again!!!","TRY AGAIN!");
                    textBox28.Clear();
                    textBox28.Focus();

                }
            }
            catch (Exception)
            {

            }
            
        }

        private void textBox22_MouseClick(object sender, MouseEventArgs e)
        {
            try
            {
                Category cate = new Category();
                cate.catecode = (Convert.ToInt32(textBox23.Text));
                if (cate.searchCategory())
                {
                    textBox22.Text = cate.catename;
                }
                else
                {
                     MessageBox.Show("Invalid category Id, Please Try Again !!!","TRY AGAIN!");
                     textBox23.Clear();
                }
            }
            catch (Exception)
            {
                
            }
        }

      
        private void textBox5_MouseClick(object sender, MouseEventArgs e)
        {
           
            try
            {

                Category cate = new Category();
                cate.catecode = (Convert.ToInt32(textBox1.Text));
                if (cate.searchCategory())
                {
                    textBox5.Text = cate.catename;
                    textBox4.Focus();
                }
                else
                {
                    MessageBox.Show("Invalid Category ID, Please Try Again or Add new Category Details!!!","TRY AGAIN!");
                    textBox1.Clear();
                    textBox1.Focus();
                }
            }
            catch (Exception)
            {

            }
        }

        private void textBox20_MouseClick(object sender, MouseEventArgs e)
        {
            try
            {
                Flowers flow = new Flowers();
                flow.fcode = (Convert.ToInt32(textBox21.Text));
                if (flow.searchFlow())
                {
                    textBox20.Text = flow.fname;
                    textBox3.Text = flow.fstock.ToString();
                }
                else
                {
                     MessageBox.Show("Invalid flower Id, Please Try Again !!!","TRY AGAIN!");

                     textBox21.Clear();
                    textBox21.Focus();

                }
            }
            catch(Exception)
            {

            }
        }

        private void RejectOrderBtn_Click(object sender, EventArgs e)
        {

            try
            {
                if ((textBox43.Text != "") || (textBox13.Text != "") || (textBox14.Text != ""))
                {
                    Order ord = new Order();
                    ord.orderNo = (Convert.ToInt32(textBox43.Text));
                    if (ord.deleteOrder() > 0)
                    {
                        MessageBox.Show("Record Deleted!", "DELETE");

                        DELETEELete();
                    }
                }
                else
                {
                    MessageBox.Show("You can't click Button without fill all fields!!!","WARNING!");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error : " + ex.Message);
            }
            finally
            {
                clearROrder();
            }
        }

        private void clearROrder()
        {
            textBox42.Clear();
            textBox43.Clear();
            textBox44.Clear();
            textBox45.Clear();
            textBox46.Clear();
            textBox47.Clear();
            textBox48.Clear();
            textBox35.Clear();
        }

        private void textBox47_TextChanged(object sender, EventArgs e)
        {
            try
            {
                if (textBox47.Text != "")
                {

                    Flowers flow = new Flowers();
                    flow.fcode = (Convert.ToInt32(textBox47.Text));
                    if (flow.orderStoreValueFlowerCode())
                    {
                        textBox50.Text = flow.fstock.ToString();
                    }
                }
            }
            catch (Exception)
            {
               
            }
        }

        private void textBox43_TextChanged(object sender, EventArgs e)
        {

            if (textBox43.Text != "")
            {
                try
                {
                    Order ord = new Order();
                    ord.orderNo = (Convert.ToInt32(textBox43.Text));
                    if (ord.orderTextChangedDelete())
                    {
                        textBox35.Text = ord.custName;
                        textBox42.Text = ord.custTP;
                        textBox46.Text = ord.fcategory;
                        textBox44.Text = ord.fname;
                        textBox47.Text = ord.fcode.ToString();
                        textBox48.Text = ord.catecode.ToString();
                        textBox45.Text = ord.orderQuantity.ToString();
                    }

                }
                catch (Exception)
                {

                }
            }
            else
            {
                textBox35.Clear();
                textBox42.Clear();
                textBox43.Clear();
                textBox44.Clear();
                textBox45.Clear();
                textBox46.Clear();
                textBox47.Clear();
                textBox48.Clear();
                textBox43.Focus();
               
            }
        }

        private void OrderAcceptBtn_Click(object sender, EventArgs e)
        {
            try
            {
                Order ord = new Order();
                ord.orderNo = (Convert.ToInt32(textBox43.Text));
                if (ord.deleteOrder() > 0)
                {
                    MessageBox.Show("Record Deleted!", "DELETE");
                    AddAcceptOrder();

                    AcceptedOrders accept = new AcceptedOrders();
                    dataGridView7.DataSource = accept.searchAllAccept().Tables[0];
                }
            }
            catch (Exception)
            {
               
            }

        }

        private void AddAcceptOrder()
        {
            try
            {
                AcceptedOrders accept = new AcceptedOrders();
                accept.orderNo = (Convert.ToInt32(textBox43.Text));
                accept.custName = textBox35.Text;
                accept.custTP = textBox42.Text;
                accept.fname = textBox44.Text;
                accept.fcategory = textBox46.Text;
                accept.fstock = (Convert.ToInt32(textBox45.Text));
                if (accept.acceptOrder() > 0)
                {
                    //MessageBox.Show("Accepted Orders Inserted Into Accepted Order Table", "Add");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error : " + ex.Message);
            }
        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {
             try
             {

                  Flowers flow = new Flowers();
                  flow.fname = textBox4.Text;
                  if (flow.flowerNameSearch())
                  {
                   MessageBox.Show("This is already have");
                   flow.fname = textBox4.Text;

                       if (flow.flowerStockSearch())
                       {
                       textBox30.Text = flow.fstock.ToString();

                       }
                  }
             }
             catch (Exception)
             {

             }
        }

        private void textBox6_TextChanged(object sender, EventArgs e)
        {
            txtbx6();
        }


        private void txtbx6()
        {
            if (textBox30.Text != "")
            {
                try
                {
                    textBox31.Text = ((float.Parse(textBox6.Text) + float.Parse(textBox30.Text)).ToString());

                }
                catch (Exception)
                {

                }
            }
        }

        private void textBox33_TextChanged(object sender, EventArgs e)
        {
            
                try
                {
                    Flowers flow = new Flowers();
                    flow.fname = textBox33.Text;
                    dataGridView2.DataSource = flow.LetterSearchFlow();

                }
                catch (Exception)
                {

                }
            
        }

        private void Logout()
        {
            this.Hide();
            LoginForm LF = new LoginForm();
            LF.Show();
        }

        private void button13_Click(object sender, EventArgs e)
        {
            Logout();
        }

        private void button12_Click(object sender, EventArgs e)
        {
            Logout();
        }

        private void button11_Click(object sender, EventArgs e)
        {
            Logout();
        }

        private void button10_Click(object sender, EventArgs e)
        {
            Logout();
        }

        private void button9_Click(object sender, EventArgs e)
        {
            Logout();
        }

        private void button8_Click(object sender, EventArgs e)
        {
            Logout();
        }

        private void button7_Click(object sender, EventArgs e)
        {
            Logout();
        }

        private void button14_Click(object sender, EventArgs e)
        {
            Logout();
        }

        private void button15_Click(object sender, EventArgs e)
        {
            tabPage5.Show();
            tabPage1.Hide();
            tabPage2.Hide();
            tabPage3.Hide();
            tabPage4.Hide();
            tabPage6.Hide();
            tabPage7.Hide();
            tabPage8.Hide();

            panel5.Height = button15.Height;
            panel5.Top = button15.Top;
            panel5.Left = button15.Left;
            button15.BackColor = Color.FromArgb(64, 64, 64);

        }

        private void button15_Leave(object sender, EventArgs e)
        {
            button15.BackColor = Color.FromArgb(24, 30, 54);
        }
    }
}

