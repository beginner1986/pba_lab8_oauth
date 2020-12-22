package io.swagger;

import io.swagger.model.CreateRequest;
import io.swagger.model.UpdateRequest;
import io.swagger.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DatabaseMock {
    public List<User> users = new ArrayList<>();

    public DatabaseMock() {
        User u1 = new User();
        u1.setId(UUID.fromString("e0134072-e2e5-4d38-a239-4f9edca26c3f"));
        u1.setName("Jan");
        u1.setSurname("Kowalski");
        u1.setAge(34);
        u1.setCitizenship(User.CitizenshipEnum.PL);
        u1.setEmail("j.kowalski@gmail.com");
        u1.setPersonalId("86012912345");
        users.add(u1);

        User u2 = new User();
        u2.setId(UUID.fromString("458b1b4e-dfae-46ef-ad19-60e6192ef935"));
        u2.setName("Hans");
        u2.setSurname("Kloss");
        u2.setAge(33);
        u2.setCitizenship(User.CitizenshipEnum.DE);
        u2.setEmail("h.kloss@bundeswehr.de");
        u2.setPersonalId("87113012345");
        users.add(u2);

        User u3 = new User();
        u3.setId(UUID.fromString("901d1cc7-6486-4c10-aa45-1697b9af074a"));
        u3.setName("John");
        u3.setSurname("Smith");
        u3.setAge(35);
        u3.setCitizenship(User.CitizenshipEnum.UK);
        u3.setEmail("j.smith@altavista.com");
        u3.setPersonalId("85052212345");
        users.add(u3);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(UUID id) {
        for(User u : users)
            if(u.getId().equals(id))
                return u;

        return null;
    }

    public User createUser(CreateRequest request) {
        User user = request.getUser();
        users.add(user);
        return user;
    }

    public void deleteUser(UUID id) {
        users.removeIf(u -> u.getId().equals(id));
    }


    public User updateUser(UUID id, UpdateRequest request) {
        for(User u : users) {
            if(u.getId().equals(id))
            {
                u = request.getUser();
                return u;
            }
        }

        return null;
    }
}
