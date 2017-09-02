package com.rok.mymobilewallet.room;

import com.rok.mymobilewallet.entity.Group;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.completable.CompletableFromAction;

/**
 * Created by Rok on 13. 07. 2017.
 */

public class GroupDataSource {

    private List<Group> GROUPS;

    public GroupDataSource(MyMobileWalletDatabase database) {
        GROUPS = new ArrayList<>();

        Group group = new Group();
        group.setId(2000);
        group.setTitle("Group 1");
        group.setDescription("Group Description 1");
        GROUPS.add(group);

        group = new Group();
        group.setId(2001);
        group.setTitle("Group 2");
        group.setDescription("Group Description 2");
        GROUPS.add(group);

        group = new Group();
        group.setId(2002);
        group.setTitle("Group 3");
        group.setDescription("Group Description 3");
        GROUPS.add(group);
    }

    public Flowable<Group> getGroup(final int id) {
        return Flowable.fromIterable(GROUPS)
                .filter(new Predicate<Group>() {
                    @Override
                    public boolean test(Group group) throws Exception {
                        return id == group.getId();
                    }
                });
    }

    public Flowable<List<Group>> getGroups() {
        return Flowable.just(GROUPS);
    }

    public Completable insert(final Group group) {
        return new CompletableFromAction(new Action() {
            @Override
            public void run() throws Exception {
                GROUPS.add(group);
            }
        });
    }
}
