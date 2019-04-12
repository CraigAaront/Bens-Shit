import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException {
        String filename = "Dogbone.txt";
        String newFile = "newDogBone.txt";
        BufferedReader br = new BufferedReader(new FileReader(filename));
        BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

        int counter = 0;
        String read = br.readLine();
        while (counter<52) {
            bw.write(read);
            bw.newLine();
            read = br.readLine();
            counter += 1;
        }
        int f600Increment = 1;
        while (read != null) { 
            if(read.equals("G92 E0")) {
                bw.write("M106 S255");
                bw.newLine();
                bw.write(read);
                bw.newLine();
                read = br.readLine();
            }
            else if(read.equals("G4 P1")) {
                bw.write(read);
                bw.newLine();
                bw.write("M107");
                bw.newLine();
                read = br.readLine();
            }
            else if(read.equals("G1 F600")) {
                bw.write("G1 F" + fIncrement(f600Increment));
                bw.newLine();
                System.out.println("G1 F" + fIncrement(f600Increment));
                f600Increment++;
                read = br.readLine();
            }
            else {
                bw.write(read);
                bw.newLine();
                read = br.readLine();
            }
        }
    }
    public static int fIncrement(int incrementer) {
        int output = 0;
        if (incrementer == 1) {
            output = 600;
        }
        else if (incrementer == 2) {
            output = 1200;
        }
        else {
            output = 1200 + ((incrementer - 2) * 60);
        }
        return output;
    }
}