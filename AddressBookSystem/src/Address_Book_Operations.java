import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Address_Book_Operations {

    static String f_name;
    static Scanner s=new Scanner(System.in);

    public static void addAddressBook(Map<String, List<Contact>> addressBooks) {
        System.out.println("Add new AddressBook");
        String bookName = s.next();
        addressBooks.put(bookName, new ArrayList<Contact>());
    }

    public static void displayAllAddressBook(Map<String, List<Contact>> addressBooks) {
        boolean is_Empty=addressBooks.isEmpty();
        if(is_Empty==true)
            System.out.println("No Address Books are Present");
        else
            System.out.println(addressBooks);
    }

    public static void editAddressBook(Map<String, List<Contact>> addressBooks) {
        System.out.println("Enter the name of the AddressBook you want to Edit");
        String bookName1 = s.next();

        if(addressBooks.containsKey(bookName1)) {
            List<Contact> contact = addressBooks.get(bookName1);
            int choice;
            do{
                System.out.println("Enter your option : ");
                System.out.println("1.Add contact  ");
                System.out.println("2.Display all contact ");
                System.out.println("3.Edit Contact ");
                System.out.println("4.Delete Contact ");
                System.out.println("5.Search Contact by City");
                System.out.println("6.View Contact's First Name and Last Name by City ");
                System.out.println("7.Count of Total Contacts By City");
                System.out.println("8.Count of Total Contacts By State");
                System.out.println("9.Sort Contacts by first Name");
                System.out.println("10.Sorted Contacts by City");
                System.out.println("11.Sorted Contacts by State");
                System.out.println("12.Sorted Contacts by Zip");

                choice=s.nextInt();
                switch (choice)
                {
                    case 1:
                        System.out.print("Add Contact  \n");
                        System.out.print("Enter First Name :");
                        String fName=s.next();

                        if (Contact_Operations.checkDuplicate(fName,contact)==false) {
                            Contact_Operations.Add_Contact(fName,contact);
                        } else {
                            System.out.println("Already exists");
                        }
                        break;
                    case 2:
                        Contact_Operations.Display_All(contact);
                        break;
                    case 3:
                        Contact_Operations.editContact(contact);
                        break;
                    case 4:
                        Contact_Operations.deleteContact(contact);
                        break;
                    case 5:
                        Contact_Operations.searchByCityOrState(contact);
                        break;
                    case 6:
                        Contact_Operations.viewPersonByCityOrState(contact);
                        break;
                    case 7:
                        Contact_Operations.countByCity(contact);
                        break;
                    case 8:
                        Contact_Operations.countByState(contact);
                        break;
                    case 9:
                        Contact_Operations.sortedContactByFirstName(contact);
                        break;
                    case 10:
                        Contact_Operations.sortedContactByCity(contact);
                        break;
                    case 11:
                        Contact_Operations.sortedContactByState(contact);
                        break;
                    case 12:
                        Contact_Operations.sortedContactByZip(contact);
                        break;
                    default:
                        System.out.println("Enter valid option");
                        break;
                }
                System.out.println("Do you want to continue (1.Continue or 0.Exit)");
                choice=s.nextInt();
            }while(choice != 0);
        }
        else
            System.out.println("Invalid AddressBook Name!Not exist");
    }
}