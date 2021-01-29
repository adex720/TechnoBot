package com.technovision.technobot.commands.utility;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Set;

public class CommandSpigot extends Command {

    public CommandSpigot(final TechnoBot bot) {
        super(bot,"spigot", "Displays resources for learning the Spigot API.", "{prefix}spigot", Category.UTILITY);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage(new EmbedBuilder()
                .setTitle("Learn Spigot Plugin Development!")
                .setDescription("Below are some important links to help you get started learning the Spigot API.")
                .addField("Spigot Wiki", "https://www.spigotmc.org/wiki/", false)
                .addField("Spigot API Documentation", "https://hub.spigotmc.org/javadocs/bukkit/", false)
                .addField("Spigot Tutorial Series", "https://youtube.com/playlist?list=PLDhiRTZ_vnoUvdrkTnaWP_hPmbj2JfPAF", false)
                .addField("SpigotMC Discord", "https://discord.gg/CK8vgg6", false)
                .setFooter("TechnoVision Discord", "https://i.imgur.com/TzHOnJu.png")
                .setTimestamp(new Date().toInstant())
                .setColor(Command.EMBED_COLOR)
                .build()
        ).queue();
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("bukkit", "paper", "plugins", "plugin", "learnspigot", "learnbukkit");
    }
}
