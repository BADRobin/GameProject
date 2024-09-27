package dci.j24e1.group1.command;

import dci.j24e1.group1.GameState;

public interface Command {
    void execute(GameState gs) throws Exception;
}
