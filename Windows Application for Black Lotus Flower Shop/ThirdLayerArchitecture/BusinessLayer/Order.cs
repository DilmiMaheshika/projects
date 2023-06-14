using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataLayer;
using System.Data;


namespace BusinessLayer
{
    public class Order
    {

        public int orderNo { get; set; }
        public int orderQuantity { get; set; }
        public string custName { get; set; }
        public string custTP { get; set; }
        public int catecode { get; set; }
        public int fcode { get; set; }
        public string fname { get; set; }
        public string fcategory { get; set; }


        public int addOrder()
        {
            try
            {
                string sql = "INSERT INTO OrderTablevv VALUES('" + custName + "','" + custTP + "'," + fcode + ",'" + fname + "'," + catecode + ",'" + fcategory + "'," + orderQuantity + ")";
                return Class1.execQuery(sql);
            }
            catch (Exception)
            {
                throw;
            }

        }
     

        public bool orderTextChangedDelete()
        {
            try
            {
                string sql = "SELECT Customer_Name,Customer_Contact_No,Relevant_Flower_Code,Item_Name,Category_Code,Item_Category,Order_Quantity FROM OrderTablevv WHERE Order_No = " + orderNo;
                DataSet ds = Class1.execSearchQuery(sql);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    custName = ds.Tables[0].Rows[0][0].ToString();
                    custTP = ds.Tables[0].Rows[0][1].ToString();
                    fcode = Convert.ToInt32(ds.Tables[0].Rows[0][2].ToString());
                    fname = ds.Tables[0].Rows[0][3].ToString();
                    catecode = Convert.ToInt32(ds.Tables[0].Rows[0][4].ToString());
                    fcategory = ds.Tables[0].Rows[0][5].ToString();
                    orderQuantity = Convert.ToInt32(ds.Tables[0].Rows[0][6].ToString());
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


        public int updateOrder()
        {
            try
            {
                string sql = "UPDATE OrderTablevv SET Customer_Name= '" + custName + "', Customer_Contact_No= '" + custTP + "', Item_Category = '" + fcategory + "', Item_Name = '" + fname + "' , Relevant_Flower_Code = " + fcode + ", Order_Quantity= " + orderQuantity + " WHERE Order_No = " + orderNo;
                return Class1.execQuery(sql);
            }
            catch (Exception)
            {
                throw;
            }

        }


        public int deleteOrder()
        {
            try
            {
                string sql = "DELETE FROM OrderTablevv WHERE Order_No=" + orderNo;
                return Class1.execQuery(sql);
            }
            catch (Exception)
            {
                throw;
            }
        }


        public DataSet searchAllOrder()
        {
            try
            {
                string sql = "SELECT * FROM OrderTablevv";
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
