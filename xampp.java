import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class xampp {

    Connection conn;

    public void select_record(String table) throws SQLException {

        String result = "";
        String q="";
        ResultSet rs=null;

        Statement stmt = this.conn.createStatement();
        try {




            switch (table) {
                case "artist":
                     q = "select * from" + " " + table;

                     rs = stmt.executeQuery(q);

                    if (!rs.next() ) {
                        System.out.println("Empty set");
                    }
                    else {
                        while (rs.next()) {
                            result = rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getInt(5);


                            System.out.println(result);
                        }
                    }
                    break;

                case "gallery":
                     q = "select * from" + " " + table;

                     rs = stmt.executeQuery(q);

                    if (!rs.next() ) {
                        System.out.println("Empty set");
                    }

                    else {

                        while (rs.next()) {
                            result = rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3);

                            System.out.println(result);
                        }
                    }
                    break;

                case "artwork":

                    q = "select * from" + " " + table;

                    rs = stmt.executeQuery(q);
                    if (!rs.next() ) {
                        System.out.println("Empty set");
                    }

                    else {

                        while (rs.next()) {

                            result = rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getFloat(7);

                            System.out.println(result);
                        }
                    }

                    break;

                case "auction":

                    q = "select * from" + " " + table;

                    rs = stmt.executeQuery(q);

                    if (!rs.next() ) {
                        System.out.println("Empty set");
                    }

                    else {

                        while (rs.next()) {

                            result = rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3);

                            System.out.println(result);

                        }
                    }
                    break;

                case "customer":
                    q = "select * from" + " " + table;

                    rs = stmt.executeQuery(q);

                    if (!rs.next() ) {
                        System.out.println("Empty set");
                    }

                    else {

                        while (rs.next()) {
                            result = rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4);


                            System.out.println(result);
                        }
                    }
                    break;

                case "factor":

                    q = "select * from" + " " + table;

                    rs = stmt.executeQuery(q);

                    if (!rs.next() ) {
                        System.out.println("Empty set");
                    }

                    else {

                        while (rs.next()) {
                            result = rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getFloat(5) + "  " + rs.getFloat(6);

                            System.out.println(result);

                        }

                    }
                    break;

                default:
                    System.out.println("Table Not Found :/");
                    break;


            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //System.out.println("Exception occured");
        }

    }

    public void insert() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String query = "";
        PreparedStatement preparedStmt;
        System.out.println("plz enter the name of the table you want insert into: ");
        String tableName = scanner.next();
        switch (tableName) {

            case "artist":

                try {



                query = "insert into artist (fname,lname,national_code,phone_number,age)" + " values (?,?,?,?,?)";
                preparedStmt = conn.prepareStatement(query);
                System.out.println("enter first name: ");
                String firstName = scanner.next();
                preparedStmt.setString(1, firstName);
                System.out.println("enter last name: ");
                scanner.nextLine();
                String lastName = scanner.nextLine();
                preparedStmt.setString(2, lastName);
                System.out.println("enter id: ");
                String id = scanner.next();
                preparedStmt.setString(3, id);
                System.out.println("enter phone number: ");
                String phoneNumber = scanner.next();
                preparedStmt.setString(4, phoneNumber);
                System.out.println("enter age: ");
                int age = scanner.nextInt();
                preparedStmt.setInt(5, age);
                preparedStmt.execute();
                System.out.println("insert successfully :)");

                }

                catch (SQLException e){

                    System.out.println("Error Occurred try again :(");
                }
                break;

            case "gallery":

                try {



                query = "insert into gallery (gallery_name,start_date,end_date)" + "values (?,?,?)";
                preparedStmt = conn.prepareStatement(query);
                System.out.println("enter gallery name: ");
                scanner.nextLine();
                String gName = scanner.nextLine();
                preparedStmt.setString(1, gName);
                System.out.println("enter start date of gallery: (like 2017-06-15) ");
                String start = scanner.next();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
                java.util.Date dateStr = formatter.parse(start);
                java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());


                preparedStmt.setDate(2, dateDB);
                System.out.println("enter end date of gallery: ");
                String end = scanner.next();


                java.util.Date dateStr2 = formatter.parse(end);
                java.sql.Date dateDB2= new java.sql.Date(dateStr.getTime());

                preparedStmt.setDate(3, dateDB2);
                preparedStmt.execute();
                System.out.println("insert successfully :)");
                }

                catch (SQLException e){

                    System.out.println("Error Occurred try again :(");

                }
                break;

            case "artwork":


                try {



                query = "insert into artwork (art_id,art_name,art_introduction,art_type,art_artist,art_gallery,cost)" + "values (?,?,?,?,?,?,?)";
                preparedStmt = conn.prepareStatement(query);
                System.out.println("enter the id of art:");
                String art_id = scanner.next();
                System.out.println("enter the art name:");
                scanner.nextLine();
                String art_name = scanner.nextLine();
                System.out.println("enter the introduction of art:");
                scanner.nextLine();
                String art_introduction = scanner.nextLine();
                System.out.println("enter the type of art");
                String type = scanner.next();
                System.out.println("enter the id of the artist:");
                String artist_id = scanner.next();
                System.out.println("enter the gallery name for the art:");
                scanner.nextLine();
                String gallery = scanner.nextLine();
                System.out.println("enter the cost of art:");
                float cost = scanner.nextFloat();
                preparedStmt.setString(1, art_id);
                preparedStmt.setString(2, art_name);
                preparedStmt.setString(3, art_introduction);
                preparedStmt.setString(4, type);
                preparedStmt.setString(5, artist_id);
                preparedStmt.setString(6, gallery);
                preparedStmt.setFloat(7, cost);
                preparedStmt.execute();
                System.out.println("insert successfully :)");
                }

                catch (SQLException e){

                    System.out.println("Error Occurred try again :(");
                }
                break;


            case "auction":

                try {



                query = "insert  into auction(auction_name,holding_date,auction_gallery)" + "values (?,?,?)";
                preparedStmt = conn.prepareStatement(query);
                System.out.println("enter the name of auction:");
                scanner.nextLine();
                String auctionName = scanner.nextLine();
                System.out.println("enter the date the auction will hold: (like 2017-06-15)");
                String holdingDate = scanner.next();

                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd"); // your template here
                java.util.Date hold = formatter1.parse(holdingDate);
                java.sql.Date date = new java.sql.Date(hold.getTime());

                System.out.println("enter the name of gallery that auction hold in:");
                scanner.nextLine();
                String galleryName = scanner.nextLine();
                preparedStmt.setString(1, auctionName);
                preparedStmt.setDate(2, date);
                preparedStmt.setString(3, galleryName);
                preparedStmt.execute();
                System.out.println("insert successfully :)");

                }

                catch (SQLException e){

                    System.out.println("Error Occurred try again :(");
                }
                break;

            case "customer":

                try {



                query = "insert into customer(customer_id,customer_fnamr,customer_lname,customer_phone)" + "values (?,?,?,?)";
                preparedStmt = conn.prepareStatement(query);
                System.out.println("enter the customer id:");
                String customerId = scanner.next();
                System.out.println("enter the first name of customer:");
                String fName = scanner.next();
                System.out.println("enter the last name of customer:");
                scanner.nextLine();
                String lName = scanner.nextLine();
                System.out.println("enter the customer phone number:");
                String phone = scanner.next();
                preparedStmt.setString(1, customerId);
                preparedStmt.setString(2, fName);
                preparedStmt.setString(3, lName);
                preparedStmt.setString(4, phone);
                preparedStmt.execute();
                System.out.println("insert successfully :)");

                }

                catch (SQLException e){

                    System.out.println("Error Occurred try again :(");
                }
                break;


            case "factor":

                try {


                query = "insert  into factor(factor_id,factor_customer,factor_artist,factor_auction,offer_cost,first_cost)" + "values (?,?,?,?,?,?)";
                preparedStmt = conn.prepareStatement(query);
                System.out.println("enter the factor id:");
                String factor_id = scanner.next();
                System.out.println("enter the id of customer:");
                String factor_customer = scanner.next();
                System.out.println("enter the id of artist:");
                String factor_artist = scanner.next();
                System.out.println("enter the name of auction:");
                scanner.nextLine();
                String factor_auction = scanner.nextLine();
                System.out.println("enter the cost that customer offered:");
                float offer = scanner.nextFloat();
                System.out.println("enter the first cost of art:");
                float firstCost = scanner.nextFloat();
                preparedStmt.setString(1, factor_id);
                preparedStmt.setString(2, factor_customer);
                preparedStmt.setString(3, factor_artist);
                preparedStmt.setString(4, factor_auction);
                preparedStmt.setFloat(5, offer);
                preparedStmt.setFloat(6, firstCost);
                preparedStmt.execute();
                System.out.println("insert successfully :)");

                }

                catch (SQLException e){
                    System.out.println("Error Occurred try again :(");
                }
                break;

            default:

                System.out.println("table not found :/");
                break;



        }

    }

    public void update() {

        System.out.println("which table you want update?  ");
        Scanner scanner = new Scanner(System.in);
        String tableName = scanner.next();
        String col = "";
        String newcol = "";
        String query = "";
        PreparedStatement preparedStmt = null;

        switch (tableName) {

            case "artist":

                try {



                System.out.println("which column you want update?");
                col = scanner.next();
                System.out.println("enter the artist id that you want update her/his " + col);
                String id = scanner.next();
                System.out.println("enter new" + " " + col);

                int newAge;
                if (col != "age") {
                    newcol = scanner.next();
                    query = "update artist set" + " " + col + "=? where" + " " + "NATIONAL_CODE='" + id + "'";
                    preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, newcol);
                    preparedStmt.execute();
                } else {

                    newAge = scanner.nextInt();
                    query = "update artist set" + " " + col + "=? where" + " " + "NATIONAL_CODE='" + id + "'";
                    preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setInt(1, newAge);
                    preparedStmt.execute();
                }

                System.out.println("update successfully");}

                catch (SQLException e){
                    System.out.println("Error Occurred try again :(");
                }


                break;

            case "gallery":

                try {



                System.out.println("which column you want update?");
                col = scanner.next();
                System.out.println("enter the gallery name you want update its " + col);
                String name = scanner.next();
                System.out.println("enter new " + col);
                newcol = scanner.next();
                query = "update gallery set" + " " + col + "=? where" + " " + "GALLERY_NAME='" + name + "'";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, newcol);
                preparedStmt.execute();
                System.out.println("update successfully");}

                catch (SQLException e){
                    System.out.println("Error Occurred try again :(");
                }
                break;

            case "artwork":

                try {


                    System.out.println("which column you want update?");
                    col = scanner.next();
                    System.out.println("enter the id of art you want update its " + col);
                    String artId = scanner.next();

                    if (col != "cost") {
                        System.out.println("enter new " + col);
                        newcol = scanner.next();
                        query = "update artwork set" + " " + col + "=? where" + " " + "art_id='" + artId + "'";
                        preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setString(1, newcol);
                        preparedStmt.execute();
                        System.out.println("update successfully");

                    } else {
                        System.out.println("enter new " + col);
                        float newCost = scanner.nextFloat();
                        query = "update artwork set" + " " + col + "=? where" + " " + "art_id='" + artId + "'";
                        preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setFloat(1, newCost);
                        preparedStmt.execute();
                        System.out.println("update successfully");
                    }
                }
                catch (SQLException e){
                    System.out.println("Error Occurred try again :(");
                }

                break;

            case "auction":
                try {



                System.out.println("which column you want update?");
                col = scanner.next();
                System.out.println("enter the auction name you want update its " + col);
                String auctionName = scanner.next();
                System.out.println("enter new " + col);
                newcol = scanner.next();
                query = "update auction set" + " " + col + "=? where" + " " + "auction_name='" + auctionName + "'";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, newcol);
                preparedStmt.execute();
                System.out.println("update successfully");}

                catch (SQLException e){
                    System.out.println("Error Occurred try again :(");
                }
                break;

            case "customer":

                try {



                System.out.println("which column you want update?");
                col = scanner.next();
                System.out.println("enter the customer id you want update his/her " + col);
                String customerId = scanner.next();
                System.out.println("enter new " + col);
                newcol = scanner.next();
                query = "update customer set" + " " + col + "=? where" + " " + "customer_id='" + customerId + "'";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, newcol);
                preparedStmt.execute();
                System.out.println("update successfully");}
                catch (SQLException e){

                    System.out.println("Error Occurred try again :(");
                }
                break;

            case "factor":
                try {


                    System.out.println("which column you want update?");
                    col = scanner.next();
                    System.out.println("enter the factor id you want update its " + col);
                    String factorId = scanner.next();
                    if (col != "offer_cost" || col != "first_cost") {
                        System.out.println("enter new " + col);
                        newcol = scanner.next();
                        query = "update factor set" + " " + col + "=? where" + " " + "factor_id='" + factorId + "'";
                        preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setString(1, newcol);
                        preparedStmt.execute();
                        System.out.println("update successfully");
                    } else {

                        System.out.println("enter new " + col);
                        float cost1 = scanner.nextFloat();
                        query = "update factor set" + " " + col + "=? where" + " " + "factor_id='" + factorId + "'";
                        preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setFloat(1, cost1);
                        preparedStmt.execute();
                        System.out.println("update successfully");
                    }
                }
                catch (SQLException e){
                    System.out.println("Error Occurred try again :(");
                }

                break;

            default:
                System.out.println("table not found :/");
                break;


        }

    }

    public void delete()  {

        Scanner scanner = new Scanner(System.in);
        System.out.println("which table you want delete from?");
        String tableName = scanner.next();
        String query = "";


        System.out.println("enter the record id (or name if you select gallery or auction) you want delete it: ");
        scanner.nextLine();
        String delete = scanner.nextLine();

        switch (tableName) {

            case "artist":


                query = "delete from" + " " + tableName + " where NATIONAL_CODE =" + delete;

                break;

            case "gallery":

                query = "delete from" + " " + tableName + " where gallery_name ='" + delete + "'";
                break;

            case "artwork":
                query = "delete from" + " " + tableName + " where art_id ='" + delete + "'";
                break;

            case "auction":
                query = "delete from" + " " + tableName + " where auction_name ='" + delete + "'";
                break;

            case "customer":
                query = "delete from" + " " + tableName + " where customer_id ='" + delete + "'";
                break;

            case "factor":
                query = "delete from" + " " + tableName + " where factor_id='" + delete + "'";
                break;

            default:
                System.out.println("table not found :/");
                break;


        }

        try {



        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.execute();
        System.out.println("delete successfully");}

        catch (SQLException e){
            System.out.println("Error Occurred try again :(");
        }


    }


    {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/picto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(url, user, pass);

            if (conn != null) {
                System.out.println("successful");
            } else {

                System.out.println("Not successful");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    public static void main(String[] args) throws SQLException {
        xampp xampp = new xampp();


        boolean flag = true;

        while (flag) {

            System.out.println("Enter 1 if you want select from tables:" + "\n" + "2 for insert new row" + "\n" + "3 for update row" + "\n" + "4 for delete a row" + "\n" + "5 for exit");
            int num;
            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();


            switch (num) {

                case 1:
                    System.out.println("Enter name of the table you want see the records: ");
                    String table_Name = sc.next();
                    xampp.select_record(table_Name);

                    break;

                case 2:
                    try {
                        xampp.insert();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    xampp.update();
                    break;

                case 4:
                    xampp.delete();
                    break;

                case 5:
                    System.out.println("thank you for using this app" + "\n" + "Hope to see you again =)");
                    flag = false;
                    xampp.conn.close();
                    break;

            }


        }
    }
}
