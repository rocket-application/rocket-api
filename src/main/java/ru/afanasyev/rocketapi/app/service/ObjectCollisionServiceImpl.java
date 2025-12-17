package ru.afanasyev.rocketapi.app.service;

import org.springframework.stereotype.Component;
import ru.afanasyev.rocketapi.app.util.ObjectCollisionService;
import ru.afanasyev.rocketapi.domain.GameObject;

@Component
public class ObjectCollisionServiceImpl implements ObjectCollisionService {
    @Override
    public boolean checkCollision(GameObject first, GameObject second) {
        // TODO Папа проверка столкновения между двумя обьектам
        // return true - если объекты столкнулись, иначе false
        return false;
    }
}
