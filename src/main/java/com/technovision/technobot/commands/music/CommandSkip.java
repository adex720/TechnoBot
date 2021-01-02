package com.technovision.technobot.commands.music;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import com.technovision.technobot.listeners.managers.MusicManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class CommandSkip extends Command {
    private final MusicManager musicManager;

    public CommandSkip(final TechnoBot bot) {
        super(bot,"skip", "Skips the currently playing song", "{prefix}skip", Command.Category.MUSIC);
        this.musicManager = bot.getMusicManager();
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        if(event.getMember()==null||event.getMember().getVoiceState()==null||!event.getMember().getVoiceState().inVoiceChannel()||event.getMember().getVoiceState().getChannel()==null) {
            event.getChannel().sendMessage("You are not in a voice channel!").queue();
            return true;
        }
        if(musicManager.handlers.get(event.getGuild().getIdLong())==null) {
            event.getChannel().sendMessage("Please use `!join` first!").queue();
            return true;
        }
        if(musicManager.handlers.get(event.getGuild().getIdLong()).trackScheduler.getQueueCopy().size()==0) {
            event.getChannel().sendMessage("There are no songs playing.").queue();
            return true;
        }
        event.getChannel().sendMessage("Skipping...").queue();

        musicManager.handlers.get(event.getGuild().getIdLong()).trackScheduler.skip();
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("next");
    }
}
