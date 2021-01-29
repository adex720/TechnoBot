package com.technovision.technobot.commands.utility;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Set;

public class CommandJDA extends Command {

    public CommandJDA(final TechnoBot bot) {
        super(bot,"jda", "Displays resources for learning the Java-Discord API.", "{prefix}jda", Category.UTILITY);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage(new EmbedBuilder()
                .setTitle("Learn the Java-Discord API!")
                .setDescription("Below are some important links to help you get started learning JDA.")
                .addField("JDA GitHub & Wiki", "https://github.com/DV8FromTheWorld/JDA", false)
                .addField("Official Documentation", "https://ci.dv8tion.net/job/JDA/javadoc/index.html", false)
                .addField("JDA Tutorial Series", "https://youtu.be/dOmyJhB_feM", false)
                .addField("JDA Discord", "https://discord.gg/C5yzqFJHNg", false)
                .setFooter("TechnoVision Discord", "https://i.imgur.com/TzHOnJu.png")
                .setTimestamp(new Date().toInstant())
                .setColor(Command.EMBED_COLOR)
                .build()
        ).queue();
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("javadiscordapi", "java-discord-api");
    }
}
