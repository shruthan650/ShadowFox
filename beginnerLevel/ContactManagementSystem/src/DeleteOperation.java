import java.util.List;
import java.util.Scanner;

public class DeleteOperation {

    void deleteContact(List<ContactStructure> contacts, Scanner s) {

        if (contacts.isEmpty()) {
            System.out.println("No contacts to delete");
        } else {
            System.out.print("Enter contact name to delete : ");
            String searchName = s.nextLine();

            boolean found = false;

            for (int i = 0; i < contacts.size(); i++) {

                if (contacts.get(i).getName().equalsIgnoreCase(searchName)) {

                    contacts.remove(i);

                    found = true;

                    System.out.println("Contact Deleted Successfully");

                    break;
                }
            }

            if (!found) {
                System.out.println("Contact Not Found");
            }
        }

    }
}