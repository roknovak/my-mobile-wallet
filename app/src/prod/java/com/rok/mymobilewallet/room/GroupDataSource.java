package com.rok.mymobilewallet.room;

import com.rok.mymobilewallet.entity.Group;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.completable.CompletableFromAction;

/**
 * Created by Rok on 13. 07. 2017.
 */

public class GroupDataSource {

    private final GroupDao groupDao;

    public GroupDataSource(MyMobileWalletDatabase database) {
        groupDao = database.groupDao();
    }

    public Flowable<Group> getGroup(int id) {
        return groupDao.getGroupById(id);
    }

    public Flowable<List<Group>> getGroups() {
        return groupDao.getAllGroups();
    }

    public Completable insert(final Group group) {
        return new CompletableFromAction(new Action() {
            @Override
            public void run() throws Exception {
                groupDao.insert(group);
            }
        });
    }
}
