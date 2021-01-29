package com.technovision.technobot.commands.utility;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Set;

public class CommandKotlin extends Command {

    public CommandKotlin(final TechnoBot bot) {
        super(bot,"kotlin", "Displays resources for learning Kotlin programming.", "{prefix}kotlin", Category.UTILITY);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage(new EmbedBuilder()
                .setTitle("Learn Kotlin Programming!")
                .setDescription("Below are some important links to help you get started learning Kotlin programming.")
                .addField("Official Documentation", "https://kotlinlang.org/docs/", false)
                .addField("Kotlin Beginner Tutorial", "https://youtu.be/F9UC9DY-vIU", false)
                .addField("Full Online Kotlin Course", "https://www.coursera.org/learn/kotlin-for-java-developers", false)
                .addField("Kotlin Practice Exercises", "https://play.kotlinlang.org/koans/overview", false)
                .setFooter("TechnoVision Discord", "https://i.imgur.com/TzHOnJu.png")
                .setTimestamp(new Date().toInstant())
                .setColor(Command.EMBED_COLOR)
                .build()
        ).queue();
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("learnkotlin");
    }
}
