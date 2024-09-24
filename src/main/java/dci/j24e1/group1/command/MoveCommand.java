package dci.j24e1.group1.command;

import dci.j24e1.group1.GameState;
import dci.j24e1.group1.types.Area;
import dci.j24e1.group1.types.Direction;

public class MoveCommand implements Command {

    private final Direction direction;

    public MoveCommand(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void execute(GameState gs) {

        //direction
        if (this.direction == Direction.LEFT) {
            Area next = gs.getToLeft();
            gs.setLocation(next);
        } else if (this.direction == Direction.RIGHT) {
            Area next = gs.getToRight();
            gs.setLocation(next);

        } else {
            throw new RuntimeException("Invalid direction: " + this.direction);
        }

    }
}
