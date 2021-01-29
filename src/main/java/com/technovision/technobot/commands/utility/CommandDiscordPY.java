package com.technovision.technobot.commands.utility;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Set;

public class CommandDiscordPY extends Command {

    public CommandDiscordPY(final TechnoBot bot) {
        super(bot,"discord.py", "Displays resources for learning the Discord.py API.", "{prefix}discord.py", Category.UTILITY);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage(new EmbedBuilder()
                .setTitle("Learn the Discord.py API!")
                .setDescription("Below are some important links to help you get started learning the Discord.py API.")
                .addField("Discord.py GitHub", "https://github.com/Rapptz/discord.py", false)
                .addField("Official Documentation", "https://discordpy.readthedocs.io/en/latest/", false)
                .addField("Discord.py Tutorial Series", "https://youtu.be/nW8c7vT6Hl4", false)
                .addField("Discord.py Discord", "https://discord.gg/r3sSKJJ", false)
                .setFooter("TechnoVision Discord", "https://i.imgur.com/TzHOnJu.png")
                .setTimestamp(new Date().toInstant())
                .setColor(Command.EMBED_COLOR)
                .build()
        ).queue();
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("discordpy", "dpy", "discord-py");
    }
}
