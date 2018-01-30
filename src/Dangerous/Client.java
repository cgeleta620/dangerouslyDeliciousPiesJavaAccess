package Dangerous;

//ssh -L 3306:cs-database:3306 cgeleta@rerun.cs.loyola.edu

import java.util.*;
import java.sql.*;

/**
 * Created by cgeleta on 12/12/16.
 */
public class Client {

    protected Connection conn;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Client client = new Client();
        System.out.println("Welcome to the Dangerously Delicious Pies database\n");
        String input;
        boolean check = true;

        while(check){

            System.out.println("\nPress 1 to show all the pies");
            System.out.println("Press 2 to show all Ingredients");
            System.out.println("Press 3 to show all the types of pies");
            System.out.println("Press 4 to all ingredient types");
            System.out.println("Press 5 to show the USES table");
            System.out.println("Press q to quit");
            System.out.println();
            input = in.next();

            if(input.equals("1")) {
                client.getPies();
            }
            else if (input.equals("2")) {
                client.getIngredients();
            }
            else if (input.equals("3")) {
                client.getPieType();
            }
            else if (input.equals("4")) {
                client.getIngType();
            }
            else if (input.equals("5")) {
                client.getPieUses();
            }
            else if (input.equals("q")) {
                break;
            }
        }

    }

    public Client() {

        if (!MysqlConnection.isRegistered())
            System.exit(42);

        String database, user, pass;

        database = "cgeleta";
        user = "cgeleta";
        pass = "1695614";

        conn = MysqlConnection.connect(database, user, pass);
        if (conn == null)
            System.exit(42);

    }

    public void getPies() {

        ResultSet rs = null;

        try {
            Statement pies = conn.createStatement();
            rs = pies.executeQuery("select pie_name, pie_quantity from PIE;");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(rs == null) {
            return;
        }

        try {
            System.out.println("Pies, quantity\n");
            while (rs.next()) {
                String pie = rs.getString(1);
                String num = rs.getString(2);
                System.out.println(pie + "\t\t\t\t" + num);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void getIngredients() {

        ResultSet rs = null;

        try {
            Statement pies = conn.createStatement();
            rs = pies.executeQuery("select ing_name, ing_quantity from INGREDIENT;");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(rs == null) {
            return;
        }

        try {
            System.out.println("Ingredients, quantity\n");
            while (rs.next()) {
                String ing = rs.getString(1);
                String num = rs.getString(2);
                System.out.println(ing + "\t\t\t\t" + num);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void getPieType() {

        ResultSet rs = null;

        try {
            Statement pies = conn.createStatement();
            rs = pies.executeQuery("select pie_type from PIETYPE;");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(rs == null) {
            return;
        }

        try {
            System.out.println("Pie types:\n");
            while (rs.next()) {
                String type = rs.getString(1);
                System.out.println(type);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void getIngType() {

        ResultSet rs = null;

        try {
            Statement pies = conn.createStatement();
            rs = pies.executeQuery("select ing_type from INGTYPE;");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(rs == null) {
            return;
        }

        try {
            System.out.println("Ingredient types:\n");
            while (rs.next()) {
                String ingT = rs.getString(1);
                System.out.println(ingT);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void getPieUses() {

        ResultSet rs = null;

        try {
            Statement pies = conn.createStatement();
            rs = pies.executeQuery("select * from USES;");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(rs == null) {
            return;
        }

        try {
            System.out.println("Pie, ing, quantity:\n");
            while (rs.next()) {
                String pie = rs.getString(1);
                String ing = rs.getString(2);
                String q = rs.getString(3);
                System.out.println(pie + "\t\t" + ing + "\t\t" + q);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}