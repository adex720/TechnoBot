package com.technovision.technobot.commands.utility;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Set;

public class CommandFabric extends Command {

    public CommandFabric(final TechnoBot bot) {
        super(bot,"fabric", "Displays resources for learning the Fabric API.", "{prefix}fabric", Category.UTILITY);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage(new EmbedBuilder()
                .setTitle("Learn Fabric Modding!")
                .setDescription("Below are some important links to help you get started learning the Fabric API.")
                .addField("Fabric Wiki", "https://fabricmc.net/wiki/doku.php", false)
                .addField("Fabric Tutorial Series", "https://tinyurl.com/y8arukl4", false)
                .addField("Fabric Discord", "https://discord.gg/TK63sxP3H7", false)
                .setFooter("TechnoVision Discord", "https://i.imgur.com/TzHOnJu.png")
                .setTimestamp(new Date().toInstant())
                .setColor(Command.EMBED_COLOR)
                .build()
        ).queue();
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("learnfabric");
    }
}
