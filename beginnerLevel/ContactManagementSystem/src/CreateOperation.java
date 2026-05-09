import java.util.List;
import java.util.Scanner;

public class CreateOperation {

    void addContacts(List<ContactStructure> contacts, Scanner s) {

        ContactStructure contact = new ContactStructure();

        try {

            System.out.print("Enter Name : ");
            String name = s.nextLine();

            if (name.isEmpty()) {
                System.out.println("Name can't be empty");
            } else {
                System.out.print("Enter Email : ");
                String email = s.nextLine();

                ExceptionHandler emailChecker = new ExceptionHandler();
                emailChecker.emailHandler(email, contacts);

                System.out.print("Enter Phone Number : ");
                String phone = s.nextLine();

                ExceptionHandler phoneChecker = new ExceptionHandler();
                phoneChecker.phoneHandler(phone, contacts);

                contact.setName(name);
                contact.setEmailAddress(email);
                contact.setPhoneNumber(phone);

                contacts.add(contact);

                System.out.println("Contact Added Successfully");
            }
        }

        catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }
    }
}