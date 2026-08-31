package com.smartparking.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;

import com.smartparking.model.Payment;
import com.smartparking.util.DBConnection;



public class PaymentDAO {



    // ================= ADD PAYMENT =================


    public boolean addPayment(Payment payment) {


        boolean result = false;


        Connection con = null;
        PreparedStatement ps = null;



        try {


            con = DBConnection.getConnection();



            String sql =
            "INSERT INTO payments(booking_id, amount, payment_method, payment_status) VALUES (?, ?, ?, ?)";



            ps = con.prepareStatement(sql);



            ps.setInt(1, payment.getBookingId());

            ps.setDouble(2, payment.getAmount());

            ps.setString(3, payment.getPaymentMethod());

            ps.setString(4, payment.getPaymentStatus());



            int rows = ps.executeUpdate();



            if(rows > 0) {


                result = true;


                System.out.println("Payment Added Successfully");


            }



        }
        catch(Exception e) {


            e.printStackTrace();


        }
        finally {


            try {


                if(ps != null)
                    ps.close();


                if(con != null)
                    con.close();


            }
            catch(Exception e) {


                e.printStackTrace();


            }

        }



        return result;


    }



}