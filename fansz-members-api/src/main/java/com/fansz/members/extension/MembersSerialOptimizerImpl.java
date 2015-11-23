package com.fansz.members.extension;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.fansz.members.model.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by allan on 15/11/23.
 */
public class MembersSerialOptimizerImpl implements SerializationOptimizer {
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        classes.add(CommonResult.class);
        classes.add(LoginResult.class);
        classes.add(RefreshResult.class);
        classes.add(RefreshParameters.class);
        classes.add(UserParameters.class);
        return classes;
    }
}

