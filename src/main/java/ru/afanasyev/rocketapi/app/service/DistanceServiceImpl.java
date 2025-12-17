package ru.afanasyev.rocketapi.app.service;

import org.springframework.stereotype.Component;
import ru.afanasyev.rocketapi.app.util.DistanceService;
import ru.afanasyev.rocketapi.domain.GameObject;

@Component
public class DistanceServiceImpl implements DistanceService {
    @Override
    public double calculateDistance(GameObject first, GameObject second) {
        // TODO Папа
        return Math.sqrt(Math.pow(second.getPosition().getX()-first.getPosition().getX(),2) + Math.pow(second.getPosition().getY()-first.getPosition().getY(),2))-second.getSize()-first.getSize();
    }
}
