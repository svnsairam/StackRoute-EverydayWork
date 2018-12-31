import java.util.Scanner;

public class BillsBurger {

    public static void main(String arg[]){
        System.out.println("choose the burger type :");
        System.out.println("1. Hamburger");
        System.out.println("2. HealtyBurger");
        System.out.println("3. Delux burger");

        Scanner scanner = new Scanner(System.in);
        int  choice = scanner.nextInt();

        switch (choice)
        {
            case 0 :
                Hamburger  myhamburger = new Hamburger("wheat_bread", "meat");

                break;
            case 1 :
                Hamburger  myhealthyhamburger = new  HealthyHamburger();
                break;
            case 2 :
                Hamburger  mydeluxHamburger   = new  DeluxHamburger();
                // Statements
        }




    }

}



class Hamburger {

    int costtomato = 45;
    int costlettuce = 55;
    int costcarrot = 55;
    int costpotato = 35;
    String bread_type;
    String non_veg;
    int total;



    public  Hamburger(String bread, String item){
        bread_type = bread;
        non_veg = item;
       }

    public

}
class HealthyHamburger extends  Hamburger{

    int costCheese = 55;
    int costOlives = 60;

    public  Hamburger(String bread, String item) {



    }
        public boolean addCheese(){
        System.out.println("Do you want to add cheese");

    }
}

class DeluxHamburger extends Hamburger{
    public DeluxHamburger(){

    }


}