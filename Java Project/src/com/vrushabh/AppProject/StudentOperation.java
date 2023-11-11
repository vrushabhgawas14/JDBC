package com.vrushabh.AppProject;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentOperation {
    public static void insertData(Student old) {
        try {
            Connection conn = DB.connect();
            // String query = "INSERT INTO student values (?,?,?,?)";
            String query = Query.insert;
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, old.getId());
            pstm.setString(2, old.getName());
            pstm.setInt(3, old.getAge());
            pstm.setString(4, String.valueOf(old.getGender()));

            System.out.println("Inserted Successfully. " + pstm.executeUpdate() + " row affected.");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteData(int id) {
        try {
            Connection conn = DB.connect();
            String query = Query.delete;
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);

            System.out.printf("Deleted Successfully. %d row affected.\n", pstm.executeUpdate());

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ID and Age
    public static void updateData(int option, int newStr, int id_Old) {
        try {
            Connection conn = DB.connect();
            String query = (option == 1) ? Query.updateID : Query.updateAge;
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, newStr);
            pstm.setInt(2, id_Old);

            System.out.printf("Data Updated Successfully. %d row affected.\n", pstm.executeUpdate());

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Name and Gender
    public static void updateData(int option, String newName, int id_Old) {
        try {
            Connection conn = DB.connect();
            String query = (option == 2) ? Query.updateName : Query.updateGender;
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, newName);
            pstm.setInt(2, id_Old);

            System.out.printf("Data Updated Successfully. %d row affected.\n", pstm.executeUpdate());

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Directly Print
    public static void readData() {
        try {
            Connection conn = DB.connect();
            String query = Query.select;
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery(query);

            System.out.println("\nID \tName \tAge \tGender\n");
            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getInt(3) + "\t");
                System.out.println(rs.getString(4));
            }
            System.out.println("\nRead Successfully.\n");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
