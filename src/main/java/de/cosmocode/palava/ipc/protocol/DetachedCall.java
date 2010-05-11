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

import de.cosmocode.palava.ipc.IpcCall;
import de.cosmocode.palava.ipc.IpcConnection;

/**
 * An {@link IpcCall} which can be attached to an {@link IpcConnection}.
 *
 * @author Willi Schoenborn
 */
public interface DetachedCall extends IpcCall {

    /**
     * Attaches this call to the specified connection.
     * 
     * @param connection the connection which belongs to this call
     * @throws NullPointerException if connection is null
     */
    void attachTo(IpcConnection connection);
    
    /**
     * {@inheritDoc}
     * @throws IllegalStateException if this call is not yet attached to a connection
     */
    @Override
    IpcConnection getConnection();
    
}
