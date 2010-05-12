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

import de.cosmocode.palava.ipc.IpcConnection;
import de.cosmocode.palava.ipc.IpcSession;

/**
 * An {@link IpcConnection} which can be attached to an {@link IpcSession}.
 *
 * @author Willi Schoenborn
 */
public interface DetachedConnection extends IpcConnection {

    /**
     * Attaches this connection to the specified session.
     * 
     * @param session the session which belongs to this connection
     * @throws NullPointerException if session is null
     */
    void attachTo(IpcSession session);
    
    /**
     * {@inheritDoc}
     * @throws IllegalStateException if this connection is not yet attached to a session
     */
    @Override
    IpcSession getSession();

    /**
     * Provides the id of this connection.
     * 
     * @since 1.0
     * @return the connection id
     */
    String getConnectionId();
    
}
