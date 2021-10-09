import java.util.Random;
import java.util.Scanner;

public class Assignment1 {
    public static class Vaccine{
        String vname;
        int vdoses;
        int vgap;
        Vaccine(String name, int doses, int gap){
            vname = name;
            vdoses = doses;
            vgap = gap;
        }
        void display(){
            System.out.print("Vaccine Name: " + vname + ",");
            System.out.print("Number of Doses: " + vdoses + ",");
            System.out.print("Gap between Doses: " + vgap);

        }
    }
    public static class Hospital{
        String hname;
        int hpin;
        int hunique_id;
        Hospital(String name, int pin, int unique_id){
            hname = name;
            hpin = pin;
            hunique_id = unique_id;
        }
        void display(){
            System.out.print("Hospital Name: " + hname + ",");
            System.out.print("PinCode: " + hpin + ",");
            System.out.print("Unique ID: " + hunique_id);
        }
    }
    public static class Citizen{
        String cname;
        int cage;
        int cunique_id;
        Citizen(String name, int age, int unique_id){
            cname = name;
            cage = age;
            cunique_id = unique_id;
        }
        void display(){
            System.out.print("Citizen Name: " + cname + ",");
            System.out.print("Age: " + cage + ",");
            System.out.print("Unique ID: " + cunique_id);
            if (cage < 18){
                System.out.println("Only above 18 are allowed");
            }
        }
    }
    public static void main(String[] args) {
        int tag = 0;
        Scanner sc = new Scanner(System.in);
        while(tag != 1){
            System.out.println("CoWin Portal initialized....");
            System.out.println("---------------------------------");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all slots for a hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println("---------------------------------");
            System.out.print("Enter Query: ");
            int input = sc.nextInt();
            if (input == 8){
                tag += 1;
            }
            else if (input == 1){
                System.out.print("Vaccine Name: ");
                String name = sc.nextLine();
                System.out.print("Number of Doses: ");
                int doses = sc.nextInt();
                System.out.print("Gap between Doses: ");
                int gap = sc.nextInt();
                Vaccine v = new Vaccine(name,doses,gap);
                v.display();
            }
            else if (input == 2){
                Random rand = new Random();
                System.out.print("Hospital Name: ");
                String name = sc.nextLine();
                System.out.print("PinCode: ");
                int pin = sc.nextInt();
                int unique_id = rand.nextInt(999999);
                Hospital h = new Hospital(name, pin, unique_id);
                h.display();
            }
            else if (input == 3){
                System.out.print("Citizen Name: ");
                String name = sc.nextLine();
                System.out.print("Age: ");
                int age = 





            }


        }




    }




}
