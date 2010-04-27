package de.cosmocode.palava.ipc.protocol;

import java.util.Map;

/**
 * An abstract {@link Protocol} which requires {@link Map} requests.
 *
 * @author Willi Schoenborn
 */
public abstract class MapProtocol implements Protocol {

    @Override
    public final boolean supports(Object request) {
        return request instanceof Map<?, ?> ? supports(Map.class.cast(request)) : false;
    }

    /**
     * Typed version of {@link #supports(Object)}.
     * 
     * @param request the incoming request
     * @return true if this protocol supports the specified request
     */
    public abstract boolean supports(Map<?, ?> request);
    
    @Override
    public final Object process(Object request, DetachedConnection connection) {
        return process(Map.class.cast(request), connection);
    }

    /**
     * Typed version of {@link #process(Object, DetachedConnection)}.
     * 
     * @param request the incoming request
     * @param connection the current connection
     * @return the produced content
     */
    public abstract Object process(Map<?, ?> request, DetachedConnection connection);

}
