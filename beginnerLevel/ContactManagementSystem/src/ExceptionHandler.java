import java.util.List;

public class ExceptionHandler {

  void emailHandler(String email, List<ContactStructure> contacts) {

    email = email.trim().toLowerCase();

    String emailRegex ="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    if (!email.matches(emailRegex)) {
        throw new IllegalArgumentException("Invalid Email Format");
    }

    for (ContactStructure c : contacts) {
        if (c.getEmailAddress().toLowerCase().equals(email)) {
            throw new IllegalArgumentException("Email Id Already Exists");
        }
    }
}

    void phoneHandler(String phone, List<ContactStructure> contacts) {

        String phoneRegex = "^[0-9]{10}$";

        if (!phone.matches(phoneRegex)) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        for (ContactStructure c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                throw new IllegalArgumentException("Phone Number Already Exists");
            }
        }
    }
}