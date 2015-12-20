package hardcorequesting.reward;

import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.List;

public class CommandRewardList extends QuestRewardList<CommandReward.Command> {
    public void executeAll(EntityPlayer player)
    {
        for (QuestReward<CommandReward.Command> reward : list)
            reward.getReward().execute(player);
    }

    public void set(String[] commands)
    {
        clear();
        for (String command : commands)
            add(new CommandReward(new CommandReward.Command(command)));
    }

    public String[] asStrings()
    {
        List<String> commands = new ArrayList<>();
        for (QuestReward<CommandReward.Command> reward : list)
            commands.add(reward.getReward().asString());
        return commands.toArray(new String[commands.size()]);
    }
}
