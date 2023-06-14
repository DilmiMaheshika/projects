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
    public partial class UserLoginOption : Form
    {
        public UserLoginOption()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e) // place orders
        {
            tabPage1.Hide();
            tabPage2.Show();
        }

        private void button1_Click(object sender, EventArgs e) //stock availability view
        {

            try
            {
                tabPage1.Show();
                tabPage2.Hide();

                Flowers flow = new Flowers();
                dataGridView2.DataSource = flow.searchAllFlow().Tables[0];
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error : " + ex.Message);
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

            if (textBox1.Text != "")
            {
                try
                {
                    Flowers flow = new Flowers();
                    flow.fcode = (Convert.ToInt32(textBox1.Text));
                    if (flow.orderUserOption())
                    {

                        textBox14.Text = flow.fname;
                        textBox13.Text = flow.fcategory;
                        textBox4.Text = flow.catecode.ToString();
                        textBox16.Text = flow.fstock.ToString();
                    }
                }

                catch (Exception ex)
                {
                    // MessageBox.Show("Error : " + ex.Message);
                }
            }
            else
            {
                textBox1.Clear();
                textBox13.Clear();
                textBox14.Clear();
                textBox16.Clear();
                textBox17.Clear();
                textBox18.Clear();
                textBox4.Clear();

            }
        }

        private void textBox14_TextChanged(object sender, EventArgs e)
        {
            try
            {
                Flowers flow = new Flowers();
                flow.fname = textBox14.Text;
                if (flow.orderUserOption2())
                {
                    textBox1.Text = flow.fcode.ToString();
                    textBox13.Text = flow.fcategory;
                    textBox4.Text = flow.catecode.ToString();
                    textBox16.Text = flow.fstock.ToString();
                }

                else
                {
                    textBox1.Clear();
                    textBox13.Clear();
                    textBox16.Clear();
                    textBox4.Clear();
                }
            }
            catch (Exception ex)
            {
                // MessageBox.Show("Error : " + ex.Message);
            }
        }

        private void textBox17_TextChanged(object sender, EventArgs e)
        {

            try
            {
                if (textBox17.Text != "")

                {
                    textBox18.Text = (float.Parse(textBox16.Text) - float.Parse(textBox17.Text)).ToString();
                }
                else
                {
                    textBox18.Clear();
                }

            }
            catch (Exception ex)
            {

            }
        }

        private void customerDetails()
        {
            if((textBox2.Text != "") && (textBox3.Text != ""))
            {

                try
                {
                    Customer cus = new Customer();
                    cus.custName = textBox2.Text;
                    cus.custTP = textBox3.Text;
                    if (cus.addCustomer() > 0)
                    {
                       // MessageBox.Show("Customer Details Inserted!", "Add");
                        //CreateBtnZeroValue();
                    }
                }
                catch(Exception ex)
                {
                    MessageBox.Show("Error : " +ex.Message);
                }
            }
        }


        private void createOrderBtn_Click(object sender, EventArgs e)
        {
            if ((textBox1.Text != "") || (textBox17.Text != ""))
            {
                try
                {
                    Order ord = new Order();
                    ord.custName = textBox2.Text;
                    ord.custTP = textBox3.Text;
                    ord.fname = textBox14.Text;
                    ord.fcategory = textBox13.Text;
                    ord.fcode = (Convert.ToInt32(textBox1.Text));
                    ord.catecode = (Convert.ToInt32(textBox4.Text));
                    ord.orderQuantity = (Convert.ToInt32(textBox17.Text));
                    if (ord.addOrder() > 0)
                    {
                        MessageBox.Show("Order Details Inserted!", "Add");
                       // CreateBtnZeroValue();
                        customerDetails();
                    }
                    UpdateAvailableStock();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error : " + ex.Message);
                }
                finally
                {
                    textBox1.Clear();
                    textBox2.Clear();
                    textBox3.Clear();
                    textBox13.Clear();
                    textBox14.Clear();
                    textBox17.Clear();
                    textBox2.Focus();
                }
            }
            else
            {
                MessageBox.Show("You can't Place Orders without fill all fields!!!");
            }
        }



        private void UpdateAvailableStock()
        {
            try
            {
                Flowers flow = new Flowers();
                flow.fcode = (Convert.ToInt32(textBox1.Text));
                flow.fstock = (Convert.ToInt32(textBox18.Text));
                if (flow.editAvailable() > 0)
                {
                    //MessageBox.Show("Record Updated!", "UPDATE");
                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("Error :" + ex.Message);
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            this.Hide();
            LoginForm LF = new LoginForm();
            LF.Show();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.Hide();
            LoginForm LF = new LoginForm();
            LF.Show();
        }

        private void UserLoginOption_Load(object sender, EventArgs e)
        {

        }
    }
}
