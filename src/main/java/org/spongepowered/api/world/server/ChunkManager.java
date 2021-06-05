/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.world.server;

import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.util.Ticks;
import org.spongepowered.api.util.annotation.DoNotStore;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.Optional;

/**
 * Manages {@link Chunk chunks} for a {@link ServerWorld}.
 */
@DoNotStore
public interface ChunkManager {

    /**
     * Gets the {@link ServerWorld} this manager operates upon.
     *
     * @return The {@link ServerWorld}
     */
    ServerWorld world();

    /**
     * Checks if the provided {@link Ticket} is valid for the world this manager
     * represents.
     *
     * @param ticket The ticket to check.
     * @return true if so
     */
    boolean valid(Ticket<?> ticket);

    /**
     * Returns whether the provided {@link Ticket} has been processed, that is,
     * it has been recognised by the engine and the {@link Chunk chunks} that
     * this ticket affects have at least been scheduled for loading.
     *
     * <p><strong>Note:</strong> a processed ticket is no guarantee that a chunk
     * has been loaded, instead it indicates that the ticket has been recognised
     * by the manager <em>at some point</em>.</p>
     *
     * @return {@code true} if the ticket has been processed.
     */
    boolean processed(Ticket<?> ticket);

    /**
     * Gets the {@link Ticks} remaining on the supplied ticket.
     *
     * @return The {@link Ticks}
     */
    Ticks timeLeft(Ticket<?> ticket);

    /**
     * Request a {@link Ticket} for a given {@link TicketType} that supports a
     * chunk position.
     *
     * @param type The type of ticket to request.
     * @param chunkOrigin The chunk co-ordinates of the central {@link Chunk}
     *                    affected by this {@link Ticket}
     * @param radius The radius of the area, in chunks, that this {@link Ticket}
     *               affects.
     * @return The ticket, if granted.
     */
    default Optional<Ticket<Vector3i>> requestTicket(final DefaultedRegistryReference<TicketType<Vector3i>> type,
                                                     final Vector3i chunkOrigin, final int radius) {
        return this.requestTicket(type.get(), chunkOrigin, radius);
    }

    /**
     * Request a {@link Ticket} for a given {@link TicketType} that supports a
     * chunk position.
     *
     * @param type The type of ticket to request.
     * @param chunkOrigin The chunk co-ordinates of the central {@link Chunk}
     *                    affected by this {@link Ticket}
     * @param radius The radius of the area, in chunks, that this {@link Ticket}
     *               affects.
     * @return The ticket, if granted.
     */
    default Optional<Ticket<Vector3i>> requestTicket(final TicketType<Vector3i> type, final Vector3i chunkOrigin,
                                                     final int radius) {
        return this.requestTicket(type, chunkOrigin, chunkOrigin, radius);
    }

    /**
     * Request a {@link Ticket} for the given {@link TicketType}.
     *
     * @param type The type of ticket to request.
     * @param chunkOrigin The chunk co-ordinates of the central {@link Chunk}
     *                    affected by this {@link Ticket}
     * @param value The value to register the ticket with.
     * @param radius The radius of the area, in chunks, that this {@link Ticket}
     *               affects.
     * @param <T> The type of the supplied {@code value}.
     * @return The ticket, if granted.
     */
    <T> Optional<Ticket<T>> requestTicket(TicketType<T> type, Vector3i chunkOrigin, T value, int radius);

    /**
     * Request a {@link Ticket} for the given {@link TicketType}.
     *
     * @param type The type of ticket to request.
     * @param chunkOrigin The chunk co-ordinates of the central {@link Chunk}
     *                    affected by this {@link Ticket}
     * @param value The value to register the ticket with.
     * @param radius The radius of the area, in chunks, that this {@link Ticket}
     *               affects.
     * @param <T> The type of the supplied {@code value}.
     * @return The ticket, if granted.
     */
    default <T> Optional<Ticket<T>> requestTicket(final DefaultedRegistryReference<TicketType<T>> type,
                                                  final Vector3i chunkOrigin, final T value, final int radius) {
        return this.requestTicket(type.get(), chunkOrigin, value, radius);
    }

    /**
     * Attempts to renew this ticket, resetting the lifetime to the default.
     *
     * <p>If this ticket is no longer valid, it cannot be renewed. Instead,
     * you should {@link #requestTicket(TicketType, Vector3i, Object, int)} a new one.</p>
     *
     * @param ticket The ticket to attempt to renew
     * @return {@code true} if successful
     */
    boolean renewTicket(Ticket<?> ticket);

    /**
     * Releases the provided {@link Ticket}, allowing the chunk position
     * represented by the given ticket to be unloaded (if it is not being kept
     * loaded by other means).
     *
     * @param ticket The ticket to release.
     */
    boolean releaseTicket(Ticket<?> ticket);

    /**
     * Gets all currently active {@link Ticket tickets} that are of the
     * provided {@link TicketType}.
     *
     * @param type The {@link TicketType} to retrieve tickets for
     * @param <T> The type of value the {@link Ticket} holds
     * @return A {@link Collection} of {@link Ticket tickets}
     */
    <T> Collection<Ticket<T>> findTickets(TicketType<T> type);

    /**
     * Gets all currently active {@link Ticket tickets} that are of the
     * provided {@link TicketType}.
     *
     * @param type The {@link TicketType} to retrieve tickets for
     * @param <T> The type of value the {@link Ticket} holds
     * @return A {@link Collection} of {@link Ticket tickets}
     */
    default <T> Collection<Ticket<T>> findTickets(final DefaultedRegistryReference<TicketType<T>> type) {
        return this.findTickets(type.get());
    }

}
