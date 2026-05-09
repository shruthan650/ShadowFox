import java.util.List;
import java.util.Scanner;

public class ReadOperation {

    public void readContacts(List<ContactStructure> contacts, Scanner s) {

        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty...");
        }

        else {
            System.out.print("Enter contact name to search : ");
            String readName = s.nextLine();
            boolean found = false;

            for (ContactStructure c : contacts) {
                if (c.getName().equalsIgnoreCase(readName)) {
                    System.out.println("Name : " + c.getName());
                    System.out.println("Phone : " + c.getPhoneNumber());
                    System.out.println("Email : " + c.getEmailAddress());
                    System.out.println("--------------------------");

                    found = true;
                }
            }

            if (!found) {
                System.out.println("Contact not found");
            }
        }
    }
}