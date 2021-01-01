package com.technovision.technobot.commands.music;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class CommandPlay extends Command {
    private final TechnoBot bot;

    public CommandPlay(final TechnoBot bot) {
        super("play", "Plays music in voice channel", "{prefix}play [song|url]", Command.Category.MUSIC);
        this.bot = bot;
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        if (event.getMember() == null || event.getMember().getVoiceState() == null || !event.getMember().getVoiceState().inVoiceChannel() || event.getMember().getVoiceState().getChannel() == null) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(ERROR_EMBED_COLOR);
            embed.setDescription(":x: Please connect to a voice channel first!");
            event.getChannel().sendMessage(embed.build()).queue();
            return true;
        }
        bot.getMusicManager().joinVoiceChannel(event.getGuild(), event.getMember().getVoiceState().getChannel(), event.getChannel());
        try {
            String url;
            try {
                url = new URL(args[0]).toString();
            } catch (MalformedURLException e) {
                StringBuilder keywords = new StringBuilder();
                for (String word : args) {
                    keywords.append(word).append(" ");
                }
                url = bot.getYoutubeManager().search(keywords.toString());
            }
            if (url != null) {
                bot.getMusicManager().addTrack(event.getAuthor(), url, event.getChannel(), event.getGuild());
                bot.getMusicManager().handlers.get(event.getGuild().getIdLong()).trackScheduler.setPaused(false);
            } else {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setColor(ERROR_EMBED_COLOR);
                embed.setDescription(":x: You have reached the maximum quota for today!");
                event.getChannel().sendMessage(embed.build()).queue();
            }
        } catch (IndexOutOfBoundsException e) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(ERROR_EMBED_COLOR);
            embed.setDescription(":x: Please specify a song a to play.");
            event.getChannel().sendMessage(embed.build()).queue();
        }
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("add");
    }
}
