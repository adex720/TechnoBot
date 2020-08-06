package com.technovision.technobot.commands.other;

import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandGoogle extends Command {

    public CommandGoogle() {
        super("google","Creates a google search","{prefix}google", Command.Category.OTHER);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(":mag: Google Search");
        embed.setColor(ERROR_EMBED_COLOR);

        if (args.length > 1) {
            String search = String.join("+", args);
            embed.setDescription(String.format("https://lmgtfy.com/?q=%s", search));
            embed.setColor(EMBED_COLOR);
        }
        else { embed.setDescription("Not enough arguments!"); }
        event.getChannel().sendMessage(embed.build()).queue();
        return true;
    }
}
