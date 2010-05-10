package de.cosmocode.palava.ipc.protocol;

import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.inject.internal.Maps;

import de.cosmocode.palava.ipc.IpcSession;
import de.cosmocode.palava.scope.AbstractScopeContext;

/**
 * Default implementation of the {@link DetachedConnection} interface.
 *
 * @since 1.0
 * @author Willi Schoenborn
 */
public final class DefaultDetachedConnection extends AbstractScopeContext implements DetachedConnection {

    private final Map<Object, Object> context = Maps.newHashMap();
    
    private IpcSession currentSession;

    @Override
    protected Map<Object, Object> context() {
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
