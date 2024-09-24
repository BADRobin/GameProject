package dci.j24e1.group1.command;

import dci.j24e1.group1.GameState;
import dci.j24e1.group1.types.Area;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateRandomDirectionCommand implements Command {
    private static final Area STARTING_AREA = Area.SPRING;

    @Override
    public void execute(GameState gs) {
        Random random = new Random();
        Area[] values = Area.values();

        List<Area> availableAreas = new ArrayList<>();
        for (Area area : values) {
            if (area != STARTING_AREA) {
                availableAreas.add(area);
            }
        }

        int randomLeftIndex = random.nextInt(availableAreas.size());
        Area leftDirection = availableAreas.get(randomLeftIndex);


        availableAreas.remove(randomLeftIndex);
        int randomRightIndex = random.nextInt(availableAreas.size());
        Area rightDirection = availableAreas.get(randomRightIndex);

        gs.setToLeft(leftDirection);
        gs.setToRight(rightDirection);

//        int randomLeft = random.nextInt(values.length);
//        gs.setToLeft(values[randomLeft]);
//        int randomRight = random.nextInt(values.length);
//        gs.setToRight(values[randomRight]);
    }
}
