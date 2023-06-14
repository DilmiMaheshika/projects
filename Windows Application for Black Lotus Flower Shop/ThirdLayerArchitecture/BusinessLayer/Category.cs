using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataLayer;
using System.Data;

namespace BusinessLayer
{
        public class Category
        {

            public int catecode { get; set; }
            public string catename { get; set; }

            public int addCate()
            {
                try
                {
                    string sql = "INSERT INTO CategoryTablev VALUES('" + catename + "')";
                    return Class1.execQuery(sql);
                }
                catch (Exception)
                {
                    throw;
                }
            }


            public int updateCate()
            {
                try
                {
                    string sql = "UPDATE CategoryTablev SET Category_Name='" + catename + "'  WHERE Category_Code=" + catecode;
                    return Class1.execQuery(sql);
                }
                catch (Exception)
                {
                    throw;
                }
            }


            public bool categoryNameSearch()
            {
                try
                {
                    string sql = "SELECT Category_Name FROM CategoryTablev WHERE Category_Name = '" + catename + "'";
                    DataSet ds = Class1.execSearchQuery(sql);
                    if (ds.Tables[0].Rows.Count > 0)
                    {
                        catename = ds.Tables[0].Rows[0][0].ToString();

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


            public int deleteCate()
            {
                try
                {
                    string sql = "DELETE FROM CategoryTablev WHERE Category_Code=" + catecode;
                    return Class1.execQuery(sql);
                }
                catch (Exception)
                {
                    throw;
                }
            }


            public bool searchCategory()
            {
                try
                {
                    string sql = "SELECT * FROM CategoryTablev WHERE Category_Code=" + catecode;
                    DataSet ds = Class1.execSearchQuery(sql);
                    if (ds.Tables[0].Rows.Count > 0)

                    {
                        catecode = Convert.ToInt32(ds.Tables[0].Rows[0][0].ToString());
                        catename = ds.Tables[0].Rows[0][1].ToString();
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


            public DataSet searchAllcate()
            {
                try
                {
                    string sql = "SELECT * FROM CategoryTablev";
                    DataSet ds = Class1.execSearchQuery(sql);
                    return ds;
                }
                catch (Exception)
                {
                    throw;
                }
            }
        }

    
}
