package me.jamieburns.support;

import java.util.function.Consumer;

import me.jamieburns.actions.Action;
import me.jamieburns.actions.KeepAction;
import me.jamieburns.actions.KeepWithRenameAction;
import me.jamieburns.actions.RemoveAction;
import me.jamieburns.data.FileData;

public class FileDataActionConsumer implements Consumer<Action<FileData>> {

    @Override
    public void accept( Action<FileData> action ) {
        switch( action ) {
            case KeepAction<FileData> move -> System.out.println( "[move] %s to ...".formatted(move.data().path() ) );
            case KeepWithRenameAction<FileData> rename -> System.out.println( "[rename] %s to ...".formatted( rename.data().path() ) );
            case RemoveAction<FileData> remove -> System.out.println( "[remove] %s".formatted( remove.data().path() ) );
        };
    }

}
