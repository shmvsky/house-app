package ru.shmvsky.houseapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shmvsky.houseapp.entity.House;
import ru.shmvsky.houseapp.entity.User;
import ru.shmvsky.houseapp.repo.HouseRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    //Create
    public House createHouse(User owner, String address) {
        House house = House.builder()
                .owner(owner)
                .address(address)
                .users(new HashSet<User>(Arrays.asList(owner)))
                .build();

        return houseRepository.save(house);
    }

    //Read
    public House getHouseById(Long houseId) {
        return houseRepository.findById(houseId).orElse(null);
    }

    //Update
    public House updateHouse(Long id, User owner, Set<User> users, String address) {
        House house = getHouseById(id);

        house.setOwner(owner);
        house.setUsers(users);
        house.setAddress(address);

        return houseRepository.save(house);
    }

    //Delete
    public void deleteHouse(House house) {
        houseRepository.delete(house);
    }

}
