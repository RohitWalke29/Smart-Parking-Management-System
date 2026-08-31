package com.smartparking.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.smartparking.model.Vehicle;
import com.smartparking.util.DBConnection;



public class VehicleDAO {



    // ADD VEHICLE

    public boolean addVehicle(Vehicle v) {


        boolean status = false;


        String sql =
        "insert into vehicles(user_id,vehicle_number,vehicle_type,vehicle_model) values(?,?,?,?)";


        try {


            Connection con = DBConnection.getConnection();


            PreparedStatement ps = con.prepareStatement(sql);


            ps.setInt(1, v.getUserId());
            ps.setString(2, v.getVehicleNumber());
            ps.setString(3, v.getVehicleType());
            ps.setString(4, v.getVehicleModel());


            int row = ps.executeUpdate();


            if(row > 0)
                status = true;


        }
        catch(Exception e){

            e.printStackTrace();

        }


        return status;

    }





    // VIEW VEHICLES


    public List<Vehicle> getVehiclesByUserId(int userId){


        List<Vehicle> list = new ArrayList<>();


        String sql =
        "select * from vehicles where user_id=?";


        try{


            Connection con = DBConnection.getConnection();


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setInt(1,userId);


            ResultSet rs =
            ps.executeQuery();



            while(rs.next()){


                Vehicle v = new Vehicle();


                v.setVehicleId(
                rs.getInt("vehicle_id"));


                v.setUserId(
                rs.getInt("user_id"));


                v.setVehicleNumber(
                rs.getString("vehicle_number"));


                v.setVehicleType(
                rs.getString("vehicle_type"));


                v.setVehicleModel(
                rs.getString("vehicle_model"));



                list.add(v);


            }


        }
        catch(Exception e){

            e.printStackTrace();

        }


        return list;

    }





    // GET SINGLE VEHICLE


    public Vehicle getVehicleById(int id){


        Vehicle v = null;


        String sql =
        "select * from vehicles where vehicle_id=?";


        try{


            Connection con =
            DBConnection.getConnection();


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setInt(1,id);


            ResultSet rs =
            ps.executeQuery();



            if(rs.next()){


                v = new Vehicle();


                v.setVehicleId(rs.getInt("vehicle_id"));
                v.setUserId(rs.getInt("user_id"));
                v.setVehicleNumber(rs.getString("vehicle_number"));
                v.setVehicleType(rs.getString("vehicle_type"));
                v.setVehicleModel(rs.getString("vehicle_model"));

            }


        }
        catch(Exception e){

            e.printStackTrace();

        }


        return v;

    }





    // UPDATE VEHICLE


    public boolean updateVehicle(Vehicle v){


        boolean status=false;


        String sql =
        "update vehicles set vehicle_number=?,vehicle_type=?,vehicle_model=? where vehicle_id=?";


        try{


            Connection con =
            DBConnection.getConnection();


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setString(1,v.getVehicleNumber());
            ps.setString(2,v.getVehicleType());
            ps.setString(3,v.getVehicleModel());
            ps.setInt(4,v.getVehicleId());



            if(ps.executeUpdate()>0)
                status=true;


        }
        catch(Exception e){

            e.printStackTrace();

        }


        return status;

    }





    // DELETE VEHICLE


    public boolean deleteVehicle(int id){


        boolean status=false;


        String sql =
        "delete from vehicles where vehicle_id=?";


        try{


            Connection con =
            DBConnection.getConnection();


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setInt(1,id);



            if(ps.executeUpdate()>0)
                status=true;


        }
        catch(Exception e){

            e.printStackTrace();

        }


        return status;


    }


}