using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataLayer;
using System.Data;

namespace BusinessLayer
{
    public class AcceptedOrders
    {

        public int orderNo { get; set; }
        public string custName { get; set; }
        public string custTP { get; set; }
        public string fname { get; set; }
        public string fcategory { get; set; }
        public int fstock { get; set; }

        public int acceptOrder()
        {
            try
            {
                string sql = "INSERT INTO AcceptedOrdersTable VALUES(" + orderNo + ",'" + custName + "','" + custTP + "','" + fname + "','" + fcategory + "'," + fstock + ")";
                return Class1.execQuery(sql);
            }
            catch (Exception)
            {
                throw;

            }
        }


        public DataSet searchAllAccept()
        {
            try
            {
                string sql = "SELECT * FROM AcceptedOrdersTable";
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
