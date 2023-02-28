
package models;

import java.io.Serializable;

public class User implements Serializable {
    String email;
    String firstName;
    String lastName;
    String password;
    Role role;
}
