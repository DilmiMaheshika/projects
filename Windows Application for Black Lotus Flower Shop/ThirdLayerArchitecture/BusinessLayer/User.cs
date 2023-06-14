using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataLayer;
using System.Data;

namespace BusinessLayer
{
      public class User
      {
            public int uid { get; set; }
            public string uname { get; set; }
            public string nic { get; set; }
            public string luser { get; set; }
            public string lpass { get; set; }


            public int addUser()
            {

                try
                {
                    string sql = "INSERT INTO UserTablevv VALUES('" + uname + "','" + nic + "','" + luser + "','" + lpass + "')";
                    return Class1.execQuery(sql);
                }
                catch (Exception)
                {
                    throw;
                }
            }


            public bool userDetails()
            {
                try
                {
                    string sql = "SELECT User_Name,NIC_No,Login_Username,Login_Password FROM UserTablevv WHERE User_Id = " + uid;
                    DataSet ds = Class1.execSearchQuery(sql);
                    if (ds.Tables[0].Rows.Count > 0)
                    {
                        uname = ds.Tables[0].Rows[0][0].ToString();
                        nic = ds.Tables[0].Rows[0][1].ToString();
                        luser = ds.Tables[0].Rows[0][2].ToString();
                        lpass = ds.Tables[0].Rows[0][3].ToString();
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                catch (Exception)
                {
                    throw;
                }
            }


            public bool userNameSearch()
            {
                try
                {
                    string sql = "SELECT NIC_No FROM UserTablevv WHERE NIC_No = '" + nic + "'";
                    DataSet ds = Class1.execSearchQuery(sql);
                    if (ds.Tables[0].Rows.Count > 0)
                    {
                        nic = ds.Tables[0].Rows[0][0].ToString();

                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                catch (Exception)
                {
                    throw;
                }
            }


            public int updateUser()
            {
                try
                {
                    string sql = "UPDATE UserTablevv SET User_Name = '" + uname + "', NIC_No = '" + nic + "' , Login_Username = '" + luser + "', Login_Password= '" + lpass + "' WHERE User_Id = " + uid;
                    return Class1.execQuery(sql);
                }
                catch (Exception)
                {
                    throw;
                }

            }


            public int deleteUser()
            {
                try
                {
                    string sql = "DELETE FROM UserTablevv WHERE User_Id=" + uid;
                    return Class1.execQuery(sql);
                }
                catch (Exception)
                {
                    throw;
                }
            }


            public DataSet searchAllUser()
            {
                try
                {
                    string sql = "SELECT * FROM UserTablevv";
                    DataSet ds = Class1.execSearchQuery(sql);
                    return ds;
                }
                catch (Exception)
                {
                    throw;
                }
            }


            public bool LoginButton()
            {
                try
                {
                    string sql = "SELECT * FROM UserTablevv WHERE Login_Username='" + luser + "'and Login_Password = '" + lpass + "'";
                    DataSet ds = Class1.execSearchQuery(sql);
                    if (ds.Tables[0].Rows.Count > 0)
                    {
                        luser = ds.Tables[0].Rows[0][0].ToString();
                        lpass = ds.Tables[0].Rows[0][1].ToString();
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                catch (Exception)
                {
                    throw;
                }
            }

      }

    
}
