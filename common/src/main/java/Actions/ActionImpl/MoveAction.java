package Actions.ActionImpl;

import Actions.SimpleAction;
import Entities.Player;
import logic.CharacterCache;

public class MoveAction extends SimpleAction {

    private boolean[] moves; // [U,D,L,R]

    public MoveAction(){

    }

    public MoveAction(boolean[] moves) {
        this.moves = moves;
    }

    @Override
    public void executeAction(Integer id) {
        Player p = CharacterCache.getInstance().getPlayer(id);
        p.setPosX(p.getPosX()+1);
        super.executeAction(id);
    }
}
