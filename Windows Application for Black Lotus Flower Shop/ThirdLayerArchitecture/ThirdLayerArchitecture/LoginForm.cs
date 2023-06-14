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
    public partial class LoginForm : Form
    {
        public LoginForm()
        {
            InitializeComponent();
        }

        private void LoginForm_Load(object sender, EventArgs e)
        {
            panel1.BackColor = Color.FromArgb(100,0,0,0);
        }

        private void button1_Click(object sender, EventArgs e) //Login 
        {
            try
            {
                User us = new User();
                us.luser = textBox1.Text;
                us.lpass = textBox2.Text;

                if (us.LoginButton())
                {
                    MessageBox.Show("Login Successfully!!!");
                    this.Hide();
                    CategoryMange CM = new CategoryMange();
                    CM.Show();
                    //MessageBox.Show("Record Updated!", "UPDATE");
                }
                else
                {
                    MessageBox.Show("Please Check Your Username and Password!!!","WARNING!");
                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("Error : " + ex.Message);
            }
        }

        private void button2_Click(object sender, EventArgs e) //Place Oreders
        {
            try
            {
                    this.Hide();
                    UserLoginOption ULO = new UserLoginOption();
                    ULO.Show();
              
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error : " + ex.Message);
            }
        }

        private void button3_Click(object sender, EventArgs e) // show password
        {
            if (textBox2.PasswordChar == '*')
            {
                button4.BringToFront();
                textBox2.PasswordChar = '\0';
            }
        }

        private void button4_Click(object sender, EventArgs e) // hide password
        {
            if (textBox2.PasswordChar == '\0')
            {
                button3.BringToFront();
                textBox2.PasswordChar = '*';
            }
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }
    }
}
