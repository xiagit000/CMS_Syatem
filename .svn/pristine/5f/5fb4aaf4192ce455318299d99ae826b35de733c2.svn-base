package com.boventech.cms.event;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventManager {

    private List<EventListener> list = new CopyOnWriteArrayList<EventListener>();

    private boolean sync = false;

    public static EventManager getManager() {
        return EventManagerHolder.INSTANCE;
    }

    private EventManager() {

    }

    public void broadcastEvent(final Event event) {

        if (isSync()) {
            syncBroadcast(event);
        } else {
            asyncBroadcast(event);
        }

    }

    private void syncBroadcast(Event event) {
        processEvent(event);
    }

    private void asyncBroadcast(final Event event) {
        Runnable run = new Runnable() {
            public void run() {
                processEvent(event);
            }
        };
        Thread thread = new Thread(run);
        thread.start();
    }

    private void processEvent(Event event) {
        Iterator<EventListener> i = list.iterator();
        while (i.hasNext()) {
            i.next().processEvent(event);
        }
    }

    public void addApplicationListener(EventListener listener) {
        this.list.add(listener);

    }

    public void removeApplicationListener(EventListener listener) {
        this.list.remove(listener);

    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }

    public boolean isSync() {
        return sync;
    }

    public void setListeners(List<EventListener> listeners) {
        this.list.clear();
        this.list.addAll(listeners);
    }

    private static class EventManagerHolder {
        private static final EventManager INSTANCE;
        static {
            INSTANCE = new EventManager();
        }
    }

}
