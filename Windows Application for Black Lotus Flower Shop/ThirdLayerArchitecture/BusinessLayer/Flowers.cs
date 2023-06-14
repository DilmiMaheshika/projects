using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataLayer;
using System.Data; 

namespace BusinessLayer
{

    public class Flowers
    {

        public int catecode { get; set; }
        public string catename { get; set; } 
        public int  fcode { get; set; }
        public string fname { get; set; }
        public string fcategory { get; set; }
        public int fstock { get; set; }


        //Flower ADD btn
        public int addFlow()
        {
            try
            {
                string sql = "INSERT INTO FlowerTABLEvv VALUES('" + fname + "'," + catecode + ",'" + fcategory + "'," + fstock + ")";
                return Class1.execQuery(sql);
            }
            catch (Exception)
            {
                throw;
            }
        }


        //when update category table then flower table also updated
        public int updateSelectedValue()
        {
            try
            {
                string sql = "UPDATE FlowerTABLEvv SET Flower_Category='" +catename + "'  WHERE Category_Code=" + catecode;
                return Class1.execQuery(sql);
            }
            catch (Exception)
            {
                throw;
            }
        }


        public bool orderStoreValueFlowerCode()
        {
            try
            {
                string sql = "SELECT Stock_Availability FROM FlowerTABLEvv WHERE Flower_Code=" + fcode;
                DataSet ds = Class1.execSearchQuery(sql);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    fstock = Convert.ToInt32(ds.Tables[0].Rows[0][0].ToString());
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


        public bool orderUserOption()
        {
            try
            {
                string sql = "SELECT Flower_Name,Category_Code,Flower_Category,Stock_Availability FROM FlowerTABLEvv WHERE Flower_Code = " + fcode;
                DataSet ds = Class1.execSearchQuery(sql);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    fname  = ds.Tables[0].Rows[0][0].ToString();
                    catecode = Convert.ToInt32(ds.Tables[0].Rows[0][1].ToString());
                    fcategory = ds.Tables[0].Rows[0][2].ToString();
                    fstock = Convert.ToInt32(ds.Tables[0].Rows[0][3].ToString());
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


        public bool orderUserOption2()
        {
            try
            {
                string sql = "SELECT Flower_Code,Category_Code,Flower_Category,Stock_Availability FROM FlowerTABLEvv WHERE Flower_Name = '" + fname + "'";
                DataSet ds = Class1.execSearchQuery(sql);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    fcode = Convert.ToInt32(ds.Tables[0].Rows[0][0].ToString());
                    catecode = Convert.ToInt32(ds.Tables[0].Rows[0][1].ToString());
                    fcategory = ds.Tables[0].Rows[0][2].ToString();
                    fstock = Convert.ToInt32(ds.Tables[0].Rows[0][3].ToString());
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

 

        public bool flowerNameSearch()
        {
            try
            {
                string sql = "SELECT Flower_Name FROM FlowerTABLEvv WHERE Flower_Name = '" + fname + "'";
                DataSet ds = Class1.execSearchQuery(sql);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    fname = ds.Tables[0].Rows[0][0].ToString();

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


        public bool flowerStockSearch()
        {
            try
            {
                string sql = "SELECT Stock_Availability FROM FlowerTABLEvv WHERE Flower_Name = '" + fname + "'";
                DataSet ds = Class1.execSearchQuery(sql);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    fstock = Convert.ToInt32(ds.Tables[0].Rows[0][0].ToString());

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


        public int editAvailable()
        {
            try
            {
                string sql = "UPDATE FlowerTABLEvv SET Stock_Availability = " + fstock + "  WHERE Flower_Code = " + fcode;
                return Class1.execQuery(sql);
            }
            catch (Exception)
            {
                throw;
            }
        }

   
        public int deleteSelectedCate()
        {
            try
            {
                string sql = "DELETE FROM FlowerTABLEvv WHERE Category_Code=" + catecode;
                return Class1.execQuery(sql);
            }
            catch (Exception)
            {
                throw;
            }
        }

        public int deleteFlow()
        {
            try
            {
                string sql = "DELETE FROM FlowerTABLEvv WHERE Flower_Code=" + fcode ;
                return Class1.execQuery(sql);
            }
            catch (Exception)
            {
                throw;
            }
        }


        public int updateFlow()
        {
            try
            {
                string sql = "UPDATE FlowerTABLEvv SET Flower_Name='" + fname + "', Stock_Availability= " + fstock + "  WHERE Flower_Code=" + fcode ;
                return Class1.execQuery(sql);
            }
            catch (Exception)
            {
                throw;
            }
        }


        public int updateFlowName()
        {
            try
            {
                string sql = "UPDATE FlowerTABLEvv SET Stock_Availability= " + fstock + "  WHERE Flower_Name='" + fname+"'";
                return Class1.execQuery(sql);
            }
            catch (Exception)
            {
                throw;
            }
        }

        //SEARCH flower btn
        public bool searchFlow()
        {
            try
            {
                string sql = "SELECT Flower_Name,Stock_Availability FROM FlowerTABLEvv WHERE Flower_Code=" + fcode;
                DataSet ds = Class1.execSearchQuery(sql);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    fname = ds.Tables[0].Rows[0][0].ToString();
                    fstock = Convert.ToInt32(ds.Tables[0].Rows[0][1].ToString());
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


        public DataSet searchAllFlow()
        {
            try
            {
                string sql = "SELECT * FROM FlowerTABLEvv";
                DataSet ds = Class1.execSearchQuery(sql);
                return ds;
            }
            catch (Exception)
            {
                throw;
            }
        }

      
        public DataTable LetterSearchCate()
        {
            try
            {
                string sql = "SELECT * FROM FlowerTABLEvv WHERE Flower_Category like '"+fcategory+"%'";
                DataTable dt = Class1.execSearch(sql);
                return dt;
            }
            catch (Exception)
            {
                throw;
            }
        }


        public DataTable LetterSearchFlow()
        {
            try
            {
                string sql = "SELECT * FROM FlowerTABLEvv WHERE Flower_Name like '" + fname + "%'";
                DataTable dt = Class1.execSearch(sql);
                return dt;
            }
            catch (Exception)
            {
                throw;
            }
        }


    }

}

