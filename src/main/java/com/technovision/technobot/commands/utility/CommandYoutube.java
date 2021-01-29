package com.technovision.technobot.commands.utility;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class CommandYoutube extends Command {


    public CommandYoutube(final TechnoBot bot) {
        super(bot,"youtube", "Sends a link to TechnoVision's YouTube Channel", "{prefix}youtube", Command.Category.UTILITY);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage("Check out TechnoVision's YouTube channel: https://youtube.com/c/TechnoVisionTV").queue();
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("technovision");
    }
}
