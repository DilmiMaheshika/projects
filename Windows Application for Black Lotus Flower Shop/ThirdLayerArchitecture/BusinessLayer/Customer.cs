using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataLayer;
using System.Data;

namespace BusinessLayer
{

    public class Customer
    {
        public string custName { get; set; }
        public string custTP { get; set; }

        public int addCustomer()
        {
            try
            {
                string sql = "INSERT INTO CustomerTable VALUES('" + custName + "','" + custTP + "')";
                return Class1.execQuery(sql);
            }
            catch (Exception)
            {
                throw;
            }

        }


    }
}
