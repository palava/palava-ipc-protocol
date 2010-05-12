package de.cosmocode.palava.ipc.protocol;

import java.util.Map;

import com.google.inject.internal.Maps;
import com.google.inject.internal.Preconditions;

import de.cosmocode.palava.ipc.IpcSession;
import de.cosmocode.palava.scope.AbstractScopeContext;

/**
 * Abstract implementation of the {@link DetachedConnection} interface.
 *
 * @since 1.0
 * @author Willi Schoenborn
 */
public abstract class AbstractDetachedConnection extends AbstractScopeContext implements DetachedConnection {

    private Map<Object, Object> context;
    
    private IpcSession currentSession;
    
    @Override
    protected Map<Object, Object> context() {
        if (context == null) {
            context = Maps.newHashMap();
        }
        return context;
    }

    @Override
    public void attachTo(IpcSession session) {
        this.currentSession = Preconditions.checkNotNull(session, "Session");
    }

    @Override
    public IpcSession getSession() {
        Preconditions.checkState(currentSession != null, "Not yet attached to a session");
        return currentSession;
    }

}
