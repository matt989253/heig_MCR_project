package GameLogic.Commands.OnLiveReceptors;

import GameLogic.Commands.CommandName;
import GameLogic.Receptors.LiveReceptor;
import org.json.JSONException;
import org.json.JSONObject;

public class Hit extends OnLiveReceptor {
    private int attackPoints;

    public Hit() {
        super(CommandName.HIT);
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    @Override
    public void execute(LiveReceptor liveReceptor) {
        liveReceptor.loseLifePoints(attackPoints);
    }

    @Override
    public void undo(LiveReceptor liveReceptor) {
        liveReceptor.gainLifePoints(attackPoints);
    }

    @Override
    public JSONObject toJson() {
        JSONObject hit = super.toJson();
        try {
            hit.put("attackpoints", attackPoints);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hit;
    }
}
