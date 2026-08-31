package com.smartparking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.smartparking.model.ParkingSlot;
import com.smartparking.util.DBConnection;


public class ParkingSlotDAO {


    // ===================== GET AVAILABLE SLOTS (USER) =====================

    public List<ParkingSlot> getAvailableSlots() {

        List<ParkingSlot> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "SELECT * FROM parking_slots WHERE status='Available'";


            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();


            while(rs.next()) {


                ParkingSlot slot = new ParkingSlot();


                slot.setSlotId(
                    rs.getInt("slot_id")
                );


                slot.setSlotNumber(
                    rs.getString("slot_number")
                );


                slot.setSlotType(
                    rs.getString("slot_type")
                );


                slot.setStatus(
                    rs.getString("status")
                );


                list.add(slot);

            }


            rs.close();
            ps.close();
            con.close();


        } catch(Exception e) {

            e.printStackTrace();

        }


        return list;

    }





    // ===================== GET ALL SLOTS (ADMIN) =====================


    public List<ParkingSlot> getAllSlots() {


        List<ParkingSlot> list = new ArrayList<>();


        try {


            Connection con = DBConnection.getConnection();


            String sql =
            "SELECT * FROM parking_slots";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ResultSet rs =
            ps.executeQuery();



            while(rs.next()) {


                ParkingSlot slot = new ParkingSlot();


                slot.setSlotId(
                    rs.getInt("slot_id")
                );


                slot.setSlotNumber(
                    rs.getString("slot_number")
                );


                slot.setSlotType(
                    rs.getString("slot_type")
                );


                slot.setStatus(
                    rs.getString("status")
                );


                list.add(slot);


            }



            rs.close();
            ps.close();
            con.close();



        } catch(Exception e) {


            e.printStackTrace();


        }



        return list;


    }


}