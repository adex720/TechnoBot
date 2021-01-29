package com.technovision.technobot.commands.utility;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Set;

public class CommandJava extends Command {

    public CommandJava(final TechnoBot bot) {
        super(bot,"java", "Displays resources for learning Java programming.", "{prefix}java", Command.Category.UTILITY);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage(new EmbedBuilder()
                .setTitle("Learn Java Programming!")
                .setDescription("Below are some important links to help you get started learning Java programming.")
                .addField("Official Documentation", "https://docs.oracle.com/javase/tutorial/", false)
                .addField("Java Basics & Interactive Environment", "https://www.codecademy.com/learn/learn-java", false)
                .addField("Full Online Java Course", "https://java-programming.mooc.fi/", false)
                .setFooter("TechnoVision Discord", "https://i.imgur.com/TzHOnJu.png")
                .setTimestamp(new Date().toInstant())
                .setColor(Command.EMBED_COLOR)
                .build()
        ).queue();
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("learnjava");
    }
}
