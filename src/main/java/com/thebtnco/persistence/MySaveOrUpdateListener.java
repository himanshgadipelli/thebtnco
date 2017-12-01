package com.thebtnco.persistence;

import com.thebtnco.persistence.domain.Movie;
import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Ady on 2/5/17.
 */
@SuppressWarnings("DefaultFileTemplate")
@Component
public class MySaveOrUpdateListener extends DefaultSaveOrUpdateEventListener {

    public void onSaveOrUpdate(SaveOrUpdateEvent event) {

        Object entity = event.getEntity();
        if (entity != null && entity instanceof Movie) {
            Movie p = (Movie) event.getEntity();
            if (p.getName().length() < 2) {
                throw new IllegalArgumentException("Whoa thats not allowed");
            }
        }
        super.onSaveOrUpdate(event);


    }
}
