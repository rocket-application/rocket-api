package ru.afanasyev.rocketapi.app;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.afanasyev.rocketapi.domain.GameObject;

@Component
public class DistanceServiceImpl implements DistanceService {
    @Override
    public double calculateDistance(@NotNull GameObject first, @NotNull GameObject second) {
        return 0;
    }
}
