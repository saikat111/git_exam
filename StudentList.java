import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader readFile = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("students.txt"))); // taking input
//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {

				String readLine = readFile.readLine();
				String i[] = readLine.split(",");
				for(String j : i) { System.out.println(j); }
			} catch (Exception e){}
			System.out.println("Data Loaded."); // data load
		}
		//		Check arguments
		else if(args[0].equals("r"))
		{
			System.out.println("Loading data ...");
			try {

				String readLine = readFile.readLine();
				String i[] = readLine.split(",");
				Random x = new Random();
				int y = x.nextInt(4); // generate new random numbers
				System.out.println(i[y]);
			} catch (Exception e){}
			System.out.println("Data Loaded.");
		}
		//		Check arguments
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");
			try {
				BufferedWriter s = new BufferedWriter(
						new FileWriter("students.txt", true));//file write
				String t = args[0].substring(1);
				Date d = new Date();
				String df = "dd/mm/yyyy-hh:mm:ss a"; //date style
				DateFormat dateFormat = new SimpleDateFormat(df);
				String fd= dateFormat.format(d);
				s.write(", "+t+"\nList last updated on "+fd); // write the file
				s.close();
			} catch (Exception e){}

			System.out.println("Data Loaded.");
		}
		//		Check arguments
		else if(args[0].contains("?"))
		{
			System.out.println("Loading data ...");
			try {
				BufferedReader s = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt"))); // file read
				String readLine = s.readLine();
				String i[] = readLine.split(",");
				boolean done = false;
				String t = args[0].substring(1);
				for(int idx = 0; idx<i.length && !done; idx++) {
					if(i[idx].equals(t)) {
						System.out.println("We found it!"); // when data found
						done=true;
					}
				}
			} catch (Exception e){}
			System.out.println("Data Loaded.");
		}
		//		Check arguments
		else if(args[0].contains("c"))
		{
			System.out.println("Loading data ...");
			try {
				String D = readFile.readLine();
				char a[] = D.toCharArray();
				boolean in_word = false;
				int count=0;
				for(char c:a) {
					if(c ==' ')
					{
						if (!in_word) {	count++; in_word =true;	}
						else { in_word=false;}
					}
				}
				System.out.println(count +" word(s) found " + a.length); // output
			} catch (Exception e){}
			System.out.println("Data Loaded.");
		}
		else{
			System.out.println("wrong output");
		}
	}
}