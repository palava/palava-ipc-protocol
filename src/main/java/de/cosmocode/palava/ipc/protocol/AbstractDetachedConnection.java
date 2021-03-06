/**
 * Copyright 2010 CosmoCode GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.cosmocode.palava.ipc.protocol;

import com.google.common.collect.MapMaker;
import com.google.inject.internal.Preconditions;
import de.cosmocode.palava.ipc.IpcSession;
import de.cosmocode.palava.ipc.IpcSessionNotAttachedException;
import de.cosmocode.palava.scope.AbstractScopeContext;

import java.util.concurrent.ConcurrentMap;

/**
 * Abstract implementation of the {@link DetachedConnection} interface.
 *
 * @since 1.0
 * @author Willi Schoenborn
 */
public abstract class AbstractDetachedConnection extends AbstractScopeContext implements DetachedConnection {

    private ConcurrentMap<Object, Object> context;
    
    private IpcSession currentSession;

    @Override
    protected ConcurrentMap<Object, Object> delegate() {
        if (context == null) {
            context = new MapMaker().makeMap();
        }
        return context;
    }

    @Override
    public void attachTo(IpcSession session) {
        this.currentSession = Preconditions.checkNotNull(session, "Session");
    }
    
    @Override
    public boolean isAttached() {
        return currentSession != null;
    }

    @Override
    public IpcSession getSession() {
        if (!isAttached()) throw new IpcSessionNotAttachedException();
        return currentSession;
    }

}
