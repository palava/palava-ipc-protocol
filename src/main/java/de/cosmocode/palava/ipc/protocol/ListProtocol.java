package de.cosmocode.palava.ipc.protocol;

import java.util.List;

/**
 * An abstract {@link Protocol} which requires {@link List} requests.
 *
 * @author Willi Schoenborn
 */
public abstract class ListProtocol implements Protocol {

    @Override
    public final boolean supports(Object request) {
        return request instanceof List<?> ? supports(List.class.cast(request)) : false;
    }
    
    /**
     * Typed version of {@link #supports(Object)}.
     * 
     * @param request the incoming request
     * @return true if this protocol supports the specified request
     */
    public abstract boolean supports(List<?> request);
    
    @Override
    public final Object process(Object request, DetachedConnection connection) {
        return process(List.class.cast(request), connection);
    }
    
    /**
     * Typed version of {@link #process(Object, DetachedConnection)}.
     * 
     * @param request the incoming request
     * @param connection the current connection
     * @return the produced content
     */
    public abstract Object process(List<?> request, DetachedConnection connection);

}
