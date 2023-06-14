using System;
using System.Data;
using System.Data.SqlClient;

namespace DataLayer
{
    public class Class1
    {
        private static SqlConnection con = new SqlConnection("server=DESKTOP-JK17UMO\\SQLEXPRESS01; database=BLACK_LOTUS; integrated security=true");

        public static int execQuery(string sql)
        {
            try
            {
                con.Open();
                SqlCommand comm = new SqlCommand(sql, con);
                return comm.ExecuteNonQuery();
            }
            catch (Exception)
            {
                throw;
            }
            finally
            {
                con.Close();
            }
        }

        // important code

        public static DataSet execSearchQuery(string sql)
        {
            try
            {
                con.Open();
                SqlDataAdapter da = new SqlDataAdapter(sql, con);
                DataSet ds = new DataSet();
                da.Fill(ds);
                return ds;
            }
            catch (Exception)
            {
                throw;
            }
            finally
            {
                con.Close();
            }
        }


        public static DataTable execSearch(string sql)
        {
            try
            {
                con.Open();
                SqlCommand com = new SqlCommand(sql, con);
                SqlDataAdapter da = new SqlDataAdapter(com);
                DataTable dt = new DataTable();
                da.Fill(dt);
                return dt;
            }
            catch (Exception)
            {
                throw;
            }
            finally
            {
                con.Close();
            }
        }

    }
}
