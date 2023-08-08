import java.util.Scanner;

public class studentDetails {

    public static void tableLines () {
        
        System.out.print("+");
        System.out.print("-".repeat(14));
        System.out.print("+");
        System.out.print("-".repeat(14));
        System.out.print("+");
        System.out.print("-".repeat(21));
        System.out.print("+");
        System.out.println();
    }

    public static void display(String name, int age, String[] subjectNames, double[] subjectMarks) {

        final String COLOR = "\033[3";
        final String RESET = "\033[0m";
        final String BOLD = "\033[1m";

        // Styling the name

        name = name.toUpperCase();
        name = COLOR+"4m"+BOLD+name+RESET;

        // Styling the age

        String ageDisplay = age+" years old";

        // Calculating the total and the average of marks

        double total = subjectMarks[0] + subjectMarks[1] + subjectMarks[2];
        double avg = total / 3;
        String avgString = String.format("%.2f", avg)+"%";

        // Styling the status

        String status;
        if (avg > 75) status = COLOR+"4m"+BOLD+"Distinguish Pass"+RESET;

        else if (avg>64) status = COLOR+"2m"+BOLD+"Credit Pass"+RESET;
    
        else if (avg >54) status = COLOR+"3m"+BOLD+"Pass"+RESET;

        else status = COLOR+"1m"+BOLD+"Fail"+RESET;

        //Checking the status of individual marks

        String[] statusMarks = new String [3];

        for (int itr=0; itr<3; itr++) {
            if (subjectMarks[itr] > 75) statusMarks[itr] = COLOR+"4m"+BOLD+"Distinguished Pass"+RESET;

            else if (subjectMarks[itr]>64) statusMarks[itr] = COLOR+"2m"+BOLD+"Credit Pass"+RESET;
        
            else if (subjectMarks[itr] >54) statusMarks[itr] = COLOR+"3m"+BOLD+"Pass"+RESET;

            else statusMarks[itr] = COLOR+"1m"+BOLD+"Fail"+RESET;

        }

        // Styling the subject name

        for (int itr=0; itr<3; itr++) {

            subjectNames[itr] = subjectNames[itr].substring(0,3)+String.format("%03d", Integer.parseInt(subjectNames[itr].substring(3)));
        }

        // Display the result with string formatting

        System.out.println();
        System.out.print("+");
        System.out.print("-".repeat(51));
        System.out.print("+");
        System.out.println();

        System.out.printf("| Name: %-57s|\n",name);
        System.out.printf("| Age: %-45s|\n",ageDisplay);
        System.out.printf("| Status: %-55s|\n",status);
        System.out.printf("| Total: %-15.2f Avg: %-22s|\n",total, avgString);

        tableLines();

        System.out.printf("| %-21s| %-21s| %-27s |\n", BOLD+"Subject"+RESET, BOLD+"Marks"+RESET, BOLD+"Status"+RESET);

        tableLines();
        
        for (int itr=0; itr < 3; itr++) {
            System.out.printf("| %-13s| %-13.2f| %-32s |\n", subjectNames[itr], subjectMarks[itr], statusMarks[itr]);
        }

        tableLines();
    }



    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boolean validity = true;
        String name = "";
        int age = 0;
        String[] subjectNames = new String[3];
        double[] subjectMarks = new double[3];

        mainBlock:
        {
            if (true) break mainBlock;
            // Name input
            System.out.print("Enter your name: ");
            name = scanner.nextLine();

            name = name.strip();

            // Name inout validation
            if (name.length() == 0) {

                validity = false;
                System.out.println("Invalid input name");
                break mainBlock;
            }

            // Age input
            System.out.print("Enter your age: ");
            age = scanner.nextInt();
            scanner.nextLine();

            // Age inout validation
            if (age < 10 || age > 18 ){

                validity = false;
                System.out.println("Invalid input age");
                break mainBlock;
            }

            // Looping for taking values of subject names and their marks
            for (int itr=0; itr<3; itr++) {

                // Subject name input
                System.out.printf("Enter your subject %s: ",itr+1);
                String subjectName = scanner.nextLine();

                // Subject name input validation
                subjectName = subjectName.strip();
                if (!subjectName.startsWith("SE-") || (subjectName.length() == 3 || subjectName.substring(3).length() >3)) {

                    validity = false;
                    System.out.println("Invalid input subject name");
                    break mainBlock; 

                } else subjectNames[itr] = subjectName;
                
                // Subject marks inout
                System.out.printf("Enter your marks %s: ", itr+1);
                double subjectMark = scanner.nextDouble();
                scanner.nextLine();

                // Subject marks input validation
                if (subjectMark > 100 || subjectMark < 0) {

                    validity = false;
                    System.out.println("Invalid input marks");
                    break mainBlock;

                } else subjectMarks[itr] = subjectMark;

            }

        }

        testData:
        {
            // if (true) break testData;
            name = "Shehan rathnayake";
            age = 13;
            subjectNames[0] = "SE-1";
            subjectNames[1] = "SE-2";
            subjectNames[2] = "SE-3";

            subjectMarks[0] = 88.523;
            subjectMarks[1] = 68;
            subjectMarks[2] = 40;
        }
        
        
        // Calling display finction to display the result
        if (validity) display(name, age, subjectNames, subjectMarks);

        else System.out.println("---------------------------------");
        
    }

}