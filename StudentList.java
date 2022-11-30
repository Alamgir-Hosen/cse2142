import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    static Constants constants = new Constants();
    public static BufferedReader getBufferedReader(){
        try{
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(constants.StudentList)));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public static BufferedWriter getBufferedWriter(){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(constants.StudentList, true));
            return  bufferedWriter;
        }catch (Exception e){
            System.out.println(e);
        }
        return  null;
    }
    public static void main(String[] args) {

//		Check arguments
        if (args[0].equals(constants.ShowAll)) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = getBufferedReader();
                String studentNames[] = bufferedReader.readLine().split(constants.StudentEntryDelimiter);
                for (String studentName : studentNames) {
                    System.out.println(studentName.trim());
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals(constants.ShowRandom)) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = getBufferedReader();
                String studentNames[] = bufferedReader.readLine().split(constants.StudentEntryDelimiter);
                Random random = new Random();
                int studentNumber = random.nextInt(4);
                System.out.println(studentNames[studentNumber].trim());
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains(constants.AddEntry)) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = getBufferedWriter();
                String newStudentName = args[0].substring(1);
                Date date = new Date();
                String dateformate = "dd/MM/yyyy-hh:mm:ss a";
                String fd = new SimpleDateFormat(dateformate).format(date);
                bufferedWriter.write(constants.StudentEntryDelimiter + newStudentName + "\nList last updated on " + fd);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains(constants.FindEntry)) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = getBufferedReader();
                String line = bufferedReader.readLine();
                if (line.contains(args[0].substring(1))) {
                    System.out.println("We Found it");
                } else {
                    System.out.println("Not found");

                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains(constants.ShowCount)) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = getBufferedReader();
                String names[] = bufferedReader.readLine().split(constants.StudentEntryDelimiter);
                System.out.println(names.length / 2 + " words found");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }
        else{
            System.out.println("Usage:constants.ShowAll|constants.ShowCount|constants.ShowRandom|+Studenti|?StudentI");
        }
    }
}