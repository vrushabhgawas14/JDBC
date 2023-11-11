package com.vrushabh.AppProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\t\tSelect Operation to perform.");

        while (true) {

            System.out.println("\n\t(Create : 1 || Read : 2 || Update : 3 || Delete :4)");
            System.out.print("Operation : ");
            int choice = input.nextInt();

            if (choice < 1 || choice >= 5)
                break;

            switch (choice) {
                case 1:
                    // Insert Data
                    System.out.println("\n\t\tInsert Data in Following format ->");
                    System.out.print("ID :\t");
                    int id = input.nextInt();
                    System.out.print("Name :\t");
                    String name = input.next();
                    String newName = name.substring(0, 1).toUpperCase() + name.substring(1);
                    System.out.print("Age :\t");
                    int age = input.nextInt();
                    // char gen = input.next().charAt(0);
                    System.out.print("Gender:\t");
                    char gender = Character.toUpperCase(input.next().charAt(0));

                    // System.out.println(id + newName + age + gender);

                    Student obj = new Student(id, newName, age, gender);
                    StudentOperation.insertData(obj);

                    break;

                case 2:
                    // Read
                    StudentOperation.readData(); // Directly print data
                    break;

                case 3:
                    // Update
                    System.out.print("\n\tWhose identity to change,his id = ");
                    int id_old = input.nextInt();
                    System.out.println("\n\t<--Choose which identity to change-->");
                    System.out.println("\t(ID : 1 || Name : 2 || Age : 3 || Gender :4)");
                    System.out.print("\tOption : ");
                    int option = input.nextInt();
                    switch (option) {
                        case 1:
                            // Update Id
                            System.out.print("Set new ID = ");
                            int id_new = input.nextInt();
                            StudentOperation.updateData(option, id_new, id_old);
                            break;
                        case 2:
                            // Update Name
                            System.out.print("Set new Name = ");
                            String name1 = input.next();
                            String newName1 = name1.substring(0, 1).toUpperCase() + name1.substring(1);
                            StudentOperation.updateData(option, newName1, id_old);
                            break;

                        case 3:
                            // Update Age
                            System.out.print("Set new Age = ");
                            int newAge = input.nextInt();
                            StudentOperation.updateData(option, newAge, id_old);
                            break;

                        case 4:
                            // Update Gender
                            System.out.print("Set new Gender = ");
                            char newGender = Character.toUpperCase(input.next().charAt(0));
                            StudentOperation.updateData(option, String.valueOf(newGender), id_old);

                            break;
                        default:
                            System.out.println("Invalid Option for Identity.");
                            break;
                    }

                    break;

                case 4:
                    // Delete
                    System.out.print("\n\t\tDelete by ID, ");
                    System.out.print("Id = ");
                    int id1 = input.nextInt();

                    StudentOperation.deleteData(id1);
                    break;
                default:
                    break;
            }
        }

        input.close();
    }
}
