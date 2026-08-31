package com.smartparking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.smartparking.model.Booking;
import com.smartparking.util.DBConnection;

public class BookingDAO {

    // ================= BOOK SLOT =================

    public int bookSlot(Booking booking) {

        int bookingId = -1;
        Connection con = null;

        try {

            con = DBConnection.getConnection();
            con.setAutoCommit(false);

            // CHECK SLOT AVAILABLE

            String checkSlot = "SELECT status FROM parking_slots WHERE slot_id=?";

            PreparedStatement ps1 = con.prepareStatement(checkSlot);
            ps1.setInt(1, booking.getSlotId());

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {

                String status = rs.getString("status");

                if (!status.equalsIgnoreCase("Available")) {

                    con.rollback();
                    return -1;

                }

            } else {

                con.rollback();
                return -1;

            }

            // INSERT BOOKING

            String sql = "INSERT INTO bookings(user_id,vehicle_id,slot_id,booking_date,start_time,end_time,status) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps2 = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps2.setInt(1, booking.getUserId());
            ps2.setInt(2, booking.getVehicleId());
            ps2.setInt(3, booking.getSlotId());
            ps2.setDate(4, booking.getBookingDate());
            ps2.setTimestamp(5, booking.getStartTime());
            ps2.setTimestamp(6, booking.getEndTime());
            ps2.setString(7, "BOOKED");

            int rows = ps2.executeUpdate();

            if (rows > 0) {

                ResultSet generatedKeys = ps2.getGeneratedKeys();

                if (generatedKeys.next()) {

                    bookingId = generatedKeys.getInt(1);

                }

                // UPDATE SLOT STATUS

                String update = "UPDATE parking_slots SET status='Occupied' WHERE slot_id=?";

                PreparedStatement ps3 = con.prepareStatement(update);

                ps3.setInt(1, booking.getSlotId());

                ps3.executeUpdate();

                con.commit();

                System.out.println("Booking Successful");

            }

        } catch (Exception e) {

            try {

                if (con != null)
                    con.rollback();

            } catch (Exception ex) {

                ex.printStackTrace();

            }

            e.printStackTrace();

        } finally {

            try {

                if (con != null)
                    con.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        return bookingId;
    }
    
    // ================= GET USER BOOKINGS =================

    public List<Booking> getBookingsByUserId(int userId) {

        List<Booking> bookingList = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM bookings WHERE user_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Booking booking = new Booking();

                booking.setBookingId(rs.getInt("booking_id"));
                booking.setUserId(rs.getInt("user_id"));
                booking.setVehicleId(rs.getInt("vehicle_id"));
                booking.setSlotId(rs.getInt("slot_id"));
                booking.setBookingDate(rs.getDate("booking_date"));
                booking.setStartTime(rs.getTimestamp("start_time"));
                booking.setEndTime(rs.getTimestamp("end_time"));
                booking.setStatus(rs.getString("status"));

                bookingList.add(booking);

            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return bookingList;

    }

    // ================= ADMIN ALL BOOKINGS =================

    public List<Booking> getAllBookings() {

        List<Booking> bookingList = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM bookings";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Booking booking = new Booking();

                booking.setBookingId(rs.getInt("booking_id"));
                booking.setUserId(rs.getInt("user_id"));
                booking.setVehicleId(rs.getInt("vehicle_id"));
                booking.setSlotId(rs.getInt("slot_id"));
                booking.setBookingDate(rs.getDate("booking_date"));
                booking.setStartTime(rs.getTimestamp("start_time"));
                booking.setEndTime(rs.getTimestamp("end_time"));
                booking.setStatus(rs.getString("status"));

                bookingList.add(booking);

            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return bookingList;

    }

    // ================= CANCEL BOOKING =================

    public boolean cancelBooking(int bookingId, int slotId) {

        boolean result = false;

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            String sql = "UPDATE bookings SET status='CANCELLED' WHERE booking_id=?";

            PreparedStatement ps1 = con.prepareStatement(sql);

            ps1.setInt(1, bookingId);

            int rows = ps1.executeUpdate();

            if (rows > 0) {

                String update = "UPDATE parking_slots SET status='Available' WHERE slot_id=?";

                PreparedStatement ps2 = con.prepareStatement(update);

                ps2.setInt(1, slotId);

                ps2.executeUpdate();

                con.commit();

                result = true;

            }

        } catch (Exception e) {

            try {

                if (con != null)
                    con.rollback();

            } catch (Exception ex) {

                ex.printStackTrace();

            }

            e.printStackTrace();

        } finally {

            try {

                if (con != null)
                    con.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        return result;

    }

}