package com.vrushabh.AppProject;

public class Query {
    public static String insert = "INSERT INTO student VALUES (?,?,?,?)";

    public static String select = "SELECT * FROM student";

    public static String updateID = "UPDATE student SET id = ? WHERE id = ?";
    public static String updateName = "UPDATE student SET name = ? WHERE id = ?";
    public static String updateAge = "UPDATE student SET age = ? WHERE id = ?";
    public static String updateGender = "UPDATE student SET gender = ? WHERE id = ?";

    public static String delete = "DELETE FROM student WHERE id = ?";

}
