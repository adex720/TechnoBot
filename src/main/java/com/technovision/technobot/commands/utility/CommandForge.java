package com.technovision.technobot.commands.utility;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Set;

public class CommandForge extends Command {

    public CommandForge(final TechnoBot bot) {
        super(bot,"forge", "Displays resources for learning the Forge API.", "{prefix}forge", Category.UTILITY);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage(new EmbedBuilder()
                .setTitle("Learn Forge Modding!")
                .setDescription("Below are some important links to help you get started learning the Forge API.")
                .addField("Forge Official Docs", "https://mcforge.readthedocs.io/", false)
                .addField("Forge Community Wiki", "https://forge.gemwire.uk/", false)
                .addField("Forge Tutorial Series", "https://wiki.mcjty.eu/modding/", false)
                .addField("Forge Discord", "https://discord.gg/UvedJ9m", false)
                .setFooter("TechnoVision Discord", "https://i.imgur.com/TzHOnJu.png")
                .setTimestamp(new Date().toInstant())
                .setColor(Command.EMBED_COLOR)
                .build()
        ).queue();
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("learnforge");
    }
}
