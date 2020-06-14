package GameLogic.Commands.OnLiveReceptors;

import GameLogic.Commands.CommandName;
import GameLogic.Receptors.LiveReceptor;
import org.json.JSONException;
import org.json.JSONObject;

public class Heal extends OnLiveReceptor {
    private int lifePoints;

    public Heal() {
        super(CommandName.HEAL);
    }

    public void setHealingPoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public void execute(LiveReceptor liveReceptor) {
        liveReceptor.gainLifePoints(lifePoints);
    }

    @Override
    public void undo(LiveReceptor liveReceptor) {
        liveReceptor.loseLifePoints(lifePoints);
    }

    @Override
    public JSONObject toJson() {
        JSONObject heal = super.toJson();
        try {
            heal.put("lifepoints", lifePoints);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return heal;
    }
}
