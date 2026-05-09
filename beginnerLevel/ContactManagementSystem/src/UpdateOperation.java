import java.util.List;
import java.util.Scanner;

public class UpdateOperation {

    public void updateContact(List<ContactStructure> contacts, Scanner s) {

        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty...");
            return;
        }

        System.out.print("Enter contact name to update : ");

        String searchName = s.nextLine();
        boolean found = false;

        ExceptionHandler handler =new ExceptionHandler();

        for (ContactStructure c : contacts) {
            if (c.getName().equalsIgnoreCase(searchName)) {
                found = true;

                try {
                    System.out.print("Enter new phone number : ");
                    String newPhone = s.nextLine();
                    handler.phoneHandler(newPhone, contacts);

                    System.out.print("Enter new email : ");
                    String newEmail = s.nextLine();
                    handler.emailHandler(newEmail, contacts);

                    c.setPhoneNumber(newPhone);
                    c.setEmailAddress(newEmail);

                    System.out.println("Contact Updated Successfully");
                    break;
                }

                catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        if (!found) {
            System.out.println("Contact Not Found");
        }
    }
}