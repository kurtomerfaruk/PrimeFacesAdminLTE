package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.IActorDAO;
import com.kurtomerfaruk.admin.models.Actor;


/**
 *
 * @author Omer Faruk KURT kurtomerfaruk@gmail.com
 */
public class ActorDAOImpl extends GenericDAOImpl<Actor> implements IActorDAO<Actor> {

    private static final long serialVersionUID = 4302022412345327839L;

    public ActorDAOImpl() {
        super(Actor.class);
    }

}
