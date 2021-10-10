import java.util.Objects;
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
            System.out.print("Vaccine Name: " + vname + ", ");
            System.out.print("Number of Doses: " + vdoses + ", ");
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
            System.out.print("Hospital Name: " + hname + ", ");
            System.out.print("PinCode: " + hpin + ", ");
            System.out.print("Unique ID: " + hunique_id);
        }
    }
    public static class Slot{
        int shid;
        int sday;
        int squantity;
        String vname;
        String hname;
        Slot(int hid, int day, int quantity, String name, String hospital){
            shid = hid;
            sday = day;
            squantity = quantity;
            vname = name;
            hname = hospital;
        }
        void display(){
            System.out.println("Slot added by Hospital " + shid + " for Day: " + sday + ", " + "Available Quantity: " + squantity + " of Vaccine " + vname);
        }
    }
    public static class Citizen{
        String cname;
        int cage;
        String cunique_id;
        Citizen(String name, int age, String unique_id){
            cname = name;
            cage = age;
            cunique_id = unique_id;
        }
        void display(){
            System.out.print("Citizen Name: " + cname + ",");
            System.out.print(" Age: " + cage + ",");
            System.out.print(" Unique ID: " + cunique_id);
            if (cage < 18){
                System.out.println("\nOnly above 18 are allowed");
            }
        }
    }
    public static void main(String[] args) {
        int tag = 0;
        Scanner sc = new Scanner(System.in);
        Vaccine[] vaccines;
        vaccines = new Vaccine[100];
        Hospital[] hospitals;
        hospitals = new Hospital[100];
        Citizen[] citizens;
        citizens = new Citizen[100];
        Slot[] slots;
        slots = new Slot[100];
        int vcount = 0;
        int hcount = 0;
        int ccount = 0;
        int scount = 0;
        System.out.println("\nCoWin Portal initialized....");
        while(tag != 1){
            System.out.println("\n---------------------------------");
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
                String name = sc.next();
                System.out.print("Number of Doses: ");
                int doses = sc.nextInt();
                System.out.print("Gap between Doses: ");
                int gap = sc.nextInt();
                vaccines[vcount] = new Vaccine(name,doses,gap);
                vaccines[vcount].display();
                vcount++;
            }
            else if (input == 2){
                Random rand = new Random();
                System.out.print("Hospital Name: ");
                String name = sc.next();
                System.out.print("PinCode: ");
                int pin = sc.nextInt();
                int unique_id = rand.nextInt(999999);
                hospitals[hcount] = new Hospital(name, pin, unique_id);
                hospitals[hcount].display();
                hcount++;
            }
            else if (input == 3){
                System.out.print("Citizen Name: ");
                String name = sc.next();
                System.out.print("Age: ");
                int age = sc.nextInt();
                System.out.print("Unique ID: ");
                String unique_id = sc.next();
                citizens[ccount] = new Citizen(name, age, unique_id);
                citizens[ccount].display();
                ccount++;
            }
            else if (input == 4){
                System.out.print("Enter Hospital ID: ");
                int id = sc.nextInt();
                String hname = "";
                for(int x = 0; x < hcount; x++){
                    if (hospitals[x].hunique_id == id){
                        hname = hospitals[x].hname;
                    }
                }
                System.out.print("Enter number of Slots to be added: ");
                int number = sc.nextInt();
                for(int i = 0; i < number; i++){
                    System.out.print("Enter Day Number: ");
                    int day = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    System.out.println("Select Vaccine");
                    for(int j = 0; j < vcount; j++){
                        System.out.println(j + ". " + vaccines[j].vname);
                    }
                    int choice = sc.nextInt();
                    slots[scount] = new Slot(id, day, quantity, vaccines[choice].vname, hname);
                    slots[scount].display();
                    scount++;
                }
            }
            else if (input == 5){
                System.out.print("Enter patient Unique ID: ");
                String puid = sc.next();
                System.out.println("1. Search by Area");
                System.out.println("2. Search by Vaccine");
                System.out.println("3. Exit");
                System.out.print("Enter Option: ");
                int option = sc.nextInt();
                if (option == 1){
                    System.out.print("Enter PinCode: ");
                    int pin = sc.nextInt();
                    for (int i = 0; i < hcount; i++){
                        if (pin == hospitals[i].hpin){
                            System.out.print(hospitals[i].hunique_id);
                            System.out.print(" ");
                            System.out.print(hospitals[i].hname);
                        }
                    }
                    System.out.println("\n");
                    System.out.print("Enter Hospital ID: ");
                    int id = sc.nextInt();
                    int l = 0;
                    String[] arr = new String[scount];
                    for(int j = 0; j < scount; j++){
                        if(id == slots[j].shid){
                            System.out.println(l + "-> " + "Day: " + slots[j].sday + " Available Qty: " + slots[j].squantity + " Vaccine: " + slots[j].vname);
                            arr[l] = slots[j].vname;
                            l++;
                        }
                    }
                    System.out.print("Choose Slot: ");
                    int choose = sc.nextInt();
                    for(int k = 0; k < ccount; k++){
                        if(Objects.equals(puid, citizens[k].cunique_id)){
                            System.out.println(citizens[k].cname + " vaccinated with " + arr[choose]);
                        }
                    }
                }
                else if (option == 2){
                    System.out.print("Enter Vaccine Name: ");
                    String vaccine = sc.next();
                    for(int i = 0; i < scount; i++){
                        if (Objects.equals(slots[i].vname, vaccine)){
                            System.out.println(slots[i].shid + " " + slots[i].hname);
                        }
                    }
                    System.out.print("Enter Hospital ID: ");
                    int id = sc.nextInt();
                    int l = 0;
                    String[] arr = new String[scount];
                    for(int j = 0; j < scount; j++){
                        if(id == slots[j].shid){
                            System.out.println(l + "-> " + "Day: " + slots[j].sday + " Available Qty: " + slots[j].squantity + " Vaccine: " + slots[j].vname);
                            arr[l] = slots[j].vname;
                            l++;
                        }
                    }
                    int choose = sc.nextInt();
                    for(int k = 0; k < ccount; k++){
                        if(Objects.equals(puid, citizens[k].cunique_id)){
                            System.out.println(citizens[k].cname + " vaccinated with " + arr[choose]);
                        }
                    }
                }
            }
            else if (input == 6){
                System.out.print("Enter Hospital ID: ");
                int id = sc.nextInt();
                for(int j = 0; j < scount; j++){
                    if (id == slots[j].shid){
                        System.out.println("Day: " + slots[j].sday + " Available Qty: " + slots[j].squantity + " Vaccine: " + slots[j].vname);
                    }
                }
            }
            else if(input == 7){
                System.out.print("Enter Patient ID: ");
                String pid = sc.next();
                System.out.println("");
            }
        }
    }
}
