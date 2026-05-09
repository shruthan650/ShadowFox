import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        List<ContactStructure> contacts = new ArrayList<>();

        while (true) {

            System.out.println("\nCONTACT MANAGEMENT SYSTEM");
            System.out.println("-------------------------------");
            System.out.println("1. Create a contact");
            System.out.println("2. Read a contact");
            System.out.println("3. Update a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");

            try {
                System.out.print("Choose an option from above: ");
                int choice = s.nextInt();
                s.nextLine();

                System.out.println("------------------------------\n");

                switch (choice) {
                    case 1:
                        CreateOperation create = new CreateOperation();
                        create.addContacts(contacts, s);
                        break;

                    case 2:
                        ReadOperation read = new ReadOperation();
                        read.readContacts(contacts, s);
                        break;

                    case 3:
                        UpdateOperation update = new UpdateOperation();
                        update.updateContact(contacts, s);
                        break;

                    case 4:
                        DeleteOperation delete = new DeleteOperation();
                        delete.deleteContact(contacts, s);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        s.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }
            }

            catch (InputMismatchException e) {
                System.out.println("Please enter numbers only");
                s.nextLine();
            }
        }
    }
}