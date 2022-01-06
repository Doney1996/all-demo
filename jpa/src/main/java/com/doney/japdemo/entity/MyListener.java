package com.doney.japdemo.entity;

import org.hibernate.event.internal.DefaultLoadEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Component
public class MyListener extends DefaultLoadEventListener implements PostUpdateEventListener {

    public void onPostUpdate(PostUpdateEvent event) {
        System.out.println(event.getEntity().getClass().getName() + ":更新完毕");
        for (int i = 0; i < event.getState().length; i++) {
            // 更新前的值
            Object oldValue = event.getOldState()[i];
            // 更新后的新值
            Object newValue = event.getState()[i];
            //更新的属性名			S
            String propertyName = event.getPersister().getPropertyNames()[i];
        }
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister persister) {
        return false;
    }

    @Override
    public boolean requiresPostCommitHandling(EntityPersister persister) {
        return false;
    }
}