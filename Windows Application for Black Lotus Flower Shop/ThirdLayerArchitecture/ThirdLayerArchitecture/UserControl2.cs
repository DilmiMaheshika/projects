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
    public partial class UserControl2 : UserControl
    {
        public UserControl2()
        {
            InitializeComponent();
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
                        textBox16.Text = flow.fstock.ToString();
                    }

                    else
                    {
                        textBox13.Clear();
                        textBox14.Clear();
                        textBox16.Clear();
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
                    textBox16.Text = flow.fstock.ToString();
                }

                else
                {
                    textBox1.Clear();
                    textBox13.Clear();
                    textBox16.Clear();
                }
            }
            catch (Exception ex)
            {
               // MessageBox.Show("Error : " + ex.Message);
            }
        }

        private void UserControl1_Load(object sender, EventArgs e)
        {

        }


        private void createBtn_Click(object sender, EventArgs e)
        {
            if ((textBox1.Text != "") || (textBox17.Text != ""))
            {
                try
                {
                    Flowers flow = new Flowers();
                    //flow.orderNo = textBox12.Text;
                    flow.fname = textBox14.Text;
                    flow.fcategory = textBox13.Text;
                    flow.fcode = (Convert.ToInt32(textBox1.Text));
                    flow.orderQuantity = (Convert.ToInt32(textBox17.Text));
                    if (flow.addOrder() > 0)
                    {
                        MessageBox.Show("Order Details Inserted!", "Add");

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
                    //textBox12.Clear();
                    textBox13.Clear();
                    textBox14.Clear();
                    textBox17.Clear();
                    textBox1.Focus();
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
                    MessageBox.Show("Record Updated!", "UPDATE");
                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("Error :" + ex.Message);
            }
        }

    }
}
