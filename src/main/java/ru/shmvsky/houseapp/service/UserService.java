package ru.shmvsky.houseapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shmvsky.houseapp.entity.House;
import ru.shmvsky.houseapp.entity.User;
import ru.shmvsky.houseapp.repo.UserRepository;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Create
    public User createUser(String name, String password, Integer age) {
        User user = User.builder()
                .name(name)
                .password(password)
                .age(age)
                .build();

        return userRepository.save(user);
    }


    //Read
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //Update
    public User updateUser(Long id, String name, String password, Integer age, Set<House> houses, Set<House> ownedHouses) {

        User user = getUserById(id);

        user.setName(name);
        user.setPassword(password);
        user.setAge(age);
        user.setHouses(houses);
        user.setOwnedHouses(ownedHouses);

        return userRepository.save(user);
    }

    //Delete
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}
